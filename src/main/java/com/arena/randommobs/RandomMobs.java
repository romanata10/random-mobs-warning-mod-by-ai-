package com.arena.randommobs;

import com.arena.randommobs.registry.ModBlocks;
import com.arena.randommobs.registry.ModEffects;
import com.arena.randommobs.registry.ModEntities;
import com.arena.randommobs.registry.ModItems;
import com.arena.randommobs.registry.ModTabs;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * Random Mobs - a mod about very large, very strange things that want to eat you.
 */
@Mod(RandomMobs.MODID)
public class RandomMobs {
    public static final String MODID = "randommobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RandomMobs() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEffects.EFFECTS.register(modBus);
        ModEntities.ENTITIES.register(modBus);
        ModTabs.TABS.register(modBus);

        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Random Mobs loaded. Please do not look at the UFO.");
    }

    public static net.minecraft.resources.ResourceLocation id(String path) {
        return new net.minecraft.resources.ResourceLocation(MODID, path);
    }
}
