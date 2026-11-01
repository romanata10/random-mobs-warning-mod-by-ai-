package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BloopEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BloopModel extends RMobModel<BloopEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bloop.png");
    public static final float SCALE = 0.97F;
    public static final float SHADOW = 3.40F;

    public BloopModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-14.0F, -18.0F, -12.0F, 28.0F, 17.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 0).addBox(-22.0F, -18.0F, -12.0F, 8.0F, 17.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 0).addBox(14.0F, -18.0F, -12.0F, 8.0F, 17.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 83).addBox(-14.0F, -18.0F, -20.0F, 28.0F, 17.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 83).addBox(-14.0F, -18.0F, 12.0F, 28.0F, 17.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 83).addBox(-12.0F, -28.0F, -10.0F, 24.0F, 5.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 134).addBox(-17.0F, -28.0F, -10.0F, 5.0F, 5.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 134).addBox(12.0F, -28.0F, -10.0F, 5.0F, 5.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 134).addBox(-12.0F, -28.0F, -15.0F, 24.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 134).addBox(-12.0F, -28.0F, 10.0F, 24.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 185).addBox(-8.0F, -23.0F, -6.0F, 16.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 185).addBox(-12.0F, -23.0F, -6.0F, 4.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 185).addBox(8.0F, -23.0F, -6.0F, 4.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 185).addBox(-8.0F, -23.0F, -10.0F, 16.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(324, 185).addBox(-8.0F, -23.0F, 6.0F, 16.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 220).addBox(-11.0F, -10.0F, -9.0F, 22.0F, 10.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(161, 220).addBox(-18.0F, -10.0F, -9.0F, 7.0F, 10.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 220).addBox(11.0F, -10.0F, -9.0F, 7.0F, 10.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 220).addBox(-11.0F, -10.0F, -16.0F, 22.0F, 10.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 277).addBox(-11.0F, -10.0F, 9.0F, 22.0F, 10.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 277).addBox(-8.0F, -1.0F, -7.0F, 16.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 277).addBox(-13.0F, -1.0F, -7.0F, 5.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(315, 277).addBox(8.0F, -1.0F, -7.0F, 5.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(392, 277).addBox(-8.0F, -1.0F, -12.0F, 16.0F, 8.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 322).addBox(-8.0F, -1.0F, 7.0F, 16.0F, 8.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(85, 322).addBox(-1.0F, -28.0F, -7.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 322).addBox(-1.0F, -30.0F, -7.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(127, 322).addBox(-1.0F, -29.0F, -3.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 322).addBox(-1.0F, -32.0F, -3.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 322).addBox(-1.0F, -28.0F, 1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 322).addBox(-1.0F, -30.0F, 1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(211, 322).addBox(-1.0F, -29.0F, 5.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 322).addBox(-1.0F, -32.0F, 5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 322).addBox(-15.0F, -13.0F, -12.0F, 30.0F, 2.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 375).addBox(-21.0F, -13.0F, -12.0F, 6.0F, 2.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 375).addBox(15.0F, -13.0F, -12.0F, 6.0F, 2.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 375).addBox(-15.0F, -13.0F, -18.0F, 30.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 428).addBox(-15.0F, -13.0F, 12.0F, 30.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 428).addBox(-18.0F, -15.0F, -14.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 428).addBox(-18.0F, -15.0F, -5.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 428).addBox(-18.0F, -15.0F, 4.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 428).addBox(18.0F, -15.0F, -14.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 428).addBox(18.0F, -15.0F, -5.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 428).addBox(18.0F, -15.0F, 4.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -13.60F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(295, 428).addBox(-13.0F, -18.0F, -5.0F, 26.0F, 16.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 428).addBox(-16.0F, -18.0F, -5.0F, 3.0F, 16.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 428).addBox(13.0F, -18.0F, -5.0F, 3.0F, 16.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 469).addBox(-13.0F, -18.0F, -8.0F, 26.0F, 16.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 469).addBox(-13.0F, -18.0F, -1.0F, 26.0F, 16.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(234, 469).addBox(-13.0F, -10.0F, -9.0F, 26.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(351, 469).addBox(-12.0F, -4.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 469).addBox(-9.0F, -4.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 469).addBox(-6.0F, -4.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 469).addBox(-3.0F, -4.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 469).addBox(0.0F, -4.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 469).addBox(3.0F, -4.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 469).addBox(6.0F, -4.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 508).addBox(9.0F, -4.0F, -10.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 508).addBox(-12.0F, -2.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 508).addBox(-9.0F, -2.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(63, 508).addBox(-6.0F, -3.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 508).addBox(-3.0F, -2.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 508).addBox(0.0F, -3.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 508).addBox(3.0F, -2.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 508).addBox(6.0F, -3.0F, -10.0F, 2.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 508).addBox(9.0F, -1.0F, -10.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 508).addBox(-18.0F, -6.0F, -4.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 508).addBox(14.0F, -6.0F, -4.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.80F, -20.0F));
        PartDefinition fin_l = body.addOrReplaceChild("fin_l", CubeListBuilder.create()
                .texOffs(255, 508).addBox(1.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 508).addBox(-2.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 508).addBox(4.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 508).addBox(1.0F, -5.0F, -7.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(415, 508).addBox(1.0F, -5.0F, 4.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(440, 508).addBox(1.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 537).addBox(-1.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 537).addBox(3.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 537).addBox(1.0F, 0.0F, -11.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 537).addBox(1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-22.0F, 7.20F, -8.0F, 0.0F, 0.0F, 0.35F));
        PartDefinition fin_r = body.addOrReplaceChild("fin_r", CubeListBuilder.create()
                .texOffs(108, 537).addBox(3.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 537).addBox(0.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 537).addBox(6.0F, -5.0F, -4.0F, 3.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 537).addBox(3.0F, -5.0F, -7.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 537).addBox(3.0F, -5.0F, 4.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 537).addBox(2.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(330, 537).addBox(0.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 537).addBox(4.0F, 0.0F, -9.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 537).addBox(2.0F, 0.0F, -11.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(421, 537).addBox(2.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(22.0F, 7.20F, -8.0F, 0.0F, 0.0F, -0.35F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(0, 566).addBox(-9.0F, -13.0F, 3.0F, 18.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 566).addBox(-12.0F, -13.0F, 3.0F, 3.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 566).addBox(9.0F, -13.0F, 3.0F, 3.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 566).addBox(-9.0F, -13.0F, 0.0F, 18.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(232, 566).addBox(-9.0F, -13.0F, 7.0F, 18.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 566).addBox(-5.0F, -10.0F, 10.0F, 10.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(374, 566).addBox(-7.0F, -10.0F, 10.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 566).addBox(5.0F, -10.0F, 10.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 566).addBox(-5.0F, -10.0F, 8.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 587).addBox(-5.0F, -10.0F, 14.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.80F, 19.0F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(BloopEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart fin_l = this.root.getChild("body").getChild("fin_l"); Anims.swing(fin_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart fin_r = this.root.getChild("body").getChild("fin_r"); Anims.swing(fin_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart tail = this.root.getChild("body").getChild("tail"); Anims.swayOne(tail, ageInTicks, 0.09F, 6.28F);
    }
}
