package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SirenHeadEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SirenHeadModel extends RMobModel<SirenHeadEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/siren_head.png");
    public static final float SCALE = 1.52F;
    public static final float SHADOW = 1.60F;

    public SirenHeadModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -44.0F, -4.0F, 10.0F, 58.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(73, 0).addBox(-8.0F, 10.0F, -5.0F, 16.0F, 12.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(178, 0).addBox(-7.0F, -10.0F, -6.0F, 14.0F, 11.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 0).addBox(-5.0F, -24.0F, -5.0F, 10.0F, 15.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 0).addBox(-2.0F, -13.0F, -7.0F, 4.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -46.0F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(389, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 34.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, -34.0F, 0.0F, 0.0F, 0.0F, -0.07F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(422, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 34.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, -34.0F, 0.0F, 0.0F, 0.0F, 0.07F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(SirenHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
    }
}
