package com.arena.randommobs.event;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.entity.AliveTreeEntity;
import com.arena.randommobs.entity.BloopEntity;
import com.arena.randommobs.entity.EvilWatermelonEntity;
import com.arena.randommobs.entity.GiantSpiderEntity;
import com.arena.randommobs.entity.KrakenEntity;
import com.arena.randommobs.entity.TripodEntity;
import com.arena.randommobs.registry.ModBlocks;
import com.arena.randommobs.registry.ModEffects;
import com.arena.randommobs.util.Advancements;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomMobs.MODID)
public final class ForgeEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            awardForKill(event);
            return;
        }
        if (!player.hasEffect(ModEffects.ROOT_INFECTION.get())) {
            return;
        }
        Level level = player.level();
        BlockPos base = player.blockPosition();
        for (int dy = 1; dy >= -2; dy--) {
            BlockPos pos = base.offset(0, dy, 0);
            if (!level.isEmptyBlock(pos)) {
                continue;
            }
            BlockPos below = pos.below();
            if (!level.getBlockState(below).isFaceSturdy(level, below, Direction.UP)) {
                continue;
            }
            BlockState bloom = ModBlocks.MOCKERY_BLOOM.get().defaultBlockState();
            if (bloom.canSurvive(level, pos)) {
                level.setBlockAndUpdate(pos, bloom);
                level.scheduleTick(pos, ModBlocks.MOCKERY_BLOOM.get(), 400);
                Advancements.grant(player, "natures_mockery");
                return;
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!event.getState().is(BlockTags.LOGS)) {
            return;
        }
        if (!(event.getLevel() instanceof Level level)) {
            return;
        }
        Player player = event.getPlayer();
        if (player == null) {
            return;
        }
        BlockPos pos = event.getPos();
        boolean angered = false;
        for (AliveTreeEntity tree : level.getEntitiesOfClass(AliveTreeEntity.class, new AABB(pos).inflate(24.0D))) {
            tree.enrage(player);
            angered = true;
        }
        if (angered && player instanceof ServerPlayer serverPlayer) {
            Advancements.grant(serverPlayer, "tree_breaker");
        }
    }

    private static void awardForKill(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof ServerPlayer killer)) {
            return;
        }
        net.minecraft.world.entity.Entity dead = event.getEntity();
        if (dead instanceof BloopEntity) {
            Advancements.grant(killer, "kill_bloop");
        } else if (dead instanceof KrakenEntity) {
            Advancements.grant(killer, "kill_kraken");
        } else if (dead instanceof TripodEntity) {
            Advancements.grant(killer, "kill_tripod");
        } else if (dead instanceof GiantSpiderEntity) {
            Advancements.grant(killer, "spider_silk");
        } else if (dead instanceof EvilWatermelonEntity) {
            Advancements.grant(killer, "watermelon_slayer");
        }
    }

    private ForgeEvents() {
    }
}
