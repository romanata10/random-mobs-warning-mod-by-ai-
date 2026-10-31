package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.ChestMimicEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ChestMimicModel extends RMobModel<ChestMimicEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/chest_mimic.png");
    public static final float SCALE = 0.65F;
    public static final float SHADOW = 0.60F;

    public ChestMimicModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -6.0F, -5.0F, 14.0F, 12.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-7.0F, -7.0F, -5.0F, 14.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 0).addBox(-8.0F, 4.0F, -6.0F, 16.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.94F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(307, 0).addBox(-8.0F, -3.0F, -6.0F, 16.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 0).addBox(-2.0F, 1.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.40F, 2.0F));
        PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create()
                .texOffs(445, 0).addBox(-6.0F, -2.0F, -3.0F, 12.0F, 4.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 45).addBox(-5.0F, -1.0F, -4.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(13, 45).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(26, 45).addBox(3.0F, -1.0F, -4.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -0.80F, -6.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(39, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(56, 45).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 11.34F, -3.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(89, 45).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 45).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 45).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 45).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(165, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 45).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 11.34F, -3.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(215, 45).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 45).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 45).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 45).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.06F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(291, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 45).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 11.34F, 3.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(341, 45).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 45).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(383, 45).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 45).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(417, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.51F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 45).addBox(-2.0F, 1.38F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 11.34F, 3.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(467, 45).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.93F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 45).addBox(-2.0F, 1.93F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 61).addBox(-3.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 61).addBox(1.0F, 3.93F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.51F, 0.0F, 0.0F, 0.0F, -0.06F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(ChestMimicEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.jaw(head, ageInTicks, 0.18F);
        ModelPart jaw = this.root.getChild("body").getChild("jaw"); Anims.jaw(jaw, ageInTicks, 0.18F);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
    }
}
