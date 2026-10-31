package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.KrakenEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class KrakenModel extends RMobModel<KrakenEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/kraken.png");
    public static final float SCALE = 0.86F;
    public static final float SHADOW = 2.60F;

    public KrakenModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -13.0F, -16.0F, 32.0F, 28.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 0).addBox(-18.0F, 3.0F, -14.0F, 36.0F, 12.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 117).addBox(-13.0F, 14.0F, -12.0F, 26.0F, 10.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 117).addBox(-14.0F, 3.0F, -13.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 117).addBox(-9.0F, 3.0F, -13.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 117).addBox(-3.0F, 2.0F, -13.0F, 5.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 117).addBox(2.0F, 3.0F, -13.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(313, 117).addBox(8.0F, 3.0F, -13.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(342, 117).addBox(-15.0F, 20.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 117).addBox(-7.0F, 20.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 117).addBox(0.0F, 20.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 117).addBox(7.0F, 20.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(410, 117).addBox(-17.0F, -5.0F, -2.0F, 3.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 182).addBox(14.0F, -5.0F, -2.0F, 3.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -29.32F, 4.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(53, 182).addBox(-14.0F, -14.0F, -12.0F, 28.0F, 24.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 182).addBox(-11.0F, 6.0F, -11.0F, 22.0F, 8.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(415, 182).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 275).addBox(-10.0F, 8.0F, -12.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 275).addBox(-7.0F, 8.0F, -12.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 275).addBox(-4.0F, 8.0F, -12.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(51, 275).addBox(0.0F, 8.0F, -12.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(68, 275).addBox(3.0F, 8.0F, -12.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(85, 275).addBox(7.0F, 8.0F, -12.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(102, 275).addBox(-10.0F, 8.0F, -12.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 275).addBox(-6.0F, 8.0F, -12.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(144, 275).addBox(-2.0F, 7.0F, -12.0F, 3.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 275).addBox(2.0F, 8.0F, -12.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 275).addBox(6.0F, 8.0F, -12.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(207, 275).addBox(-11.0F, 11.0F, -11.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(228, 275).addBox(-7.0F, 11.0F, -12.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 275).addBox(-3.0F, 10.0F, -12.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 275).addBox(2.0F, 11.0F, -12.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 275).addBox(6.0F, 11.0F, -11.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.40F, -16.0F));
        PartDefinition eye_l = body.addOrReplaceChild("eye_l", CubeListBuilder.create()
                .texOffs(324, 275).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(365, 275).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-7.0F, -16.0F, -27.0F));
        PartDefinition eye_r = body.addOrReplaceChild("eye_r", CubeListBuilder.create()
                .texOffs(378, 275).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 275).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(7.0F, -16.0F, -27.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(432, 275).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(473, 275).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 326).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 326).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 326).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.0F, 19.20F, -10.0F, 0.0F, 0.0F, -0.31F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(83, 326).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(124, 326).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 326).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 326).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 326).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 19.20F, -10.0F, 0.0F, 0.0F, -0.21F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(240, 326).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 326).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 326).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 326).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 326).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 19.20F, -10.0F, 0.0F, 0.0F, -0.10F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(397, 326).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(438, 326).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 377).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 377).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 377).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 19.20F, 2.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(83, 377).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(124, 377).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 377).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 377).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(223, 377).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 19.20F, 2.0F, 0.0F, 0.0F, 0.10F));
        PartDefinition tentacle_5 = body.addOrReplaceChild("tentacle_5", CubeListBuilder.create()
                .texOffs(240, 377).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 377).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(314, 377).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 377).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 377).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, 19.20F, 2.0F, 0.0F, 0.0F, 0.21F));
        PartDefinition tentacle_6 = body.addOrReplaceChild("tentacle_6", CubeListBuilder.create()
                .texOffs(397, 377).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 20.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(438, 377).addBox(-2.0F, 17.0F, -2.0F, 4.0F, 17.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 428).addBox(-3.0F, 21.0F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 428).addBox(-3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 428).addBox(-3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.0F, 19.20F, 14.0F, 0.0F, 0.0F, 0.31F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(KrakenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye_l = this.root.getChild("body").getChild("eye_l"); Anims.pulse(eye_l, ageInTicks, 0.06F);
        ModelPart eye_r = this.root.getChild("body").getChild("eye_r"); Anims.pulse(eye_r, ageInTicks, 0.06F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 9.42F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 11.00F);
        ModelPart tentacle_4 = this.root.getChild("body").getChild("tentacle_4"); Anims.swayOne(tentacle_4, ageInTicks, 0.09F, 12.57F);
        ModelPart tentacle_5 = this.root.getChild("body").getChild("tentacle_5"); Anims.swayOne(tentacle_5, ageInTicks, 0.09F, 14.14F);
        ModelPart tentacle_6 = this.root.getChild("body").getChild("tentacle_6"); Anims.swayOne(tentacle_6, ageInTicks, 0.09F, 15.71F);
    }
}
