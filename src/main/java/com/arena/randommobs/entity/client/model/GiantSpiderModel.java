package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GiantSpiderEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class GiantSpiderModel extends RMobModel<GiantSpiderEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/giant_spider.png");
    public static final float SCALE = 0.58F;
    public static final float SHADOW = 1.80F;

    public GiantSpiderModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-10.0F, -9.0F, -8.0F, 20.0F, 16.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 0).addBox(-7.0F, -13.0F, -20.0F, 14.0F, 12.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -23.42F, 6.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(282, 0).addBox(-7.0F, -6.0F, -8.0F, 14.0F, 11.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 0).addBox(-2.0F, -4.0F, -9.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 0).addBox(2.0F, -4.0F, -9.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(413, 0).addBox(6.0F, -4.0F, -9.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.0F, -14.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(426, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -27.42F, -4.0F, 0.36F, 0.0F, 0.55F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(451, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, -1.24F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(468, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -27.42F, -1.60F, 0.15F, 0.0F, 0.41F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(493, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, -1.05F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(0, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -27.42F, 1.60F, -0.15F, 0.0F, 0.41F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(25, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, -1.05F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(42, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -27.42F, 4.0F, -0.36F, 0.0F, 0.55F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(67, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, -1.24F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(84, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -27.42F, -4.0F, 0.36F, 0.0F, -0.55F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(109, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, 1.24F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(126, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -27.42F, -1.60F, 0.15F, 0.0F, -0.41F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(151, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, 1.05F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(168, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -27.42F, 1.60F, -0.15F, 0.0F, -0.41F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(193, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, 1.05F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(210, 77).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -27.42F, 4.0F, -0.36F, 0.0F, -0.55F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(235, 77).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 24.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0F, 1.24F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(GiantSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_l0 = this.root.getChild("leg_l0"); Anims.swing(leg_l0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_l0_low = this.root.getChild("leg_l0").getChild("leg_l0_low"); Anims.swing(leg_l0_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_l1 = this.root.getChild("leg_l1"); Anims.swing(leg_l1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l1_low = this.root.getChild("leg_l1").getChild("leg_l1_low"); Anims.swing(leg_l1_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_l2 = this.root.getChild("leg_l2"); Anims.swing(leg_l2, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_l2_low = this.root.getChild("leg_l2").getChild("leg_l2_low"); Anims.swing(leg_l2_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_l3 = this.root.getChild("leg_l3"); Anims.swing(leg_l3, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_l3_low = this.root.getChild("leg_l3").getChild("leg_l3_low"); Anims.swing(leg_l3_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_r0 = this.root.getChild("leg_r0"); Anims.swing(leg_r0, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_r0_low = this.root.getChild("leg_r0").getChild("leg_r0_low"); Anims.swing(leg_r0_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
        ModelPart leg_r1 = this.root.getChild("leg_r1"); Anims.swing(leg_r1, limbSwing, limbSwingAmount, 0.95F, 18.85F);
        ModelPart leg_r1_low = this.root.getChild("leg_r1").getChild("leg_r1_low"); Anims.swing(leg_r1_low, limbSwing, limbSwingAmount, 0.45F, 20.42F);
        ModelPart leg_r2 = this.root.getChild("leg_r2"); Anims.swing(leg_r2, limbSwing, limbSwingAmount, 0.95F, 21.99F);
        ModelPart leg_r2_low = this.root.getChild("leg_r2").getChild("leg_r2_low"); Anims.swing(leg_r2_low, limbSwing, limbSwingAmount, 0.45F, 23.56F);
        ModelPart leg_r3 = this.root.getChild("leg_r3"); Anims.swing(leg_r3, limbSwing, limbSwingAmount, 0.95F, 25.13F);
        ModelPart leg_r3_low = this.root.getChild("leg_r3").getChild("leg_r3_low"); Anims.swing(leg_r3_low, limbSwing, limbSwingAmount, 0.45F, 26.70F);
    }
}
