package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BearEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BearModel extends RMobModel<BearEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bear.png");
    public static final float SCALE = 0.78F;
    public static final float SHADOW = 1.0F;

    public BearModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -9.0F, -7.0F, 12.0F, 10.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 0).addBox(-11.0F, -9.0F, -7.0F, 5.0F, 10.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 0).addBox(6.0F, -9.0F, -7.0F, 5.0F, 10.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 0).addBox(-6.0F, -9.0F, -12.0F, 12.0F, 10.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 0).addBox(-6.0F, -9.0F, 7.0F, 12.0F, 10.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 0).addBox(-5.0F, 1.0F, -6.0F, 10.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 49).addBox(-9.0F, 1.0F, -6.0F, 4.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 49).addBox(5.0F, 1.0F, -6.0F, 4.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(130, 49).addBox(-5.0F, 1.0F, -10.0F, 10.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(187, 49).addBox(-5.0F, 1.0F, 6.0F, 10.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(244, 49).addBox(-5.0F, -13.0F, -5.0F, 10.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 49).addBox(-7.0F, -13.0F, -5.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 49).addBox(5.0F, -13.0F, -5.0F, 2.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 49).addBox(-5.0F, -13.0F, -7.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 49).addBox(-5.0F, -13.0F, 3.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 86).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 86).addBox(-5.0F, -11.0F, -4.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(86, 86).addBox(4.0F, -11.0F, -4.0F, 1.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 86).addBox(-4.0F, -11.0F, -5.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 86).addBox(-4.0F, -11.0F, 2.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 86).addBox(-2.0F, -2.0F, 12.0F, 4.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.37F, 2.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create()
                .texOffs(218, 86).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 86).addBox(-7.0F, -4.0F, -2.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 86).addBox(4.0F, -4.0F, -2.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(313, 86).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 86).addBox(-4.0F, -4.0F, 1.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.80F, -9.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(403, 86).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 86).addBox(-6.0F, -5.0F, -4.0F, 2.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 86).addBox(4.0F, -5.0F, -4.0F, 2.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 109).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 109).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 109).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 109).addBox(-4.0F, -3.0F, -7.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 109).addBox(1.0F, -3.0F, -7.0F, 3.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 109).addBox(-3.0F, -2.0F, -7.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 109).addBox(1.0F, -2.0F, -7.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(191, 109).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 109).addBox(-4.0F, -3.0F, -3.0F, 1.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 109).addBox(3.0F, -3.0F, -3.0F, 1.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 109).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 109).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 109).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 109).addBox(-1.0F, -4.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 109).addBox(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 109).addBox(-1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 109).addBox(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 109).addBox(-6.0F, -8.0F, -2.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 109).addBox(-7.0F, -8.0F, -2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 109).addBox(-4.0F, -8.0F, -2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 109).addBox(-6.0F, -8.0F, -3.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(473, 109).addBox(-6.0F, -8.0F, 0.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(486, 109).addBox(-5.0F, -7.0F, -1.0F, 0.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 109).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(493, 109).addBox(-5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(498, 109).addBox(-5.0F, -7.0F, -2.0F, 0.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(503, 109).addBox(-5.0F, -7.0F, -1.0F, 0.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 128).addBox(4.0F, -8.0F, -2.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 128).addBox(3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(30, 128).addBox(6.0F, -8.0F, -2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(43, 128).addBox(4.0F, -8.0F, -3.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(56, 128).addBox(4.0F, -8.0F, 0.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(69, 128).addBox(5.0F, -7.0F, -1.0F, 0.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(71, 128).addBox(4.0F, -7.0F, -1.0F, 1.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 128).addBox(5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 128).addBox(5.0F, -7.0F, -2.0F, 0.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(86, 128).addBox(5.0F, -7.0F, -1.0F, 0.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.40F, -4.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(91, 128).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 128).addBox(-3.0F, 0.82F, -3.0F, 5.0F, 3.44F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 128).addBox(-2.0F, 3.99F, -2.0F, 3.0F, 2.06F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 128).addBox(-3.0F, 1.87F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 3.97F, -7.0F, 0.0F, 0.0F, 0.41F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(263, 128).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 4.13F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 128).addBox(-2.0F, 3.67F, -2.0F, 3.0F, 3.67F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 128).addBox(-2.0F, 4.18F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 128).addBox(-2.0F, 6.18F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 128).addBox(-3.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 128).addBox(1.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 6.30F, 0.0F, 0.0F, 0.0F, -0.16F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(445, 128).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 151).addBox(-3.0F, 0.82F, -3.0F, 5.0F, 3.44F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 151).addBox(-2.0F, 3.99F, -2.0F, 3.0F, 2.06F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 151).addBox(-3.0F, 1.87F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 3.97F, -7.0F, 0.0F, 0.0F, -0.41F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(115, 151).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 4.13F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 151).addBox(-2.0F, 3.67F, -2.0F, 3.0F, 3.67F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 151).addBox(-2.0F, 4.18F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 151).addBox(-2.0F, 6.18F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 151).addBox(-3.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 151).addBox(1.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 6.30F, 0.0F, 0.0F, 0.0F, 0.16F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(297, 151).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 151).addBox(-3.0F, 0.82F, -3.0F, 5.0F, 3.44F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 151).addBox(-2.0F, 3.99F, -2.0F, 3.0F, 2.06F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 151).addBox(-3.0F, 1.87F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 3.97F, 8.0F, 0.0F, 0.0F, 0.41F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(469, 151).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 4.13F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 174).addBox(-2.0F, 3.67F, -2.0F, 3.0F, 3.67F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 174).addBox(-2.0F, 4.18F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 174).addBox(-2.0F, 6.18F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 174).addBox(-3.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 174).addBox(1.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 6.30F, 0.0F, 0.0F, 0.0F, -0.16F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(141, 174).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 174).addBox(-3.0F, 0.82F, -3.0F, 5.0F, 3.44F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 174).addBox(-2.0F, 3.99F, -2.0F, 3.0F, 2.06F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 174).addBox(-3.0F, 1.87F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 3.97F, 8.0F, 0.0F, 0.0F, -0.41F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(313, 174).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 4.13F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 174).addBox(-2.0F, 3.67F, -2.0F, 3.0F, 3.67F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 174).addBox(-2.0F, 4.18F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 174).addBox(-2.0F, 6.18F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 174).addBox(-3.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(470, 174).addBox(1.0F, 9.18F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 6.30F, 0.0F, 0.0F, 0.0F, 0.16F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart neck = this.root.getChild("body").getChild("neck"); Anims.look(neck, netHeadYaw, headPitch);
        ModelPart head = this.root.getChild("body").getChild("neck").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
    }
}
