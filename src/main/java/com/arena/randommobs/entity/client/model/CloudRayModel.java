package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.CloudRayEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CloudRayModel extends RMobModel<CloudRayEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/cloud_ray.png");
    public static final float SCALE = 1.06F;
    public static final float SHADOW = 1.60F;

    public CloudRayModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 0).addBox(-8.0F, -4.0F, -4.0F, 5.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 0).addBox(3.0F, -4.0F, -4.0F, 5.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 0).addBox(-3.0F, -4.0F, -9.0F, 6.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 0).addBox(-3.0F, -4.0F, 4.0F, 6.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 0).addBox(-6.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 0).addBox(2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 0).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(409, 0).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 0).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 27).addBox(-5.0F, 0.0F, -3.0F, 3.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 27).addBox(2.0F, 0.0F, -3.0F, 3.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 27).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 27).addBox(-2.0F, 0.0F, 3.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(132, 27).addBox(-4.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 27).addBox(-5.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 27).addBox(-4.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.80F, 0.0F));
        PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(175, 27).addBox(1.0F, -2.0F, -4.0F, 8.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 27).addBox(-2.0F, -2.0F, -4.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 27).addBox(9.0F, -2.0F, -4.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 27).addBox(1.0F, -2.0F, -7.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 27).addBox(1.0F, -2.0F, 6.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 27).addBox(1.0F, -1.0F, -3.0F, 7.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 52).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 52).addBox(8.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 52).addBox(1.0F, -1.0F, -5.0F, 7.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(119, 52).addBox(1.0F, -1.0F, 5.0F, 7.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -1.60F, -2.0F, 0.0F, 0.0F, -0.10F));
        PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(156, 52).addBox(3.0F, -2.0F, -4.0F, 8.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 52).addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(282, 52).addBox(11.0F, -2.0F, -4.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 52).addBox(3.0F, -2.0F, -7.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 52).addBox(3.0F, -2.0F, 6.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 52).addBox(2.0F, -1.0F, -3.0F, 7.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 77).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 77).addBox(9.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 77).addBox(2.0F, -1.0F, -5.0F, 7.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(119, 77).addBox(2.0F, -1.0F, 5.0F, 7.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -1.60F, -2.0F, 0.0F, 0.0F, 0.10F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(156, 77).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 77).addBox(-1.0F, -1.0F, 4.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 77).addBox(-1.0F, -1.0F, 8.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(231, 77).addBox(-1.0F, 0.0F, 12.0F, 1.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -0.32F, 8.0F, -0.14F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(CloudRayEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart wing_l = this.root.getChild("body").getChild("wing_l"); Anims.flapOne(wing_l, ageInTicks, 0.25F, 1.57F);
        ModelPart wing_r = this.root.getChild("body").getChild("wing_r"); Anims.flapOne(wing_r, ageInTicks, 0.25F, 3.14F);
        ModelPart tail = this.root.getChild("body").getChild("tail"); Anims.swayOne(tail, ageInTicks, 0.09F, 4.71F);
    }
}
