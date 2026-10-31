package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WoodcrawlerModel extends RMobModel<WoodcrawlerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/woodcrawler.png");
    public static final float SCALE = 0.59F;
    public static final float SHADOW = 0.90F;

    public WoodcrawlerModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 0).addBox(-5.0F, 1.0F, -4.0F, 10.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 0).addBox(-4.0F, 7.0F, -3.0F, 8.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(219, 0).addBox(-3.0F, 13.0F, -2.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(260, 0).addBox(-7.0F, 2.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 0).addBox(5.0F, 2.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 0).addBox(-6.0F, 8.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 0).addBox(4.0F, 8.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.08F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(328, 0).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 0).addBox(-5.0F, 2.0F, -4.0F, 10.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(490, 0).addBox(-4.0F, 4.0F, -5.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 37).addBox(1.0F, 4.0F, -5.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -11.0F, -2.0F));
        PartDefinition eye_l = head.addOrReplaceChild("eye_l", CubeListBuilder.create()
                .texOffs(21, 37).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-3.0F, -2.0F, -6.0F));
        PartDefinition eye_r = head.addOrReplaceChild("eye_r", CubeListBuilder.create()
                .texOffs(46, 37).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(3.0F, -2.0F, -6.0F));
        PartDefinition palp_l = head.addOrReplaceChild("palp_l", CubeListBuilder.create()
                .texOffs(71, 37).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 2.0F, -5.0F, 0.49F, 0.0F, 0.24F));
        PartDefinition palp_r = head.addOrReplaceChild("palp_r", CubeListBuilder.create()
                .texOffs(88, 37).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 2.0F, -5.0F, 0.49F, 0.0F, -0.24F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(105, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.75F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 37).addBox(-3.0F, 4.19F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -14.08F, -6.0F, -2.37F, 0.0F, 1.08F));
        PartDefinition leg_l0_low = leg_l0.addOrReplaceChild("leg_l0_low", CubeListBuilder.create()
                .texOffs(187, 37).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 37.05F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 37).addBox(-2.0F, 35.05F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 37).addBox(-3.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 37).addBox(1.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 16.75F, 0.0F, 1.45F, 0.0F, 0.70F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(279, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 15.98F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(312, 37).addBox(-3.0F, 3.99F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -14.08F, -2.40F, -2.77F, 0.0F, 1.18F));
        PartDefinition leg_l1_low = leg_l1.addOrReplaceChild("leg_l1_low", CubeListBuilder.create()
                .texOffs(361, 37).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 36.57F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(386, 37).addBox(-2.0F, 34.57F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 37).addBox(-3.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(436, 37).addBox(1.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 15.98F, 0.0F, 1.45F, 0.0F, 1.15F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(453, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 15.98F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 118).addBox(-3.0F, 3.99F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -14.08F, 2.40F, 2.77F, 0.0F, 1.18F));
        PartDefinition leg_l2_low = leg_l2.addOrReplaceChild("leg_l2_low", CubeListBuilder.create()
                .texOffs(49, 118).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 36.57F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 118).addBox(-2.0F, 34.57F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 118).addBox(-3.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(124, 118).addBox(1.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 15.98F, 0.0F, -1.45F, 0.0F, 1.15F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(141, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.75F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 118).addBox(-3.0F, 4.19F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -14.08F, 6.0F, 2.37F, 0.0F, 1.08F));
        PartDefinition leg_l3_low = leg_l3.addOrReplaceChild("leg_l3_low", CubeListBuilder.create()
                .texOffs(223, 118).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 37.05F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 118).addBox(-2.0F, 35.05F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 118).addBox(-3.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 118).addBox(1.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 16.75F, 0.0F, -1.45F, 0.0F, 0.70F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(315, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.75F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 118).addBox(-3.0F, 4.19F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -14.08F, -6.0F, -2.37F, 0.0F, -1.08F));
        PartDefinition leg_r0_low = leg_r0.addOrReplaceChild("leg_r0_low", CubeListBuilder.create()
                .texOffs(397, 118).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 37.05F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(422, 118).addBox(-2.0F, 35.05F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 118).addBox(-3.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 118).addBox(1.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 16.75F, 0.0F, 1.45F, 0.0F, -0.70F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(0, 199).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 15.98F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 199).addBox(-3.0F, 3.99F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -14.08F, -2.40F, -2.77F, 0.0F, -1.18F));
        PartDefinition leg_r1_low = leg_r1.addOrReplaceChild("leg_r1_low", CubeListBuilder.create()
                .texOffs(82, 199).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 36.57F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 199).addBox(-2.0F, 34.57F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 199).addBox(-3.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 199).addBox(1.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 15.98F, 0.0F, 1.45F, 0.0F, -1.15F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(174, 199).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 15.98F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 199).addBox(-3.0F, 3.99F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -14.08F, 2.40F, 2.77F, 0.0F, -1.18F));
        PartDefinition leg_r2_low = leg_r2.addOrReplaceChild("leg_r2_low", CubeListBuilder.create()
                .texOffs(256, 199).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 36.57F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 199).addBox(-2.0F, 34.57F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 199).addBox(-3.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 199).addBox(1.0F, 36.57F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 15.98F, 0.0F, -1.45F, 0.0F, -1.15F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(348, 199).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.75F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 199).addBox(-3.0F, 4.19F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -14.08F, 6.0F, 2.37F, 0.0F, -1.08F));
        PartDefinition leg_r3_low = leg_r3.addOrReplaceChild("leg_r3_low", CubeListBuilder.create()
                .texOffs(430, 199).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 37.05F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 199).addBox(-2.0F, 35.05F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 199).addBox(-3.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 280).addBox(1.0F, 37.05F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 16.75F, 0.0F, -1.45F, 0.0F, -0.70F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(WoodcrawlerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye_l = this.root.getChild("body").getChild("head").getChild("eye_l"); Anims.pulse(eye_l, ageInTicks, 0.06F);
        ModelPart eye_r = this.root.getChild("body").getChild("head").getChild("eye_r"); Anims.pulse(eye_r, ageInTicks, 0.06F);
        ModelPart leg_l0 = this.root.getChild("leg_l0"); Anims.swing(leg_l0, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l0_low = this.root.getChild("leg_l0").getChild("leg_l0_low"); Anims.swing(leg_l0_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_l1 = this.root.getChild("leg_l1"); Anims.swing(leg_l1, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_l1_low = this.root.getChild("leg_l1").getChild("leg_l1_low"); Anims.swing(leg_l1_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_l2 = this.root.getChild("leg_l2"); Anims.swing(leg_l2, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_l2_low = this.root.getChild("leg_l2").getChild("leg_l2_low"); Anims.swing(leg_l2_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_l3 = this.root.getChild("leg_l3"); Anims.swing(leg_l3, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_l3_low = this.root.getChild("leg_l3").getChild("leg_l3_low"); Anims.swing(leg_l3_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
        ModelPart leg_r0 = this.root.getChild("leg_r0"); Anims.swing(leg_r0, limbSwing, limbSwingAmount, 0.95F, 18.85F);
        ModelPart leg_r0_low = this.root.getChild("leg_r0").getChild("leg_r0_low"); Anims.swing(leg_r0_low, limbSwing, limbSwingAmount, 0.45F, 20.42F);
        ModelPart leg_r1 = this.root.getChild("leg_r1"); Anims.swing(leg_r1, limbSwing, limbSwingAmount, 0.95F, 21.99F);
        ModelPart leg_r1_low = this.root.getChild("leg_r1").getChild("leg_r1_low"); Anims.swing(leg_r1_low, limbSwing, limbSwingAmount, 0.45F, 23.56F);
        ModelPart leg_r2 = this.root.getChild("leg_r2"); Anims.swing(leg_r2, limbSwing, limbSwingAmount, 0.95F, 25.13F);
        ModelPart leg_r2_low = this.root.getChild("leg_r2").getChild("leg_r2_low"); Anims.swing(leg_r2_low, limbSwing, limbSwingAmount, 0.45F, 26.70F);
        ModelPart leg_r3 = this.root.getChild("leg_r3"); Anims.swing(leg_r3, limbSwing, limbSwingAmount, 0.95F, 28.27F);
        ModelPart leg_r3_low = this.root.getChild("leg_r3").getChild("leg_r3_low"); Anims.swing(leg_r3_low, limbSwing, limbSwingAmount, 0.45F, 29.85F);
    }
}
