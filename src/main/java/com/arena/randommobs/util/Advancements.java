package com.arena.randommobs.util;

import com.arena.randommobs.RandomMobs;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

/**
 * All Random Mobs advancements use the "minecraft:impossible" trigger with a single
 * criterion called "code", and are granted from code when something weird happens.
 */
public final class Advancements {
    public static final String CRITERION = "code";

    public static void grant(ServerPlayer player, String path) {
        if (!"root".equals(path)) {
            grantInternal(player, "root");
        }
        grantInternal(player, path);
    }

    private static void grantInternal(ServerPlayer player, String path) {
        MinecraftServer server = player.getServer();
        if (server == null) {
            return;
        }
        Advancement advancement = server.getAdvancements()
                .getAdvancement(new ResourceLocation(RandomMobs.MODID, path));
        if (advancement == null) {
            RandomMobs.LOGGER.warn("Missing advancement randommobs:{}", path);
            return;
        }
        if (!player.getAdvancements().getOrStartProgress(advancement).isDone()) {
            player.getAdvancements().award(advancement, CRITERION);
        }
    }

    public static void grantForAllNearby(net.minecraft.world.level.Level level, net.minecraft.world.phys.Vec3 pos,
                                         double radius, String path) {
        for (ServerPlayer player : level.getEntitiesOfClass(ServerPlayer.class,
                new net.minecraft.world.phys.AABB(pos, pos).inflate(radius))) {
            grant(player, path);
        }
    }

    private Advancements() {
    }
}
