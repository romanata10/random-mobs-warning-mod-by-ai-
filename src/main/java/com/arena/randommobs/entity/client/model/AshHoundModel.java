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
    public static final float SCALE = 0.74F;
    public static final float SHADOW = 0.90F;

    public AshHoundModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -5.0F, -9.0F, 10.0F, 10.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-6.0F, -2.0F, -8.0F, 12.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 0).addBox(-3.0F, -6.0F, 6.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.73F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(275, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 9.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 0).addBox(-3.0F, -1.0F, -9.0F, 6.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 0).addBox(-5.0F, -7.0F, -3.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 0).addBox(2.0F, -7.0F, -3.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.0F, -10.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(451, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 0).addBox(-1.0F, 8.0F, -1.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 1.60F, 8.0F, -0.61F, 0.0F, 0.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(0, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.51F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 57).addBox(-3.0F, 1.63F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 9.13F, -7.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(66, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 57).addBox(-2.0F, 2.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 57).addBox(-3.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 57).addBox(1.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 6.51F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(150, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.51F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(175, 57).addBox(-3.0F, 1.63F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 9.13F, -7.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(216, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 57).addBox(-2.0F, 2.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 57).addBox(-3.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 57).addBox(1.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 6.51F, 0.0F, 0.0F, 0.0F, -0.02F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(300, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.51F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(325, 57).addBox(-3.0F, 1.63F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 9.13F, 7.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(366, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(383, 57).addBox(-2.0F, 2.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 57).addBox(-3.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(433, 57).addBox(1.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 6.51F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(450, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.51F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 77).addBox(-3.0F, 1.63F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 9.13F, 7.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(41, 77).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.93F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 77).addBox(-2.0F, 2.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 77).addBox(-3.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 77).addBox(1.0F, 4.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 6.51F, 0.0F, 0.0F, 0.0F, -0.02F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(AshHoundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 3.14F);
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
