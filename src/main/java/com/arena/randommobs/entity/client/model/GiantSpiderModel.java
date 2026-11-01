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
                .texOffs(0, 0).addBox(-11.0F, -1.0F, 1.0F, 22.0F, 7.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 0).addBox(-10.0F, 4.0F, 2.0F, 20.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 0).addBox(-8.0F, 9.0F, 3.0F, 16.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 47).addBox(-9.0F, 2.0F, -9.0F, 18.0F, 6.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 47).addBox(-7.0F, 5.0F, -8.0F, 14.0F, 5.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 47).addBox(-9.0F, -2.0F, 3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(227, 47).addBox(-9.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(244, 47).addBox(-9.0F, -3.0F, 8.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(265, 47).addBox(-9.0F, -2.0F, 11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(282, 47).addBox(-9.0F, -2.0F, 14.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(299, 47).addBox(-9.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 47).addBox(-5.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 47).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 47).addBox(2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 47).addBox(5.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(384, 47).addBox(-7.0F, 1.0F, -5.0F, 14.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 82).addBox(-5.0F, 6.0F, -2.0F, 10.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 82).addBox(-5.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 82).addBox(-2.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(95, 82).addBox(2.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(112, 82).addBox(5.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 82).addBox(-3.0F, 3.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 82).addBox(3.0F, 3.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 82).addBox(-4.0F, 6.0F, -6.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 82).addBox(2.0F, 6.0F, -6.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, -9.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(189, 82).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 82).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 82).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 82).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, -9.0F, -2.64F, 0.0F, 0.83F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(393, 82).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 82).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 82).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 124).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 124).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 124).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, -5.50F, 1.72F, 0.0F, 0.93F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(91, 124).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 124).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 124).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 124).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, -3.60F, -2.92F, 0.0F, 0.88F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(295, 124).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(344, 124).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 124).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 124).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 124).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 124).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, -2.20F, 2.10F, 0.0F, 1.26F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(0, 166).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 166).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 166).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 166).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, 3.60F, 2.92F, 0.0F, 0.88F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(204, 166).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 166).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 166).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 166).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 166).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 166).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, 2.20F, -2.10F, 0.0F, 1.26F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(410, 166).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 208).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 208).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 208).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 6.40F, 9.0F, 2.64F, 0.0F, 0.83F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(139, 208).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 208).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 208).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 208).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 208).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 208).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.45F, -10.0F, 5.50F, -1.72F, 0.0F, 0.93F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(345, 208).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 208).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 208).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 250).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, -9.0F, -2.64F, 0.0F, -0.83F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(57, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 250).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 250).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 250).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 250).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 250).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, -5.50F, 1.72F, 0.0F, -0.93F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(263, 250).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 250).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 250).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 250).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, -3.60F, -2.92F, 0.0F, -0.88F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(0, 292).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 292).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 292).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 292).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 292).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 292).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, -2.20F, 2.10F, 0.0F, -1.26F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(206, 292).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.58F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 292).addBox(-3.0F, 1.93F, -3.0F, 6.0F, 8.06F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 292).addBox(-2.0F, 9.35F, -2.0F, 4.0F, 4.84F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 292).addBox(-4.0F, 10.12F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, 3.60F, 2.92F, 0.0F, -0.88F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(410, 292).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.26F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 292).addBox(-2.0F, 12.68F, -2.0F, 4.0F, 12.68F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 334).addBox(-2.0F, 25.69F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 334).addBox(-2.0F, 28.69F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 334).addBox(-3.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 334).addBox(1.0F, 31.69F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.45F, -10.0F, 2.20F, -2.10F, 0.0F, -1.26F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(124, 334).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.70F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 334).addBox(-3.0F, 2.03F, -3.0F, 6.0F, 8.44F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 334).addBox(-2.0F, 9.80F, -2.0F, 4.0F, 5.07F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 334).addBox(-4.0F, 10.89F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 6.40F, 9.0F, 2.64F, 0.0F, -0.83F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(328, 334).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.51F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 334).addBox(-2.0F, 12.90F, -2.0F, 4.0F, 12.90F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 334).addBox(-2.0F, 26.24F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 334).addBox(-2.0F, 29.24F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(484, 334).addBox(-3.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 376).addBox(1.0F, 32.24F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
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
