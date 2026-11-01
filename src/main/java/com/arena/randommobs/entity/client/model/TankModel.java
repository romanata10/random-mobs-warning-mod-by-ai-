package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TankEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TankModel extends RMobModel<TankEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tank.png");
    public static final float SCALE = 0.95F;
    public static final float SHADOW = 1.60F;

    public TankModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -4.0F, -10.0F, 22.0F, 10.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 0).addBox(-15.0F, -4.0F, -10.0F, 4.0F, 10.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 0).addBox(11.0F, -4.0F, -10.0F, 4.0F, 10.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 0).addBox(-11.0F, -4.0F, -14.0F, 22.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 61).addBox(-11.0F, -4.0F, 10.0F, 22.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 61).addBox(-10.0F, 4.0F, -10.0F, 20.0F, 7.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 61).addBox(-13.0F, 4.0F, -10.0F, 3.0F, 7.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 61).addBox(10.0F, 4.0F, -10.0F, 3.0F, 7.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 116).addBox(-10.0F, 4.0F, -13.0F, 20.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 116).addBox(-10.0F, 4.0F, 10.0F, 20.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 116).addBox(-12.0F, 1.0F, -15.0F, 24.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 116).addBox(-13.0F, 1.0F, -15.0F, 1.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 116).addBox(12.0F, 1.0F, -15.0F, 1.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 116).addBox(-12.0F, 1.0F, -16.0F, 24.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 137).addBox(-12.0F, 1.0F, -12.0F, 24.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 137).addBox(-17.0F, 10.0F, -13.0F, 3.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 137).addBox(-19.0F, 10.0F, -13.0F, 2.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 137).addBox(-14.0F, 10.0F, -13.0F, 2.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 137).addBox(-17.0F, 10.0F, -15.0F, 3.0F, 13.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 137).addBox(-17.0F, 10.0F, 13.0F, 3.0F, 13.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 216).addBox(14.0F, 10.0F, -13.0F, 3.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 216).addBox(12.0F, 10.0F, -13.0F, 2.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(230, 216).addBox(17.0F, 10.0F, -13.0F, 2.0F, 13.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 216).addBox(14.0F, 10.0F, -15.0F, 3.0F, 13.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 216).addBox(14.0F, 10.0F, 13.0F, 3.0F, 13.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 216).addBox(-18.0F, 15.0F, -12.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 216).addBox(-18.0F, 15.0F, -4.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(467, 216).addBox(-18.0F, 15.0F, 4.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 295).addBox(-18.0F, 15.0F, 12.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 295).addBox(18.0F, 15.0F, -12.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 295).addBox(18.0F, 15.0F, -4.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 295).addBox(18.0F, 15.0F, 4.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 295).addBox(18.0F, 15.0F, 12.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 295).addBox(-10.0F, -6.0F, 10.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(230, 295).addBox(-12.0F, -6.0F, 10.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 295).addBox(-6.0F, -6.0F, 10.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 295).addBox(-10.0F, -6.0F, 8.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 295).addBox(-10.0F, -6.0F, 12.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 295).addBox(16.0F, -2.0F, 10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 295).addBox(17.0F, 0.0F, 10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 295).addBox(16.0F, 3.0F, 10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 295).addBox(-2.0F, -8.0F, 5.0F, 4.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 295).addBox(-3.0F, -8.0F, 5.0F, 1.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 295).addBox(2.0F, -8.0F, 5.0F, 1.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(440, 295).addBox(-2.0F, -8.0F, 4.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(461, 295).addBox(-2.0F, -8.0F, 9.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(482, 295).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(499, 295).addBox(-2.0F, -6.0F, 6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 318).addBox(1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(13, 318).addBox(-1.0F, -6.0F, 5.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(26, 318).addBox(-1.0F, -6.0F, 8.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(39, 318).addBox(8.0F, -9.0F, 9.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(56, 318).addBox(8.0F, -13.0F, 9.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(73, 318).addBox(9.0F, -17.0F, 10.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(82, 318).addBox(-5.0F, -6.0F, -4.0F, 10.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 318).addBox(-9.0F, -6.0F, -4.0F, 4.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 318).addBox(5.0F, -6.0F, -4.0F, 4.0F, 9.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 318).addBox(-5.0F, -6.0F, -8.0F, 10.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 318).addBox(-5.0F, -6.0F, 4.0F, 10.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 318).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 318).addBox(-7.0F, -8.0F, -3.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(461, 318).addBox(4.0F, -8.0F, -3.0F, 3.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 353).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 353).addBox(-4.0F, -8.0F, 3.0F, 8.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 353).addBox(-2.0F, -3.0F, -24.0F, 4.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 353).addBox(-3.0F, -5.0F, -25.0F, 6.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 353).addBox(-3.0F, -2.0F, -12.0F, 6.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.60F, 1.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TankEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
    }
}
