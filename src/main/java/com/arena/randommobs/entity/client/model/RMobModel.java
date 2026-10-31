package com.arena.randommobs.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

/**
 * Small shared base for the (procedurally generated) creature models.
 */
public abstract class RMobModel<T extends LivingEntity> extends EntityModel<T> {
    protected final ModelPart root;
    protected List<ModelPart> legs = List.of();
    protected List<ModelPart> tentacles = List.of();
    protected List<ModelPart> arms = List.of();
    protected List<ModelPart> wings = List.of();
    protected ModelPart head;
    protected ModelPart body;

    protected RMobModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
    }

    protected void registerParts(List<ModelPart> legs, List<ModelPart> tentacles, List<ModelPart> arms,
                                 List<ModelPart> wings, ModelPart head, ModelPart body) {
        this.legs = legs;
        this.tentacles = tentacles;
        this.arms = arms;
        this.wings = wings;
        this.head = head;
        this.body = body;
    }

    protected void resetPose() {
        this.root.getAllParts().forEach(ModelPart::resetPose);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
