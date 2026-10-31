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
    public static final float SCALE = 0.61F;
    public static final float SHADOW = 1.60F;

    public WaterGrabberModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -7.0F, -11.0F, 22.0F, 14.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 0).addBox(-9.0F, -9.0F, -9.0F, 18.0F, 3.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 0).addBox(-9.0F, 7.0F, -9.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(467, 0).addBox(-13.0F, -3.0F, -4.0F, 2.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 73).addBox(11.0F, -3.0F, -4.0F, 2.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -3.66F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(41, 73).addBox(-8.0F, -6.0F, -2.0F, 16.0F, 12.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 73).addBox(-5.0F, -8.0F, -3.0F, 10.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 73).addBox(-9.0F, -2.0F, 0.0F, 18.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.80F, -12.0F));
        PartDefinition dome = body.addOrReplaceChild("dome", CubeListBuilder.create()
                .texOffs(252, 73).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 73).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -7.20F, 0.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(462, 73).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 114).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 7.06F, -7.0F, 0.0F, 0.0F, 0.71F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(41, 114).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 114).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 114).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 114).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, -0.37F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(125, 114).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(150, 114).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 7.06F, 0.0F, 0.0F, 0.0F, 0.71F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(191, 114).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 114).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 114).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 114).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, -0.37F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(275, 114).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 114).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 7.06F, 7.0F, 0.0F, 0.0F, 0.71F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(341, 114).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 114).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 114).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 114).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, -0.37F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(425, 114).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(450, 114).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 7.06F, -7.0F, 0.0F, 0.0F, -0.71F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(491, 114).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 135).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 135).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 135).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, 0.37F));
        PartDefinition leg_4 = root.addOrReplaceChild("leg_4", CubeListBuilder.create()
                .texOffs(67, 135).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 135).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 7.06F, 0.0F, 0.0F, 0.0F, -0.71F));
        PartDefinition leg_4_low = leg_4.addOrReplaceChild("leg_4_low", CubeListBuilder.create()
                .texOffs(133, 135).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(150, 135).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(183, 135).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(200, 135).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, 0.37F));
        PartDefinition leg_5 = root.addOrReplaceChild("leg_5", CubeListBuilder.create()
                .texOffs(217, 135).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.13F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 135).addBox(-3.0F, 1.78F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 7.06F, 7.0F, 0.0F, 0.0F, -0.71F));
        PartDefinition leg_5_low = leg_5.addOrReplaceChild("leg_5_low", CubeListBuilder.create()
                .texOffs(283, 135).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.03F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 135).addBox(-2.0F, 2.03F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 135).addBox(-3.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 135).addBox(1.0F, 4.03F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.13F, 0.0F, 0.0F, 0.0F, 0.37F));
        PartDefinition claw_l = body.addOrReplaceChild("claw_l", CubeListBuilder.create()
                .texOffs(367, 135).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 135).addBox(-4.0F, 11.0F, -4.0F, 8.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 135).addBox(-4.0F, 14.0F, -6.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 170).addBox(1.0F, 14.0F, -6.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 1.60F, -5.0F, 0.31F, 0.0F, 0.91F));
        PartDefinition claw_r = body.addOrReplaceChild("claw_r", CubeListBuilder.create()
                .texOffs(33, 170).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 170).addBox(-4.0F, 11.0F, -4.0F, 8.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 170).addBox(-4.0F, 14.0F, -6.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 170).addBox(1.0F, 14.0F, -6.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 1.60F, -5.0F, 0.31F, 0.0F, -0.91F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(WaterGrabberEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart dome = this.root.getChild("body").getChild("dome"); Anims.bob(dome, ageInTicks, 0.45F);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
        ModelPart leg_4 = this.root.getChild("leg_4"); Anims.swing(leg_4, limbSwing, limbSwingAmount, 0.95F, 17.28F);
        ModelPart leg_4_low = this.root.getChild("leg_4").getChild("leg_4_low"); Anims.swing(leg_4_low, limbSwing, limbSwingAmount, 0.45F, 18.85F);
        ModelPart leg_5 = this.root.getChild("leg_5"); Anims.swing(leg_5, limbSwing, limbSwingAmount, 0.95F, 20.42F);
        ModelPart leg_5_low = this.root.getChild("leg_5").getChild("leg_5_low"); Anims.swing(leg_5_low, limbSwing, limbSwingAmount, 0.45F, 21.99F);
        ModelPart claw_l = this.root.getChild("body").getChild("claw_l"); Anims.swing(claw_l, limbSwing, limbSwingAmount, 0.6F, 23.56F);
        ModelPart claw_r = this.root.getChild("body").getChild("claw_r"); Anims.swing(claw_r, limbSwing, limbSwingAmount, 0.6F, 25.13F);
    }
}
