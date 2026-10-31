package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.LanternWraithEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LanternWraithModel extends RMobModel<LanternWraithEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/lantern_wraith.png");
    public static final float SCALE = 0.97F;
    public static final float SHADOW = 0.70F;

    public LanternWraithModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -11.0F, -5.0F, 14.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-8.0F, -1.0F, -6.0F, 16.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 0).addBox(-6.0F, 6.0F, -5.0F, 12.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(299, 0).addBox(-7.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 0).addBox(-5.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 0).addBox(-3.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 0).addBox(0.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 0).addBox(2.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 0).addBox(-6.0F, 3.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 0).addBox(-4.0F, 3.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(418, 0).addBox(-1.0F, 3.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 0).addBox(2.0F, 3.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 49).addBox(-8.0F, -1.0F, -6.0F, 16.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 49).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(138, 49).addBox(-7.0F, -6.0F, -7.0F, 14.0F, 9.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 49).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 49).addBox(-6.0F, -2.0F, -8.0F, 12.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 49).addBox(-4.0F, -4.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 49).addBox(2.0F, -4.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.92F, 0.0F));
        PartDefinition orb = body.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(419, 49).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 96).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 96).addBox(-5.0F, -8.0F, -2.0F, 10.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 96).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 96).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.40F, -8.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(140, 96).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 96).addBox(-2.0F, 8.0F, -3.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 96).addBox(-3.0F, 9.0F, -4.0F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(227, 96).addBox(-3.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 96).addBox(-2.0F, 1.0F, -5.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 96).addBox(-1.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, -7.20F, 0.0F, 0.0F, 0.0F, 0.16F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(258, 96).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 96).addBox(-1.0F, 8.0F, -3.0F, 3.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 96).addBox(-1.0F, 9.0F, -4.0F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 96).addBox(-1.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 96).addBox(0.0F, 1.0F, -5.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 96).addBox(1.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, -7.20F, 0.0F, 0.0F, 0.0F, -0.16F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(LanternWraithEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart orb = this.root.getChild("body").getChild("orb"); Anims.pulse(orb, ageInTicks, 0.06F);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 6.28F);
    }
}
