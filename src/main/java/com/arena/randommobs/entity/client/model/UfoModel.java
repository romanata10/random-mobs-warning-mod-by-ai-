package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.UfoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class UfoModel extends RMobModel<UfoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/ufo.png");
    public static final float SCALE = 0.89F;
    public static final float SHADOW = 1.40F;

    public UfoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-9.0F, -3.0F, -9.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 0).addBox(-18.0F, -3.0F, -9.0F, 9.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 0).addBox(9.0F, -3.0F, -9.0F, 9.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 0).addBox(-9.0F, -3.0F, -18.0F, 18.0F, 4.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 45).addBox(-9.0F, -3.0F, 9.0F, 18.0F, 4.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 45).addBox(-7.0F, 1.0F, -7.0F, 14.0F, 4.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 45).addBox(-15.0F, 1.0F, -7.0F, 8.0F, 4.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 45).addBox(7.0F, 1.0F, -7.0F, 8.0F, 4.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 45).addBox(-7.0F, 1.0F, -15.0F, 14.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 82).addBox(-7.0F, 1.0F, 7.0F, 14.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 82).addBox(-5.0F, 6.0F, -5.0F, 10.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 82).addBox(-10.0F, 6.0F, -5.0F, 5.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(231, 82).addBox(5.0F, 6.0F, -5.0F, 5.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(292, 82).addBox(-5.0F, 6.0F, -10.0F, 10.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 82).addBox(-5.0F, 6.0F, 5.0F, 10.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 82).addBox(-3.0F, 10.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(463, 82).addBox(-7.0F, 10.0F, -3.0F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 113).addBox(3.0F, 10.0F, -3.0F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 113).addBox(-3.0F, 10.0F, -7.0F, 6.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 113).addBox(-3.0F, 10.0F, 3.0F, 6.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 113).addBox(13.0F, 1.0F, -1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 113).addBox(12.0F, 1.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 113).addBox(6.0F, 1.0F, 12.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 113).addBox(-1.0F, 1.0F, 13.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 113).addBox(-8.0F, 1.0F, 12.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 113).addBox(-14.0F, 1.0F, 6.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 113).addBox(-15.0F, 1.0F, -1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 113).addBox(-14.0F, 1.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(323, 113).addBox(-8.0F, 1.0F, -14.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 113).addBox(-1.0F, 1.0F, -15.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 113).addBox(6.0F, 1.0F, -14.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 113).addBox(12.0F, 1.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.80F, 0.0F));
        PartDefinition dome = body.addOrReplaceChild("dome", CubeListBuilder.create()
                .texOffs(423, 113).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 138).addBox(-6.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 138).addBox(4.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 138).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 138).addBox(-4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 138).addBox(-3.0F, 1.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 138).addBox(-4.0F, 1.0F, -3.0F, 1.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 138).addBox(3.0F, 1.0F, -3.0F, 1.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 138).addBox(-3.0F, 1.0F, -4.0F, 6.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 138).addBox(-3.0F, 1.0F, 3.0F, 6.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 138).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(362, 138).addBox(-5.0F, 3.0F, -2.0F, 3.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 138).addBox(2.0F, 3.0F, -2.0F, 3.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 138).addBox(-2.0F, 3.0F, -5.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(449, 138).addBox(-2.0F, 3.0F, 2.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition head = dome.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(478, 138).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 163).addBox(-4.0F, -4.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 163).addBox(2.0F, -4.0F, -2.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 163).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 163).addBox(-2.0F, -4.0F, 2.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 163).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 163).addBox(-2.0F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(130, 163).addBox(1.0F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(143, 163).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 163).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 7.20F, -4.0F));
        PartDefinition struts = root.addOrReplaceChild("struts", CubeListBuilder.create()
                .texOffs(169, 163).addBox(10.0F, 21.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 163).addBox(10.0F, 18.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(211, 163).addBox(10.0F, 14.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 163).addBox(-1.0F, 21.0F, 10.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 163).addBox(-1.0F, 18.0F, 10.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 163).addBox(-1.0F, 14.0F, 10.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 163).addBox(-12.0F, 21.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 163).addBox(-12.0F, 18.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 163).addBox(-12.0F, 14.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(UfoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart dome = this.root.getChild("body").getChild("dome"); Anims.bob(dome, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("dome").getChild("head"); Anims.pulse(head, ageInTicks, 0.06F);
        ModelPart struts = this.root.getChild("struts"); Anims.bob(struts, ageInTicks, 0.45F);
    }
}
