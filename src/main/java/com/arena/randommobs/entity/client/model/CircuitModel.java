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
                .texOffs(0, 0).addBox(-7.0F, -9.0F, -4.0F, 14.0F, 14.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 0).addBox(-8.0F, 6.0F, -5.0F, 16.0F, 6.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 0).addBox(-6.0F, -9.0F, -3.0F, 12.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 0).addBox(-6.0F, -2.0F, -3.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 0).addBox(-3.0F, -3.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 0).addBox(0.0F, -3.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 0).addBox(3.0F, -2.0F, -3.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 0).addBox(-8.0F, 2.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 0).addBox(-8.0F, 3.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 0).addBox(-8.0F, 3.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(382, 0).addBox(-8.0F, 1.0F, -3.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 0).addBox(-7.13F, 3.0F, -3.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 0).addBox(-7.13F, 5.0F, -3.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(433, 0).addBox(-8.0F, 7.0F, -3.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.03F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 47).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 10.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 47).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 47).addBox(-2.0F, -4.0F, -7.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 47).addBox(-5.0F, 5.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 47).addBox(-2.0F, 5.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 47).addBox(2.0F, 5.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.40F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(230, 47).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 11.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(255, 47).addBox(-2.0F, 11.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 47).addBox(-2.0F, 16.0F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -5.60F, 0.0F, 0.0F, 0.0F, 0.12F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(329, 47).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 11.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 47).addBox(-2.0F, 11.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 47).addBox(-2.0F, 16.0F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -5.60F, 0.0F, 0.0F, 0.0F, -0.12F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(428, 47).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 47).addBox(-2.0F, 1.10F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(494, 47).addBox(-1.0F, 5.31F, -1.0F, 1.0F, 2.75F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 92).addBox(-2.0F, 6.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 5.37F, 0.0F, 0.0F, 0.0F, 0.18F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(33, 92).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.86F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 92).addBox(-1.0F, 2.54F, -1.0F, 1.0F, 2.54F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 92).addBox(-1.0F, 3.35F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 92).addBox(-2.0F, 3.35F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 92).addBox(-3.0F, 6.35F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 92).addBox(1.0F, 6.35F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 9.0F, 0.0F, 0.0F, 0.0F, 0.03F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(167, 92).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 92).addBox(-2.0F, 1.10F, -2.0F, 3.0F, 4.58F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 92).addBox(-1.0F, 5.31F, -1.0F, 1.0F, 2.75F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 92).addBox(-2.0F, 6.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 5.37F, 0.0F, 0.0F, 0.0F, -0.18F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(275, 92).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.86F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 92).addBox(-1.0F, 2.54F, -1.0F, 1.0F, 2.54F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(309, 92).addBox(-1.0F, 3.35F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 92).addBox(-2.0F, 3.35F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 92).addBox(-3.0F, 6.35F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 92).addBox(1.0F, 6.35F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 9.0F, 0.0F, 0.0F, 0.0F, -0.03F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(CircuitEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
