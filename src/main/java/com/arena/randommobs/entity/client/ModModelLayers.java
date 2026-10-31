package com.arena.randommobs.entity.client;

import com.arena.randommobs.RandomMobs;
import net.minecraft.client.model.geom.ModelLayerLocation;

public final class ModModelLayers {
    public static final ModelLayerLocation TRIPOD = layer("tripod");
    public static final ModelLayerLocation WOODCRAWLER = layer("woodcrawler");
    public static final ModelLayerLocation BLOOP = layer("bloop");
    public static final ModelLayerLocation ALIVE_HOUSE = layer("alive_house");
    public static final ModelLayerLocation GIANT_SPIDER = layer("giant_spider");
    public static final ModelLayerLocation GARDENER = layer("gardener");
    public static final ModelLayerLocation SAND_WORM = layer("sand_worm");
    public static final ModelLayerLocation UFO = layer("ufo");
    public static final ModelLayerLocation BEAR = layer("bear");
    public static final ModelLayerLocation KRAKEN = layer("kraken");
    public static final ModelLayerLocation EVIL_WATERMELON = layer("evil_watermelon");
    public static final ModelLayerLocation ALIVE_TREE = layer("alive_tree");
    public static final ModelLayerLocation WOODCOCK = layer("woodcock");
    public static final ModelLayerLocation LIGHTS = layer("lights");
    public static final ModelLayerLocation CHEST_MIMIC = layer("chest_mimic");
    public static final ModelLayerLocation WATER_GRABBER = layer("water_grabber");
    public static final ModelLayerLocation TANK = layer("tank");
    public static final ModelLayerLocation SIREN_HEAD = layer("siren_head");
    public static final ModelLayerLocation WARSHIP = layer("warship");
    public static final ModelLayerLocation CIRCUIT = layer("circuit");
    public static final ModelLayerLocation ASH_HOUND = layer("ash_hound");
    public static final ModelLayerLocation CLOUD_RAY = layer("cloud_ray");
    public static final ModelLayerLocation BOG_WRETCH = layer("bog_wretch");
    public static final ModelLayerLocation LANTERN_WRAITH = layer("lantern_wraith");
    public static final ModelLayerLocation HOLLOW_NEIGHBOR = layer("hollow_neighbor");
    public static final ModelLayerLocation TORNADO = layer("tornado");

    private static ModelLayerLocation layer(String name) {
        return new ModelLayerLocation(RandomMobs.id(name), "main");
    }

    private ModModelLayers() {
    }
}
