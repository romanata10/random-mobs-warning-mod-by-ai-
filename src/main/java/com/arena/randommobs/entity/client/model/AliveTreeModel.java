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
    public static final float SCALE = 0.95F;
    public static final float SHADOW = 2.60F;

    public AliveTreeModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -26.0F, -6.0F, 14.0F, 46.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 0).addBox(-9.0F, 16.0F, -7.0F, 18.0F, 11.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(234, 0).addBox(-5.0F, -26.0F, -4.0F, 10.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(307, 0).addBox(-8.0F, -3.0F, -8.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 0).addBox(-4.0F, -4.0F, -8.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(361, 0).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 0).addBox(4.0F, -3.0F, -8.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(415, 0).addBox(-6.0F, -4.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 0).addBox(-2.0F, -4.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(449, 0).addBox(2.0F, -4.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.99F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 117).addBox(-8.0F, -15.0F, -7.0F, 16.0F, 16.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 117).addBox(-6.0F, -6.0F, -8.0F, 12.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 117).addBox(-5.0F, -14.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 117).addBox(3.0F, -14.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 117).addBox(-4.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 117).addBox(-2.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(230, 117).addBox(0.0F, 3.0F, -8.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 117).addBox(2.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -20.80F, -1.0F));
        PartDefinition crown = body.addOrReplaceChild("crown", CubeListBuilder.create()
                .texOffs(248, 117).addBox(-9.0F, -8.0F, -9.0F, 18.0F, 10.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 117).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(490, 117).addBox(-7.0F, -2.0F, -8.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 178).addBox(-4.0F, -3.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 178).addBox(0.0F, -3.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 178).addBox(3.0F, -2.0F, -8.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -33.60F, 0.0F));
        PartDefinition branch_0 = body.addOrReplaceChild("branch_0", CubeListBuilder.create()
                .texOffs(71, 178).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(88, 178).addBox(-7.0F, 8.0F, -1.0F, 2.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -16.0F, 3.0F, 0.0F, 0.0F, 0.45F));
        PartDefinition branch_1 = body.addOrReplaceChild("branch_1", CubeListBuilder.create()
                .texOffs(129, 178).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(146, 178).addBox(-1.0F, 8.0F, -1.0F, 2.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -16.0F, 3.0F, 0.0F, 0.0F, -0.45F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(187, 178).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 178).addBox(-2.0F, 1.11F, -2.0F, 4.0F, 4.63F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(269, 178).addBox(-1.0F, 5.37F, -1.0F, 2.0F, 2.78F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 178).addBox(-3.0F, 5.26F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 4.41F, -4.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(327, 178).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.25F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 178).addBox(-1.0F, 2.89F, -1.0F, 2.0F, 2.89F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 178).addBox(-1.0F, 3.23F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 178).addBox(-2.0F, 4.23F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 178).addBox(-3.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 178).addBox(1.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 9.0F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(0, 207).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 207).addBox(-2.0F, 1.11F, -2.0F, 4.0F, 4.63F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 207).addBox(-1.0F, 5.37F, -1.0F, 2.0F, 2.78F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 207).addBox(-3.0F, 5.26F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 4.41F, -4.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(140, 207).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.25F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 207).addBox(-1.0F, 2.89F, -1.0F, 2.0F, 2.89F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 207).addBox(-1.0F, 3.23F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 207).addBox(-2.0F, 4.23F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 207).addBox(-3.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 207).addBox(1.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 9.0F, 0.0F, 0.0F, 0.0F, -0.01F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(298, 207).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 207).addBox(-2.0F, 1.11F, -2.0F, 4.0F, 4.63F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 207).addBox(-1.0F, 5.37F, -1.0F, 2.0F, 2.78F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 207).addBox(-3.0F, 5.26F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 4.41F, 4.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(438, 207).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.25F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(471, 207).addBox(-1.0F, 2.89F, -1.0F, 2.0F, 2.89F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 207).addBox(-1.0F, 3.23F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 226).addBox(-2.0F, 4.23F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 226).addBox(-3.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 226).addBox(1.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 9.0F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(91, 226).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 226).addBox(-2.0F, 1.11F, -2.0F, 4.0F, 4.63F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 226).addBox(-1.0F, 5.37F, -1.0F, 2.0F, 2.78F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(190, 226).addBox(-3.0F, 5.26F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 4.41F, 4.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(231, 226).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.25F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 226).addBox(-1.0F, 2.89F, -1.0F, 2.0F, 2.89F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 226).addBox(-1.0F, 3.23F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 226).addBox(-2.0F, 4.23F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 226).addBox(-3.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 226).addBox(1.0F, 7.23F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 9.0F, 0.0F, 0.0F, 0.0F, -0.01F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(AliveTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart crown = this.root.getChild("body").getChild("crown"); Anims.look(crown, netHeadYaw, headPitch);
        ModelPart branch_0 = this.root.getChild("body").getChild("branch_0"); Anims.swayOne(branch_0, ageInTicks, 0.09F, 4.71F);
        ModelPart branch_1 = this.root.getChild("body").getChild("branch_1"); Anims.swayOne(branch_1, ageInTicks, 0.09F, 6.28F);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 17.28F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 18.85F);
    }
}
