package com.randommobs.client.render;

import com.randommobs.RandomMobs;
import com.randommobs.client.model.TripodModel;
import com.randommobs.entity.TripodEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TripodRenderer extends MobRenderer<TripodEntity, TripodModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RandomMobs.MODID, "textures/entity/tripod.png");

    public TripodRenderer(EntityRendererProvider.Context context) {
        super(context, new TripodModel(context.bakeLayer(com.randommobs.registry.ModModelLayers.TRIPOD_LAYER)), 1.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(TripodEntity entity) {
        return TEXTURE;
    }
}
