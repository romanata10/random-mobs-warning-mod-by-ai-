package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TankEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TankModel extends RMobModel<TankEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tank.png");
    public static final float SCALE = 0.95F;
    public static final float SHADOW = 1.60F;

    public TankModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-13.0F, -8.0F, -19.0F, 26.0F, 8.0F, 38.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 0).addBox(-11.0F, 0.0F, -18.0F, 22.0F, 7.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 93).addBox(-12.0F, -12.0F, -20.0F, 24.0F, 4.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(125, 93).addBox(-12.0F, -6.0F, 18.0F, 24.0F, 3.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 93).addBox(-20.0F, 1.0F, -21.0F, 7.0F, 2.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 182).addBox(13.0F, 1.0F, -21.0F, 7.0F, 2.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 182).addBox(-19.0F, 3.0F, -21.0F, 6.0F, 12.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 291).addBox(13.0F, 3.0F, -21.0F, 6.0F, 12.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 291).addBox(-19.0F, 2.0F, -20.0F, 6.0F, 2.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 400).addBox(13.0F, 2.0F, -20.0F, 6.0F, 2.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 400).addBox(-18.50F, 8.0F, -16.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 400).addBox(-18.50F, 8.0F, -8.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 400).addBox(-18.50F, 8.0F, 0.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 400).addBox(-18.50F, 8.0F, 8.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 400).addBox(-18.50F, 8.0F, 16.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 400).addBox(14.50F, 8.0F, -16.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(407, 400).addBox(14.50F, 8.0F, -8.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 400).addBox(14.50F, 8.0F, 0.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 485).addBox(14.50F, 8.0F, 8.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(37, 485).addBox(14.50F, 8.0F, 16.0F, 4.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 485).addBox(-9.0F, -10.0F, 20.0F, 4.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(111, 485).addBox(5.0F, -10.0F, 20.0F, 4.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 485).addBox(14.50F, -5.0F, 6.0F, 5.0F, 6.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(205, 485).addBox(-19.50F, -5.0F, 4.0F, 5.0F, 6.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(262, 485).addBox(-8.0F, -6.0F, -21.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 485).addBox(5.0F, -6.0F, -21.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 485).addBox(-12.0F, -2.0F, -19.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(321, 485).addBox(-7.0F, -2.0F, -19.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 485).addBox(-2.0F, -2.0F, -19.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 485).addBox(2.0F, -2.0F, -19.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 485).addBox(7.0F, -2.0F, -19.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.40F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 516).addBox(-9.0F, -4.0F, -9.0F, 18.0F, 7.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 516).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 2.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 516).addBox(-9.50F, -1.0F, -6.0F, 19.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(399, 516).addBox(-4.0F, -3.0F, -12.0F, 8.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 567).addBox(-2.0F, -3.0F, -30.0F, 3.0F, 3.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 567).addBox(-3.0F, -4.0F, -35.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 567).addBox(-4.0F, -8.0F, 2.0F, 7.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 567).addBox(-3.0F, -9.0F, 3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 567).addBox(6.0F, -10.0F, -2.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(245, 567).addBox(6.0F, -7.0F, -4.0F, 2.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(278, 567).addBox(-8.0F, -3.0F, -7.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(303, 567).addBox(-4.0F, -4.0F, -7.0F, 4.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(332, 567).addBox(1.0F, -3.0F, -7.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(357, 567).addBox(4.0F, -3.0F, 7.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 567).addBox(10.0F, -3.0F, 7.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -12.80F, -2.0F));
        PartDefinition wheel_0 = body.addOrReplaceChild("wheel_0", CubeListBuilder.create()
                .texOffs(423, 567).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 14.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-19.50F, 6.40F, -16.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition wheel_1 = body.addOrReplaceChild("wheel_1", CubeListBuilder.create()
                .texOffs(0, 612).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 14.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-19.50F, 6.40F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(TankEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
    }
}
