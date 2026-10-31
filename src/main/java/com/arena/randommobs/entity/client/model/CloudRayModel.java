package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.CloudRayEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CloudRayModel extends RMobModel<CloudRayEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/cloud_ray.png");
    public static final float SCALE = 0.66F;
    public static final float SHADOW = 1.60F;

    public CloudRayModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-9.0F, -4.0F, -14.0F, 18.0F, 7.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(185, 0).addBox(-26.0F, -3.0F, -10.0F, 18.0F, 3.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(346, 0).addBox(8.0F, -3.0F, -10.0F, 18.0F, 3.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 71).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, -14.0F));
        PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(73, 71).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-26.0F, -6.0F, 6.0F, 0.0F, 0.0F, -0.31F));
        PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(98, 71).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 22.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(26.0F, -6.0F, 6.0F, 0.0F, 0.0F, 0.31F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(123, 71).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, 0.35F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(CloudRayEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart wing_l = this.root.getChild("body").getChild("wing_l"); Anims.flapOne(wing_l, ageInTicks, 0.25F, 3.14F);
        ModelPart wing_r = this.root.getChild("body").getChild("wing_r"); Anims.flapOne(wing_r, ageInTicks, 0.25F, 4.71F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 6.28F);
    }
}
