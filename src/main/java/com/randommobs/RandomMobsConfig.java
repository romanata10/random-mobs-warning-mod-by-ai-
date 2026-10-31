package com.randommobs;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Simple common config so players can tune how dangerous the mobs are.
 */
public class RandomMobsConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.DoubleValue TRIPOD_HEAT_RAY_DAMAGE =
            BUILDER.comment("Base damage of the tripod heat ray")
                    .defineInRange("tripod.heatRayDamage", 8.0D, 0.0D, 100.0D);

    public static final ForgeConfigSpec.DoubleValue TRIPOD_WATER_DAMAGE =
            BUILDER.comment("Damage the tripod takes every second while its head is underwater")
                    .defineInRange("tripod.waterDamage", 6.0D, 0.0D, 100.0D);

    public static final ForgeConfigSpec.IntValue ROOT_VIRUS_DURATION =
            BUILDER.comment("Duration (in ticks) of the Root Virus applied by a woodcrawler hit (7200 = 6 minutes)")
                    .defineInRange("woodcrawler.rootVirusDuration", 7200, 20, 24000);

    public static final ForgeConfigSpec.DoubleValue ROOT_VIRUS_DAMAGE =
            BUILDER.comment("Damage dealt by the Root Virus every 3 seconds")
                    .defineInRange("woodcrawler.rootVirusDamage", 1.0D, 0.0D, 20.0D);

    // NOTE: the movement speed penalty of the virus is a fixed -20% multiplier;
    // it cannot be configurable because mob effects register before configs load.

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
