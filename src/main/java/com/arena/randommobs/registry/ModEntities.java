package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.entity.AliveHouseEntity;
import com.arena.randommobs.entity.AliveTreeEntity;
import com.arena.randommobs.entity.AshHoundEntity;
import com.arena.randommobs.entity.BearEntity;
import com.arena.randommobs.entity.BloopEntity;
import com.arena.randommobs.entity.BogWretchEntity;
import com.arena.randommobs.entity.ChestMimicEntity;
import com.arena.randommobs.entity.CircuitEntity;
import com.arena.randommobs.entity.CloudRayEntity;
import com.arena.randommobs.entity.EvilWatermelonEntity;
import com.arena.randommobs.entity.GardenerEntity;
import com.arena.randommobs.entity.GiantSpiderEntity;
import com.arena.randommobs.entity.HollowNeighborEntity;
import com.arena.randommobs.entity.KrakenEntity;
import com.arena.randommobs.entity.LanternWraithEntity;
import com.arena.randommobs.entity.LightsEntity;
import com.arena.randommobs.entity.SandWormEntity;
import com.arena.randommobs.entity.SirenHeadEntity;
import com.arena.randommobs.entity.TankEntity;
import com.arena.randommobs.entity.TornadoEntity;
import com.arena.randommobs.entity.TripodEntity;
import com.arena.randommobs.entity.UfoEntity;
import com.arena.randommobs.entity.WarshipEntity;
import com.arena.randommobs.entity.WaterGrabberEntity;
import com.arena.randommobs.entity.WoodcockEntity;
import com.arena.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RandomMobs.MODID);

    public static final RegistryObject<EntityType<TripodEntity>> TRIPOD = ENTITIES.register("tripod",
            () -> EntityType.Builder.of(TripodEntity::new, MobCategory.MONSTER)
                    .sized(2.6F, 6.4F).clientTrackingRange(12).build("tripod"));

    public static final RegistryObject<EntityType<WoodcrawlerEntity>> WOODCRAWLER = ENTITIES.register("woodcrawler",
            () -> EntityType.Builder.of(WoodcrawlerEntity::new, MobCategory.MONSTER)
                    .sized(0.7F, 2.0F).clientTrackingRange(10).build("woodcrawler"));

    public static final RegistryObject<EntityType<BloopEntity>> BLOOP = ENTITIES.register("bloop",
            () -> EntityType.Builder.of(BloopEntity::new, MobCategory.MONSTER)
                    .sized(6.0F, 4.2F).clientTrackingRange(12).build("bloop"));

    public static final RegistryObject<EntityType<AliveHouseEntity>> ALIVE_HOUSE = ENTITIES.register("alive_house",
            () -> EntityType.Builder.of(AliveHouseEntity::new, MobCategory.MONSTER)
                    .sized(4.2F, 4.5F).clientTrackingRange(10).build("alive_house"));

    public static final RegistryObject<EntityType<GiantSpiderEntity>> GIANT_SPIDER = ENTITIES.register("giant_spider",
            () -> EntityType.Builder.of(GiantSpiderEntity::new, MobCategory.MONSTER)
                    .sized(3.4F, 2.2F).clientTrackingRange(10).build("giant_spider"));

    public static final RegistryObject<EntityType<GardenerEntity>> GARDENER = ENTITIES.register("gardener",
            () -> EntityType.Builder.of(GardenerEntity::new, MobCategory.MONSTER)
                    .sized(1.2F, 3.2F).clientTrackingRange(10).build("gardener"));

    public static final RegistryObject<EntityType<SandWormEntity>> SAND_WORM = ENTITIES.register("sand_worm",
            () -> EntityType.Builder.of(SandWormEntity::new, MobCategory.MONSTER)
                    .sized(2.2F, 2.2F).clientTrackingRange(10).build("sand_worm"));

    public static final RegistryObject<EntityType<UfoEntity>> UFO = ENTITIES.register("ufo",
            () -> EntityType.Builder.of(UfoEntity::new, MobCategory.MONSTER)
                    .sized(3.0F, 2.0F).clientTrackingRange(12).build("ufo"));

    public static final RegistryObject<EntityType<BearEntity>> BEAR = ENTITIES.register("bear",
            () -> EntityType.Builder.of(BearEntity::new, MobCategory.CREATURE)
                    .sized(1.4F, 1.8F).clientTrackingRange(10).build("bear"));

    public static final RegistryObject<EntityType<KrakenEntity>> KRAKEN = ENTITIES.register("kraken",
            () -> EntityType.Builder.of(KrakenEntity::new, MobCategory.MONSTER)
                    .sized(4.5F, 4.2F).clientTrackingRange(12).build("kraken"));

    public static final RegistryObject<EntityType<EvilWatermelonEntity>> EVIL_WATERMELON = ENTITIES.register("evil_watermelon",
            () -> EntityType.Builder.of(EvilWatermelonEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 1.0F).clientTrackingRange(8).build("evil_watermelon"));

    public static final RegistryObject<EntityType<AliveTreeEntity>> ALIVE_TREE = ENTITIES.register("alive_tree",
            () -> EntityType.Builder.of(AliveTreeEntity::new, MobCategory.MONSTER)
                    .sized(2.2F, 4.6F).clientTrackingRange(10).build("alive_tree"));

    public static final RegistryObject<EntityType<WoodcockEntity>> WOODCOCK = ENTITIES.register("woodcock",
            () -> EntityType.Builder.of(WoodcockEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.9F).clientTrackingRange(10).build("woodcock"));

    // ---- 1.1 storm pack --------------------------------------------------
    public static final RegistryObject<EntityType<LightsEntity>> LIGHTS = ENTITIES.register("lights",
            () -> EntityType.Builder.of(LightsEntity::new, MobCategory.MONSTER)
                    .sized(0.8F, 1.0F).clientTrackingRange(10).build("lights"));

    public static final RegistryObject<EntityType<ChestMimicEntity>> CHEST_MIMIC = ENTITIES.register("chest_mimic",
            () -> EntityType.Builder.of(ChestMimicEntity::new, MobCategory.MONSTER)
                    .sized(1.0F, 1.0F).clientTrackingRange(8).build("chest_mimic"));

    public static final RegistryObject<EntityType<WaterGrabberEntity>> WATER_GRABBER = ENTITIES.register("water_grabber",
            () -> EntityType.Builder.of(WaterGrabberEntity::new, MobCategory.WATER_CREATURE)
                    .sized(3.6F, 1.6F).clientTrackingRange(12).build("water_grabber"));

    public static final RegistryObject<EntityType<TankEntity>> TANK = ENTITIES.register("tank",
            () -> EntityType.Builder.of(TankEntity::new, MobCategory.MONSTER)
                    .sized(3.6F, 2.4F).clientTrackingRange(12).build("tank"));

    public static final RegistryObject<EntityType<SirenHeadEntity>> SIREN_HEAD = ENTITIES.register("siren_head",
            () -> EntityType.Builder.of(SirenHeadEntity::new, MobCategory.MONSTER)
                    .sized(1.6F, 9.5F).clientTrackingRange(14).build("siren_head"));

    public static final RegistryObject<EntityType<WarshipEntity>> WARSHIP = ENTITIES.register("warship",
            () -> EntityType.Builder.of(WarshipEntity::new, MobCategory.MONSTER)
                    .sized(8.0F, 6.0F).clientTrackingRange(16).build("warship"));

    public static final RegistryObject<EntityType<CircuitEntity>> CIRCUIT = ENTITIES.register("circuit",
            () -> EntityType.Builder.of(CircuitEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.2F).clientTrackingRange(10).build("circuit"));

    public static final RegistryObject<EntityType<AshHoundEntity>> ASH_HOUND = ENTITIES.register("ash_hound",
            () -> EntityType.Builder.of(AshHoundEntity::new, MobCategory.MONSTER)
                    .sized(1.0F, 1.3F).clientTrackingRange(10).build("ash_hound"));

    public static final RegistryObject<EntityType<CloudRayEntity>> CLOUD_RAY = ENTITIES.register("cloud_ray",
            () -> EntityType.Builder.of(CloudRayEntity::new, MobCategory.CREATURE)
                    .sized(3.0F, 1.6F).clientTrackingRange(12).build("cloud_ray"));

    public static final RegistryObject<EntityType<BogWretchEntity>> BOG_WRETCH = ENTITIES.register("bog_wretch",
            () -> EntityType.Builder.of(BogWretchEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.2F).clientTrackingRange(10).build("bog_wretch"));

    public static final RegistryObject<EntityType<LanternWraithEntity>> LANTERN_WRAITH = ENTITIES.register("lantern_wraith",
            () -> EntityType.Builder.of(LanternWraithEntity::new, MobCategory.MONSTER)
                    .sized(0.8F, 2.0F).clientTrackingRange(10).build("lantern_wraith"));

    public static final RegistryObject<EntityType<HollowNeighborEntity>> HOLLOW_NEIGHBOR = ENTITIES.register("hollow_neighbor",
            () -> EntityType.Builder.of(HollowNeighborEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.1F).clientTrackingRange(10).build("hollow_neighbor"));

    public static final RegistryObject<EntityType<TornadoEntity>> TORNADO = ENTITIES.register("tornado",
            () -> EntityType.Builder.of(TornadoEntity::new, MobCategory.MISC)
                    .sized(6.0F, 12.0F).fireImmune().clientTrackingRange(16).build("tornado"));

    private ModEntities() {
    }
}
