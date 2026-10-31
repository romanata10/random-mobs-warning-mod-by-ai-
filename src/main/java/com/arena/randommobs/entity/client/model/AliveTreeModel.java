package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AliveTreeEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class AliveTreeModel extends RMobModel<AliveTreeEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/alive_tree.png");
    public static final float SCALE = 0.88F;
    public static final float SHADOW = 1.60F;

    public AliveTreeModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 30.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-10.0F, 6.0F, -10.0F, 20.0F, 6.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 0).addBox(-5.0F, -18.0F, -5.0F, 10.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.86F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 89).addBox(-16.0F, -10.0F, -16.0F, 32.0F, 14.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 89).addBox(-12.0F, -18.0F, -12.0F, 24.0F, 8.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(450, 89).addBox(-3.0F, 2.0F, -8.0F, 6.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -27.20F, 0.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(0, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.14F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 182).addBox(-3.0F, 2.54F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 2.74F, -5.0F, 0.0F, 0.0F, 0.22F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(82, 182).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 7.79F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(107, 182).addBox(-2.0F, 5.79F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 182).addBox(-3.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 182).addBox(1.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 10.14F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(174, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.14F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 182).addBox(-3.0F, 2.54F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 2.74F, -5.0F, 0.0F, 0.0F, -0.22F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(256, 182).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 7.79F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 182).addBox(-2.0F, 5.79F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 182).addBox(-3.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 182).addBox(1.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 10.14F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(348, 182).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.14F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 182).addBox(-3.0F, 2.54F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 2.74F, 5.0F, 0.0F, 0.0F, 0.22F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(430, 182).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 7.79F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 182).addBox(-2.0F, 5.79F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 182).addBox(-3.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 211).addBox(1.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 10.14F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(17, 211).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.14F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 211).addBox(-3.0F, 2.54F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 2.74F, 5.0F, 0.0F, 0.0F, -0.22F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(99, 211).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 7.79F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(124, 211).addBox(-2.0F, 5.79F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 211).addBox(-3.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 211).addBox(1.0F, 7.79F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 10.14F, 0.0F, 0.0F, 0.0F, -0.01F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(AliveTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
