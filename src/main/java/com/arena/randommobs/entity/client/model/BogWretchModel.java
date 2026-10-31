package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BogWretchEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BogWretchModel extends RMobModel<BogWretchEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bog_wretch.png");
    public static final float SCALE = 0.80F;
    public static final float SHADOW = 0.90F;

    public BogWretchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -8.0F, -4.0F, 14.0F, 20.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 0).addBox(-8.0F, 8.0F, -5.0F, 16.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 0).addBox(-5.0F, -11.0F, -3.0F, 10.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -3.48F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(271, 0).addBox(-6.0F, -6.0F, -5.0F, 12.0F, 11.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 0).addBox(-4.0F, 3.0F, -6.0F, 8.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.40F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(405, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(438, 0).addBox(-2.0F, 12.0F, -2.0F, 5.0F, 14.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 59).addBox(-3.0F, 24.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -5.60F, 0.0F, 0.14F, 0.0F, 0.10F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(49, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 59).addBox(-2.0F, 12.0F, -2.0F, 5.0F, 14.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 59).addBox(-3.0F, 24.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -5.60F, 0.0F, 0.14F, 0.0F, -0.10F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(172, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.26F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 59).addBox(-3.0F, 2.32F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 4.52F, 0.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(254, 59).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 6.88F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 59).addBox(-2.0F, 4.88F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 59).addBox(-3.0F, 6.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 59).addBox(1.0F, 6.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.26F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(346, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.26F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 59).addBox(-3.0F, 2.32F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 4.52F, 0.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(428, 59).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 6.88F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 59).addBox(-2.0F, 4.88F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(486, 59).addBox(-3.0F, 6.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 98).addBox(1.0F, 6.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.26F, 0.0F, 0.0F, 0.0F, -0.02F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(BogWretchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
    }
}
