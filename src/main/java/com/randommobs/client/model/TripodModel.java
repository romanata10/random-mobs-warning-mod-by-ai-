package com.randommobs.client.model;

import com.randommobs.entity.TripodEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

/**
 * Tripod model: a hood (head) on a small body, two hanging tentacles and
 * three long legs standing like a tripod. Roughly 7.7 blocks tall.
 * Texture size: 128x256.
 */
public class TripodModel extends HierarchicalModel<TripodEntity> {

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart hood;
    private final ModelPart aperture;
    private final ModelPart legFrontLeft;
    private final ModelPart legFrontRight;
    private final ModelPart legBack;
    private final ModelPart tentacleLeft;
    private final ModelPart tentacleRight;

    public TripodModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.hood = this.body.getChild("hood");
        this.aperture = this.hood.getChild("aperture");
        this.legFrontLeft = root.getChild("leg_front_left");
        this.legFrontRight = root.getChild("leg_front_right");
        this.legBack = root.getChild("leg_back");
        this.tentacleLeft = this.body.getChild("tentacle_left");
        this.tentacleRight = this.body.getChild("tentacle_right");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        // Three long legs, hips ~6 blocks up, feet on the ground.
        root.addOrReplaceChild("leg_front_left",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 96.0F, 4.0F),
                PartPose.offset(-16.0F, -72.0F, 20.0F));
        root.addOrReplaceChild("leg_front_right",
                CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 96.0F, 4.0F),
                PartPose.offset(16.0F, -72.0F, 20.0F));
        root.addOrReplaceChild("leg_back",
                CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 96.0F, 4.0F),
                PartPose.offset(0.0F, -72.0F, -22.0F));

        // Small body the hood sits on.
        PartDefinition body = root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(48, 0).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 12.0F, 14.0F),
                PartPose.offset(0.0F, -72.0F, 0.0F));

        // Hood / head.
        PartDefinition hood = body.addOrReplaceChild("hood",
                CubeListBuilder.create().texOffs(0, 132).addBox(-10.0F, -14.0F, -10.0F, 20.0F, 14.0F, 20.0F),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        // Glowing front aperture (the "eye" of the heat ray).
        hood.addOrReplaceChild("aperture",
                CubeListBuilder.create().texOffs(96, 132).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, -7.0F, -10.0F));

        // Two squiddy tentacles hanging under the body.
        body.addOrReplaceChild("tentacle_left",
                CubeListBuilder.create().texOffs(80, 132).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F),
                PartPose.offset(-8.0F, 0.0F, 0.0F));
        body.addOrReplaceChild("tentacle_right",
                CubeListBuilder.create().texOffs(88, 132).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F),
                PartPose.offset(8.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 128, 256);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        // Three-legged gait: each leg is 1/3 of a step out of phase.
        float swing = limbSwing * 0.35F;
        this.legFrontLeft.xRot = Mth.cos(swing) * 0.9F * limbSwingAmount;
        this.legFrontRight.xRot = Mth.cos(swing + Mth.PI * 0.6666F) * 0.9F * limbSwingAmount;
        this.legBack.xRot = Mth.cos(swing + Mth.PI * 1.3333F) * 0.9F * limbSwingAmount;

        // Hood turns towards the target; the aperture follows.
        this.hood.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.hood.xRot = headPitch * ((float) Math.PI / 180F) * 0.25F;

        // Tentacles sway gently.
        this.tentacleLeft.xRot = Mth.sin(ageInTicks * 0.07F) * 0.12F + limbSwingAmount * 0.3F;
        this.tentacleLeft.zRot = Mth.cos(ageInTicks * 0.05F) * 0.08F;
        this.tentacleRight.xRot = Mth.sin(ageInTicks * 0.07F + 1.2F) * 0.12F + limbSwingAmount * 0.3F;
        this.tentacleRight.zRot = Mth.cos(ageInTicks * 0.05F + 1.2F) * -0.08F;
    }
}
