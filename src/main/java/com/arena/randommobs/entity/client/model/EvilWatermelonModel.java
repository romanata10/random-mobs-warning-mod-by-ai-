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
    public static final float SCALE = 0.56F;
    public static final float SHADOW = 0.60F;

    public EvilWatermelonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 13.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-6.0F, 4.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 0).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.25F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(243, 0).addBox(-6.0F, -5.0F, -1.0F, 12.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 0).addBox(-4.0F, 0.0F, -2.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 0).addBox(1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.80F, -7.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(338, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 0).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 10.25F, -4.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(388, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.82F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 0).addBox(-2.0F, 2.82F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 0).addBox(-3.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 0).addBox(1.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(464, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 55).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 10.25F, -4.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(33, 55).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.82F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 55).addBox(-2.0F, 2.82F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 55).addBox(-3.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 55).addBox(1.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(109, 55).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 55).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 10.25F, 4.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(159, 55).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.82F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 55).addBox(-2.0F, 2.82F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 55).addBox(-3.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 55).addBox(1.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(235, 55).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(252, 55).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 10.25F, 4.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(285, 55).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.82F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 55).addBox(-2.0F, 2.82F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 55).addBox(-3.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(344, 55).addBox(1.0F, 4.82F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.01F));
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
