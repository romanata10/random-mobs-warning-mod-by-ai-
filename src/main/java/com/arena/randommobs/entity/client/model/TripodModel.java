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
    public static final float SCALE = 0.93F;
    public static final float SHADOW = 2.20F;

    public TripodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 21.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 0).addBox(-13.0F, -16.0F, -8.0F, 5.0F, 21.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 0).addBox(8.0F, -16.0F, -8.0F, 5.0F, 21.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(299, 0).addBox(-8.0F, -16.0F, -13.0F, 16.0F, 21.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 0).addBox(-8.0F, -16.0F, 8.0F, 16.0F, 21.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 75).addBox(-7.0F, 1.0F, -7.0F, 14.0F, 9.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 75).addBox(-11.0F, 1.0F, -7.0F, 4.0F, 9.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 75).addBox(7.0F, 1.0F, -7.0F, 4.0F, 9.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 75).addBox(-7.0F, 1.0F, -11.0F, 14.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 75).addBox(-7.0F, 1.0F, 7.0F, 14.0F, 9.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 75).addBox(-5.0F, 9.0F, -4.0F, 10.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 122).addBox(-8.0F, 9.0F, -4.0F, 3.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 122).addBox(5.0F, 9.0F, -4.0F, 3.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(90, 122).addBox(-5.0F, 9.0F, -7.0F, 10.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(143, 122).addBox(-5.0F, 9.0F, 4.0F, 10.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 122).addBox(-14.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 122).addBox(-16.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 122).addBox(-12.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 122).addBox(-14.0F, -14.0F, -7.0F, 2.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 122).addBox(-14.0F, -14.0F, 5.0F, 2.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 122).addBox(12.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 122).addBox(10.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 171).addBox(14.0F, -14.0F, -5.0F, 2.0F, 14.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 171).addBox(12.0F, -14.0F, -7.0F, 2.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 171).addBox(12.0F, -14.0F, 5.0F, 2.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 171).addBox(-11.0F, -2.0F, -11.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 171).addBox(-8.0F, -2.0F, -12.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 171).addBox(-4.0F, -3.0F, -12.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(142, 171).addBox(0.0F, -3.0F, -12.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 171).addBox(3.0F, -2.0F, -12.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(184, 171).addBox(7.0F, -2.0F, -11.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 171).addBox(-12.0F, -4.0F, -12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 171).addBox(-7.0F, -4.0F, -12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 171).addBox(-2.0F, -4.0F, -12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(252, 171).addBox(2.0F, -4.0F, -12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(269, 171).addBox(7.0F, -4.0F, -12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 171).addBox(-15.0F, 2.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 171).addBox(-13.27F, 4.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 171).addBox(-13.27F, 7.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 171).addBox(-15.0F, 10.0F, -10.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 171).addBox(-4.0F, -2.0F, -14.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 171).addBox(-5.0F, -4.0F, -14.0F, 10.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -56.32F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(440, 171).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 220).addBox(-8.0F, -6.0F, -3.0F, 4.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 220).addBox(4.0F, -6.0F, -3.0F, 4.0F, 10.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 220).addBox(-4.0F, -6.0F, -7.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 220).addBox(-4.0F, -6.0F, 3.0F, 8.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 220).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(221, 220).addBox(-6.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 220).addBox(3.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 220).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 220).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 6.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 220).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 220).addBox(-6.0F, -6.0F, -8.0F, 12.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 220).addBox(-1.0F, -10.0F, 1.0F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 220).addBox(-1.0F, -13.0F, 1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.80F, -2.0F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(0, 253).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 3.72F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 253).addBox(-4.0F, 2.79F, -4.0F, 8.0F, 11.61F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(146, 253).addBox(-3.0F, 13.47F, -3.0F, 6.0F, 6.97F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 253).addBox(-5.0F, 15.22F, -5.0F, 9.0F, 8.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-11.0F, -49.92F, -5.0F, -0.07F, 0.0F, 0.37F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(268, 253).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 19.88F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 253).addBox(-3.0F, 17.67F, -3.0F, 6.0F, 17.67F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(382, 253).addBox(-3.0F, 36.17F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(431, 253).addBox(-2.0F, 41.17F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 253).addBox(-3.0F, 44.17F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 310).addBox(1.0F, 44.17F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.40F, 21.60F, -1.50F, 0.04F, 0.0F, -0.29F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(25, 310).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 3.72F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(106, 310).addBox(-4.0F, 2.79F, -4.0F, 8.0F, 11.61F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 310).addBox(-3.0F, 13.47F, -3.0F, 6.0F, 6.97F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 310).addBox(-5.0F, 15.22F, -5.0F, 9.0F, 8.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(11.0F, -49.92F, -5.0F, -0.07F, 0.0F, -0.37F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(293, 310).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 19.88F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 310).addBox(-3.0F, 17.67F, -3.0F, 6.0F, 17.67F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(407, 310).addBox(-3.0F, 36.17F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 310).addBox(-2.0F, 41.17F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 367).addBox(-3.0F, 44.17F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 367).addBox(1.0F, 44.17F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.40F, 21.60F, -1.50F, 0.04F, 0.0F, 0.29F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(50, 367).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 3.67F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 367).addBox(-4.0F, 2.75F, -4.0F, 8.0F, 11.46F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 367).addBox(-3.0F, 13.29F, -3.0F, 6.0F, 6.88F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 367).addBox(-5.0F, 14.92F, -5.0F, 9.0F, 8.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.0F, -49.92F, 11.0F, 0.09F, 0.0F, -0.33F));
        PartDefinition leg_b_low = leg_b.addOrReplaceChild("leg_b_low", CubeListBuilder.create()
                .texOffs(318, 367).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 19.89F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(383, 367).addBox(-3.0F, 17.68F, -3.0F, 6.0F, 17.68F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(432, 367).addBox(-3.0F, 36.19F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 424).addBox(-2.0F, 41.19F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 424).addBox(-3.0F, 44.19F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 424).addBox(1.0F, 44.19F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.40F, 21.60F, 2.0F, -0.05F, 0.0F, 0.25F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_b_low = this.root.getChild("leg_b").getChild("leg_b_low"); Anims.swing(leg_b_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
    }
}
