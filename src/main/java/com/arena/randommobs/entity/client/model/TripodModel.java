package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TripodEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TripodModel extends RMobModel<TripodEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tripod.png");
    public static final float SCALE = 1.13F;
    public static final float SHADOW = 2.20F;

    public TripodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -10.0F, -11.0F, 22.0F, 20.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 0).addBox(-13.0F, 4.0F, -8.0F, 26.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(346, 0).addBox(-7.0F, 8.0F, -7.0F, 14.0F, 9.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 85).addBox(-15.0F, -2.0F, -3.0F, 30.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -39.43F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(145, 85).addBox(-8.0F, -8.0F, -9.0F, 16.0F, 12.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 85).addBox(-5.0F, -6.0F, -12.0F, 10.0F, 7.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 85).addBox(-2.0F, 2.0F, -12.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -58.63F, 0.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(364, 85).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 47.60F, -12.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(405, 85).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.20F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 152).addBox(-4.0F, 6.80F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -33.03F, 9.0F, 0.0F, 0.0F, 0.12F));
        PartDefinition leg_a_low = leg_a.addOrReplaceChild("leg_a_low", CubeListBuilder.create()
                .texOffs(65, 152).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 26.50F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 152).addBox(-2.0F, 24.50F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 152).addBox(-3.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 152).addBox(1.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 27.20F, 0.0F, 0.0F, 0.0F, -0.02F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(173, 152).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.20F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 152).addBox(-4.0F, 6.80F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -33.03F, 9.0F, 0.0F, 0.0F, -0.12F));
        PartDefinition leg_b_low = leg_b.addOrReplaceChild("leg_b_low", CubeListBuilder.create()
                .texOffs(287, 152).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 26.50F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(328, 152).addBox(-2.0F, 24.50F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(361, 152).addBox(-3.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(378, 152).addBox(1.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 27.20F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(395, 152).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.20F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 152).addBox(-4.0F, 6.80F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -33.03F, -11.0F, 0.0F, 0.0F, -0.12F));
        PartDefinition leg_c_low = leg_c.addOrReplaceChild("leg_c_low", CubeListBuilder.create()
                .texOffs(0, 219).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 26.50F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 219).addBox(-2.0F, 24.50F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 219).addBox(-3.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 219).addBox(1.0F, 26.50F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 27.20F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(108, 219).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(141, 219).addBox(-3.0F, 12.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-13.0F, -36.23F, -2.0F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(190, 219).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 219).addBox(-3.0F, 12.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(13.0F, -36.23F, -2.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
        ModelPart leg_a = this.root.getChild("leg_a"); Anims.swing(leg_a, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_a_low = this.root.getChild("leg_a").getChild("leg_a_low"); Anims.swing(leg_a_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_b_low = this.root.getChild("leg_b").getChild("leg_b_low"); Anims.swing(leg_b_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_c = this.root.getChild("leg_c"); Anims.swing(leg_c, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_c_low = this.root.getChild("leg_c").getChild("leg_c_low"); Anims.swing(leg_c_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart arm_l = this.root.getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 14.14F);
        ModelPart arm_r = this.root.getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 15.71F);
    }
}
