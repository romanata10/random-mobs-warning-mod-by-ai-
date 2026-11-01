package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.LightsEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LightsModel extends RMobModel<LightsEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/lights.png");
    public static final float SCALE = 1.03F;
    public static final float SHADOW = 0.50F;

    public LightsModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 7.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 0).addBox(-7.0F, -5.0F, -3.0F, 3.0F, 7.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(94, 0).addBox(4.0F, -5.0F, -3.0F, 3.0F, 7.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 0).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 0).addBox(-4.0F, -5.0F, 3.0F, 8.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 0).addBox(-3.0F, 1.0F, -2.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 0).addBox(-6.0F, 1.0F, -2.0F, 3.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 0).addBox(3.0F, 1.0F, -2.0F, 3.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 0).addBox(-3.0F, 1.0F, -5.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(357, 0).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 0).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 0).addBox(-4.0F, 4.0F, -2.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 0).addBox(2.0F, 4.0F, -2.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 0).addBox(-2.0F, 4.0F, -4.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 27).addBox(-2.0F, 4.0F, 2.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 27).addBox(-5.0F, -1.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(38, 27).addBox(-3.0F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(55, 27).addBox(0.0F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(72, 27).addBox(2.0F, -1.0F, -4.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(85, 27).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 27).addBox(-5.0F, -4.0F, -3.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 27).addBox(3.0F, -4.0F, -3.0F, 2.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 27).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 27).addBox(-3.0F, -4.0F, 1.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -3.52F, -2.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(242, 27).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(271, 27).addBox(-4.0F, -4.0F, -1.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(280, 27).addBox(3.0F, -4.0F, -1.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 27).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 27).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 27).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 3.0F, -1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(352, 27).addBox(-2.0F, -3.0F, -2.0F, 1.0F, 3.0F, -1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 27).addBox(1.0F, -3.0F, -2.0F, 1.0F, 3.0F, -1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 27).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 27).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.32F, -4.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(382, 27).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 27).addBox(-2.0F, 0.22F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 27).addBox(-1.0F, 1.07F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(457, 27).addBox(-2.0F, -1.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 20.16F, -3.0F, 0.0F, 0.0F, 1.10F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(0, 46).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 46).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 46).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 0.84F, 0.0F, 0.0F, 0.0F, -0.68F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(43, 46).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 46).addBox(-2.0F, 0.22F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 46).addBox(-1.0F, 1.07F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 46).addBox(-2.0F, -1.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 20.16F, -3.0F, 0.0F, 0.0F, -1.10F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(151, 46).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 46).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 46).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 0.84F, 0.0F, 0.0F, 0.0F, 0.68F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(194, 46).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 46).addBox(-2.0F, 0.22F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(260, 46).addBox(-1.0F, 1.07F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(269, 46).addBox(-2.0F, -1.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 20.16F, 3.0F, 0.0F, 0.0F, 1.10F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(302, 46).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 46).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 46).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 0.84F, 0.0F, 0.0F, 0.0F, -0.68F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(345, 46).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(386, 46).addBox(-2.0F, 0.22F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 46).addBox(-1.0F, 1.07F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 46).addBox(-2.0F, -1.15F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 20.16F, 3.0F, 0.0F, 0.0F, -1.10F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(453, 46).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(478, 46).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(487, 46).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 0.84F, 0.0F, 0.0F, 0.0F, 0.68F));
        return LayerDefinition.create(mesh, 512, 64);
    }

    @Override
    public void setupAnim(LightsEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("body").getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
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
