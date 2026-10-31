package com.arena.randommobs.entity.client;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.entity.client.model.AliveHouseModel;
import com.arena.randommobs.entity.client.model.AliveTreeModel;
import com.arena.randommobs.entity.client.model.BearModel;
import com.arena.randommobs.entity.client.model.BloopModel;
import com.arena.randommobs.entity.client.model.EvilWatermelonModel;
import com.arena.randommobs.entity.client.model.GardenerModel;
import com.arena.randommobs.entity.client.model.GiantSpiderModel;
import com.arena.randommobs.entity.client.model.KrakenModel;
import com.arena.randommobs.entity.client.model.SandWormModel;
import com.arena.randommobs.entity.client.model.TripodModel;
import com.arena.randommobs.entity.client.model.UfoModel;
import com.arena.randommobs.entity.client.model.WoodcockModel;
import com.arena.randommobs.entity.client.model.WoodcrawlerModel;
import com.arena.randommobs.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientSetup {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TRIPOD, TripodModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WOODCRAWLER, WoodcrawlerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BLOOP, BloopModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ALIVE_HOUSE, AliveHouseModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GIANT_SPIDER, GiantSpiderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GARDENER, GardenerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SAND_WORM, SandWormModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.UFO, UfoModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BEAR, BearModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.KRAKEN, KrakenModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EVIL_WATERMELON, EvilWatermelonModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ALIVE_TREE, AliveTreeModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WOODCOCK, WoodcockModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TRIPOD.get(), context ->
                new RMobRenderer<>(context, new TripodModel(context.bakeLayer(ModModelLayers.TRIPOD)),
                        TripodModel.SHADOW, TripodModel.TEXTURE, TripodModel.SCALE));
        event.registerEntityRenderer(ModEntities.WOODCRAWLER.get(), context ->
                new RMobRenderer<>(context, new WoodcrawlerModel(context.bakeLayer(ModModelLayers.WOODCRAWLER)),
                        WoodcrawlerModel.SHADOW, WoodcrawlerModel.TEXTURE, WoodcrawlerModel.SCALE));
        event.registerEntityRenderer(ModEntities.BLOOP.get(), context ->
                new RMobRenderer<>(context, new BloopModel(context.bakeLayer(ModModelLayers.BLOOP)),
                        BloopModel.SHADOW, BloopModel.TEXTURE, BloopModel.SCALE));
        event.registerEntityRenderer(ModEntities.ALIVE_HOUSE.get(), context ->
                new RMobRenderer<>(context, new AliveHouseModel(context.bakeLayer(ModModelLayers.ALIVE_HOUSE)),
                        AliveHouseModel.SHADOW, AliveHouseModel.TEXTURE, AliveHouseModel.SCALE));
        event.registerEntityRenderer(ModEntities.GIANT_SPIDER.get(), context ->
                new RMobRenderer<>(context, new GiantSpiderModel(context.bakeLayer(ModModelLayers.GIANT_SPIDER)),
                        GiantSpiderModel.SHADOW, GiantSpiderModel.TEXTURE, GiantSpiderModel.SCALE));
        event.registerEntityRenderer(ModEntities.GARDENER.get(), context ->
                new RMobRenderer<>(context, new GardenerModel(context.bakeLayer(ModModelLayers.GARDENER)),
                        GardenerModel.SHADOW, GardenerModel.TEXTURE, GardenerModel.SCALE));
        event.registerEntityRenderer(ModEntities.SAND_WORM.get(), context ->
                new RMobRenderer<>(context, new SandWormModel(context.bakeLayer(ModModelLayers.SAND_WORM)),
                        SandWormModel.SHADOW, SandWormModel.TEXTURE, SandWormModel.SCALE));
        event.registerEntityRenderer(ModEntities.UFO.get(), context ->
                new RMobRenderer<>(context, new UfoModel(context.bakeLayer(ModModelLayers.UFO)),
                        UfoModel.SHADOW, UfoModel.TEXTURE, UfoModel.SCALE));
        event.registerEntityRenderer(ModEntities.BEAR.get(), context ->
                new RMobRenderer<>(context, new BearModel(context.bakeLayer(ModModelLayers.BEAR)),
                        BearModel.SHADOW, BearModel.TEXTURE, BearModel.SCALE));
        event.registerEntityRenderer(ModEntities.KRAKEN.get(), context ->
                new RMobRenderer<>(context, new KrakenModel(context.bakeLayer(ModModelLayers.KRAKEN)),
                        KrakenModel.SHADOW, KrakenModel.TEXTURE, KrakenModel.SCALE));
        event.registerEntityRenderer(ModEntities.EVIL_WATERMELON.get(), context ->
                new RMobRenderer<>(context, new EvilWatermelonModel(context.bakeLayer(ModModelLayers.EVIL_WATERMELON)),
                        EvilWatermelonModel.SHADOW, EvilWatermelonModel.TEXTURE, EvilWatermelonModel.SCALE));
        event.registerEntityRenderer(ModEntities.ALIVE_TREE.get(), context ->
                new RMobRenderer<>(context, new AliveTreeModel(context.bakeLayer(ModModelLayers.ALIVE_TREE)),
                        AliveTreeModel.SHADOW, AliveTreeModel.TEXTURE, AliveTreeModel.SCALE));
        event.registerEntityRenderer(ModEntities.WOODCOCK.get(), context ->
                new RMobRenderer<>(context, new WoodcockModel(context.bakeLayer(ModModelLayers.WOODCOCK)),
                        WoodcockModel.SHADOW, WoodcockModel.TEXTURE, WoodcockModel.SCALE));
    }

    private ClientSetup() {
    }
}
