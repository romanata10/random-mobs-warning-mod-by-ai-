package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WarshipEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WarshipModel extends RMobModel<WarshipEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/warship.png");
    public static final float SCALE = 0.79F;
    public static final float SHADOW = 3.0F;

    public WarshipModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -21.0F, -29.0F, 12.0F, 24.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 0).addBox(-11.0F, -21.0F, -29.0F, 5.0F, 24.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 141).addBox(6.0F, -21.0F, -29.0F, 5.0F, 24.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 141).addBox(-6.0F, -21.0F, -34.0F, 12.0F, 24.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 141).addBox(-6.0F, -21.0F, 17.0F, 12.0F, 24.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 282).addBox(-5.0F, 0.0F, -26.0F, 10.0F, 11.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 282).addBox(-9.0F, 0.0F, -26.0F, 4.0F, 11.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 385).addBox(5.0F, 0.0F, -26.0F, 4.0F, 11.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 385).addBox(-5.0F, 0.0F, -30.0F, 10.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(234, 385).addBox(-5.0F, 0.0F, 14.0F, 10.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 385).addBox(-4.0F, -25.0F, -19.0F, 8.0F, 5.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 488).addBox(-7.0F, -25.0F, -19.0F, 3.0F, 5.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(125, 488).addBox(4.0F, -25.0F, -19.0F, 3.0F, 5.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 488).addBox(-4.0F, -25.0F, -22.0F, 8.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(295, 488).addBox(-4.0F, -25.0F, 9.0F, 8.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(340, 488).addBox(-6.0F, -22.0F, -36.0F, 12.0F, 19.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 488).addBox(-8.0F, -22.0F, -36.0F, 2.0F, 19.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(430, 488).addBox(6.0F, -22.0F, -36.0F, 2.0F, 19.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(455, 488).addBox(-6.0F, -22.0F, -38.0F, 12.0F, 19.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 555).addBox(-6.0F, -22.0F, -32.0F, 12.0F, 19.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 555).addBox(-6.0F, -23.0F, 24.0F, 12.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 555).addBox(-8.0F, -23.0F, 24.0F, 2.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 555).addBox(6.0F, -23.0F, 24.0F, 2.0F, 14.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 555).addBox(-6.0F, -23.0F, 22.0F, 12.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(229, 555).addBox(-6.0F, -23.0F, 28.0F, 12.0F, 14.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(286, 555).addBox(-11.0F, -11.0F, -30.0F, 1.0F, 6.0F, 50.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 668).addBox(10.0F, -11.0F, -30.0F, 1.0F, 6.0F, 50.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 668).addBox(-10.0F, 1.0F, -30.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 668).addBox(-10.0F, 1.0F, -22.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(239, 668).addBox(-10.0F, 1.0F, -13.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 668).addBox(-10.0F, 1.0F, -5.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 668).addBox(-10.0F, 1.0F, 3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 668).addBox(-10.0F, 1.0F, 12.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -17.60F, 6.0F));
        PartDefinition bridge = body.addOrReplaceChild("bridge", CubeListBuilder.create()
                .texOffs(307, 668).addBox(-5.0F, -21.0F, -6.0F, 10.0F, 22.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(396, 668).addBox(-8.0F, -21.0F, -6.0F, 3.0F, 22.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 781).addBox(5.0F, -21.0F, -6.0F, 3.0F, 22.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 781).addBox(-5.0F, -21.0F, -9.0F, 10.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 781).addBox(-5.0F, -21.0F, 6.0F, 10.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(167, 781).addBox(-4.0F, -29.0F, -5.0F, 8.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(240, 781).addBox(-6.0F, -29.0F, -5.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 781).addBox(4.0F, -29.0F, -5.0F, 2.0F, 8.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 781).addBox(-4.0F, -29.0F, -7.0F, 8.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 781).addBox(-4.0F, -29.0F, 5.0F, 8.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 781).addBox(-2.0F, -34.0F, -3.0F, 4.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(461, 781).addBox(-4.0F, -34.0F, -3.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 850).addBox(2.0F, -34.0F, -3.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 850).addBox(-2.0F, -34.0F, -5.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 850).addBox(-2.0F, -34.0F, 3.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(83, 850).addBox(-1.0F, -42.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 850).addBox(-1.0F, -46.0F, -5.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(117, 850).addBox(0.0F, -49.0F, -4.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 850).addBox(0.0F, -53.0F, -4.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -27.20F, -12.0F));
        PartDefinition funnel_0 = body.addOrReplaceChild("funnel_0", CubeListBuilder.create()
                .texOffs(135, 850).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 850).addBox(-4.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 850).addBox(2.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 850).addBox(-2.0F, -11.0F, -4.0F, 4.0F, 11.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 850).addBox(-2.0F, -11.0F, 2.0F, 4.0F, 11.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 850).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 850).addBox(-3.0F, -13.0F, -2.0F, 1.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 850).addBox(2.0F, -13.0F, -2.0F, 1.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 850).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 850).addBox(-2.0F, -13.0F, 2.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -43.20F, -2.0F));
        PartDefinition funnel_1 = body.addOrReplaceChild("funnel_1", CubeListBuilder.create()
                .texOffs(385, 850).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(418, 850).addBox(-4.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 850).addBox(2.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 850).addBox(-2.0F, -11.0F, -4.0F, 4.0F, 11.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 881).addBox(-2.0F, -11.0F, 2.0F, 4.0F, 11.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 881).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 881).addBox(-3.0F, -13.0F, -2.0F, 1.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(79, 881).addBox(2.0F, -13.0F, -2.0F, 1.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(100, 881).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 881).addBox(-2.0F, -13.0F, 2.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -43.20F, 8.0F));
        PartDefinition turret_0 = body.addOrReplaceChild("turret_0", CubeListBuilder.create()
                .texOffs(142, 881).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(175, 881).addBox(-5.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(204, 881).addBox(2.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 881).addBox(-2.0F, -8.0F, -5.0F, 4.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 881).addBox(-2.0F, -8.0F, 2.0F, 4.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(291, 881).addBox(-3.0F, -4.0F, -14.0F, 2.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 881).addBox(1.0F, -4.0F, -14.0F, 2.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -26.40F, -24.0F));
        PartDefinition turret_1 = body.addOrReplaceChild("turret_1", CubeListBuilder.create()
                .texOffs(381, 881).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(414, 881).addBox(-5.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 881).addBox(2.0F, -8.0F, -2.0F, 3.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 881).addBox(-2.0F, -8.0F, -5.0F, 4.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 908).addBox(-2.0F, -8.0F, 2.0F, 4.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(29, 908).addBox(-3.0F, -4.0F, -14.0F, 2.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 908).addBox(1.0F, -4.0F, -14.0F, 2.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -26.40F, 8.0F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(WarshipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart bridge = this.root.getChild("body").getChild("bridge"); Anims.look(bridge, netHeadYaw, headPitch);
        ModelPart funnel_0 = this.root.getChild("body").getChild("funnel_0"); Anims.bob(funnel_0, ageInTicks, 0.45F);
        ModelPart funnel_1 = this.root.getChild("body").getChild("funnel_1"); Anims.bob(funnel_1, ageInTicks, 0.45F);
        ModelPart turret_0 = this.root.getChild("body").getChild("turret_0"); Anims.look(turret_0, netHeadYaw, headPitch);
        ModelPart turret_1 = this.root.getChild("body").getChild("turret_1"); Anims.look(turret_1, netHeadYaw, headPitch);
    }
}
