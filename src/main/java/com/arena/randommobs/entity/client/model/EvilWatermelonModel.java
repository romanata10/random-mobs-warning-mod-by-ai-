package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.EvilWatermelonEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class EvilWatermelonModel extends RMobModel<EvilWatermelonEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/evil_watermelon.png");
    public static final float SCALE = 0.77F;
    public static final float SHADOW = 0.60F;

    public EvilWatermelonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-6.0F, 3.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 0).addBox(-7.0F, -5.0F, -6.0F, 14.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(315, 0).addBox(-5.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 0).addBox(-3.0F, -3.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 0).addBox(0.0F, -3.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(362, 0).addBox(2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 0).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 12.23F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(392, 0).addBox(-6.0F, -5.0F, -1.0F, 12.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 0).addBox(-4.0F, -2.0F, -2.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(470, 0).addBox(1.0F, -2.0F, -2.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(487, 0).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(496, 0).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 45).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(9, 45).addBox(2.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.72F, -7.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(59, 45).addBox(-2.0F, 0.29F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 45).addBox(-1.0F, 1.42F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 45).addBox(-2.0F, -0.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 14.63F, -4.0F, 0.0F, 0.0F, 0.74F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(126, 45).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 45).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(160, 45).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 45).addBox(-2.0F, 0.29F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 45).addBox(-3.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 45).addBox(1.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 1.80F, 0.0F, 0.0F, 0.0F, -0.32F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(260, 45).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 45).addBox(-2.0F, 0.29F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 45).addBox(-1.0F, 1.42F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 45).addBox(-2.0F, -0.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 14.63F, -4.0F, 0.0F, 0.0F, -0.74F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(368, 45).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 45).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 45).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 45).addBox(-2.0F, 0.29F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 45).addBox(-3.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 45).addBox(1.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 1.80F, 0.0F, 0.0F, 0.0F, 0.32F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(0, 64).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 64).addBox(-2.0F, 0.29F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 64).addBox(-1.0F, 1.42F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 64).addBox(-2.0F, -0.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 14.63F, 4.0F, 0.0F, 0.0F, 0.74F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(108, 64).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 64).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 64).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 64).addBox(-2.0F, 0.29F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(192, 64).addBox(-3.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 64).addBox(1.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 1.80F, 0.0F, 0.0F, 0.0F, -0.32F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(242, 64).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 64).addBox(-2.0F, 0.29F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 64).addBox(-1.0F, 1.42F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(317, 64).addBox(-2.0F, -0.56F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 14.63F, 4.0F, 0.0F, 0.0F, -0.74F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(350, 64).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 64).addBox(-1.0F, 1.32F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 64).addBox(-1.0F, 0.29F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 64).addBox(-2.0F, 0.29F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 64).addBox(-3.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 64).addBox(1.0F, 3.29F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 1.80F, 0.0F, 0.0F, 0.0F, 0.32F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(EvilWatermelonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
