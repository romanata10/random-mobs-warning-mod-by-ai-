package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.LanternWraithEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LanternWraithModel extends RMobModel<LanternWraithEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/lantern_wraith.png");
    public static final float SCALE = 0.86F;
    public static final float SHADOW = 0.70F;

    public LanternWraithModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 0).addBox(-8.0F, -8.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 0).addBox(4.0F, -8.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 0).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 0).addBox(-4.0F, -8.0F, 2.0F, 8.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 0).addBox(-5.0F, 3.0F, -3.0F, 10.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 0).addBox(-9.0F, 3.0F, -3.0F, 4.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 0).addBox(5.0F, 3.0F, -3.0F, 4.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 0).addBox(-5.0F, 3.0F, -7.0F, 10.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 0).addBox(-5.0F, 3.0F, 3.0F, 10.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(474, 0).addBox(-9.0F, 8.0F, -6.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 37).addBox(-5.0F, 8.0F, -6.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 37).addBox(-1.0F, 8.0F, -6.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 37).addBox(3.0F, 8.0F, -6.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(63, 37).addBox(7.0F, 8.0F, -6.0F, 2.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 37).addBox(-8.0F, -8.0F, -6.0F, 16.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.40F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(197, 37).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(246, 37).addBox(-5.0F, -4.0F, -3.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 37).addBox(3.0F, -4.0F, -3.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 37).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 37).addBox(-3.0F, -4.0F, 3.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 37).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 37).addBox(-3.0F, -2.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 37).addBox(1.0F, -2.0F, -6.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 37).addBox(-2.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(454, 37).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 66).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 66).addBox(-6.0F, -9.0F, -4.0F, 2.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 66).addBox(4.0F, -9.0F, -4.0F, 2.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 66).addBox(-4.0F, -9.0F, -6.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 66).addBox(-4.0F, -9.0F, 4.0F, 8.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 66).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 66).addBox(-4.0F, -7.0F, -3.0F, 1.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(307, 66).addBox(3.0F, -7.0F, -3.0F, 1.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 66).addBox(-3.0F, -7.0F, -4.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 66).addBox(-3.0F, -7.0F, 3.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.40F, 0.0F));
        PartDefinition orb = body.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(394, 66).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 66).addBox(-4.0F, -4.0F, -2.0F, 2.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 66).addBox(2.0F, -4.0F, -2.0F, 2.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 66).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 89).addBox(-2.0F, -4.0F, 2.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 89).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 89).addBox(-3.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(59, 89).addBox(1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 89).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 89).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 89).addBox(-5.0F, -4.0F, -1.0F, 10.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(159, 89).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.40F, -7.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(176, 89).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 89).addBox(-2.0F, 1.48F, -2.0F, 3.0F, 6.18F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 89).addBox(-1.0F, 7.17F, -1.0F, 1.0F, 3.71F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 89).addBox(-2.0F, 9.37F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -1.60F, 0.0F, 0.0F, 0.0F, 0.25F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(284, 89).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.00F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(309, 89).addBox(-1.0F, 4.44F, -1.0F, 1.0F, 4.44F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 89).addBox(-1.0F, 8.10F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.11F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(327, 89).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(368, 89).addBox(-2.0F, 1.48F, -2.0F, 3.0F, 6.18F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 89).addBox(-1.0F, 7.17F, -1.0F, 1.0F, 3.71F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 89).addBox(-2.0F, 9.37F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -1.60F, 0.0F, 0.0F, 0.0F, -0.25F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(435, 89).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.00F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 89).addBox(-1.0F, 4.44F, -1.0F, 1.0F, 4.44F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 89).addBox(-1.0F, 8.10F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.11F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(LanternWraithEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart orb = this.root.getChild("body").getChild("orb"); Anims.pulse(orb, ageInTicks, 0.06F);
        ModelPart arm_l = this.root.getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart arm_l_low = this.root.getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 6.28F);
        ModelPart arm_r = this.root.getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 7.85F);
        ModelPart arm_r_low = this.root.getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 9.42F);
    }
}
