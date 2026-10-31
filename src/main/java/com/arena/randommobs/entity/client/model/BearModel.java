package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BearEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BearModel extends RMobModel<BearEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bear.png");
    public static final float SCALE = 0.84F;
    public static final float SHADOW = 1.0F;

    public BearModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-9.0F, -6.0F, -14.0F, 18.0F, 16.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 0).addBox(-10.0F, -3.0F, -12.0F, 20.0F, 9.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(362, 0).addBox(-7.0F, 2.0F, 8.0F, 14.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 89).addBox(-7.0F, -11.0F, -9.0F, 14.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 89).addBox(-8.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 89).addBox(-5.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 89).addBox(-2.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 89).addBox(2.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 89).addBox(5.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 89).addBox(9.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(211, 89).addBox(12.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 89).addBox(-6.0F, 7.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 89).addBox(-2.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 89).addBox(2.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(299, 89).addBox(6.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(324, 89).addBox(10.0F, 7.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 89).addBox(-2.0F, -1.0F, 14.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.85F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(374, 89).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 13.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 142).addBox(-3.0F, -1.0F, -10.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 142).addBox(-2.0F, 0.0F, -11.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 142).addBox(-9.0F, -5.0F, -3.0F, 4.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 142).addBox(5.0F, -5.0F, -3.0F, 4.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 142).addBox(-8.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 142).addBox(5.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 142).addBox(-2.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 142).addBox(-1.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(216, 142).addBox(0.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 142).addBox(-5.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 142).addBox(3.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.80F, -15.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(255, 142).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 9.41F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 142).addBox(-4.0F, 2.35F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 3.25F, -9.0F, 0.0F, 0.0F, 0.30F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(353, 142).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.89F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(386, 142).addBox(-2.0F, 5.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 142).addBox(-3.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(436, 142).addBox(1.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.41F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(453, 142).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 9.41F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 172).addBox(-4.0F, 2.35F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 3.25F, -9.0F, 0.0F, 0.0F, -0.30F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(57, 172).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.89F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 172).addBox(-2.0F, 5.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 172).addBox(-3.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 172).addBox(1.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.41F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(157, 172).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 9.41F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 172).addBox(-4.0F, 2.35F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 3.25F, 9.0F, 0.0F, 0.0F, 0.30F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(255, 172).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.89F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(288, 172).addBox(-2.0F, 5.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 172).addBox(-3.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 172).addBox(1.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.41F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(355, 172).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 9.41F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(396, 172).addBox(-4.0F, 2.35F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 3.25F, 9.0F, 0.0F, 0.0F, -0.30F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(453, 172).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.89F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 202).addBox(-2.0F, 5.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 202).addBox(-3.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 202).addBox(1.0F, 7.89F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.41F, 0.0F, 0.0F, 0.0F, 0.01F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
    }
}
