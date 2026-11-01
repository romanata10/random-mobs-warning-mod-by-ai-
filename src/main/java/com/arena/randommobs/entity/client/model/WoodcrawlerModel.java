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
                .texOffs(0, 0).addBox(-7.0F, -2.0F, -8.0F, 14.0F, 5.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 0).addBox(-6.0F, 2.0F, -7.0F, 12.0F, 5.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 0).addBox(-4.0F, 6.0F, -6.0F, 8.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 0).addBox(-8.0F, -1.0F, 2.0F, 16.0F, 7.0F, 15.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 0).addBox(-7.0F, 4.0F, 3.0F, 14.0F, 5.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 45).addBox(-5.0F, 8.0F, 5.0F, 10.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 45).addBox(-3.0F, -3.0F, 6.0F, 6.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(134, 45).addBox(-7.0F, -2.0F, 3.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 45).addBox(-7.0F, -3.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 45).addBox(-7.0F, -3.0F, 9.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 45).addBox(-7.0F, -2.0F, 12.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 45).addBox(-8.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 45).addBox(-4.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(260, 45).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 45).addBox(4.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.05F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(294, 45).addBox(-6.0F, -1.0F, -4.0F, 12.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(371, 45).addBox(-5.0F, 3.0F, -1.0F, 10.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(436, 45).addBox(-4.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 45).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(470, 45).addBox(1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(487, 45).addBox(4.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(504, 45).addBox(-3.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 74).addBox(3.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(9, 74).addBox(-3.0F, 4.0F, -5.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(30, 74).addBox(1.0F, 4.0F, -5.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(51, 74).addBox(-6.0F, 4.0F, -4.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 74).addBox(4.0F, 4.0F, -4.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, -8.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(101, 74).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(158, 74).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 74).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 74).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, -8.0F, -2.68F, 0.0F, 0.70F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(273, 74).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 74).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 74).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 74).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 74).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 74).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, -5.50F, 2.02F, 0.0F, 0.87F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(455, 74).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 114).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 114).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 114).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, -3.20F, -2.94F, 0.0F, 0.75F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(115, 114).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 114).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 114).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 114).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 114).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 114).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, -2.20F, 2.52F, 0.0F, 1.11F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(297, 114).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 114).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 114).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 114).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, 3.20F, 2.94F, 0.0F, 0.75F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(469, 114).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 153).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 153).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 153).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 153).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 153).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, 2.20F, -2.52F, 0.0F, 1.11F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(141, 153).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 153).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 153).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 153).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 5.65F, 8.0F, 2.68F, 0.0F, 0.70F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(313, 153).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 153).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 153).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 153).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 153).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(470, 153).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.35F, -11.0F, 5.50F, -2.02F, 0.0F, 0.87F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(0, 193).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 193).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 193).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 193).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, -8.0F, -2.68F, 0.0F, -0.70F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(172, 193).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 193).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 193).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 193).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 193).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 193).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, -5.50F, 2.02F, 0.0F, -0.87F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(354, 193).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 193).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 193).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 233).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, -3.20F, -2.94F, 0.0F, -0.75F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(49, 233).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 233).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 233).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 233).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 233).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 233).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, -2.20F, 2.52F, 0.0F, -1.11F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(231, 233).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.44F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 233).addBox(-3.0F, 1.83F, -3.0F, 5.0F, 7.63F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 233).addBox(-2.0F, 8.85F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 233).addBox(-3.0F, 10.26F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, 3.20F, 2.94F, 0.0F, -0.75F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(403, 233).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.19F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 233).addBox(-2.0F, 12.62F, -2.0F, 3.0F, 12.62F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 233).addBox(-2.0F, 26.54F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 272).addBox(-2.0F, 28.54F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 272).addBox(-3.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 272).addBox(1.0F, 31.54F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.35F, -11.0F, 2.20F, -2.52F, 0.0F, -1.11F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(91, 272).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.57F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 272).addBox(-3.0F, 1.93F, -3.0F, 5.0F, 8.04F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 272).addBox(-2.0F, 9.32F, -2.0F, 3.0F, 4.82F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 272).addBox(-3.0F, 11.07F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 5.65F, 8.0F, 2.68F, 0.0F, -0.70F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(263, 272).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 14.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 272).addBox(-2.0F, 12.84F, -2.0F, 3.0F, 12.84F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 272).addBox(-2.0F, 27.10F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 272).addBox(-2.0F, 29.10F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 272).addBox(-3.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 272).addBox(1.0F, 32.10F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
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
