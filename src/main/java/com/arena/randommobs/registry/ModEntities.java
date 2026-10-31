package com.arena.randommobs.registry;

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
                    .sized(2.6F, 5.6F).clientTrackingRange(12).build("tripod"));

    public static final RegistryObject<EntityType<WoodcrawlerEntity>> WOODCRAWLER = ENTITIES.register("woodcrawler",
            () -> EntityType.Builder.of(WoodcrawlerEntity::new, MobCategory.MONSTER)
                    .sized(0.7F, 1.9F).clientTrackingRange(10).build("woodcrawler"));

    public static final RegistryObject<EntityType<BloopEntity>> BLOOP = ENTITIES.register("bloop",
            () -> EntityType.Builder.of(BloopEntity::new, MobCategory.MONSTER)
                    .sized(6.0F, 5.0F).clientTrackingRange(12).build("bloop"));

    public static final RegistryObject<EntityType<AliveHouseEntity>> ALIVE_HOUSE = ENTITIES.register("alive_house",
            () -> EntityType.Builder.of(AliveHouseEntity::new, MobCategory.MONSTER)
                    .sized(4.2F, 4.0F).clientTrackingRange(10).build("alive_house"));

    public static final RegistryObject<EntityType<GiantSpiderEntity>> GIANT_SPIDER = ENTITIES.register("giant_spider",
            () -> EntityType.Builder.of(GiantSpiderEntity::new, MobCategory.MONSTER)
                    .sized(3.4F, 2.2F).clientTrackingRange(10).build("giant_spider"));

    public static final RegistryObject<EntityType<GardenerEntity>> GARDENER = ENTITIES.register("gardener",
            () -> EntityType.Builder.of(GardenerEntity::new, MobCategory.MONSTER)
                    .sized(1.2F, 2.6F).clientTrackingRange(10).build("gardener"));

    public static final RegistryObject<EntityType<SandWormEntity>> SAND_WORM = ENTITIES.register("sand_worm",
            () -> EntityType.Builder.of(SandWormEntity::new, MobCategory.MONSTER)
                    .sized(2.2F, 2.2F).clientTrackingRange(10).build("sand_worm"));

    public static final RegistryObject<EntityType<UfoEntity>> UFO = ENTITIES.register("ufo",
            () -> EntityType.Builder.of(UfoEntity::new, MobCategory.MONSTER)
                    .sized(3.0F, 1.4F).clientTrackingRange(12).build("ufo"));

    public static final RegistryObject<EntityType<BearEntity>> BEAR = ENTITIES.register("bear",
            () -> EntityType.Builder.of(BearEntity::new, MobCategory.CREATURE)
                    .sized(1.4F, 1.6F).clientTrackingRange(10).build("bear"));

    public static final RegistryObject<EntityType<KrakenEntity>> KRAKEN = ENTITIES.register("kraken",
            () -> EntityType.Builder.of(KrakenEntity::new, MobCategory.MONSTER)
                    .sized(4.5F, 4.0F).clientTrackingRange(12).build("kraken"));

    public static final RegistryObject<EntityType<EvilWatermelonEntity>> EVIL_WATERMELON = ENTITIES.register("evil_watermelon",
            () -> EntityType.Builder.of(EvilWatermelonEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 0.9F).clientTrackingRange(8).build("evil_watermelon"));

    public static final RegistryObject<EntityType<AliveTreeEntity>> ALIVE_TREE = ENTITIES.register("alive_tree",
            () -> EntityType.Builder.of(AliveTreeEntity::new, MobCategory.MONSTER)
                    .sized(2.2F, 4.6F).clientTrackingRange(10).build("alive_tree"));

    public static final RegistryObject<EntityType<WoodcockEntity>> WOODCOCK = ENTITIES.register("woodcock",
            () -> EntityType.Builder.of(WoodcockEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.9F).clientTrackingRange(10).build("woodcock"));

    private ModEntities() {
    }
}
