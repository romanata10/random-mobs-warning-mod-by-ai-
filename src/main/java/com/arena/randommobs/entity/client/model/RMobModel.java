package com.arena.randommobs.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;

/**
 * Shared base for the procedurally generated creature models.
 */
public abstract class RMobModel<T extends LivingEntity> extends EntityModel<T> {
    protected final ModelPart root;

    protected RMobModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
    }

    protected void resetPose() {
        this.root.getAllParts().forEach(ModelPart::resetPose);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer,
                               int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
