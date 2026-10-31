package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WaterGrabberEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WaterGrabberModel extends RMobModel<WaterGrabberEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/water_grabber.png");
    public static final float SCALE = 0.47F;
    public static final float SHADOW = 1.60F;

    public WaterGrabberModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -8.0F, -16.0F, 32.0F, 14.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 0).addBox(-12.0F, 6.0F, -12.0F, 24.0F, 5.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -20.92F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 93).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(113, 93).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.52F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(146, 93).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 26.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, -0.42F, 0.0F, 0.35F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(171, 93).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.52F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(204, 93).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 26.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, -0.42F, 0.0F, -0.35F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(WaterGrabberEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.jaw(head, ageInTicks, 0.18F);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_l_low = this.root.getChild("body").getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 4.71F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 6.28F);
        ModelPart arm_r_low = this.root.getChild("body").getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 7.85F);
    }
}
