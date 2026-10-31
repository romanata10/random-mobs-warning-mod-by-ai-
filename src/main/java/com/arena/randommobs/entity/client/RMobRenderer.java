package com.arena.randommobs.entity.client;

import com.arena.randommobs.entity.RAnimatedMob;
import com.arena.randommobs.entity.client.model.RMobModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class RMobRenderer<T extends Mob, M extends RMobModel<T>> extends MobRenderer<T, M> {
    private final ResourceLocation texture;
    private final float modelScale;

    public RMobRenderer(EntityRendererProvider.Context context, M model, float shadow, ResourceLocation texture,
                        float modelScale) {
        super(context, model, shadow);
        this.texture = texture;
        this.modelScale = modelScale;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }

    @Override
    protected void scale(T entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(this.modelScale, this.modelScale, this.modelScale);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        float offset = entity instanceof RAnimatedMob animated ? animated.renderYOffset(partialTick) : 0.0F;
        if (offset != 0.0F) {
            poseStack.pushPose();
            poseStack.translate(0.0D, offset, 0.0D);
            super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
            poseStack.popPose();
        } else {
            super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
        }
    }
}
