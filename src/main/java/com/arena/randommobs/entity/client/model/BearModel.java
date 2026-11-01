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
    public static final float SCALE = 0.99F;
    public static final float SHADOW = 1.0F;

    public BearModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-10.0F, -6.0F, -14.0F, 20.0F, 15.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 0).addBox(-9.0F, 1.0F, -13.0F, 18.0F, 7.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 0).addBox(-7.0F, 5.0F, 8.0F, 14.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 87).addBox(-8.0F, -10.0F, -10.0F, 16.0F, 5.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 87).addBox(-9.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 87).addBox(-6.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(143, 87).addBox(-3.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(164, 87).addBox(1.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 87).addBox(4.0F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 87).addBox(8.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 87).addBox(11.0F, -2.0F, -12.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(240, 87).addBox(-7.0F, 7.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(261, 87).addBox(-3.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 87).addBox(1.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 87).addBox(5.0F, 6.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 87).addBox(9.0F, 7.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(357, 87).addBox(-2.0F, -1.0F, 14.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 5.02F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(386, 87).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 12.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 138).addBox(-3.0F, -1.0F, -10.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 138).addBox(-2.0F, 0.0F, -11.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 138).addBox(-9.0F, -5.0F, -3.0F, 4.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 138).addBox(5.0F, -5.0F, -3.0F, 4.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 138).addBox(-8.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 138).addBox(5.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 138).addBox(-2.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 138).addBox(-1.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(216, 138).addBox(0.0F, 4.0F, -11.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 138).addBox(-5.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 138).addBox(3.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.80F, -15.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(255, 138).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 138).addBox(-3.0F, 0.92F, -3.0F, 5.0F, 3.85F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 138).addBox(-2.0F, 4.47F, -2.0F, 3.0F, 2.31F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 138).addBox(-3.0F, 2.71F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 7.42F, -9.0F, 0.0F, 0.0F, 0.36F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(427, 138).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.72F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 138).addBox(-2.0F, 2.41F, -2.0F, 3.0F, 2.41F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 161).addBox(-2.0F, 1.04F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 161).addBox(-2.0F, 3.04F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 161).addBox(-3.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 161).addBox(1.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 7.20F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(116, 161).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 161).addBox(-3.0F, 0.92F, -3.0F, 5.0F, 3.85F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 161).addBox(-2.0F, 4.47F, -2.0F, 3.0F, 2.31F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 161).addBox(-3.0F, 2.71F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 7.42F, -9.0F, 0.0F, 0.0F, -0.36F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(288, 161).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.72F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 161).addBox(-2.0F, 2.41F, -2.0F, 3.0F, 2.41F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 161).addBox(-2.0F, 1.04F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 161).addBox(-2.0F, 3.04F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 161).addBox(-3.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(445, 161).addBox(1.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 7.20F, 0.0F, 0.0F, 0.0F, -0.02F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(0, 184).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 184).addBox(-3.0F, 0.92F, -3.0F, 5.0F, 3.85F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 184).addBox(-2.0F, 4.47F, -2.0F, 3.0F, 2.31F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 184).addBox(-3.0F, 2.71F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 7.42F, 9.0F, 0.0F, 0.0F, 0.36F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(172, 184).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.72F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 184).addBox(-2.0F, 2.41F, -2.0F, 3.0F, 2.41F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 184).addBox(-2.0F, 1.04F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 184).addBox(-2.0F, 3.04F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 184).addBox(-3.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 184).addBox(1.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 7.20F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(354, 184).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 184).addBox(-3.0F, 0.92F, -3.0F, 5.0F, 3.85F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 184).addBox(-2.0F, 4.47F, -2.0F, 3.0F, 2.31F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 207).addBox(-3.0F, 2.71F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 7.42F, 9.0F, 0.0F, 0.0F, -0.36F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(49, 207).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.72F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 207).addBox(-2.0F, 2.41F, -2.0F, 3.0F, 2.41F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 207).addBox(-2.0F, 1.04F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 207).addBox(-2.0F, 3.04F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 207).addBox(-3.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 207).addBox(1.0F, 6.04F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 7.20F, 0.0F, 0.0F, 0.0F, -0.02F));
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
