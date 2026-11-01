package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TripodEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TripodModel extends RMobModel<TripodEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tripod.png");
    public static final float SCALE = 0.93F;
    public static final float SHADOW = 2.20F;

    public TripodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -10.0F, -11.0F, 22.0F, 19.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 0).addBox(-9.0F, 5.0F, -9.0F, 18.0F, 8.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 0).addBox(-8.0F, 11.0F, -7.0F, 16.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 83).addBox(-13.0F, 1.0F, -7.0F, 26.0F, 4.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(161, 83).addBox(-12.0F, -3.0F, -5.0F, 24.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 83).addBox(-13.0F, -8.0F, -6.0F, 4.0F, 11.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 83).addBox(9.0F, -8.0F, -6.0F, 4.0F, 11.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(428, 83).addBox(-9.0F, -2.0F, -9.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 83).addBox(-6.0F, -2.0F, -10.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(466, 83).addBox(-3.0F, -3.0F, -10.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(487, 83).addBox(0.0F, -3.0F, -10.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 130).addBox(3.0F, -2.0F, -10.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 130).addBox(6.0F, -2.0F, -9.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(38, 130).addBox(-10.0F, -3.0F, -10.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(55, 130).addBox(-5.0F, -3.0F, -10.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(72, 130).addBox(0.0F, -3.0F, -10.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 130).addBox(5.0F, -3.0F, -10.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 130).addBox(-13.0F, 1.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 130).addBox(-11.27F, 3.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 130).addBox(-11.27F, 6.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 130).addBox(-13.0F, 8.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 130).addBox(-3.0F, 1.0F, -12.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 130).addBox(-4.0F, -2.0F, -12.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -44.41F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(244, 130).addBox(-8.0F, -13.0F, -9.0F, 16.0F, 16.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 130).addBox(-9.0F, -5.0F, -7.0F, 18.0F, 8.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 197).addBox(-5.0F, -8.0F, -12.0F, 10.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(53, 197).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 197).addBox(-9.0F, -12.0F, -6.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(127, 197).addBox(7.0F, -12.0F, -6.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 197).addBox(-4.0F, -20.0F, 2.0F, 8.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 197).addBox(-1.0F, -22.0F, 3.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 197).addBox(4.0F, -20.0F, -7.0F, 1.0F, 16.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 197).addBox(-5.0F, -20.0F, -7.0F, 1.0F, 16.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 197).addBox(-4.0F, 9.0F, -12.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 197).addBox(-2.0F, 9.0F, -12.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 197).addBox(0.0F, 9.0F, -12.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(307, 197).addBox(2.0F, 9.0F, -12.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -19.20F, 0.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(320, 197).addBox(-4.0F, -5.0F, -1.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(361, 197).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -7.20F, -13.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(382, 197).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 4.36F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 197).addBox(-4.0F, 3.27F, -4.0F, 7.0F, 13.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 239).addBox(-3.0F, 15.82F, -3.0F, 5.0F, 8.18F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 239).addBox(-4.0F, 20.27F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, -34.01F, 8.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition leg_a_low = leg_a.addOrReplaceChild("leg_a_low", CubeListBuilder.create()
                .texOffs(106, 239).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 12.41F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 239).addBox(-3.0F, 11.03F, -3.0F, 5.0F, 11.03F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 239).addBox(-3.0F, 20.58F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 239).addBox(-2.0F, 24.58F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 239).addBox(-3.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 239).addBox(1.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.85F, 27.0F, 0.0F, 0.0F, 0.0F, -0.03F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(336, 239).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 4.36F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(409, 239).addBox(-4.0F, 3.27F, -4.0F, 7.0F, 13.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(466, 239).addBox(-3.0F, 15.82F, -3.0F, 5.0F, 8.18F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 281).addBox(-4.0F, 20.27F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, -34.01F, 8.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition leg_b_low = leg_b.addOrReplaceChild("leg_b_low", CubeListBuilder.create()
                .texOffs(65, 281).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 12.41F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 281).addBox(-3.0F, 11.03F, -3.0F, 5.0F, 11.03F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 281).addBox(-3.0F, 20.58F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 281).addBox(-2.0F, 24.58F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 281).addBox(-3.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 281).addBox(1.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.85F, 27.0F, 0.0F, 0.0F, 0.0F, 0.03F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(295, 281).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 4.36F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(368, 281).addBox(-4.0F, 3.27F, -4.0F, 7.0F, 13.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 281).addBox(-3.0F, 15.82F, -3.0F, 5.0F, 8.18F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 323).addBox(-4.0F, 20.27F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -34.01F, -10.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition leg_c_low = leg_c.addOrReplaceChild("leg_c_low", CubeListBuilder.create()
                .texOffs(65, 323).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 12.41F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 323).addBox(-3.0F, 11.03F, -3.0F, 5.0F, 11.03F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 323).addBox(-3.0F, 20.58F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 323).addBox(-2.0F, 24.58F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 323).addBox(-3.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 323).addBox(1.0F, 27.58F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.85F, 27.0F, 0.0F, 0.0F, 0.0F, 0.03F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(295, 323).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 323).addBox(-3.0F, 11.0F, -3.0F, 5.0F, 11.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 323).addBox(-3.0F, 14.0F, -4.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(418, 323).addBox(-3.0F, 11.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(431, 323).addBox(-1.0F, 10.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 323).addBox(1.0F, 11.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-13.0F, 7.20F, -2.0F, 0.0F, 0.0F, 0.10F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(461, 323).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 363).addBox(-2.0F, 11.0F, -3.0F, 5.0F, 11.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 363).addBox(-3.0F, 14.0F, -4.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 363).addBox(-3.0F, 11.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 363).addBox(-1.0F, 10.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(120, 363).addBox(1.0F, 11.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(13.0F, 7.20F, -2.0F, 0.0F, 0.0F, -0.10F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("body").getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
        ModelPart leg_a = this.root.getChild("leg_a"); Anims.swing(leg_a, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_a_low = this.root.getChild("leg_a").getChild("leg_a_low"); Anims.swing(leg_a_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_b_low = this.root.getChild("leg_b").getChild("leg_b_low"); Anims.swing(leg_b_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_c = this.root.getChild("leg_c"); Anims.swing(leg_c, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_c_low = this.root.getChild("leg_c").getChild("leg_c_low"); Anims.swing(leg_c_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 14.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 15.71F);
    }
}
