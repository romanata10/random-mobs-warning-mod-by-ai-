package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.LanternWraithEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LanternWraithModel extends RMobModel<LanternWraithEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/lantern_wraith.png");
    public static final float SCALE = 0.65F;
    public static final float SHADOW = 0.70F;

    public LanternWraithModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -6.0F, -5.0F, 14.0F, 16.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-8.0F, 8.0F, -6.0F, 16.0F, 5.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 0).addBox(-6.0F, 13.0F, -5.0F, 12.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(299, 0).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 12.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(412, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -21.60F, 0.0F));
        PartDefinition orb = body.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(0, 53).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 53).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, -4.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(98, 53).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 16.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 53).addBox(-2.0F, 14.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 53).addBox(-2.0F, 22.0F, -3.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, -11.20F, 0.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(189, 53).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 16.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 53).addBox(-2.0F, 14.0F, -2.0F, 4.0F, 10.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 53).addBox(-1.0F, 22.0F, -3.0F, 3.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, -11.20F, 0.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(280, 53).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 10.40F, 2.0F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(LanternWraithEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart orb = this.root.getChild("body").getChild("orb"); Anims.pulse(orb, ageInTicks, 0.06F);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 6.28F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 7.85F);
    }
}
