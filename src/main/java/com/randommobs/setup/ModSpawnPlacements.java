package com.randommobs.setup;

import com.randommobs.RandomMobs;
import com.randommobs.entity.TripodEntity;
import com.randommobs.entity.WoodcrawlerEntity;
import com.randommobs.registry.ModEntities;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Registers natural spawn placement rules for the mobs.
 * Biomes and weights are configured through the biome modifier JSONs
 * in data/randommobs/forge/biome_modifier/.
 */
@Mod.EventBusSubscriber(modid = RandomMobs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSpawnPlacements {

    @SubscribeEvent
    public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {
        // Woodcrawler: dark forest nights, like any proper horror creature.
        event.register(ModEntities.WOODCRAWLER.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.REPLACE);

        // Tripod: spawns in any light (its arrival is not bound to the night).
        event.register(ModEntities.TRIPOD.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                TripodEntity::checkTripodSpawnRules,
                SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
