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
    public static final float SCALE = 0.61F;
    public static final float SHADOW = 0.90F;

    public BogWretchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-8.0F, -10.0F, -6.0F, 16.0F, 20.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 0).addBox(-10.0F, 8.0F, -7.0F, 20.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -16.38F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(250, 0).addBox(-6.0F, -7.0F, -7.0F, 12.0F, 11.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 0).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.0F, -4.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(376, 0).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 26.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -6.0F, 0.0F, -0.14F, 0.0F, -0.17F));
        PartDefinition arm_l_low = arm_l.addOrReplaceChild("arm_l_low", CubeListBuilder.create()
                .texOffs(401, 0).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 20.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, 0.31F, 0.0F, 0.0F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(426, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 26.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -6.0F, 0.0F, -0.14F, 0.0F, 0.17F));
        PartDefinition arm_r_low = arm_r.addOrReplaceChild("arm_r_low", CubeListBuilder.create()
                .texOffs(451, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 20.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, 0.31F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(BogWretchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_l_low = this.root.getChild("body").getChild("arm_l").getChild("arm_l_low"); Anims.swing(arm_l_low, limbSwing, limbSwingAmount, 0.3F, 4.71F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 6.28F);
        ModelPart arm_r_low = this.root.getChild("body").getChild("arm_r").getChild("arm_r_low"); Anims.swing(arm_r_low, limbSwing, limbSwingAmount, 0.3F, 7.85F);
    }
}
