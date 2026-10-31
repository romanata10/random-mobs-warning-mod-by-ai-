package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GardenerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class GardenerModel extends RMobModel<GardenerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/gardener.png");
    public static final float SCALE = 0.48F;
    public static final float SHADOW = 1.20F;

    public GardenerModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-12.0F, -12.0F, -12.0F, 24.0F, 24.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 0).addBox(-16.0F, 8.0F, -8.0F, 32.0F, 8.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -25.98F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 97).addBox(-9.0F, -9.0F, -9.0F, 18.0F, 9.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -22.0F, 0.0F));
        PartDefinition orb = head.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(145, 97).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -30.0F, 0.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(226, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 30.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 12.0F, -9.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(259, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 32.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.50F, 12.0F, 9.0F, 0.0F, 0.0F, -0.09F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(292, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 34.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, -9.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(325, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 36.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.50F, 12.0F, 9.0F, 0.0F, 0.0F, 0.09F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(358, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 38.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 12.0F, -9.0F, 0.0F, 0.0F, 0.17F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(GardenerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart orb = this.root.getChild("body").getChild("head").getChild("orb"); Anims.pulse(orb, ageInTicks, 0.06F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 4.71F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 9.42F);
        ModelPart tentacle_4 = this.root.getChild("body").getChild("tentacle_4"); Anims.swayOne(tentacle_4, ageInTicks, 0.09F, 11.00F);
    }
}
