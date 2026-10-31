package com.arena.randommobs.storm;

import com.arena.randommobs.entity.LightsEntity;
import com.arena.randommobs.entity.TornadoEntity;
import com.arena.randommobs.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Drives the whole storm cycle: calm -> warning -> raging -> aftermath -> calm.
 */
public final class StormHandler {
    public static final String KEY = "randommobs_storm";

    public static StormData data(ServerLevel level) {
        return level.getServer().overworld().getDataStorage()
                .computeIfAbsent(StormData::load, StormData::new, KEY);
    }

    public static boolean isRaging(ServerLevel level) {
        return data(level).phase == StormData.RAGING;
    }

    public static void tick(ServerLevel level) {
        StormData data = data(level);
        if (data.timer > 0) {
            data.timer--;
        }
        switch (data.phase) {
            case StormData.CALM -> {
                if (data.timer <= 0) {
                    data.phase = StormData.WARNING;
                    data.timer = 240;
                    announce(level, "storm.randommobs.warning");
                    level.playSound(null, level.getSharedSpawnPos(), SoundEvents.WARDEN_ROAR,
                            SoundSource.WEATHER, 8.0F, 0.6F);
                }
            }
            case StormData.WARNING -> {
                if (data.timer % 60 == 0) {
                    for (Player player : level.players()) {
                        level.playSound(null, player.blockPosition(), SoundEvents.WARDEN_ROAR,
                                SoundSource.WEATHER, 2.0F, 0.8F);
                    }
                }
                if (data.timer <= 0) {
                    data.phase = StormData.RAGING;
                    data.timer = 2400 + level.random.nextInt(2400);
                    level.setWeatherParameters(0, data.timer, true, true);
                    announce(level, "storm.randommobs.raging");
                }
            }
            case StormData.RAGING -> {
                ragingEffects(level, data);
                if (data.timer <= 0) {
                    data.phase = StormData.AFTERMATH;
                    data.timer = 600;
                    level.setWeatherParameters(6000, 0, false, false);
                    spawnLights(level);
                    announce(level, "storm.randommobs.aftermath");
                    for (ServerPlayer player : level.players()) {
                        com.arena.randommobs.util.Advancements.grant(player, "storm_survivor");
                    }
                }
            }
            case StormData.AFTERMATH -> {
                if (data.timer <= 0) {
                    data.phase = StormData.CALM;
                    data.timer = 8000 + level.random.nextInt(16000);
                }
            }
            default -> data.phase = StormData.CALM;
        }
        data.setDirty();
    }

    private static void ragingEffects(ServerLevel level, StormData data) {
        for (ServerPlayer player : level.players()) {
            if (TornadoEntity.isSheltered(level, player.blockPosition())) {
                continue;
            }
            if (level.random.nextInt(100) < 4) {
                strikeNear(level, player);
            }
            if (level.random.nextInt(6) == 0) {
                level.sendParticles(ParticleTypes.CHERRY_LEAVES,
                        player.getX() + (level.random.nextDouble() - 0.5D) * 24.0D,
                        player.getY() + 12.0D,
                        player.getZ() + (level.random.nextDouble() - 0.5D) * 24.0D,
                        12, 3.0D, 1.5D, 3.0D, 0.05D);
            }
        }
        if (data.timer % 200 == 0 && !level.players().isEmpty()) {
            ServerPlayer player = level.players().get(level.random.nextInt(level.players().size()));
            if (level.getEntitiesOfClass(TornadoEntity.class, player.getBoundingBox().inflate(160.0D)).isEmpty()) {
                BlockPos pos = player.blockPosition().offset(level.random.nextInt(40) - 20, 6,
                        level.random.nextInt(40) - 20);
                TornadoEntity tornado = ModEntities.TORNADO.get().create(level);
                if (tornado != null) {
                    tornado.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);
                    level.addFreshEntity(tornado);
                    announce(level, "storm.randommobs.tornado");
                }
            }
        }
    }

    private static void strikeNear(ServerLevel level, ServerPlayer player) {
        Vec3 offset = new Vec3((level.random.nextDouble() - 0.5D) * 16.0D, 0.0D,
                (level.random.nextDouble() - 0.5D) * 16.0D);
        BlockPos pos = BlockPos.containing(player.position().add(offset));
        pos = level.getHeightmapPos(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING, pos);
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
        if (bolt == null) {
            return;
        }
        bolt.moveTo(Vec3.atBottomCenterOf(pos));
        bolt.setCause(player);
        level.addFreshEntity(bolt);
    }

    private static void spawnLights(ServerLevel level) {
        for (ServerPlayer player : level.players()) {
            int count = 1 + level.random.nextInt(3);
            for (int i = 0; i < count; i++) {
                if (player.blockPosition().distSqr(BlockPos.containing(
                        player.getX() + level.random.nextInt(16) - 8, player.getY(),
                        player.getZ() + level.random.nextInt(16) - 8)) > 24 * 24) {
                    continue;
                }
                BlockPos pos = player.blockPosition().offset(level.random.nextInt(16) - 8, 0,
                        level.random.nextInt(16) - 8);
                pos = level.getHeightmapPos(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos);
                LightsEntity lights = ModEntities.LIGHTS.get().create(level);
                if (lights != null) {
                    lights.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);
                    level.addFreshEntity(lights);
                }
            }
        }
    }

    private static void announce(ServerLevel level, String key) {
        for (ServerPlayer player : level.players()) {
            player.sendSystemMessage(Component.translatable(key));
        }
    }

    /** "Clear", "Storm warning", ... used by the weather map and the radio. */
    public static Component describe(ServerLevel level) {
        StormData data = data(level);
        return switch (data.phase) {
            case StormData.WARNING -> Component.translatable("storm.randommobs.warning");
            case StormData.RAGING -> Component.translatable("storm.randommobs.raging");
            case StormData.AFTERMATH -> Component.translatable("storm.randommobs.aftermath");
            default -> Component.translatable("storm.randommobs.calm");
        };
    }

    public static int secondsLeft(ServerLevel level) {
        return Math.max(0, data(level).timer) / 20;
    }

    private StormHandler() {
    }
}
