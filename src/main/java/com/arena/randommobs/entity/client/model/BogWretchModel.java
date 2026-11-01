package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BogWretchEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BogWretchModel extends RMobModel<BogWretchEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bog_wretch.png");
    public static final float SCALE = 0.88F;
    public static final float SHADOW = 1.0F;

    public BogWretchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 0).addBox(-8.0F, -8.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 0).addBox(4.0F, -8.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 0).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 0).addBox(-4.0F, -8.0F, 2.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 0).addBox(-4.0F, 1.0F, -2.0F, 8.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 0).addBox(-7.0F, 1.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 0).addBox(4.0F, 1.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 0).addBox(-4.0F, 1.0F, -5.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 0).addBox(-4.0F, 1.0F, 2.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 0).addBox(-5.0F, -12.0F, -4.0F, 10.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 29).addBox(-7.0F, -12.0F, -4.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 29).addBox(5.0F, -12.0F, -4.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 29).addBox(-5.0F, -12.0F, -6.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 29).addBox(-5.0F, -12.0F, 4.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 29).addBox(-4.0F, -10.0F, -3.0F, 8.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 29).addBox(-5.0F, -10.0F, -3.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 29).addBox(4.0F, -10.0F, -3.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 29).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 29).addBox(-4.0F, -10.0F, 3.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 29).addBox(-5.0F, 7.0F, -3.0F, 10.0F, 14.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 29).addBox(-9.0F, 7.0F, -3.0F, 4.0F, 14.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 70).addBox(5.0F, 7.0F, -3.0F, 4.0F, 14.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 70).addBox(-5.0F, 7.0F, -7.0F, 10.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 70).addBox(-5.0F, 7.0F, 3.0F, 10.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 70).addBox(-8.0F, -2.0F, -6.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 70).addBox(-5.0F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 70).addBox(-2.0F, -3.0F, -7.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 70).addBox(1.0F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 70).addBox(4.0F, -2.0F, -6.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.07F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(252, 70).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 70).addBox(-5.0F, -5.0F, -3.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 70).addBox(3.0F, -5.0F, -3.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 70).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 70).addBox(-3.0F, -5.0F, 1.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(409, 70).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(450, 70).addBox(-3.0F, -3.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(463, 70).addBox(1.0F, -3.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 70).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(485, 70).addBox(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 111).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 111).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(70, 111).addBox(-4.0F, -1.0F, -5.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 111).addBox(3.0F, -1.0F, -5.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(96, 111).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(125, 111).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(154, 111).addBox(-3.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(167, 111).addBox(-2.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 111).addBox(-1.0F, 1.0F, -7.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 111).addBox(1.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -8.80F, -6.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(206, 111).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.33F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 111).addBox(-2.0F, 1.75F, -2.0F, 3.0F, 7.28F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 111).addBox(-1.0F, 8.44F, -1.0F, 1.0F, 4.37F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 111).addBox(-2.0F, 11.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -7.67F, -1.0F, 0.0F, 0.0F, 0.28F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(314, 111).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.89F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 111).addBox(-1.0F, 5.23F, -1.0F, 1.0F, 5.23F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 111).addBox(-1.0F, 10.09F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(357, 111).addBox(-2.0F, 10.09F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 111).addBox(-3.0F, 13.09F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 111).addBox(1.0F, 13.09F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, 0.0F, 0.0F, -0.16F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(448, 111).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.33F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 133).addBox(-2.0F, 1.75F, -2.0F, 3.0F, 7.28F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 133).addBox(-1.0F, 8.44F, -1.0F, 1.0F, 4.37F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 133).addBox(-2.0F, 11.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -7.67F, -1.0F, 0.0F, 0.0F, -0.28F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(67, 133).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.89F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 133).addBox(-1.0F, 5.23F, -1.0F, 1.0F, 5.23F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 133).addBox(-1.0F, 10.09F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 133).addBox(-2.0F, 10.09F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 133).addBox(-3.0F, 13.09F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 133).addBox(1.0F, 13.09F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, 0.0F, 0.0F, 0.16F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(201, 133).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 133).addBox(-2.0F, 1.01F, -2.0F, 4.0F, 4.20F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 133).addBox(-1.0F, 4.87F, -1.0F, 2.0F, 2.52F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 133).addBox(-3.0F, 4.39F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 4.33F, 0.0F, 0.0F, 0.0F, 0.27F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(341, 133).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.30F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(374, 133).addBox(-1.0F, 2.93F, -1.0F, 2.0F, 2.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 133).addBox(-1.0F, 3.32F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 133).addBox(-2.0F, 4.32F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(449, 133).addBox(-3.0F, 7.32F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(474, 133).addBox(1.0F, 7.32F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 8.10F, 0.0F, 0.0F, 0.0F, -0.02F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(0, 155).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 155).addBox(-2.0F, 1.01F, -2.0F, 4.0F, 4.20F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 155).addBox(-1.0F, 4.87F, -1.0F, 2.0F, 2.52F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 155).addBox(-3.0F, 4.39F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 4.33F, 0.0F, 0.0F, 0.0F, -0.27F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(140, 155).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.30F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 155).addBox(-1.0F, 2.93F, -1.0F, 2.0F, 2.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 155).addBox(-1.0F, 3.32F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 155).addBox(-2.0F, 4.32F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 155).addBox(-3.0F, 7.32F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 155).addBox(1.0F, 7.32F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 8.10F, 0.0F, 0.0F, 0.0F, 0.02F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(BogWretchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_l_low = this.root.getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 4.71F);
        ModelPart arm_r = this.root.getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 6.28F);
        ModelPart arm_r_low = this.root.getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 7.85F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
    }
}
