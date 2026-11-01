package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WoodcrawlerModel extends RMobModel<WoodcrawlerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/woodcrawler.png");
    public static final float SCALE = 0.96F;
    public static final float SHADOW = 0.90F;

    public WoodcrawlerModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(53, 0).addBox(-7.0F, -2.0F, -5.0F, 3.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(86, 0).addBox(4.0F, -2.0F, -5.0F, 3.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(119, 0).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 0).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 0).addBox(-3.0F, 3.0F, -4.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 0).addBox(-5.0F, 3.0F, -4.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(275, 0).addBox(3.0F, 3.0F, -4.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 0).addBox(-3.0F, 3.0F, -6.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 0).addBox(-3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(366, 0).addBox(-4.0F, -2.0F, 6.0F, 8.0F, 8.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 0).addBox(-8.0F, -2.0F, 6.0F, 4.0F, 8.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 31).addBox(4.0F, -2.0F, 6.0F, 4.0F, 8.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 31).addBox(-4.0F, -2.0F, 2.0F, 8.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(94, 31).addBox(-4.0F, -2.0F, 13.0F, 8.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(143, 31).addBox(-3.0F, 5.0F, 7.0F, 6.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 31).addBox(-6.0F, 5.0F, 7.0F, 3.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 31).addBox(3.0F, 5.0F, 7.0F, 3.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 31).addBox(-3.0F, 5.0F, 4.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 31).addBox(-3.0F, 5.0F, 12.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 31).addBox(-4.0F, -5.0F, 6.0F, 8.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 31).addBox(-5.0F, -5.0F, 6.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 31).addBox(4.0F, -5.0F, 6.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 31).addBox(-4.0F, -5.0F, 5.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 62).addBox(-4.0F, -5.0F, 12.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 62).addBox(-3.0F, -4.0F, 7.0F, 6.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 62).addBox(-4.0F, -4.0F, 7.0F, 1.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 62).addBox(3.0F, -4.0F, 7.0F, 1.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(120, 62).addBox(-3.0F, -4.0F, 6.0F, 6.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 62).addBox(-3.0F, -4.0F, 11.0F, 6.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 62).addBox(-7.0F, -2.0F, 3.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 62).addBox(-7.0F, -3.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 62).addBox(-7.0F, -3.0F, 9.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 62).addBox(-7.0F, -2.0F, 12.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 62).addBox(-8.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 62).addBox(-4.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 62).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 62).addBox(4.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.05F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(338, 62).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 62).addBox(-6.0F, -1.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(396, 62).addBox(4.0F, -1.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(413, 62).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(454, 62).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 77).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 77).addBox(-4.0F, 1.0F, -5.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 77).addBox(1.0F, 1.0F, -5.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 77).addBox(-3.0F, 2.0F, -5.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(96, 77).addBox(1.0F, 2.0F, -5.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 77).addBox(-4.0F, 4.0F, -3.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(154, 77).addBox(-3.0F, 4.0F, -6.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(175, 77).addBox(1.0F, 4.0F, -6.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 77).addBox(-7.0F, 4.0F, -4.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 77).addBox(5.0F, 4.0F, -4.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, -8.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(246, 77).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 77).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(344, 77).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 77).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, -8.0F, -2.68F, 0.0F, 0.70F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(418, 77).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 77).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(484, 77).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 117).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 117).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 117).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, -5.50F, 2.02F, 0.0F, 0.87F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(91, 117).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 117).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 117).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 117).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, -3.20F, -2.94F, 0.0F, 0.75F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(263, 117).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 117).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 117).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 117).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 117).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 117).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, -2.20F, 2.52F, 0.0F, 1.11F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(445, 117).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 156).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 156).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 156).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, 3.20F, 2.94F, 0.0F, 0.75F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(115, 156).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 156).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 156).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 156).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 156).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 156).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, 2.20F, -2.52F, 0.0F, 1.11F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(297, 156).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 156).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 156).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 156).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, 8.0F, 2.68F, 0.0F, 0.70F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(469, 156).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 196).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 196).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 196).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 196).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 196).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, 5.50F, -2.02F, 0.0F, 0.87F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(141, 196).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 196).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 196).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 196).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, -8.0F, -2.68F, 0.0F, -0.70F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(313, 196).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 196).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 196).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 196).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 196).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(470, 196).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, -5.50F, 2.02F, 0.0F, -0.87F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(0, 236).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 236).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 236).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 236).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, -3.20F, -2.94F, 0.0F, -0.75F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(172, 236).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 236).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 236).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 236).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 236).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 236).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, -2.20F, 2.52F, 0.0F, -1.11F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(354, 236).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 236).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 236).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 275).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, 3.20F, 2.94F, 0.0F, -0.75F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(49, 275).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 275).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 275).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 275).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 275).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 275).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, 2.20F, -2.52F, 0.0F, -1.11F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(231, 275).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 275).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 275).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 275).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, 8.0F, 2.68F, 0.0F, -0.70F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(403, 275).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 275).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 275).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 315).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 315).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 315).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, 5.50F, -2.02F, 0.0F, -0.87F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(WoodcrawlerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
