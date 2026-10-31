package com.arena.randommobs.event;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.entity.AliveHouseEntity;
import com.arena.randommobs.entity.AliveTreeEntity;
import com.arena.randommobs.entity.BearEntity;
import com.arena.randommobs.entity.BloopEntity;
import com.arena.randommobs.entity.EvilWatermelonEntity;
import com.arena.randommobs.entity.GardenerEntity;
import com.arena.randommobs.entity.GiantSpiderEntity;
import com.arena.randommobs.entity.KrakenEntity;
import com.arena.randommobs.entity.SandWormEntity;
import com.arena.randommobs.entity.TripodEntity;
import com.arena.randommobs.entity.UfoEntity;
import com.arena.randommobs.entity.WoodcockEntity;
import com.arena.randommobs.entity.WoodcrawlerEntity;
import com.arena.randommobs.registry.ModEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TRIPOD.get(), TripodEntity.createAttributes().build());
        event.put(ModEntities.WOODCRAWLER.get(), WoodcrawlerEntity.createAttributes().build());
        event.put(ModEntities.BLOOP.get(), BloopEntity.createAttributes().build());
        event.put(ModEntities.ALIVE_HOUSE.get(), AliveHouseEntity.createAttributes().build());
        event.put(ModEntities.GIANT_SPIDER.get(), GiantSpiderEntity.createAttributes().build());
        event.put(ModEntities.GARDENER.get(), GardenerEntity.createAttributes().build());
        event.put(ModEntities.SAND_WORM.get(), SandWormEntity.createAttributes().build());
        event.put(ModEntities.UFO.get(), UfoEntity.createAttributes().build());
        event.put(ModEntities.BEAR.get(), BearEntity.createAttributes().build());
        event.put(ModEntities.KRAKEN.get(), KrakenEntity.createAttributes().build());
        event.put(ModEntities.EVIL_WATERMELON.get(), EvilWatermelonEntity.createAttributes().build());
        event.put(ModEntities.ALIVE_TREE.get(), AliveTreeEntity.createAttributes().build());
        event.put(ModEntities.WOODCOCK.get(), WoodcockEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.TRIPOD.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TripodEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.WOODCRAWLER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WoodcrawlerEntity::checkDarkSpawnRules, Operation.OR);
        event.register(ModEntities.BLOOP.get(), SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BloopEntity::checkWaterSpawnRules, Operation.OR);
        event.register(ModEntities.ALIVE_HOUSE.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AliveHouseEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.GIANT_SPIDER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantSpiderEntity::checkDarkSpawnRules, Operation.OR);
        event.register(ModEntities.GARDENER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GardenerEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.SAND_WORM.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SandWormEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.UFO.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, UfoEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.BEAR.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, Operation.OR);
        event.register(ModEntities.KRAKEN.get(), SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KrakenEntity::checkWaterSpawnRules, Operation.OR);
        event.register(ModEntities.EVIL_WATERMELON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EvilWatermelonEntity::checkDarkSpawnRules, Operation.OR);
        event.register(ModEntities.ALIVE_TREE.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AliveTreeEntity::checkLightSpawnRules, Operation.OR);
        event.register(ModEntities.WOODCOCK.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, Operation.OR);
    }

    private ModEvents() {
    }
}
