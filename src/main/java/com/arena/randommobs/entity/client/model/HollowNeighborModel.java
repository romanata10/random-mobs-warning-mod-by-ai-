package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.HollowNeighborEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class HollowNeighborModel extends RMobModel<HollowNeighborEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/hollow_neighbor.png");
    public static final float SCALE = 0.87F;
    public static final float SHADOW = 0.90F;

    public HollowNeighborModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 0).addBox(-7.0F, -7.0F, -2.0F, 3.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 0).addBox(4.0F, -7.0F, -2.0F, 3.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 0).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 9.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 0).addBox(-4.0F, -7.0F, 2.0F, 8.0F, 9.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 0).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(246, 0).addBox(-8.0F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 0).addBox(4.0F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 0).addBox(-4.0F, 2.0F, -6.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(361, 0).addBox(-4.0F, 2.0F, 2.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 0).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 29).addBox(-9.0F, 9.0F, -3.0F, 4.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 29).addBox(5.0F, 9.0F, -3.0F, 4.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 29).addBox(-5.0F, 9.0F, -7.0F, 10.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 29).addBox(-5.0F, 9.0F, 3.0F, 10.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 29).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 29).addBox(-6.0F, -8.0F, -2.0F, 3.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 29).addBox(3.0F, -8.0F, -2.0F, 3.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 29).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 29).addBox(-3.0F, -8.0F, 2.0F, 6.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.63F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(369, 29).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 29).addBox(-5.0F, -3.0F, -3.0F, 2.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 29).addBox(3.0F, -3.0F, -3.0F, 2.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 29).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 58).addBox(-3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 58).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 58).addBox(-3.0F, -1.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(87, 58).addBox(1.0F, -1.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 58).addBox(-2.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 58).addBox(1.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 58).addBox(-4.0F, 2.0F, -6.0F, 8.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 58).addBox(-3.0F, 1.0F, -6.0F, 6.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.92F, 0.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(184, 58).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.60F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(225, 58).addBox(-2.0F, 1.95F, -2.0F, 3.0F, 8.14F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 58).addBox(-1.0F, 9.44F, -1.0F, 1.0F, 4.88F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 58).addBox(-2.0F, 13.28F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, -7.71F, 0.0F, 0.0F, 0.0F, 0.19F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(292, 58).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.78F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 58).addBox(-1.0F, 6.03F, -1.0F, 1.0F, 6.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 58).addBox(-1.0F, 12.07F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 16.0F, 0.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(335, 58).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.60F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 58).addBox(-2.0F, 1.95F, -2.0F, 3.0F, 8.14F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 58).addBox(-1.0F, 9.44F, -1.0F, 1.0F, 4.88F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 58).addBox(-2.0F, 13.28F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, -7.71F, 0.0F, 0.0F, 0.0F, -0.19F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(443, 58).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.78F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 58).addBox(-1.0F, 6.03F, -1.0F, 1.0F, 6.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 58).addBox(-1.0F, 12.07F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.09F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(0, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 81).addBox(-2.0F, 0.85F, -2.0F, 4.0F, 3.53F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 81).addBox(-1.0F, 4.09F, -1.0F, 2.0F, 2.12F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 81).addBox(-3.0F, 3.05F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 4.77F, 0.0F, 0.0F, 0.0F, 0.32F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(140, 81).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.56F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 81).addBox(-1.0F, 3.16F, -1.0F, 2.0F, 3.16F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 81).addBox(-1.0F, 3.91F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 6.70F, 0.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(207, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 81).addBox(-2.0F, 0.85F, -2.0F, 4.0F, 3.53F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 81).addBox(-1.0F, 4.09F, -1.0F, 2.0F, 2.12F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 81).addBox(-3.0F, 3.05F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 4.77F, 0.0F, 0.0F, 0.0F, -0.32F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(347, 81).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.56F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 81).addBox(-1.0F, 3.16F, -1.0F, 2.0F, 3.16F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 81).addBox(-1.0F, 3.91F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 6.70F, 0.0F, 0.0F, 0.0F, 0.09F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(HollowNeighborEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
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
