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
    public static final float SCALE = 0.99F;
    public static final float SHADOW = 0.60F;

    public ChestMimicModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -4.0F, 12.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 0).addBox(-9.0F, -5.0F, -4.0F, 3.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 0).addBox(6.0F, -5.0F, -4.0F, 3.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 0).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(232, 0).addBox(-6.0F, -5.0F, 4.0F, 12.0F, 7.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 0).addBox(-6.0F, 0.0F, -4.0F, 12.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(374, 0).addBox(-8.0F, 0.0F, -4.0F, 2.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(415, 0).addBox(6.0F, 0.0F, -4.0F, 2.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 31).addBox(-6.0F, 0.0F, 4.0F, 12.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 31).addBox(-9.0F, -5.0F, -3.0F, 18.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 31).addBox(-2.0F, -5.0F, -7.0F, 4.0F, 1.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(211, 31).addBox(-6.0F, -3.0F, -5.0F, 12.0F, 4.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 31).addBox(-9.0F, -3.0F, -5.0F, 3.0F, 4.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(345, 31).addBox(6.0F, -3.0F, -5.0F, 3.0F, 4.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 31).addBox(-6.0F, -3.0F, -8.0F, 12.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 62).addBox(-6.0F, -3.0F, 4.0F, 12.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 14.78F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(61, 62).addBox(-7.0F, -1.0F, -2.0F, 14.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 62).addBox(-8.0F, -1.0F, -2.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 62).addBox(7.0F, -1.0F, -2.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 62).addBox(-7.0F, -1.0F, -3.0F, 14.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(213, 62).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 62).addBox(-7.0F, -3.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 62).addBox(-5.0F, -3.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(300, 62).addBox(-3.0F, -3.0F, -4.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(313, 62).addBox(0.0F, -3.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 62).addBox(2.0F, -3.0F, -4.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 62).addBox(5.0F, -3.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(352, 62).addBox(-7.0F, 1.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 62).addBox(-5.0F, 1.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 62).addBox(-3.0F, 0.0F, -4.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(391, 62).addBox(0.0F, 1.0F, -4.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 62).addBox(2.0F, 0.0F, -4.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 62).addBox(5.0F, 2.0F, -4.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 62).addBox(-2.0F, 2.0F, -5.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.0F, -7.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(463, 62).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 81).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 81).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 81).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 16.06F, -4.0F, 0.0F, 0.0F, 0.55F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(67, 81).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 81).addBox(-1.0F, 1.70F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(101, 81).addBox(-1.0F, 1.24F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 2.70F, 0.0F, 0.0F, 0.0F, -0.22F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(110, 81).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 81).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(176, 81).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 81).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 16.06F, -4.0F, 0.0F, 0.0F, -0.55F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(218, 81).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 81).addBox(-1.0F, 1.70F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(252, 81).addBox(-1.0F, 1.24F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 2.70F, 0.0F, 0.0F, 0.0F, 0.22F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(261, 81).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(302, 81).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 81).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 81).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 16.06F, 4.0F, 0.0F, 0.0F, 0.55F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(369, 81).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 81).addBox(-1.0F, 1.70F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(403, 81).addBox(-1.0F, 1.24F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 2.70F, 0.0F, 0.0F, 0.0F, -0.22F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(412, 81).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(453, 81).addBox(-2.0F, 0.38F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(478, 81).addBox(-1.0F, 1.84F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 96).addBox(-2.0F, 0.16F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 16.06F, 4.0F, 0.0F, 0.0F, -0.55F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(33, 96).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 96).addBox(-1.0F, 1.70F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 96).addBox(-1.0F, 1.24F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 2.70F, 0.0F, 0.0F, 0.0F, 0.22F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(ChestMimicEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.jaw(head, ageInTicks, 0.18F);
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
