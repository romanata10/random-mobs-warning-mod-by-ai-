package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GiantSpiderEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class GiantSpiderModel extends RMobModel<GiantSpiderEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/giant_spider.png");
    public static final float SCALE = 1.10F;
    public static final float SHADOW = 1.80F;

    public GiantSpiderModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -2.0F, 5.0F, 14.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 0).addBox(-11.0F, -2.0F, 5.0F, 4.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 0).addBox(7.0F, -2.0F, 5.0F, 4.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(187, 0).addBox(-7.0F, -2.0F, 1.0F, 14.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(260, 0).addBox(-7.0F, -2.0F, 13.0F, 14.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 0).addBox(-6.0F, 5.0F, 5.0F, 12.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 0).addBox(-9.0F, 5.0F, 5.0F, 3.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 0).addBox(6.0F, 5.0F, 5.0F, 3.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 33).addBox(-6.0F, 5.0F, 2.0F, 12.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 33).addBox(-6.0F, 5.0F, 12.0F, 12.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 33).addBox(-6.0F, -5.0F, 5.0F, 12.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 33).addBox(-8.0F, -5.0F, 5.0F, 2.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 33).addBox(6.0F, -5.0F, 5.0F, 2.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 33).addBox(-6.0F, -5.0F, 3.0F, 12.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(330, 33).addBox(-6.0F, -5.0F, 12.0F, 12.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 33).addBox(-4.0F, -4.0F, 7.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 33).addBox(-6.0F, -4.0F, 7.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 33).addBox(4.0F, -4.0F, 7.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 52).addBox(-4.0F, -4.0F, 5.0F, 8.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 52).addBox(-4.0F, -4.0F, 10.0F, 8.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 52).addBox(-5.0F, 1.0F, -5.0F, 10.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 52).addBox(-9.0F, 1.0F, -5.0F, 4.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 52).addBox(5.0F, 1.0F, -5.0F, 4.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 52).addBox(-5.0F, 1.0F, -9.0F, 10.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 52).addBox(-5.0F, 1.0F, -1.0F, 10.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 52).addBox(-9.0F, -2.0F, 3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 52).addBox(-9.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 52).addBox(-9.0F, -3.0F, 8.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(374, 52).addBox(-9.0F, -2.0F, 11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 52).addBox(-9.0F, -2.0F, 14.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 52).addBox(-9.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 52).addBox(-5.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 52).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 52).addBox(2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 52).addBox(5.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 75).addBox(-5.0F, 1.0F, -4.0F, 10.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(53, 75).addBox(-7.0F, 1.0F, -4.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 75).addBox(5.0F, 1.0F, -4.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(95, 75).addBox(-5.0F, 1.0F, -6.0F, 10.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(144, 75).addBox(-5.0F, 1.0F, -1.0F, 10.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 75).addBox(-6.0F, 1.0F, -7.0F, 12.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 75).addBox(-5.0F, 3.0F, -7.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(267, 75).addBox(2.0F, 3.0F, -7.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 75).addBox(-4.0F, 4.0F, -7.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(297, 75).addBox(2.0F, 4.0F, -7.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 75).addBox(-5.0F, 7.0F, -5.0F, 10.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 75).addBox(-5.0F, 0.0F, -6.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 75).addBox(3.0F, 0.0F, -6.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 75).addBox(-3.0F, 3.0F, -9.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(422, 75).addBox(-3.0F, 1.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(439, 75).addBox(-3.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 75).addBox(1.0F, 3.0F, -9.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(481, 75).addBox(1.0F, 1.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 94).addBox(1.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, -9.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(17, 94).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 94).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 94).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 94).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, -9.0F, -2.64F, 0.0F, 0.83F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(221, 94).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 94).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 94).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 94).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 94).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 94).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, -5.50F, 1.72F, 0.0F, 0.93F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(427, 94).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 136).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 136).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 136).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, -3.60F, -2.92F, 0.0F, 0.88F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(139, 136).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 136).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 136).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 136).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 136).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 136).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, -2.20F, 2.10F, 0.0F, 1.26F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(345, 136).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 136).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 136).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 178).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, 3.60F, 2.92F, 0.0F, 0.88F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(57, 178).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 178).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 178).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 178).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 178).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 178).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, 2.20F, -2.10F, 0.0F, 1.26F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(263, 178).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 178).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 178).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 178).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, 9.0F, 2.64F, 0.0F, 0.83F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(0, 220).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 220).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 220).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 220).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 220).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 220).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, 5.50F, -1.72F, 0.0F, 0.93F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(206, 220).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 220).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 220).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 220).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, -9.0F, -2.64F, 0.0F, -0.83F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(410, 220).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 220).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 262).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 262).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 262).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 262).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, -5.50F, 1.72F, 0.0F, -0.93F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(124, 262).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 262).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 262).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 262).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, -3.60F, -2.92F, 0.0F, -0.88F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(328, 262).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 262).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 262).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 262).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(484, 262).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 304).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, -2.20F, 2.10F, 0.0F, -1.26F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(25, 304).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 304).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 304).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 304).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, 3.60F, 2.92F, 0.0F, -0.88F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(229, 304).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 304).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 304).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(344, 304).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 304).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 304).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, 2.20F, -2.10F, 0.0F, -1.26F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(435, 304).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 346).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 346).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 346).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, 9.0F, 2.64F, 0.0F, -0.83F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(139, 346).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 346).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 346).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 346).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 346).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 346).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, 5.50F, -1.72F, 0.0F, -0.93F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(GiantSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_l0 = this.root.getChild("leg_l0"); Anims.swing(leg_l0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_l0_low = this.root.getChild("leg_l0").getChild("leg_l0_low"); Anims.swing(leg_l0_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_l1 = this.root.getChild("leg_l1"); Anims.swing(leg_l1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l1_low = this.root.getChild("leg_l1").getChild("leg_l1_low"); Anims.swing(leg_l1_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_l2 = this.root.getChild("leg_l2"); Anims.swing(leg_l2, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_l2_low = this.root.getChild("leg_l2").getChild("leg_l2_low"); Anims.swing(leg_l2_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_l3 = this.root.getChild("leg_l3"); Anims.swing(leg_l3, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_l3_low = this.root.getChild("leg_l3").getChild("leg_l3_low"); Anims.swing(leg_l3_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_r0 = this.root.getChild("leg_r0"); Anims.swing(leg_r0, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_r0_low = this.root.getChild("leg_r0").getChild("leg_r0_low"); Anims.swing(leg_r0_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
        ModelPart leg_r1 = this.root.getChild("leg_r1"); Anims.swing(leg_r1, limbSwing, limbSwingAmount, 0.95F, 18.85F);
        ModelPart leg_r1_low = this.root.getChild("leg_r1").getChild("leg_r1_low"); Anims.swing(leg_r1_low, limbSwing, limbSwingAmount, 0.45F, 20.42F);
        ModelPart leg_r2 = this.root.getChild("leg_r2"); Anims.swing(leg_r2, limbSwing, limbSwingAmount, 0.95F, 21.99F);
        ModelPart leg_r2_low = this.root.getChild("leg_r2").getChild("leg_r2_low"); Anims.swing(leg_r2_low, limbSwing, limbSwingAmount, 0.45F, 23.56F);
        ModelPart leg_r3 = this.root.getChild("leg_r3"); Anims.swing(leg_r3, limbSwing, limbSwingAmount, 0.95F, 25.13F);
        ModelPart leg_r3_low = this.root.getChild("leg_r3").getChild("leg_r3_low"); Anims.swing(leg_r3_low, limbSwing, limbSwingAmount, 0.45F, 26.70F);
    }
}
