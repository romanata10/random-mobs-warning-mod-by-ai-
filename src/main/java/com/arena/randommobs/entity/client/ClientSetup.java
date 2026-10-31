package com.arena.randommobs.entity.client;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.entity.client.model.AliveHouseModel;
import com.arena.randommobs.entity.client.model.AshHoundModel;
import com.arena.randommobs.entity.client.model.BogWretchModel;
import com.arena.randommobs.entity.client.model.ChestMimicModel;
import com.arena.randommobs.entity.client.model.CircuitModel;
import com.arena.randommobs.entity.client.model.CloudRayModel;
import com.arena.randommobs.entity.client.model.HollowNeighborModel;
import com.arena.randommobs.entity.client.model.LanternWraithModel;
import com.arena.randommobs.entity.client.model.LightsModel;
import com.arena.randommobs.entity.client.model.SirenHeadModel;
import com.arena.randommobs.entity.client.model.TankModel;
import com.arena.randommobs.entity.client.model.TornadoModel;
import com.arena.randommobs.entity.client.model.WarshipModel;
import com.arena.randommobs.entity.client.model.WaterGrabberModel;
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
        event.registerLayerDefinition(ModModelLayers.LIGHTS, LightsModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHEST_MIMIC, ChestMimicModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WATER_GRABBER, WaterGrabberModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.TANK, TankModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SIREN_HEAD, SirenHeadModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WARSHIP, WarshipModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CIRCUIT, CircuitModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ASH_HOUND, AshHoundModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CLOUD_RAY, CloudRayModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BOG_WRETCH, BogWretchModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LANTERN_WRAITH, LanternWraithModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HOLLOW_NEIGHBOR, HollowNeighborModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.TORNADO, TornadoModel::createBodyLayer);
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
        event.registerEntityRenderer(ModEntities.LIGHTS.get(), context ->
                new RMobRenderer<>(context, new LightsModel(context.bakeLayer(ModModelLayers.LIGHTS)),
                        LightsModel.SHADOW, LightsModel.TEXTURE, LightsModel.SCALE));
        event.registerEntityRenderer(ModEntities.CHEST_MIMIC.get(), context ->
                new RMobRenderer<>(context, new ChestMimicModel(context.bakeLayer(ModModelLayers.CHEST_MIMIC)),
                        ChestMimicModel.SHADOW, ChestMimicModel.TEXTURE, ChestMimicModel.SCALE));
        event.registerEntityRenderer(ModEntities.WATER_GRABBER.get(), context ->
                new RMobRenderer<>(context, new WaterGrabberModel(context.bakeLayer(ModModelLayers.WATER_GRABBER)),
                        WaterGrabberModel.SHADOW, WaterGrabberModel.TEXTURE, WaterGrabberModel.SCALE));
        event.registerEntityRenderer(ModEntities.TANK.get(), context ->
                new RMobRenderer<>(context, new TankModel(context.bakeLayer(ModModelLayers.TANK)),
                        TankModel.SHADOW, TankModel.TEXTURE, TankModel.SCALE));
        event.registerEntityRenderer(ModEntities.SIREN_HEAD.get(), context ->
                new RMobRenderer<>(context, new SirenHeadModel(context.bakeLayer(ModModelLayers.SIREN_HEAD)),
                        SirenHeadModel.SHADOW, SirenHeadModel.TEXTURE, SirenHeadModel.SCALE));
        event.registerEntityRenderer(ModEntities.WARSHIP.get(), context ->
                new RMobRenderer<>(context, new WarshipModel(context.bakeLayer(ModModelLayers.WARSHIP)),
                        WarshipModel.SHADOW, WarshipModel.TEXTURE, WarshipModel.SCALE));
        event.registerEntityRenderer(ModEntities.CIRCUIT.get(), context ->
                new RMobRenderer<>(context, new CircuitModel(context.bakeLayer(ModModelLayers.CIRCUIT)),
                        CircuitModel.SHADOW, CircuitModel.TEXTURE, CircuitModel.SCALE));
        event.registerEntityRenderer(ModEntities.ASH_HOUND.get(), context ->
                new RMobRenderer<>(context, new AshHoundModel(context.bakeLayer(ModModelLayers.ASH_HOUND)),
                        AshHoundModel.SHADOW, AshHoundModel.TEXTURE, AshHoundModel.SCALE));
        event.registerEntityRenderer(ModEntities.CLOUD_RAY.get(), context ->
                new RMobRenderer<>(context, new CloudRayModel(context.bakeLayer(ModModelLayers.CLOUD_RAY)),
                        CloudRayModel.SHADOW, CloudRayModel.TEXTURE, CloudRayModel.SCALE));
        event.registerEntityRenderer(ModEntities.BOG_WRETCH.get(), context ->
                new RMobRenderer<>(context, new BogWretchModel(context.bakeLayer(ModModelLayers.BOG_WRETCH)),
                        BogWretchModel.SHADOW, BogWretchModel.TEXTURE, BogWretchModel.SCALE));
        event.registerEntityRenderer(ModEntities.LANTERN_WRAITH.get(), context ->
                new RMobRenderer<>(context, new LanternWraithModel(context.bakeLayer(ModModelLayers.LANTERN_WRAITH)),
                        LanternWraithModel.SHADOW, LanternWraithModel.TEXTURE, LanternWraithModel.SCALE));
        event.registerEntityRenderer(ModEntities.HOLLOW_NEIGHBOR.get(), context ->
                new RMobRenderer<>(context, new HollowNeighborModel(context.bakeLayer(ModModelLayers.HOLLOW_NEIGHBOR)),
                        HollowNeighborModel.SHADOW, HollowNeighborModel.TEXTURE, HollowNeighborModel.SCALE));
        event.registerEntityRenderer(ModEntities.TORNADO.get(), context ->
                new RMobRenderer<>(context, new TornadoModel(context.bakeLayer(ModModelLayers.TORNADO)),
                        TornadoModel.SHADOW, TornadoModel.TEXTURE, TornadoModel.SCALE));
    }

    private ClientSetup() {
    }
}
