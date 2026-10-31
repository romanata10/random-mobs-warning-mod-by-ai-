package com.randommobs;

import com.mojang.logging.LogUtils;
import com.randommobs.client.render.TripodRenderer;
import com.randommobs.client.render.WoodcrawlerRenderer;
import com.randommobs.entity.TripodEntity;
import com.randommobs.entity.WoodcrawlerEntity;
import com.randommobs.registry.ModEntities;
import com.randommobs.registry.ModItems;
import com.randommobs.registry.ModModelLayers;
import com.randommobs.registry.ModEffects;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;

/**
 * Random Mobs — a Forge 1.20.1 mod that adds creepy mobs:
 * 1) Tripod from "War of the Worlds" (with the "Oh that just fish" achievement
 *    for submerging it underwater),
 * 2) Woodcrawler from "Gemini Home Entertainment" (infects the player with the
 *    Root Virus on hit).
 */
@Mod(RandomMobs.MODID)
public class RandomMobs {

    public static final String MODID = "randommobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RandomMobs() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.ENTITY_TYPES.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEffects.MOB_EFFECTS.register(modBus);

        modBus.addListener(this::onEntityAttributes);
        modBus.addListener(this::onBuildCreativeTabs);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modBus.addListener(this::onRegisterLayers);
            modBus.addListener(this::onRegisterRenderers);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RandomMobsConfig.SPEC);
    }

    private void onEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TRIPOD.get(), TripodEntity.createAttributes().build());
        event.put(ModEntities.WOODCRAWLER.get(), WoodcrawlerEntity.createAttributes().build());
    }

    private void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.TRIPOD_SPAWN_EGG.get());
            event.accept(ModItems.WOODCRAWLER_SPAWN_EGG.get());
        }
    }

    private void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinition event) {
        event.registerLayerDefinition(ModModelLayers.TRIPOD_LAYER, com.randommobs.client.model.TripodModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WOODCRAWLER_LAYER, com.randommobs.client.model.WoodcrawlerModel::createBodyLayer);
    }

    private void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TRIPOD.get(), TripodRenderer::new);
        event.registerEntityRenderer(ModEntities.WOODCRAWLER.get(), WoodcrawlerRenderer::new);
    }
}
