package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.CircuitEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CircuitModel extends RMobModel<CircuitEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/circuit.png");
    public static final float SCALE = 0.89F;
    public static final float SHADOW = 1.0F;

    public CircuitModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 0).addBox(-7.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 0).addBox(4.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 0).addBox(-4.0F, -8.0F, 2.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(246, 0).addBox(-6.0F, 0.0F, -2.0F, 2.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 0).addBox(4.0F, 0.0F, -2.0F, 2.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 0).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 0).addBox(-6.0F, -8.0F, -5.0F, 12.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 0).addBox(-6.0F, 1.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 0).addBox(-2.0F, 1.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 0).addBox(2.0F, 1.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.61F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 25).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 25).addBox(-6.0F, -4.0F, -2.0F, 3.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(70, 25).addBox(3.0F, -4.0F, -2.0F, 3.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 25).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(136, 25).addBox(-3.0F, -4.0F, 2.0F, 6.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 25).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 2.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 25).addBox(-4.0F, -4.0F, -5.0F, 1.0F, 2.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 25).addBox(3.0F, -4.0F, -5.0F, 1.0F, 2.0F, 0.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 25).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 25).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.08F, 0.0F));
        PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create()
                .texOffs(266, 25).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 25).addBox(-3.0F, -1.0F, -7.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 25).addBox(1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.92F, -6.0F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(329, 25).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 25).addBox(-2.0F, 0.90F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 25).addBox(-1.0F, 4.37F, -1.0F, 2.0F, 2.26F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(428, 25).addBox(-3.0F, 3.53F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 3.19F, 0.0F, 0.0F, 0.0F, 0.30F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(469, 25).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.40F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 48).addBox(-1.0F, 3.91F, -1.0F, 2.0F, 3.91F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 48).addBox(-1.0F, 5.77F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 48).addBox(-2.0F, 6.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 48).addBox(-3.0F, 9.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 48).addBox(1.0F, 9.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 7.20F, 0.0F, 0.0F, 0.0F, -0.11F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(125, 48).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 48).addBox(-2.0F, 0.90F, -2.0F, 4.0F, 3.76F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 48).addBox(-1.0F, 4.37F, -1.0F, 2.0F, 2.26F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 48).addBox(-3.0F, 3.53F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 3.19F, 0.0F, 0.0F, 0.0F, -0.30F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(265, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.40F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 48).addBox(-1.0F, 3.91F, -1.0F, 2.0F, 3.91F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(315, 48).addBox(-1.0F, 5.77F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 48).addBox(-2.0F, 6.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 48).addBox(-3.0F, 9.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 48).addBox(1.0F, 9.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 7.20F, 0.0F, 0.0F, 0.0F, 0.11F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(423, 48).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(464, 48).addBox(-2.0F, 1.22F, -2.0F, 3.0F, 5.10F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(489, 48).addBox(-1.0F, 5.91F, -1.0F, 1.0F, 3.06F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 67).addBox(-2.0F, 7.20F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, -7.21F, 0.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(33, 67).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 4.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 67).addBox(-1.0F, 3.65F, -1.0F, 1.0F, 3.65F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 67).addBox(-1.0F, 6.12F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 67).addBox(-2.0F, 6.12F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 67).addBox(-3.0F, 9.12F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 67).addBox(1.0F, 9.12F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.03F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(167, 67).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 67).addBox(-2.0F, 1.22F, -2.0F, 3.0F, 5.10F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 67).addBox(-1.0F, 5.91F, -1.0F, 1.0F, 3.06F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 67).addBox(-2.0F, 7.20F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, -7.21F, 0.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(275, 67).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 4.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 67).addBox(-1.0F, 3.65F, -1.0F, 1.0F, 3.65F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(309, 67).addBox(-1.0F, 6.12F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 67).addBox(-2.0F, 6.12F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 67).addBox(-3.0F, 9.12F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 67).addBox(1.0F, 9.12F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.03F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(CircuitEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart face = this.root.getChild("body").getChild("head").getChild("face"); Anims.pulse(face, ageInTicks, 0.06F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart arm_l = this.root.getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 11.00F);
        ModelPart arm_l_low = this.root.getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 12.57F);
        ModelPart arm_r = this.root.getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 14.14F);
        ModelPart arm_r_low = this.root.getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 15.71F);
    }
}
