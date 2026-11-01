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
                .texOffs(0, 0).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 0).addBox(-7.0F, -11.0F, -2.0F, 3.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 0).addBox(4.0F, -11.0F, -2.0F, 3.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 0).addBox(-4.0F, -11.0F, -5.0F, 8.0F, 24.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 0).addBox(-4.0F, -11.0F, 2.0F, 8.0F, 24.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 0).addBox(-3.0F, 13.0F, -2.0F, 6.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 0).addBox(-5.0F, 13.0F, -2.0F, 2.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 0).addBox(3.0F, 13.0F, -2.0F, 2.0F, 24.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 0).addBox(-3.0F, 13.0F, -4.0F, 6.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 0).addBox(-3.0F, 13.0F, 2.0F, 6.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 0).addBox(-4.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 0).addBox(-3.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 0).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 0).addBox(0.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 0).addBox(2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -67.21F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create()
                .texOffs(411, 0).addBox(-2.0F, -29.0F, -2.0F, 4.0F, 29.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(440, 0).addBox(-4.0F, -29.0F, -2.0F, 2.0F, 29.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(461, 0).addBox(2.0F, -29.0F, -2.0F, 2.0F, 29.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(482, 0).addBox(-2.0F, -29.0F, -4.0F, 4.0F, 29.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 65).addBox(-2.0F, -29.0F, 1.0F, 4.0F, 29.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(25, 65).addBox(-4.0F, -16.0F, -3.0F, 8.0F, 16.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 65).addBox(-9.0F, -16.0F, -3.0F, 5.0F, 16.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(119, 65).addBox(4.0F, -16.0F, -3.0F, 5.0F, 16.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(160, 65).addBox(-4.0F, -16.0F, -8.0F, 8.0F, 16.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 65).addBox(-4.0F, -16.0F, 2.0F, 8.0F, 16.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 65).addBox(-4.0F, -18.0F, -3.0F, 8.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 65).addBox(-7.0F, -18.0F, -3.0F, 3.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(352, 65).addBox(4.0F, -18.0F, -3.0F, 3.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 65).addBox(-4.0F, -18.0F, -6.0F, 8.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 65).addBox(-4.0F, -18.0F, 2.0F, 8.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 128).addBox(-9.0F, -20.0F, -3.0F, 7.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 128).addBox(-8.0F, -22.0F, -2.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 128).addBox(-8.0F, -25.0F, -2.0F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 128).addBox(3.0F, -20.0F, -3.0F, 7.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 128).addBox(4.0F, -22.0F, -2.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 128).addBox(4.0F, -25.0F, -2.0F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 128).addBox(-9.0F, -8.0F, -14.0F, 9.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 128).addBox(-8.0F, -10.0F, -13.0F, 7.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(392, 128).addBox(-7.0F, -12.0F, -12.0F, 5.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(433, 128).addBox(1.0F, -8.0F, -14.0F, 9.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 153).addBox(2.0F, -10.0F, -13.0F, 7.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 153).addBox(3.0F, -12.0F, -12.0F, 5.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 153).addBox(-1.0F, -18.0F, -8.0F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -28.80F, 0.0F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(111, 153).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.55F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(160, 153).addBox(-2.0F, 2.66F, -2.0F, 4.0F, 11.10F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 153).addBox(-1.0F, 12.88F, -1.0F, 2.0F, 6.66F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 153).addBox(-3.0F, 18.20F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, -76.81F, 0.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(251, 153).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.03F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 153).addBox(-1.0F, 8.02F, -1.0F, 2.0F, 8.02F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 153).addBox(-1.0F, 16.06F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.06F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(318, 153).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.55F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 153).addBox(-2.0F, 2.66F, -2.0F, 4.0F, 11.10F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 153).addBox(-1.0F, 12.88F, -1.0F, 2.0F, 6.66F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 153).addBox(-3.0F, 18.20F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, -76.81F, 0.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(458, 153).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.03F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(491, 153).addBox(-1.0F, 8.02F, -1.0F, 2.0F, 8.02F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 184).addBox(-1.0F, 16.06F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(17, 184).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 4.00F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 184).addBox(-4.0F, 3.00F, -4.0F, 7.0F, 12.50F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 184).addBox(-3.0F, 14.50F, -3.0F, 5.0F, 7.50F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(188, 184).addBox(-4.0F, 17.99F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, -51.21F, 0.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(253, 184).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 22.23F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 184).addBox(-3.0F, 19.76F, -3.0F, 5.0F, 19.76F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(351, 184).addBox(-3.0F, 42.40F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.85F, 24.30F, 0.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(392, 184).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 4.00F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 243).addBox(-4.0F, 3.00F, -4.0F, 7.0F, 12.50F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 243).addBox(-3.0F, 14.50F, -3.0F, 5.0F, 7.50F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 243).addBox(-4.0F, 17.99F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, -51.21F, 0.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(163, 243).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 22.23F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 243).addBox(-3.0F, 19.76F, -3.0F, 5.0F, 19.76F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(261, 243).addBox(-3.0F, 42.40F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.85F, 24.30F, 0.0F, 0.0F, 0.0F, 0.17F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(SirenHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart neck = this.root.getChild("body").getChild("neck"); Anims.look(neck, netHeadYaw, headPitch);
        ModelPart head = this.root.getChild("body").getChild("neck").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart arm_l_low = this.root.getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 6.28F);
        ModelPart arm_r = this.root.getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 7.85F);
        ModelPart arm_r_low = this.root.getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 9.42F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
    }
}
