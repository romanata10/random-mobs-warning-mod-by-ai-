package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WarshipEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WarshipModel extends RMobModel<WarshipEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/warship.png");
    public static final float SCALE = 1.02F;
    public static final float SHADOW = 3.0F;

    public WarshipModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-14.0F, -2.0F, -42.0F, 28.0F, 15.0F, 84.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 199).addBox(-10.0F, 7.0F, -38.0F, 20.0F, 10.0F, 76.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(385, 199).addBox(-8.0F, -2.0F, -50.0F, 16.0F, 15.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 372).addBox(-3.0F, -2.0F, -56.0F, 6.0F, 15.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 372).addBox(-11.0F, -2.0F, 42.0F, 22.0F, 14.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 419).addBox(-12.0F, -4.0F, -40.0F, 24.0F, 2.0F, 80.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 419).addBox(-7.0F, -4.0F, -48.0F, 14.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 584).addBox(-12.0F, -2.0F, -38.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 584).addBox(-12.0F, -3.0F, -33.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 584).addBox(-12.0F, -3.0F, -27.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 584).addBox(-13.0F, -3.0F, -21.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(104, 584).addBox(-13.0F, -3.0F, -15.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 584).addBox(-13.0F, -4.0F, -9.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 584).addBox(-13.0F, -4.0F, -3.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(191, 584).addBox(-13.0F, -4.0F, 2.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 584).addBox(-13.0F, -3.0F, 8.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 584).addBox(-13.0F, -3.0F, 14.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 584).addBox(-12.0F, -3.0F, 20.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 584).addBox(-12.0F, -3.0F, 26.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 584).addBox(-12.0F, -2.0F, 32.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 584).addBox(11.0F, -2.0F, -38.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 584).addBox(11.0F, -3.0F, -33.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(403, 584).addBox(11.0F, -3.0F, -27.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(428, 584).addBox(10.0F, -3.0F, -21.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(457, 584).addBox(10.0F, -3.0F, -15.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 603).addBox(10.0F, -4.0F, -9.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(29, 603).addBox(10.0F, -4.0F, -3.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 603).addBox(10.0F, -4.0F, 2.0F, 2.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(87, 603).addBox(10.0F, -3.0F, 8.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 603).addBox(10.0F, -3.0F, 14.0F, 2.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 603).addBox(11.0F, -3.0F, 20.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 603).addBox(11.0F, -3.0F, 26.0F, 1.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 603).addBox(11.0F, -2.0F, 32.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 622).addBox(-13.0F, -7.0F, -40.0F, 2.0F, 2.0F, 80.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 787).addBox(11.0F, -7.0F, -40.0F, 2.0F, 2.0F, 80.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 787).addBox(-13.0F, 2.0F, -24.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(346, 787).addBox(-13.0F, 2.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 787).addBox(-13.0F, 2.0F, 4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 787).addBox(-13.0F, 2.0F, 18.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 787).addBox(-13.0F, 2.0F, 32.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 787).addBox(11.0F, 2.0F, -24.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(431, 787).addBox(11.0F, 2.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 787).addBox(11.0F, 2.0F, 4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 787).addBox(11.0F, 2.0F, 18.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(482, 787).addBox(11.0F, 2.0F, 32.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.80F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 952).addBox(-9.0F, -5.0F, -8.0F, 18.0F, 14.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 952).addBox(-10.0F, -8.0F, -9.0F, 20.0F, 3.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 952).addBox(-6.0F, -14.0F, -5.0F, 12.0F, 10.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1017).addBox(-7.0F, -16.0F, -6.0F, 14.0F, 3.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 1017).addBox(-3.0F, -29.0F, 6.0F, 6.0F, 16.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 1017).addBox(-4.0F, -31.0F, 5.0F, 8.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 1017).addBox(-3.0F, -24.0F, 16.0F, 5.0F, 11.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 1017).addBox(-1.0F, -56.0F, -2.0F, 2.0F, 42.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 1017).addBox(-4.0F, -48.0F, -3.0F, 8.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(342, 1017).addBox(-6.0F, -38.0F, -1.0F, 12.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 1017).addBox(-2.0F, -59.0F, -1.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(428, 1017).addBox(-9.0F, -4.0F, -5.0F, 5.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(457, 1017).addBox(-4.0F, -5.0F, -5.0F, 5.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1106).addBox(1.0F, -4.0F, -5.0F, 5.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.0F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(29, 1106).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 13.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 1106).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 1106).addBox(-4.0F, -2.0F, -18.0F, 2.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 1106).addBox(2.0F, -2.0F, -18.0F, 2.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 1106).addBox(-5.0F, -10.0F, -4.0F, 2.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -11.20F, -26.0F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(338, 1106).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 11.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 1106).addBox(-4.0F, -1.0F, -16.0F, 2.0F, 3.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1157).addBox(2.0F, -1.0F, -16.0F, 2.0F, 3.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -11.20F, 26.0F));
        return LayerDefinition.create(mesh, 512, 2048);
    }

    @Override
    public void setupAnim(WarshipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
    }
}
