package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.ChestMimicEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ChestMimicModel extends RMobModel<ChestMimicEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/chest_mimic.png");
    public static final float SCALE = 0.68F;
    public static final float SHADOW = 0.60F;

    public ChestMimicModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -3.0F, -5.0F, 14.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-7.0F, -3.0F, -5.0F, 14.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 0).addBox(-8.0F, -2.0F, -6.0F, 16.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(307, 0).addBox(-7.0F, -3.0F, -5.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 0).addBox(5.0F, -3.0F, -5.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 0).addBox(-1.0F, -4.0F, -6.0F, 3.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 0).addBox(-6.0F, 3.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 0).addBox(-3.0F, 3.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 0).addBox(0.0F, 3.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 0).addBox(3.0F, 3.0F, -6.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.94F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 37).addBox(-8.0F, -2.0F, -6.0F, 16.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 37).addBox(-6.0F, -2.0F, -5.0F, 12.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 37).addBox(-7.0F, -2.0F, -5.0F, 2.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 37).addBox(5.0F, -2.0F, -5.0F, 2.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.40F, 2.0F));
        PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create()
                .texOffs(300, 37).addBox(-6.0F, 0.0F, -3.0F, 12.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 37).addBox(-5.0F, -1.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 37).addBox(-3.0F, -1.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 37).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 37).addBox(1.0F, -1.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 37).addBox(3.0F, -1.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 37).addBox(-5.0F, 2.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 37).addBox(-3.0F, 2.0F, -3.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 37).addBox(0.0F, 1.0F, -3.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 37).addBox(3.0F, 3.0F, -3.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 70).addBox(-3.0F, 3.0F, -4.0F, 6.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -0.80F, -6.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(37, 70).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(54, 70).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 11.34F, -3.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(87, 70).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(96, 70).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 70).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(146, 70).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(163, 70).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 70).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 11.34F, -3.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(213, 70).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 70).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(255, 70).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 70).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.06F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(289, 70).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 70).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 11.34F, 3.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(339, 70).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 70).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 70).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 70).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(415, 70).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 70).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 11.34F, 3.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(465, 70).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(474, 70).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 86).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 86).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.06F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(ChestMimicEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.jaw(head, ageInTicks, 0.18F);
        ModelPart jaw = this.root.getChild("body").getChild("jaw"); Anims.jaw(jaw, ageInTicks, 0.18F);
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
