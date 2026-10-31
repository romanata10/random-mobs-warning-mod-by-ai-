package com.randommobs.registry;

import com.randommobs.RandomMobs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RandomMobs.MODID);

    public static final RegistryObject<Item> TRIPOD_SPAWN_EGG = ITEMS.register("tripod_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TRIPOD, 0x7A3B24, 0xFF9A3C, new Item.Properties()));

    public static final RegistryObject<Item> WOODCRAWLER_SPAWN_EGG = ITEMS.register("woodcrawler_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WOODCRAWLER, 0x5C4433, 0x9C8468, new Item.Properties()));
}
