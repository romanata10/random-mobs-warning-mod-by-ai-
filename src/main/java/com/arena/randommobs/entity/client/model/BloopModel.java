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
    public static final float SCALE = 0.87F;
    public static final float SHADOW = 3.40F;

    public BloopModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-20.0F, -16.0F, -20.0F, 40.0F, 14.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 109).addBox(-22.0F, -8.0F, -18.0F, 44.0F, 8.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 198).addBox(-17.0F, 3.0F, -17.0F, 34.0F, 11.0F, 34.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 198).addBox(-14.0F, 13.0F, -14.0F, 28.0F, 10.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 289).addBox(-12.0F, 1.0F, -9.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 289).addBox(-8.0F, 0.0F, -9.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 289).addBox(-3.0F, -1.0F, -9.0F, 4.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(79, 289).addBox(2.0F, 0.0F, -9.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(104, 289).addBox(7.0F, 1.0F, -9.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 289).addBox(-18.0F, 0.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(146, 289).addBox(-11.0F, 0.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 289).addBox(-4.0F, 0.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(180, 289).addBox(4.0F, 0.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 289).addBox(11.0F, 0.0F, -18.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -29.06F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(214, 289).addBox(-12.0F, -10.0F, -8.0F, 24.0F, 10.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 342).addBox(-10.0F, 6.0F, -9.0F, 20.0F, 8.0F, 15.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(141, 342).addBox(-9.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(158, 342).addBox(-6.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(175, 342).addBox(-3.0F, 0.0F, -9.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(192, 342).addBox(0.0F, 0.0F, -9.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 342).addBox(3.0F, 0.0F, -9.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 342).addBox(6.0F, 0.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 342).addBox(-9.0F, 7.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 342).addBox(-6.0F, 7.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(285, 342).addBox(-2.0F, 6.0F, -9.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 342).addBox(1.0F, 7.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 342).addBox(5.0F, 7.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 342).addBox(-10.0F, 8.0F, -8.0F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 342).addBox(-6.0F, 7.0F, -9.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 342).addBox(-2.0F, 6.0F, -9.0F, 4.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(419, 342).addBox(2.0F, 7.0F, -9.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(444, 342).addBox(6.0F, 8.0F, -8.0F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.40F, -12.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(0, 389).addBox(-6.0F, -5.0F, -1.0F, 12.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 389).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.0F, -8.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(86, 389).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(135, 389).addBox(-2.0F, 23.0F, -2.0F, 4.0F, 22.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 389).addBox(-2.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 389).addBox(0.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, 8.0F, -4.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(202, 389).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 389).addBox(-2.0F, 23.0F, -2.0F, 4.0F, 22.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(284, 389).addBox(-2.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 389).addBox(0.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 8.0F, 1.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(318, 389).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 389).addBox(-2.0F, 23.0F, -2.0F, 4.0F, 22.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(400, 389).addBox(-2.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(417, 389).addBox(0.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(434, 389).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 454).addBox(-2.0F, 23.0F, -2.0F, 4.0F, 22.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 454).addBox(-2.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 454).addBox(0.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 8.0F, -4.0F, 0.0F, 0.0F, 0.09F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(67, 454).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 454).addBox(-2.0F, 23.0F, -2.0F, 4.0F, 22.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 454).addBox(-2.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(166, 454).addBox(0.0F, 16.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.17F));
        return LayerDefinition.create(mesh, 512, 1024);
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
