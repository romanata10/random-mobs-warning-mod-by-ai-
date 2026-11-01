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
    public static final float SCALE = 0.78F;
    public static final float SHADOW = 1.60F;

    public WaterGrabberModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -8.0F, -6.0F, 14.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 0).addBox(-10.0F, -8.0F, -6.0F, 3.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(166, 0).addBox(7.0F, -8.0F, -6.0F, 3.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(227, 0).addBox(-7.0F, -8.0F, -9.0F, 14.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 0).addBox(-7.0F, -8.0F, 6.0F, 14.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 0).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(454, 0).addBox(-8.0F, -5.0F, -5.0F, 2.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 31).addBox(6.0F, -5.0F, -5.0F, 2.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 31).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 31).addBox(-6.0F, -5.0F, 5.0F, 12.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 31).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 31).addBox(-6.0F, -2.0F, -3.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 31).addBox(4.0F, -2.0F, -3.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 31).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 31).addBox(-4.0F, -2.0F, 3.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(368, 31).addBox(-6.0F, 3.0F, -5.0F, 12.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 62).addBox(-10.0F, 3.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 62).addBox(6.0F, 3.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 62).addBox(-6.0F, 3.0F, -9.0F, 12.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(179, 62).addBox(-6.0F, 3.0F, 5.0F, 12.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(244, 62).addBox(-5.0F, 6.0F, -4.0F, 10.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 62).addBox(-8.0F, 6.0F, -4.0F, 3.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(362, 62).addBox(5.0F, 6.0F, -4.0F, 3.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(407, 62).addBox(-5.0F, 6.0F, -7.0F, 10.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 62).addBox(-5.0F, 6.0F, 4.0F, 10.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 93).addBox(8.0F, -4.0F, -1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 93).addBox(8.0F, -6.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 93).addBox(4.0F, -4.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 93).addBox(4.0F, -6.0F, 6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 93).addBox(-5.0F, -4.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 93).addBox(-5.0F, -6.0F, 6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 93).addBox(-10.0F, -4.0F, -1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 93).addBox(-10.0F, -6.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 93).addBox(-6.0F, -4.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 93).addBox(-6.0F, -6.0F, -8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 93).addBox(4.0F, -4.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 93).addBox(4.0F, -6.0F, -8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.01F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(252, 93).addBox(-5.0F, -3.0F, -1.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 93).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 93).addBox(5.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 93).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 93).addBox(-5.0F, -3.0F, 1.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(433, 93).addBox(-5.0F, -3.0F, -2.0F, 10.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 108).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 108).addBox(-5.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 108).addBox(3.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 1.60F, -11.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(83, 108).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(132, 108).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 108).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 108).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 1.39F, -6.0F, 0.16F, 0.0F, 0.77F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(223, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 108).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 108).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 108).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 108).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 108).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 6.30F, 1.0F, -0.04F, 0.0F, -0.55F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(381, 108).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 108).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(463, 108).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 127).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-11.0F, 1.39F, 0.0F, 0.16F, 0.0F, 0.77F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(41, 127).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 127).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 127).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 127).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 127).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 127).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 6.30F, 1.0F, -0.04F, 0.0F, -0.55F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(199, 127).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 127).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 127).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 127).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 1.39F, 6.0F, 0.16F, 0.0F, 0.77F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(339, 127).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 127).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 127).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 127).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 127).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 127).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.20F, 6.30F, 1.0F, -0.04F, 0.0F, -0.55F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(0, 146).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 146).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 146).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 146).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 1.39F, -6.0F, 0.16F, 0.0F, -0.77F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(140, 146).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 146).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 146).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 146).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 146).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 146).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 6.30F, 1.0F, -0.04F, 0.0F, 0.55F));
        PartDefinition leg_4 = root.addOrReplaceChild("leg_4", CubeListBuilder.create()
                .texOffs(298, 146).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 146).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 146).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 146).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(11.0F, 1.39F, 0.0F, 0.16F, 0.0F, -0.77F));
        PartDefinition leg_4_low = leg_4.addOrReplaceChild("leg_4_low", CubeListBuilder.create()
                .texOffs(438, 146).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(471, 146).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 146).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 165).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 165).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 165).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 6.30F, 1.0F, -0.04F, 0.0F, 0.55F));
        PartDefinition leg_5 = root.addOrReplaceChild("leg_5", CubeListBuilder.create()
                .texOffs(91, 165).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 165).addBox(-2.0F, 1.07F, -2.0F, 4.0F, 4.45F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 165).addBox(-1.0F, 5.16F, -1.0F, 2.0F, 2.67F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 165).addBox(-3.0F, 4.90F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, 1.39F, 6.0F, 0.16F, 0.0F, -0.77F));
        PartDefinition leg_5_low = leg_5.addOrReplaceChild("leg_5_low", CubeListBuilder.create()
                .texOffs(231, 165).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 165).addBox(-1.0F, 3.34F, -1.0F, 2.0F, 3.34F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 165).addBox(-1.0F, 4.36F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 165).addBox(-2.0F, 5.36F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 165).addBox(-3.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 165).addBox(1.0F, 8.36F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.20F, 6.30F, 1.0F, -0.04F, 0.0F, 0.55F));
        PartDefinition claw_l = body.addOrReplaceChild("claw_l", CubeListBuilder.create()
                .texOffs(389, 165).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 165).addBox(-3.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(439, 165).addBox(1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(464, 165).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(481, 165).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 184).addBox(-2.0F, 6.0F, -12.0F, 4.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 184).addBox(-3.0F, 9.0F, -12.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 184).addBox(1.0F, 9.0F, -12.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 1.60F, -8.0F, 0.24F, 0.0F, -0.31F));
        PartDefinition claw_r = body.addOrReplaceChild("claw_r", CubeListBuilder.create()
                .texOffs(119, 184).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(144, 184).addBox(-3.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 184).addBox(1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 184).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(211, 184).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 184).addBox(-2.0F, 6.0F, -12.0F, 4.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 184).addBox(-3.0F, 9.0F, -12.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 184).addBox(1.0F, 9.0F, -12.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 1.60F, -8.0F, 0.24F, 0.0F, 0.31F));
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
