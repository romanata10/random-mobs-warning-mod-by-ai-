package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BogWretchEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BogWretchModel extends RMobModel<BogWretchEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bog_wretch.png");
    public static final float SCALE = 0.93F;
    public static final float SHADOW = 1.0F;

    public BogWretchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -10.0F, -4.0F, 14.0F, 14.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 0).addBox(-8.0F, 3.0F, -5.0F, 16.0F, 6.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 0).addBox(-6.0F, 9.0F, -4.0F, 12.0F, 6.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 0).addBox(-7.0F, -4.0F, -5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 0).addBox(-5.0F, -4.0F, -5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 0).addBox(-2.0F, -4.0F, -5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 0).addBox(1.0F, -4.0F, -5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 0).addBox(4.0F, -4.0F, -5.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 0).addBox(-6.0F, 5.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 0).addBox(-3.0F, 5.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 0).addBox(0.0F, 5.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 0).addBox(3.0F, 5.0F, -4.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 0).addBox(-6.0F, -8.0F, -3.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(481, 0).addBox(3.0F, -8.0F, -3.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 1.21F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 47).addBox(-6.0F, -3.0F, -5.0F, 12.0F, 9.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 47).addBox(-3.0F, 1.0F, -7.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 47).addBox(-4.0F, -2.0F, -6.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 47).addBox(2.0F, -2.0F, -6.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 47).addBox(-4.0F, 1.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 47).addBox(-2.0F, 1.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 47).addBox(0.0F, 1.0F, -6.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(191, 47).addBox(2.0F, 1.0F, -6.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -12.0F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(204, 47).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 47).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 47).addBox(-2.0F, 18.0F, -3.0F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 47).addBox(-5.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 47).addBox(-3.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 47).addBox(-1.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.16F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(378, 47).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 12.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(403, 47).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(436, 47).addBox(-2.0F, 18.0F, -3.0F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 47).addBox(-5.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 86).addBox(-3.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 86).addBox(-1.0F, 10.0F, -5.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.16F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(50, 86).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(99, 86).addBox(-2.0F, 1.00F, -2.0F, 4.0F, 4.15F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(132, 86).addBox(-1.0F, 4.81F, -1.0F, 2.0F, 2.49F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 86).addBox(-3.0F, 4.30F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 6.81F, 0.0F, 0.0F, 0.0F, 0.27F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(190, 86).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.65F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 86).addBox(-1.0F, 2.35F, -1.0F, 2.0F, 2.35F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(240, 86).addBox(-1.0F, 1.88F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 86).addBox(-2.0F, 2.88F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 86).addBox(-3.0F, 5.88F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(323, 86).addBox(1.0F, 5.88F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.20F, 8.0F, 0.0F, 0.0F, 0.0F, 0.04F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(348, 86).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 86).addBox(-2.0F, 1.00F, -2.0F, 4.0F, 4.15F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 86).addBox(-1.0F, 4.81F, -1.0F, 2.0F, 2.49F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 86).addBox(-3.0F, 4.30F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 6.81F, 0.0F, 0.0F, 0.0F, -0.27F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(0, 105).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.65F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 105).addBox(-1.0F, 2.35F, -1.0F, 2.0F, 2.35F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 105).addBox(-1.0F, 1.88F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 105).addBox(-2.0F, 2.88F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(108, 105).addBox(-3.0F, 5.88F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(133, 105).addBox(1.0F, 5.88F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.20F, 8.0F, 0.0F, 0.0F, 0.0F, -0.04F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(BogWretchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
    }
}
