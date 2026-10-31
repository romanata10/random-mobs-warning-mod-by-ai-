package com.randommobs.client.render;

import com.randommobs.RandomMobs;
import com.randommobs.client.model.WoodcrawlerModel;
import com.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WoodcrawlerRenderer extends MobRenderer<WoodcrawlerEntity, WoodcrawlerModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RandomMobs.MODID, "textures/entity/woodcrawler.png");

    public WoodcrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new WoodcrawlerModel(context.bakeLayer(com.randommobs.registry.ModModelLayers.WOODCRAWLER_LAYER)), 0.9F);
    }

    @Override
    public ResourceLocation getTextureLocation(WoodcrawlerEntity entity) {
        return TEXTURE;
    }
}
