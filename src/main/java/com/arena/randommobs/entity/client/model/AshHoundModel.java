package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AshHoundEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class AshHoundModel extends RMobModel<AshHoundEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/ash_hound.png");
    public static final float SCALE = 0.68F;
    public static final float SHADOW = 0.70F;

    public AshHoundModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-3.0F, -5.0F, -7.0F, 6.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 0).addBox(-6.0F, -5.0F, -7.0F, 3.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(150, 0).addBox(3.0F, -5.0F, -7.0F, 3.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(219, 0).addBox(-3.0F, -5.0F, -10.0F, 6.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 0).addBox(-3.0F, -5.0F, 7.0F, 6.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 0).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 0).addBox(-5.0F, -1.0F, -6.0F, 3.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 0).addBox(2.0F, -1.0F, -6.0F, 3.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(480, 0).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 41).addBox(-2.0F, -1.0F, 6.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(29, 41).addBox(-1.0F, -8.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(46, 41).addBox(0.0F, -10.0F, -8.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(55, 41).addBox(-1.0F, -8.0F, -5.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(72, 41).addBox(0.0F, -10.0F, -4.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 41).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 41).addBox(0.0F, -10.0F, 0.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 41).addBox(-1.0F, -8.0F, 3.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(124, 41).addBox(0.0F, -10.0F, 4.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 41).addBox(-1.0F, -8.0F, 7.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(150, 41).addBox(0.0F, -10.0F, 8.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(159, 41).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 1.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 7.25F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create()
                .texOffs(200, 41).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 41).addBox(-4.0F, -4.0F, -1.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 41).addBox(2.0F, -4.0F, -1.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 41).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 41).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.88F, -9.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(333, 41).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 41).addBox(-4.0F, -4.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 41).addBox(2.0F, -4.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(392, 41).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 41).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 41).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 41).addBox(-2.0F, -2.0F, -5.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 41).addBox(0.0F, -2.0F, -5.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(501, 41).addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 60).addBox(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(9, 60).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 60).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(59, 60).addBox(1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 60).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 60).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 60).addBox(-1.0F, 1.0F, -7.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 60).addBox(-2.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 60).addBox(-1.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 60).addBox(0.0F, 1.0F, -7.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 60).addBox(-4.0F, -7.0F, -4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 60).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 60).addBox(1.0F, -7.0F, -4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 60).addBox(2.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -0.96F, -5.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(230, 60).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 60).addBox(-2.0F, 0.78F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 60).addBox(-1.0F, 3.78F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(305, 60).addBox(-2.0F, 3.51F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 9.17F, -7.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(338, 60).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.29F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 60).addBox(-1.0F, 2.03F, -1.0F, 1.0F, 2.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 60).addBox(-1.0F, 2.08F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 60).addBox(-2.0F, 2.08F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(422, 60).addBox(-3.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 60).addBox(1.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 6.30F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(472, 60).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 79).addBox(-2.0F, 0.78F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 79).addBox(-1.0F, 3.78F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 79).addBox(-2.0F, 3.51F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 9.17F, -7.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(67, 79).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.29F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 79).addBox(-1.0F, 2.03F, -1.0F, 1.0F, 2.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 79).addBox(-1.0F, 2.08F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 79).addBox(-2.0F, 2.08F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 79).addBox(-3.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 79).addBox(1.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 6.30F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(201, 79).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 79).addBox(-2.0F, 0.78F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(267, 79).addBox(-1.0F, 3.78F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(276, 79).addBox(-2.0F, 3.51F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 9.17F, 6.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(309, 79).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.29F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(334, 79).addBox(-1.0F, 2.03F, -1.0F, 1.0F, 2.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 79).addBox(-1.0F, 2.08F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(352, 79).addBox(-2.0F, 2.08F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 79).addBox(-3.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(418, 79).addBox(1.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 6.30F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(443, 79).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(484, 79).addBox(-2.0F, 0.78F, -2.0F, 3.0F, 3.26F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 98).addBox(-1.0F, 3.78F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(9, 98).addBox(-2.0F, 3.51F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 9.17F, 6.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(42, 98).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.29F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 98).addBox(-1.0F, 2.03F, -1.0F, 1.0F, 2.03F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(76, 98).addBox(-1.0F, 2.08F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(85, 98).addBox(-2.0F, 2.08F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 98).addBox(-3.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 98).addBox(1.0F, 5.08F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 6.30F, 0.0F, 0.0F, 0.0F, -0.01F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(AshHoundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart neck = this.root.getChild("body").getChild("neck"); Anims.look(neck, netHeadYaw, headPitch);
        ModelPart head = this.root.getChild("body").getChild("neck").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
    }
}
