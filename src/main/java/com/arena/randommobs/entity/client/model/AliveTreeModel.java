package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AliveTreeEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class AliveTreeModel extends RMobModel<AliveTreeEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/alive_tree.png");
    public static final float SCALE = 0.88F;
    public static final float SHADOW = 2.60F;

    public AliveTreeModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 16.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 0).addBox(-8.0F, -5.0F, -4.0F, 4.0F, 16.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 0).addBox(4.0F, -5.0F, -4.0F, 4.0F, 16.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 16.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 0).addBox(-4.0F, -5.0F, 4.0F, 8.0F, 16.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(261, 0).addBox(-5.0F, 10.0F, -5.0F, 10.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(342, 0).addBox(-9.0F, 10.0F, -5.0F, 4.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 0).addBox(5.0F, 10.0F, -5.0F, 4.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 0).addBox(-5.0F, 10.0F, -9.0F, 10.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 49).addBox(-5.0F, 10.0F, 5.0F, 10.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 49).addBox(-10.0F, 23.0F, -10.0F, 20.0F, 10.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 49).addBox(8.0F, 19.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(267, 49).addBox(9.0F, 16.0F, -2.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 49).addBox(10.0F, 13.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 49).addBox(5.0F, 19.0F, 5.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(382, 49).addBox(6.0F, 16.0F, 6.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 49).addBox(7.0F, 13.0F, 7.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 49).addBox(-3.0F, 19.0F, 8.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 110).addBox(-2.0F, 16.0F, 9.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 110).addBox(-1.0F, 13.0F, 10.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 110).addBox(-11.0F, 19.0F, 5.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 110).addBox(-10.0F, 16.0F, 6.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 110).addBox(-9.0F, 13.0F, 7.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 110).addBox(-5.0F, 6.0F, -9.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 110).addBox(2.0F, 6.0F, -9.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(231, 110).addBox(-4.0F, 8.0F, -9.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(244, 110).addBox(3.0F, 8.0F, -9.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 110).addBox(-4.0F, 17.0F, -9.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.40F, 0.0F));
        PartDefinition crown = body.addOrReplaceChild("crown", CubeListBuilder.create()
                .texOffs(298, 110).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 4.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 159).addBox(-15.0F, -8.0F, -10.0F, 5.0F, 4.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 159).addBox(10.0F, -8.0F, -10.0F, 5.0F, 4.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 159).addBox(-10.0F, -8.0F, -15.0F, 20.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 159).addBox(-10.0F, -8.0F, 10.0F, 20.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 208).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 208).addBox(-12.0F, -4.0F, -8.0F, 4.0F, 4.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 208).addBox(8.0F, -4.0F, -8.0F, 4.0F, 4.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 208).addBox(-8.0F, -4.0F, -12.0F, 16.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 208).addBox(-8.0F, -4.0F, 8.0F, 16.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 249).addBox(-6.0F, 1.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 249).addBox(-9.0F, 1.0F, -6.0F, 3.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(158, 249).addBox(6.0F, 1.0F, -6.0F, 3.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(219, 249).addBox(-6.0F, 1.0F, -9.0F, 12.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(280, 249).addBox(-6.0F, 1.0F, 6.0F, 12.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(341, 249).addBox(-8.0F, -19.0F, -8.0F, 16.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 294).addBox(-12.0F, -19.0F, -8.0F, 4.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 294).addBox(8.0F, -19.0F, -8.0F, 4.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 294).addBox(-8.0F, -19.0F, -12.0F, 16.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 294).addBox(-8.0F, -19.0F, 8.0F, 16.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(324, 294).addBox(-6.0F, -13.0F, -6.0F, 12.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(421, 294).addBox(-8.0F, -13.0F, -6.0F, 2.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 339).addBox(6.0F, -13.0F, -6.0F, 2.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 339).addBox(-6.0F, -13.0F, -8.0F, 12.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 339).addBox(-6.0F, -13.0F, 6.0F, 12.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 339).addBox(-6.0F, -29.0F, -6.0F, 12.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 339).addBox(-9.0F, -29.0F, -6.0F, 3.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 339).addBox(6.0F, -29.0F, -6.0F, 3.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 339).addBox(-6.0F, -29.0F, -9.0F, 12.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 339).addBox(-6.0F, -29.0F, 6.0F, 12.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 376).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 376).addBox(-6.0F, -24.0F, -4.0F, 2.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 376).addBox(4.0F, -24.0F, -4.0F, 2.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 376).addBox(-4.0F, -24.0F, -6.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 376).addBox(-4.0F, -24.0F, 4.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 376).addBox(-5.0F, -36.0F, -5.0F, 10.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 376).addBox(-7.0F, -36.0F, -5.0F, 2.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 376).addBox(5.0F, -36.0F, -5.0F, 2.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 376).addBox(-5.0F, -36.0F, -7.0F, 10.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(457, 376).addBox(-5.0F, -36.0F, 5.0F, 10.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 405).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 405).addBox(-5.0F, -32.0F, -4.0F, 1.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(102, 405).addBox(4.0F, -32.0F, -4.0F, 1.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 405).addBox(-4.0F, -32.0F, -5.0F, 8.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 405).addBox(-4.0F, -32.0F, 4.0F, 8.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 405).addBox(-13.0F, 6.0F, -6.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 405).addBox(10.0F, 6.0F, 4.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 405).addBox(-4.0F, 6.0F, 12.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 405).addBox(6.0F, 6.0F, -12.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.40F, 0.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(313, 405).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 405).addBox(-3.0F, 1.20F, -3.0F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 405).addBox(-2.0F, 5.80F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(436, 405).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -17.40F, 0.0F, 0.0F, 0.0F, 0.64F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(0, 430).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 3.66F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 430).addBox(-2.0F, 3.26F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 430).addBox(-2.0F, 3.14F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.46F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(91, 430).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 430).addBox(-3.0F, 1.20F, -3.0F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 430).addBox(-2.0F, 5.80F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 430).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -17.40F, 0.0F, 0.0F, 0.0F, -0.64F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(263, 430).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 3.66F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 430).addBox(-2.0F, 3.26F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 430).addBox(-2.0F, 3.14F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.46F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(354, 430).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.19F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 430).addBox(-3.0F, 1.64F, -3.0F, 6.0F, 6.83F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 430).addBox(-2.0F, 7.93F, -2.0F, 4.0F, 4.10F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 457).addBox(-4.0F, 7.67F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, -3.00F, 0.0F, 0.0F, 0.0F, 0.40F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(57, 457).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 5.97F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 457).addBox(-2.0F, 5.31F, -2.0F, 4.0F, 5.31F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 457).addBox(-2.0F, 7.28F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.30F, 12.60F, 0.0F, 0.0F, 0.0F, -0.19F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(172, 457).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.19F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 457).addBox(-3.0F, 1.64F, -3.0F, 6.0F, 6.83F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 457).addBox(-2.0F, 7.93F, -2.0F, 4.0F, 4.10F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 457).addBox(-4.0F, 7.67F, -4.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, -3.00F, 0.0F, 0.0F, 0.0F, -0.40F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(376, 457).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 5.97F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 457).addBox(-2.0F, 5.31F, -2.0F, 4.0F, 5.31F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(458, 457).addBox(-2.0F, 7.28F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.30F, 12.60F, 0.0F, 0.0F, 0.0F, 0.19F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(AliveTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart crown = this.root.getChild("body").getChild("crown"); Anims.look(crown, netHeadYaw, headPitch);
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
