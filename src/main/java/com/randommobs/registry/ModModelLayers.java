package com.randommobs.registry;

import com.randommobs.RandomMobs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation TRIPOD_LAYER =
            new ModelLayerLocation(new ResourceLocation(RandomMobs.MODID, "tripod"), "main");

    public static final ModelLayerLocation WOODCRAWLER_LAYER =
            new ModelLayerLocation(new ResourceLocation(RandomMobs.MODID, "woodcrawler"), "main");
}
