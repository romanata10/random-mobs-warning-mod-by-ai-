package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SandWormEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SandWormModel extends RMobModel<SandWormEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/sand_worm.png");
    public static final float SCALE = 1.03F;
    public static final float SHADOW = 2.0F;

    public SandWormModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -16.0F, -10.0F, 32.0F, 30.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 0).addBox(-13.0F, -13.0F, -24.0F, 26.0F, 24.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 10.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 105).addBox(-11.0F, -11.0F, -8.0F, 22.0F, 22.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 105).addBox(-8.0F, -8.0F, -10.0F, 16.0F, 16.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -2.0F, -24.0F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create()
                .texOffs(206, 105).addBox(-10.0F, 0.0F, -3.0F, 20.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.0F, -30.0F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(SandWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart jaw = this.root.getChild("body").getChild("head").getChild("jaw"); Anims.jaw(jaw, ageInTicks, 0.18F);
    }
}
