package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.UfoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class UfoModel extends RMobModel<UfoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/ufo.png");
    public static final float SCALE = 1.01F;
    public static final float SHADOW = 1.40F;

    public UfoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-24.0F, 0.0F, -24.0F, 48.0F, 4.0F, 48.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 105).addBox(-19.0F, -3.0F, -19.0F, 38.0F, 3.0F, 38.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 188).addBox(-13.0F, -5.0F, -13.0F, 26.0F, 4.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 188).addBox(-8.0F, 1.0F, -8.0F, 16.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 188).addBox(-6.0F, 4.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 188).addBox(-4.0F, 6.0F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 249).addBox(-2.0F, -1.0F, -22.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(29, 249).addBox(-2.0F, -1.0F, -11.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(58, 249).addBox(-2.0F, -1.0F, 11.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(87, 249).addBox(-2.0F, -1.0F, 22.0F, 4.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 249).addBox(-22.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 249).addBox(-11.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(174, 249).addBox(11.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 249).addBox(22.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(232, 249).addBox(-20.0F, -2.0F, -20.0F, 5.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 249).addBox(-15.0F, -2.0F, -20.0F, 5.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(282, 249).addBox(-9.0F, -3.0F, -21.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(311, 249).addBox(-3.0F, -3.0F, -21.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(340, 249).addBox(2.0F, -3.0F, -21.0F, 5.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 249).addBox(8.0F, -2.0F, -20.0F, 5.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(394, 249).addBox(14.0F, -2.0F, -20.0F, 5.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 9.60F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 262).addBox(-9.0F, -2.0F, -9.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 262).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 262).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(307, 262).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -7.20F, 0.0F));
        PartDefinition strut_0 = body.addOrReplaceChild("strut_0", CubeListBuilder.create()
                .texOffs(324, 262).addBox(-8.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.60F, 0.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition strut_1 = body.addOrReplaceChild("strut_1", CubeListBuilder.create()
                .texOffs(341, 262).addBox(-8.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.60F, 0.0F, 0.0F, 2.09F, 0.0F));
        PartDefinition strut_2 = body.addOrReplaceChild("strut_2", CubeListBuilder.create()
                .texOffs(358, 262).addBox(-8.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.60F, 0.0F, 0.0F, 4.19F, 0.0F));
        PartDefinition beam = body.addOrReplaceChild("beam", CubeListBuilder.create()
                .texOffs(0, 307).addBox(-10.0F, 0.0F, -10.0F, 20.0F, 2.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.80F, 0.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(UfoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart strut_0 = this.root.getChild("body").getChild("strut_0"); Anims.swing(strut_0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart strut_1 = this.root.getChild("body").getChild("strut_1"); Anims.swing(strut_1, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart strut_2 = this.root.getChild("body").getChild("strut_2"); Anims.swing(strut_2, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart beam = this.root.getChild("body").getChild("beam"); Anims.pulse(beam, ageInTicks, 0.06F);
    }
}
