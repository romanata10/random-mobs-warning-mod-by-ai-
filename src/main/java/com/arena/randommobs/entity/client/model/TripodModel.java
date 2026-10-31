package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TripodEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class TripodModel extends RMobModel<TripodEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tripod.png");
    public static final float SCALE = 1.32F;
    public static final float SHADOW = 2.0F;

    public TripodModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b"), root.getChild("leg_c")),
                List.of(),
                List.of(),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -12.0F, -11.0F, 22.0F, 24.0F, 22.0F)
                .texOffs(89, 0).addBox(-7.0F, -10.0F, -12.0F, 14.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -20.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(122, 0).addBox(-8.0F, -9.0F, -8.0F, 16.0F, 11.0F, 16.0F),
                PartPose.offset(0.0F, -34.0F, 0.0F));
        PartDefinition eye = root.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(187, 0).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F),
                PartPose.offset(0.0F, -37.0F, -7.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(210, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 38.0F, 4.0F),
                PartPose.offsetAndRotation(11.0F, -12.0F, 8.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(227, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 38.0F, 4.0F),
                PartPose.offsetAndRotation(-11.0F, -12.0F, 8.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(0, 47).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 38.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -12.0F, -12.0F, 0.17F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 128);
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.45F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
