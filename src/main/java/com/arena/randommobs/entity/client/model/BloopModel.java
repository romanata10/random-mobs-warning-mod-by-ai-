package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BloopEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BloopModel extends RMobModel<BloopEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bloop.png");
    public static final float SCALE = 1.07F;
    public static final float SHADOW = 3.40F;

    public BloopModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-20.0F, -17.0F, -19.0F, 40.0F, 14.0F, 38.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 105).addBox(-22.0F, -9.0F, -17.0F, 44.0F, 8.0F, 34.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 190).addBox(-18.0F, -2.0F, -16.0F, 36.0F, 8.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 190).addBox(-14.0F, 6.0F, -13.0F, 28.0F, 8.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 271).addBox(-19.0F, -16.0F, -18.0F, 38.0F, 3.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(297, 271).addBox(-12.0F, 1.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 271).addBox(-8.0F, 0.0F, -7.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 271).addBox(-3.0F, -1.0F, -7.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(376, 271).addBox(2.0F, 0.0F, -7.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 271).addBox(7.0F, 1.0F, -7.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(426, 271).addBox(-18.0F, 4.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 271).addBox(-11.0F, 4.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(460, 271).addBox(-4.0F, 4.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 271).addBox(4.0F, 4.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(494, 271).addBox(11.0F, 4.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.25F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 350).addBox(-12.0F, -10.0F, -8.0F, 24.0F, 10.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(161, 350).addBox(-10.0F, 4.0F, -9.0F, 20.0F, 8.0F, 15.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(302, 350).addBox(-9.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(319, 350).addBox(-6.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(336, 350).addBox(-3.0F, 0.0F, -9.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 350).addBox(0.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 350).addBox(3.0F, 0.0F, -9.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(387, 350).addBox(6.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(404, 350).addBox(-9.0F, 8.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 350).addBox(-6.0F, 8.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(446, 350).addBox(-2.0F, 7.0F, -9.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(467, 350).addBox(1.0F, 8.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 350).addBox(5.0F, 8.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 403).addBox(-10.0F, 9.0F, -8.0F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 403).addBox(-6.0F, 8.0F, -9.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(46, 403).addBox(-2.0F, 7.0F, -9.0F, 4.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(71, 403).addBox(2.0F, 8.0F, -9.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(96, 403).addBox(6.0F, 9.0F, -8.0F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -12.80F, -13.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(117, 403).addBox(-6.0F, -4.0F, -1.0F, 12.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 403).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.80F, -8.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(203, 403).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(252, 403).addBox(-2.0F, 11.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 403).addBox(-2.0F, 22.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 403).addBox(-3.0F, 29.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, 8.0F, -4.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(375, 403).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 403).addBox(-2.0F, 11.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 403).addBox(-2.0F, 22.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 432).addBox(-3.0F, 29.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 8.0F, 1.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(49, 432).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 432).addBox(-2.0F, 11.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(139, 432).addBox(-2.0F, 22.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 432).addBox(-3.0F, 29.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(221, 432).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(270, 432).addBox(-2.0F, 11.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 432).addBox(-2.0F, 22.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(344, 432).addBox(-3.0F, 29.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 8.0F, -4.0F, 0.0F, 0.0F, 0.09F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(393, 432).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(442, 432).addBox(-2.0F, 11.0F, -2.0F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 461).addBox(-2.0F, 22.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 461).addBox(-3.0F, 29.0F, -3.0F, 6.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.17F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(BloopEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("body").getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 4.71F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 9.42F);
        ModelPart tentacle_4 = this.root.getChild("body").getChild("tentacle_4"); Anims.swayOne(tentacle_4, ageInTicks, 0.09F, 11.00F);
    }
}
