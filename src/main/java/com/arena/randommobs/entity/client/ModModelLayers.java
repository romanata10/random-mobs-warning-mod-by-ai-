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

    private static ModelLayerLocation layer(String name) {
        return new ModelLayerLocation(RandomMobs.id(name), "main");
    }

    private ModModelLayers() {
    }
}
