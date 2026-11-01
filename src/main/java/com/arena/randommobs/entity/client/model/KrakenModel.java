package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.KrakenEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class KrakenModel extends RMobModel<KrakenEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/kraken.png");
    public static final float SCALE = 1.19F;
    public static final float SHADOW = 2.60F;

    public KrakenModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-10.0F, -14.0F, -7.0F, 3.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 0).addBox(7.0F, -14.0F, -7.0F, 3.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 0).addBox(-7.0F, -14.0F, -10.0F, 14.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 0).addBox(-7.0F, -14.0F, 7.0F, 14.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 41).addBox(-8.0F, -8.0F, -6.0F, 2.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 41).addBox(6.0F, -8.0F, -6.0F, 2.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 41).addBox(-6.0F, -8.0F, -8.0F, 12.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 41).addBox(-6.0F, -8.0F, 6.0F, 12.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 41).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 41).addBox(-6.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(334, 41).addBox(4.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 41).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 41).addBox(-4.0F, -2.0F, 4.0F, 8.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 78).addBox(-5.0F, 7.0F, -5.0F, 10.0F, 9.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 78).addBox(-10.0F, 7.0F, -5.0F, 5.0F, 9.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 78).addBox(5.0F, 7.0F, -5.0F, 5.0F, 9.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 78).addBox(-5.0F, 7.0F, -10.0F, 10.0F, 9.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 78).addBox(-5.0F, 7.0F, 5.0F, 10.0F, 9.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(325, 78).addBox(-4.0F, 14.0F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 78).addBox(-8.0F, 14.0F, -4.0F, 4.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(439, 78).addBox(4.0F, 14.0F, -4.0F, 4.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 117).addBox(-4.0F, 14.0F, -8.0F, 8.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 117).addBox(-4.0F, 14.0F, 4.0F, 8.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 117).addBox(-7.0F, 12.0F, -8.0F, 14.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 117).addBox(-9.0F, 12.0F, -8.0F, 2.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 117).addBox(7.0F, 12.0F, -8.0F, 2.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 117).addBox(-7.0F, 12.0F, -10.0F, 14.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 117).addBox(-7.0F, 12.0F, -4.0F, 14.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(351, 117).addBox(-7.0F, 16.0F, -12.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 117).addBox(3.0F, 16.0F, -12.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(409, 117).addBox(-1.0F, 22.0F, -11.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 117).addBox(-3.0F, 22.0F, -11.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 117).addBox(1.0F, 22.0F, -11.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 117).addBox(-1.0F, 22.0F, -13.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 117).addBox(-1.0F, 22.0F, -9.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 142).addBox(-2.0F, 19.0F, -16.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 142).addBox(-2.0F, 17.0F, -16.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 142).addBox(-1.0F, 16.0F, -15.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -18.35F, 0.0F));
        PartDefinition t_l0 = body.addOrReplaceChild("t_l0", CubeListBuilder.create()
                .texOffs(99, 142).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 142).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 142).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(246, 142).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 142).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 142).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 13.60F, -8.0F, 0.14F, 0.0F, -0.45F));
        PartDefinition t_l1 = body.addOrReplaceChild("t_l1", CubeListBuilder.create()
                .texOffs(329, 142).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(386, 142).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 142).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 142).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 169).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 169).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 13.60F, -3.0F, 0.14F, 0.0F, -0.45F));
        PartDefinition t_l2 = body.addOrReplaceChild("t_l2", CubeListBuilder.create()
                .texOffs(50, 169).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 169).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 169).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 169).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(230, 169).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(255, 169).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 13.60F, 2.0F, 0.14F, 0.0F, -0.45F));
        PartDefinition t_l3 = body.addOrReplaceChild("t_l3", CubeListBuilder.create()
                .texOffs(280, 169).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 169).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(386, 169).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 169).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 169).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(485, 169).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 13.60F, 7.0F, 0.14F, 0.0F, -0.45F));
        PartDefinition t_r0 = body.addOrReplaceChild("t_r0", CubeListBuilder.create()
                .texOffs(0, 196).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 196).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 196).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 196).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 196).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 196).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 13.60F, -8.0F, 0.14F, 0.0F, 0.45F));
        PartDefinition t_r1 = body.addOrReplaceChild("t_r1", CubeListBuilder.create()
                .texOffs(230, 196).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 196).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 196).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 196).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 196).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 196).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 13.60F, -3.0F, 0.14F, 0.0F, 0.45F));
        PartDefinition t_r2 = body.addOrReplaceChild("t_r2", CubeListBuilder.create()
                .texOffs(0, 223).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 223).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 223).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 223).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 223).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 223).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 13.60F, 2.0F, 0.14F, 0.0F, 0.45F));
        PartDefinition t_r3 = body.addOrReplaceChild("t_r3", CubeListBuilder.create()
                .texOffs(230, 223).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 6.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 223).addBox(-3.0F, 5.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 223).addBox(-2.0F, 10.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 223).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 223).addBox(-1.0F, 20.0F, -1.0F, 3.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 223).addBox(-1.0F, 25.0F, -1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 13.60F, 7.0F, 0.14F, 0.0F, 0.45F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(KrakenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart t_l0 = this.root.getChild("body").getChild("t_l0"); Anims.swayOne(t_l0, ageInTicks, 0.09F, 1.57F);
        ModelPart t_l1 = this.root.getChild("body").getChild("t_l1"); Anims.swayOne(t_l1, ageInTicks, 0.09F, 3.14F);
        ModelPart t_l2 = this.root.getChild("body").getChild("t_l2"); Anims.swayOne(t_l2, ageInTicks, 0.09F, 4.71F);
        ModelPart t_l3 = this.root.getChild("body").getChild("t_l3"); Anims.swayOne(t_l3, ageInTicks, 0.09F, 6.28F);
        ModelPart t_r0 = this.root.getChild("body").getChild("t_r0"); Anims.swayOne(t_r0, ageInTicks, 0.09F, 7.85F);
        ModelPart t_r1 = this.root.getChild("body").getChild("t_r1"); Anims.swayOne(t_r1, ageInTicks, 0.09F, 9.42F);
        ModelPart t_r2 = this.root.getChild("body").getChild("t_r2"); Anims.swayOne(t_r2, ageInTicks, 0.09F, 11.00F);
        ModelPart t_r3 = this.root.getChild("body").getChild("t_r3"); Anims.swayOne(t_r3, ageInTicks, 0.09F, 12.57F);
    }
}
