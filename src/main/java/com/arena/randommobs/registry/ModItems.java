package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.item.BoltLanceItem;
import com.arena.randommobs.item.ChipsItem;
import com.arena.randommobs.item.HeatRayItem;
import com.arena.randommobs.item.RadioItem;
import com.arena.randommobs.item.TimeClockItem;
import com.arena.randommobs.item.WeatherMapItem;
import com.arena.randommobs.item.RootBladeItem;
import com.arena.randommobs.item.RootSeedItem;
import com.arena.randommobs.item.RootShardItem;
import com.arena.randommobs.item.RootSerumItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RandomMobs.MODID);

    public static final List<RegistryObject<Item>> ALL = new ArrayList<>();

    // ---- materials -------------------------------------------------------
    public static final RegistryObject<Item> TRIPOD_CORE = register("tripod_core", () -> new Item(props()));
    public static final RegistryObject<Item> ALIEN_METAL_INGOT = register("alien_metal_ingot", () -> new Item(props()));
    public static final RegistryObject<Item> CRAWLER_CLAW = register("crawler_claw", () -> new Item(props()));
    public static final RegistryObject<Item> MOCKERY_POD = register("mockery_pod", () -> new Item(props()));
    public static final RegistryObject<Item> BLOOP_EYE = register("bloop_eye", () -> new Item(props()));
    public static final RegistryObject<Item> UFO_SCRAP = register("ufo_scrap", () -> new Item(props()));
    public static final RegistryObject<Item> GIANT_SPIDER_SILK = register("giant_spider_silk", () -> new Item(props()));
    public static final RegistryObject<Item> MEEP_FEATHER = register("meep_feather", () -> new Item(props()));

    // ---- weapons / tools -------------------------------------------------
    public static final RegistryObject<Item> HEAT_RAY = register("heat_ray",
            () -> new HeatRayItem(props().stacksTo(1).durability(384).fireResistant()));
    public static final RegistryObject<Item> ROOT_BLADE = register("root_blade",
            () -> new RootBladeItem(Tiers.DIAMOND, 3, -2.2F, props().durability(1500)));
    public static final RegistryObject<Item> SAND_WORM_FANG = register("sand_worm_fang",
            () -> new SwordItem(Tiers.IRON, 2, -1.4F, props().durability(420)));

    // ---- consumables -----------------------------------------------------
    public static final RegistryObject<Item> ROOT_SERUM = register("root_serum",
            () -> new RootSerumItem(props().stacksTo(8)));

    public static final RegistryObject<Item> BEAR_MEAT = register("bear_meat",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).meat().build())));
    public static final RegistryObject<Item> COOKED_BEAR_MEAT = register("cooked_bear_meat",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(9).saturationMod(0.8F).meat().build())));
    public static final RegistryObject<Item> KRAKEN_TENTACLE = register("kraken_tentacle",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.6F).meat().build())));
    public static final RegistryObject<Item> COOKED_KRAKEN_TENTACLE = register("cooked_kraken_tentacle",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).meat().build())));
    public static final RegistryObject<Item> ROOT_FRUIT = register("root_fruit",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4F)
                    .effect(new MobEffectInstance(ModEffects.ROOT_INFECTION.get(), 160, 0), 0.25F).build())));
    public static final RegistryObject<Item> ROOT_SEED = register("root_seed",
            () -> new RootSeedItem(props()));
    public static final RegistryObject<Item> ROOT_SHARD = register("root_shard",
            () -> new RootShardItem(props().stacksTo(1).fireResistant()));


    // ---- 1.1 storm pack --------------------------------------------------
    public static final RegistryObject<Item> LOCK_KEY = register("lock_key", () -> new Item(props().stacksTo(1)));
    public static final RegistryObject<Item> STORM_RADIO = register("storm_radio",
            () -> new RadioItem(props().stacksTo(1)));
    public static final RegistryObject<Item> WEATHER_MAP = register("weather_map",
            () -> new WeatherMapItem(props().stacksTo(1)));
    public static final RegistryObject<Item> TIME_CLOCK = register("time_clock",
            () -> new TimeClockItem(props().stacksTo(1)));
    public static final RegistryObject<Item> CHIPS = register("chips",
            () -> new ChipsItem(props().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4F)
                    .fast().build())));
    public static final RegistryObject<Item> KIRIESHKI = register("kirieshki",
            () -> new ChipsItem(props().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.6F)
                    .fast().build())));
    public static final RegistryObject<Item> CHEESE_SLICE = register("cheese_slice",
            () -> new Item(props().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> BOLT_LANCE = register("bolt_lance",
            () -> new BoltLanceItem(Tiers.IRON, 4, -2.4F, props().durability(600)));
    public static final RegistryObject<Item> TANK_TRACK = register("tank_track", () -> new Item(props()));
    public static final RegistryObject<Item> CIRCUIT_FRAGMENT = register("circuit_fragment", () -> new Item(props()));
    public static final RegistryObject<Item> STORM_SCALE = register("storm_scale", () -> new Item(props()));
    public static final RegistryObject<Item> SIREN_BULB = register("siren_bulb", () -> new Item(props()));

    // ---- spawn eggs ------------------------------------------------------
    public static final RegistryObject<Item> TRIPOD_SPAWN_EGG = spawnEgg("tripod_spawn_egg", () -> ModEntities.TRIPOD.get(), 0x3d4450, 0xf2d15a);
    public static final RegistryObject<Item> WOODCRAWLER_SPAWN_EGG = spawnEgg("woodcrawler_spawn_egg", () -> ModEntities.WOODCRAWLER.get(), 0x5d4227, 0xb8d86a);
    public static final RegistryObject<Item> BLOOP_SPAWN_EGG = spawnEgg("bloop_spawn_egg", () -> ModEntities.BLOOP.get(), 0x0d2b3a, 0x2fd6c9);
    public static final RegistryObject<Item> ALIVE_HOUSE_SPAWN_EGG = spawnEgg("alive_house_spawn_egg", () -> ModEntities.ALIVE_HOUSE.get(), 0x7a6350, 0x2b2118);
    public static final RegistryObject<Item> GIANT_SPIDER_SPAWN_EGG = spawnEgg("giant_spider_spawn_egg", () -> ModEntities.GIANT_SPIDER.get(), 0x3b3324, 0x8b2d1c);
    public static final RegistryObject<Item> GARDENER_SPAWN_EGG = spawnEgg("gardener_spawn_egg", () -> ModEntities.GARDENER.get(), 0xb8a48e, 0xfff39a);
    public static final RegistryObject<Item> SAND_WORM_SPAWN_EGG = spawnEgg("sand_worm_spawn_egg", () -> ModEntities.SAND_WORM.get(), 0xc8b07a, 0x6d2b23);
    public static final RegistryObject<Item> UFO_SPAWN_EGG = spawnEgg("ufo_spawn_egg", () -> ModEntities.UFO.get(), 0x878f96, 0x7cf2a8);
    public static final RegistryObject<Item> BEAR_SPAWN_EGG = spawnEgg("bear_spawn_egg", () -> ModEntities.BEAR.get(), 0x5b3a24, 0x2a1a10);
    public static final RegistryObject<Item> KRAKEN_SPAWN_EGG = spawnEgg("kraken_spawn_egg", () -> ModEntities.KRAKEN.get(), 0x2a1a3a, 0xa37dd6);
    public static final RegistryObject<Item> EVIL_WATERMELON_SPAWN_EGG = spawnEgg("evil_watermelon_spawn_egg", () -> ModEntities.EVIL_WATERMELON.get(), 0x2f5c1f, 0xd43a3a);
    public static final RegistryObject<Item> ALIVE_TREE_SPAWN_EGG = spawnEgg("alive_tree_spawn_egg", () -> ModEntities.ALIVE_TREE.get(), 0x5a3f22, 0x3f7a2e);
    public static final RegistryObject<Item> WOODCOCK_SPAWN_EGG = spawnEgg("woodcock_spawn_egg", () -> ModEntities.WOODCOCK.get(), 0x6b5540, 0xd8c3a2);
    public static final RegistryObject<Item> LIGHTS_SPAWN_EGG = spawnEgg("lights_spawn_egg", () -> ModEntities.LIGHTS.get(), 0x8a8f95, 0xffffff);
    public static final RegistryObject<Item> CHEST_MIMIC_SPAWN_EGG = spawnEgg("chest_mimic_spawn_egg", () -> ModEntities.CHEST_MIMIC.get(), 0x7a5a2e, 0xd8b46a);
    public static final RegistryObject<Item> WATER_GRABBER_SPAWN_EGG = spawnEgg("water_grabber_spawn_egg", () -> ModEntities.WATER_GRABBER.get(), 0x8c2f45, 0xe0a3b5);
    public static final RegistryObject<Item> TANK_SPAWN_EGG = spawnEgg("tank_spawn_egg", () -> ModEntities.TANK.get(), 0x4a5232, 0x2b2f1c);
    public static final RegistryObject<Item> SIREN_HEAD_SPAWN_EGG = spawnEgg("siren_head_spawn_egg", () -> ModEntities.SIREN_HEAD.get(), 0x8e8471, 0xc4463a);
    public static final RegistryObject<Item> WARSHIP_SPAWN_EGG = spawnEgg("warship_spawn_egg", () -> ModEntities.WARSHIP.get(), 0x3d4650, 0x8f2f2a);
    public static final RegistryObject<Item> CIRCUIT_SPAWN_EGG = spawnEgg("circuit_spawn_egg", () -> ModEntities.CIRCUIT.get(), 0x1d2b2b, 0x59ffd0);
    public static final RegistryObject<Item> ASH_HOUND_SPAWN_EGG = spawnEgg("ash_hound_spawn_egg", () -> ModEntities.ASH_HOUND.get(), 0x3b332d, 0xd9713a);
    public static final RegistryObject<Item> CLOUD_RAY_SPAWN_EGG = spawnEgg("cloud_ray_spawn_egg", () -> ModEntities.CLOUD_RAY.get(), 0xd7dde2, 0x6fa8c9);
    public static final RegistryObject<Item> BOG_WRETCH_SPAWN_EGG = spawnEgg("bog_wretch_spawn_egg", () -> ModEntities.BOG_WRETCH.get(), 0x38442c, 0x7f8f52);
    public static final RegistryObject<Item> LANTERN_WRAITH_SPAWN_EGG = spawnEgg("lantern_wraith_spawn_egg", () -> ModEntities.LANTERN_WRAITH.get(), 0x2a2f3c, 0x74c9ff);
    public static final RegistryObject<Item> HOLLOW_NEIGHBOR_SPAWN_EGG = spawnEgg("hollow_neighbor_spawn_egg", () -> ModEntities.HOLLOW_NEIGHBOR.get(), 0x6a5a48, 0x1b1712);

    private static Item.Properties props() {
        return new Item.Properties();
    }

    public static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        RegistryObject<Item> reg = ITEMS.register(name, supplier);
        ALL.add(reg);
        return reg;
    }

    private static RegistryObject<Item> spawnEgg(String name,
                                                 Supplier<? extends net.minecraft.world.entity.EntityType<? extends net.minecraft.world.entity.Mob>> type,
                                                 int background, int highlight) {
        return register(name, () -> new ForgeSpawnEggItem(type, background, highlight, new Item.Properties()));
    }

    private ModItems() {
    }
}
