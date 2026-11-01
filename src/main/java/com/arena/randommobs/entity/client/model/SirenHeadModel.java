package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SirenHeadEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SirenHeadModel extends RMobModel<SirenHeadEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/siren_head.png");
    public static final float SCALE = 0.94F;
    public static final float SHADOW = 1.60F;

    public SirenHeadModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -27.0F, -6.0F, 12.0F, 54.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-8.0F, 13.0F, -8.0F, 16.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 0).addBox(-8.0F, 29.0F, -8.0F, 16.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 0).addBox(-7.0F, 34.0F, -7.0F, 14.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 0).addBox(-6.0F, -3.0F, -7.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(489, 0).addBox(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 133).addBox(0.0F, -3.0F, -7.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 133).addBox(3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 133).addBox(-6.0F, 3.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 133).addBox(-2.0F, 3.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 133).addBox(2.0F, 3.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 133).addBox(-3.0F, -48.0F, -3.0F, 6.0F, 21.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(166, 133).addBox(-4.0F, 1.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(183, 133).addBox(-3.29F, 3.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(200, 133).addBox(-3.0F, 5.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 133).addBox(-3.29F, 7.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(234, 133).addBox(-4.0F, 9.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 133).addBox(2.0F, 1.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 133).addBox(1.29F, 3.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(285, 133).addBox(1.0F, 5.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(302, 133).addBox(1.29F, 7.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 133).addBox(2.0F, 9.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -59.20F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(336, 133).addBox(-7.0F, -13.0F, -7.0F, 14.0F, 18.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 198).addBox(-11.0F, -10.0F, -6.0F, 4.0F, 12.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 198).addBox(7.0F, -10.0F, -6.0F, 4.0F, 12.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(130, 198).addBox(-12.0F, -8.0F, -3.0F, 1.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(159, 198).addBox(11.0F, -8.0F, -3.0F, 1.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 198).addBox(-3.0F, -15.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 198).addBox(-2.0F, -18.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 198).addBox(-1.0F, -21.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 198).addBox(-6.0F, 4.0F, -7.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 198).addBox(-3.0F, 4.0F, -7.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(305, 198).addBox(0.0F, 4.0F, -7.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 198).addBox(3.0F, 4.0F, -7.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -57.60F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(323, 198).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 198).addBox(-2.0F, 24.0F, -2.0F, 5.0F, 21.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 198).addBox(-2.0F, 64.0F, -2.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(446, 198).addBox(-2.0F, 19.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 198).addBox(-1.0F, 18.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 198).addBox(1.0F, 19.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, -22.40F, 0.0F, 0.0F, 0.0F, 0.09F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(477, 198).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 259).addBox(-2.0F, 24.0F, -2.0F, 5.0F, 21.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 259).addBox(-2.0F, 64.0F, -2.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 259).addBox(-2.0F, 19.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 259).addBox(-1.0F, 18.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(112, 259).addBox(1.0F, 19.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, -22.40F, 0.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(121, 259).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.91F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 259).addBox(-2.0F, 3.68F, -2.0F, 4.0F, 15.34F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 259).addBox(-1.0F, 17.79F, -1.0F, 2.0F, 9.20F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 259).addBox(-3.0F, 26.68F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, -33.60F, 0.0F, 0.0F, 0.0F, 0.07F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(261, 259).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.74F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 259).addBox(-1.0F, 9.55F, -1.0F, 2.0F, 9.55F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 259).addBox(-1.0F, 19.87F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 259).addBox(-2.0F, 20.87F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 259).addBox(-3.0F, 23.87F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 259).addBox(1.0F, 23.87F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 30.60F, 0.0F, 0.0F, 0.0F, 0.00F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(419, 259).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.91F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 259).addBox(-2.0F, 3.68F, -2.0F, 4.0F, 15.34F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 312).addBox(-1.0F, 17.79F, -1.0F, 2.0F, 9.20F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 312).addBox(-3.0F, 26.68F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, -33.60F, 0.0F, 0.0F, 0.0F, -0.07F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(58, 312).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.74F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 312).addBox(-1.0F, 9.55F, -1.0F, 2.0F, 9.55F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 312).addBox(-1.0F, 19.87F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(125, 312).addBox(-2.0F, 20.87F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(166, 312).addBox(-3.0F, 23.87F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(191, 312).addBox(1.0F, 23.87F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 30.60F, 0.0F, 0.0F, 0.0F, -0.00F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(SirenHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
    }
}
