package com.randommobs.registry;

import com.randommobs.RandomMobs;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

/**
 * Helpers for handing out advancements that are triggered from code
 * (their JSON criteria are "minecraft:impossible").
 */
public class ModAdvancements {

    /** "Oh that just fish" — awarded when a tripod somehow ends up underwater. */
    public static final ResourceLocation OH_THATS_JUST_FISH =
            new ResourceLocation(RandomMobs.MODID, "oh_thats_just_fish");

    /** "The Root Virus" — awarded when a woodcrawler infects you. */
    public static final ResourceLocation ROOT_VIRUS =
            new ResourceLocation(RandomMobs.MODID, "root_virus");

    public static void award(ServerPlayer player, ResourceLocation advancementId) {
        if (player == null) {
            return;
        }
        Advancement advancement = player.server.getAdvancements().getAdvancement(advancementId);
        if (advancement == null) {
            RandomMobs.LOGGER.warn("Advancement {} not found, cannot award", advancementId);
            return;
        }
        AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
        if (!progress.isDone()) {
            for (String criterion : progress.getRemainingCriteria()) {
                player.getAdvancements().award(advancement, criterion);
            }
        }
    }
}
