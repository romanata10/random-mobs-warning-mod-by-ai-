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
    public static final float SCALE = 0.52F;
    public static final float SHADOW = 1.80F;

    public GiantSpiderModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -9.0F, -12.0F, 22.0F, 18.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 0).addBox(-9.0F, -12.0F, -10.0F, 18.0F, 5.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -20.42F, 6.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(346, 0).addBox(-9.0F, -8.0F, -9.0F, 18.0F, 14.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 0).addBox(-6.0F, 4.0F, -10.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 89).addBox(2.0F, 4.0F, -10.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.40F, -14.0F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(29, 89).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.18F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(62, 89).addBox(-3.0F, 4.79F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -32.22F, -6.0F, -2.58F, 0.0F, 1.00F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(111, 89).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 43.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(136, 89).addBox(-2.0F, 41.11F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 89).addBox(-3.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 89).addBox(1.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 19.18F, 0.0F, 1.70F, 0.0F, 0.90F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(203, 89).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.50F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 89).addBox(-3.0F, 4.63F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -32.22F, -2.40F, -2.90F, 0.0F, 1.06F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(285, 89).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 42.70F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(310, 89).addBox(-2.0F, 40.70F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 89).addBox(-3.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 89).addBox(1.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 18.50F, 0.0F, 1.97F, 0.0F, 1.26F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(377, 89).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.50F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 89).addBox(-3.0F, 4.63F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -32.22F, 2.40F, 2.90F, 0.0F, 1.06F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(459, 89).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 42.70F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 182).addBox(-2.0F, 40.70F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 182).addBox(-3.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 182).addBox(1.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 18.50F, 0.0F, -1.97F, 0.0F, 1.26F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(67, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.18F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 182).addBox(-3.0F, 4.79F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -32.22F, 6.0F, 2.58F, 0.0F, 1.00F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(149, 182).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 43.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 182).addBox(-2.0F, 41.11F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 182).addBox(-3.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 182).addBox(1.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 19.18F, 0.0F, -1.70F, 0.0F, 0.90F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(241, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.18F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 182).addBox(-3.0F, 4.79F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -32.22F, -6.0F, -2.58F, 0.0F, -1.00F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(323, 182).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 43.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 182).addBox(-2.0F, 41.11F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 182).addBox(-3.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 182).addBox(1.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 19.18F, 0.0F, 1.70F, 0.0F, -0.90F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(415, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.50F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 182).addBox(-3.0F, 4.63F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -32.22F, -2.40F, -2.90F, 0.0F, -1.06F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(0, 275).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 42.70F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 275).addBox(-2.0F, 40.70F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 275).addBox(-3.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 275).addBox(1.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 18.50F, 0.0F, 1.97F, 0.0F, -1.26F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(92, 275).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.50F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(125, 275).addBox(-3.0F, 4.63F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -32.22F, 2.40F, 2.90F, 0.0F, -1.06F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(174, 275).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 42.70F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 275).addBox(-2.0F, 40.70F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(232, 275).addBox(-3.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 275).addBox(1.0F, 42.70F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 18.50F, 0.0F, -1.97F, 0.0F, -1.26F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(266, 275).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.18F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(299, 275).addBox(-3.0F, 4.79F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -32.22F, 6.0F, 2.58F, 0.0F, -1.00F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(348, 275).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 43.11F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 275).addBox(-2.0F, 41.11F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 275).addBox(-3.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 275).addBox(1.0F, 43.11F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 19.18F, 0.0F, -1.70F, 0.0F, -0.90F));
        return LayerDefinition.create(mesh, 512, 512);
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
