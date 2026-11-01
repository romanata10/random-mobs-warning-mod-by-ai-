package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WaterGrabberEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WaterGrabberModel extends RMobModel<WaterGrabberEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/water_grabber.png");
    public static final float SCALE = 0.80F;
    public static final float SHADOW = 1.60F;

    public WaterGrabberModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -3.0F, -10.0F, 22.0F, 6.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 0).addBox(-9.0F, -6.0F, -8.0F, 18.0F, 4.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 0).addBox(-6.0F, -8.0F, -5.0F, 12.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 53).addBox(-10.0F, 2.0F, -9.0F, 20.0F, 5.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 53).addBox(-8.0F, 5.0F, -7.0F, 16.0F, 3.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 53).addBox(-9.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 53).addBox(-5.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 53).addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(325, 53).addBox(5.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -0.02F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(342, 53).addBox(-7.0F, -2.0F, -3.0F, 14.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 53).addBox(-5.0F, -3.0F, -2.0F, 10.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 100).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 100).addBox(-5.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 100).addBox(3.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.80F, -11.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(83, 100).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(132, 100).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 100).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 100).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 0.78F, -6.0F, 0.14F, 0.0F, 0.71F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(223, 100).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 100).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 100).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 100).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 100).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 100).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 7.20F, 1.0F, -0.02F, 0.0F, -0.49F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(381, 100).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 100).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(463, 100).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 119).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-11.0F, 0.78F, 0.0F, 0.14F, 0.0F, 0.71F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(41, 119).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 119).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 119).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 119).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 119).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 119).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 7.20F, 1.0F, -0.02F, 0.0F, -0.49F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(199, 119).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 119).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 119).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 119).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 0.78F, 6.0F, 0.14F, 0.0F, 0.71F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(339, 119).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 119).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 119).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 119).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 119).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 119).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 7.20F, 1.0F, -0.02F, 0.0F, -0.49F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(0, 138).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 138).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 138).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 138).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 0.78F, -6.0F, 0.14F, 0.0F, -0.71F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(140, 138).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 138).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 138).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 138).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 138).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 138).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 7.20F, 1.0F, -0.02F, 0.0F, 0.49F));
        PartDefinition leg_4 = root.addOrReplaceChild("leg_4", CubeListBuilder.create()
                .texOffs(298, 138).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 138).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 138).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 138).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(11.0F, 0.78F, 0.0F, 0.14F, 0.0F, -0.71F));
        PartDefinition leg_4_low = leg_4.addOrReplaceChild("leg_4_low", CubeListBuilder.create()
                .texOffs(438, 138).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(471, 138).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 138).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 157).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 157).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 157).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 7.20F, 1.0F, -0.02F, 0.0F, 0.49F));
        PartDefinition leg_5 = root.addOrReplaceChild("leg_5", CubeListBuilder.create()
                .texOffs(91, 157).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 157).addBox(-2.0F, 1.15F, -2.0F, 4.0F, 4.78F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 157).addBox(-1.0F, 5.54F, -1.0F, 2.0F, 2.87F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 157).addBox(-3.0F, 5.55F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 0.78F, 6.0F, 0.14F, 0.0F, -0.71F));
        PartDefinition leg_5_low = leg_5.addOrReplaceChild("leg_5_low", CubeListBuilder.create()
                .texOffs(231, 157).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.72F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 157).addBox(-1.0F, 3.30F, -1.0F, 2.0F, 3.30F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 157).addBox(-1.0F, 4.26F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 157).addBox(-2.0F, 5.26F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 157).addBox(-3.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 157).addBox(1.0F, 8.26F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 7.20F, 1.0F, -0.02F, 0.0F, 0.49F));
        PartDefinition claw_l = body.addOrReplaceChild("claw_l", CubeListBuilder.create()
                .texOffs(389, 157).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(446, 157).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 184).addBox(-2.0F, 7.0F, -12.0F, 4.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 184).addBox(-3.0F, 10.0F, -12.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 184).addBox(-3.0F, 5.0F, -12.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 0.80F, -8.0F, 0.24F, 0.0F, -0.31F));
        PartDefinition claw_r = body.addOrReplaceChild("claw_r", CubeListBuilder.create()
                .texOffs(111, 184).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 184).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 184).addBox(-2.0F, 7.0F, -12.0F, 4.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 184).addBox(-3.0F, 10.0F, -12.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 184).addBox(-3.0F, 5.0F, -12.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 0.80F, -8.0F, 0.24F, 0.0F, 0.31F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(WaterGrabberEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_4 = this.root.getChild("leg_4"); Anims.swing(leg_4, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_4_low = this.root.getChild("leg_4").getChild("leg_4_low"); Anims.swing(leg_4_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
        ModelPart leg_5 = this.root.getChild("leg_5"); Anims.swing(leg_5, limbSwing, limbSwingAmount, 0.95F, 18.85F);
        ModelPart leg_5_low = this.root.getChild("leg_5").getChild("leg_5_low"); Anims.swing(leg_5_low, limbSwing, limbSwingAmount, 0.45F, 20.42F);
        ModelPart claw_l = this.root.getChild("body").getChild("claw_l"); Anims.swing(claw_l, limbSwing, limbSwingAmount, 0.6F, 21.99F);
        ModelPart claw_r = this.root.getChild("body").getChild("claw_r"); Anims.swing(claw_r, limbSwing, limbSwingAmount, 0.6F, 23.56F);
    }
}
