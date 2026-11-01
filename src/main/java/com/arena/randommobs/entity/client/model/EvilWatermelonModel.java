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
    public static final float SCALE = 0.81F;
    public static final float SHADOW = 0.60F;

    public EvilWatermelonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 0).addBox(-10.0F, -4.0F, -4.0F, 6.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 0).addBox(4.0F, -4.0F, -4.0F, 6.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(179, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 0).addBox(-4.0F, -4.0F, 4.0F, 8.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 0).addBox(-3.0F, 4.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(342, 0).addBox(-8.0F, 4.0F, -3.0F, 5.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 0).addBox(3.0F, 4.0F, -3.0F, 5.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 0).addBox(-3.0F, 4.0F, -8.0F, 6.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 33).addBox(-3.0F, 4.0F, 3.0F, 6.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 33).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 33).addBox(-7.0F, -8.0F, -5.0F, 2.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(175, 33).addBox(5.0F, -8.0F, -5.0F, 2.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(224, 33).addBox(-5.0F, -8.0F, -7.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 33).addBox(-5.0F, -8.0F, 5.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 33).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 33).addBox(-5.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 33).addBox(4.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(461, 33).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 58).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 58).addBox(-7.0F, -4.0F, -9.0F, 2.0F, 1.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 58).addBox(5.0F, -4.0F, -9.0F, 2.0F, 1.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 58).addBox(-9.0F, -4.0F, -1.0F, 18.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 12.26F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(280, 58).addBox(-6.0F, -4.0F, -1.0F, 12.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 58).addBox(-7.0F, -4.0F, -1.0F, 1.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(350, 58).addBox(6.0F, -4.0F, -1.0F, 1.0F, 7.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 58).addBox(-6.0F, -4.0F, -2.0F, 12.0F, 7.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 58).addBox(-6.0F, -4.0F, 1.0F, 12.0F, 7.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 97).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 97).addBox(-4.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(62, 97).addBox(-2.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 97).addBox(0.0F, -2.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(88, 97).addBox(2.0F, -2.0F, -4.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 97).addBox(-4.0F, 2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 97).addBox(-2.0F, 2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(127, 97).addBox(0.0F, 1.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 97).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 97).addBox(-4.0F, -3.0F, -3.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 97).addBox(1.0F, -3.0F, -3.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.64F, -9.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(195, 97).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 97).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(261, 97).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 97).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 16.42F, -5.0F, 0.0F, 0.0F, 0.55F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(303, 97).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 97).addBox(-1.0F, 1.58F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 97).addBox(-1.0F, 0.94F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 2.70F, 0.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(346, 97).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 97).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(412, 97).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(421, 97).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 16.42F, -5.0F, 0.0F, 0.0F, -0.55F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(454, 97).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(479, 97).addBox(-1.0F, 1.58F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 97).addBox(-1.0F, 0.94F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 2.70F, 0.0F, 0.0F, 0.0F, 0.20F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(0, 112).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 112).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 112).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 112).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 16.42F, 5.0F, 0.0F, 0.0F, 0.55F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(108, 112).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 112).addBox(-1.0F, 1.58F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 112).addBox(-1.0F, 0.94F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 2.70F, 0.0F, 0.0F, 0.0F, -0.20F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(151, 112).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(192, 112).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 112).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 112).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 16.42F, 5.0F, 0.0F, 0.0F, -0.55F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(259, 112).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 112).addBox(-1.0F, 1.58F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 112).addBox(-1.0F, 0.94F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 2.70F, 0.0F, 0.0F, 0.0F, 0.20F));
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
