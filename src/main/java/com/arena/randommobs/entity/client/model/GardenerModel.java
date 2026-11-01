package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GardenerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class GardenerModel extends RMobModel<GardenerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/gardener.png");
    public static final float SCALE = 0.82F;
    public static final float SHADOW = 1.20F;

    public GardenerModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -11.0F, -3.0F, 10.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 0).addBox(-8.0F, -11.0F, -3.0F, 3.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(102, 0).addBox(5.0F, -11.0F, -3.0F, 3.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 0).addBox(-5.0F, -11.0F, -6.0F, 10.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(192, 0).addBox(-5.0F, -11.0F, 3.0F, 10.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 0).addBox(-6.0F, -2.0F, -4.0F, 12.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 0).addBox(-9.0F, -2.0F, -4.0F, 3.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(371, 0).addBox(6.0F, -2.0F, -4.0F, 3.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 0).addBox(-6.0F, -2.0F, -7.0F, 12.0F, 9.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 35).addBox(-6.0F, -2.0F, 4.0F, 12.0F, 9.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 35).addBox(-6.0F, 6.0F, -4.0F, 12.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 35).addBox(-10.0F, 6.0F, -4.0F, 4.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(191, 35).addBox(6.0F, 6.0F, -4.0F, 4.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(240, 35).addBox(-6.0F, 6.0F, -8.0F, 12.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(305, 35).addBox(-6.0F, 6.0F, 4.0F, 12.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 35).addBox(-6.0F, -16.0F, -4.0F, 12.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 35).addBox(-9.0F, -16.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 70).addBox(6.0F, -16.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 70).addBox(-6.0F, -16.0F, -7.0F, 12.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 70).addBox(-6.0F, -16.0F, 4.0F, 12.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(167, 70).addBox(-4.0F, -18.0F, -3.0F, 8.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 70).addBox(-6.0F, -18.0F, -3.0F, 2.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 70).addBox(4.0F, -18.0F, -3.0F, 2.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 70).addBox(-4.0F, -18.0F, -5.0F, 8.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 70).addBox(-4.0F, -18.0F, 3.0F, 8.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 70).addBox(-6.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 99).addBox(-9.0F, -30.0F, -6.0F, 3.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 99).addBox(6.0F, -30.0F, -6.0F, 3.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 99).addBox(-6.0F, -30.0F, -9.0F, 12.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(183, 99).addBox(-6.0F, -30.0F, 6.0F, 12.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(244, 99).addBox(-4.0F, -28.0F, -4.0F, 8.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(309, 99).addBox(-6.0F, -28.0F, -4.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 99).addBox(4.0F, -28.0F, -4.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 99).addBox(-4.0F, -28.0F, -6.0F, 8.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 99).addBox(-4.0F, -28.0F, 4.0F, 8.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -7.95F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 128).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 128).addBox(-5.0F, -8.0F, -3.0F, 2.0F, 8.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 128).addBox(3.0F, -8.0F, -3.0F, 2.0F, 8.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 128).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(136, 128).addBox(-3.0F, -8.0F, 2.0F, 6.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 128).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 128).addBox(-3.0F, -6.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 128).addBox(1.0F, -6.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 128).addBox(-2.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 128).addBox(1.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 128).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 128).addBox(-6.0F, -14.0F, -4.0F, 2.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 128).addBox(4.0F, -14.0F, -4.0F, 2.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 128).addBox(-4.0F, -14.0F, -6.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 128).addBox(-4.0F, -14.0F, 4.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 155).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 155).addBox(-4.0F, -12.0F, -3.0F, 1.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 155).addBox(3.0F, -12.0F, -3.0F, 1.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 155).addBox(-3.0F, -12.0F, -4.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(136, 155).addBox(-3.0F, -12.0F, 3.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 155).addBox(-7.0F, -11.0F, -7.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 155).addBox(-1.0F, -3.0F, -7.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 155).addBox(-1.0F, -4.0F, -7.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 155).addBox(-1.0F, -6.0F, -7.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.80F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create()
                .texOffs(337, 155).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 155).addBox(-3.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(371, 155).addBox(1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(388, 155).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 155).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(422, 155).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(471, 155).addBox(-2.0F, 1.46F, -2.0F, 4.0F, 6.08F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 188).addBox(-1.0F, 7.06F, -1.0F, 2.0F, 3.65F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 188).addBox(-3.0F, 8.17F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -18.35F, -1.0F, 0.0F, 0.0F, 0.17F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(58, 188).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.00F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 188).addBox(-1.0F, 4.44F, -1.0F, 2.0F, 4.44F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 188).addBox(-1.0F, 7.10F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.03F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(125, 188).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 188).addBox(-2.0F, 1.46F, -2.0F, 4.0F, 6.08F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 188).addBox(-1.0F, 7.06F, -1.0F, 2.0F, 3.65F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 188).addBox(-3.0F, 8.17F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -18.35F, -1.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(265, 188).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.00F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 188).addBox(-1.0F, 4.44F, -1.0F, 2.0F, 4.44F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(315, 188).addBox(-1.0F, 7.10F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.03F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(332, 188).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 188).addBox(-2.0F, 1.19F, -2.0F, 4.0F, 4.97F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 188).addBox(-1.0F, 5.76F, -1.0F, 2.0F, 2.98F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(431, 188).addBox(-3.0F, 5.93F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 0.05F, 0.0F, 0.0F, 0.0F, 0.44F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(472, 188).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.08F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 209).addBox(-1.0F, 5.41F, -1.0F, 2.0F, 5.41F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 209).addBox(-1.0F, 9.52F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.20F, 9.0F, 0.0F, 0.0F, 0.0F, -0.30F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(34, 209).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 209).addBox(-2.0F, 1.19F, -2.0F, 4.0F, 4.97F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 209).addBox(-1.0F, 5.76F, -1.0F, 2.0F, 2.98F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 209).addBox(-3.0F, 5.93F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 0.05F, 0.0F, 0.0F, 0.0F, -0.44F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(174, 209).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.08F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 209).addBox(-1.0F, 5.41F, -1.0F, 2.0F, 5.41F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 209).addBox(-1.0F, 9.52F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.20F, 9.0F, 0.0F, 0.0F, 0.0F, 0.30F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(GardenerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
