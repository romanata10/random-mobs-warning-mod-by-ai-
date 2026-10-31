package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.UfoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class UfoModel extends RMobModel<UfoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/ufo.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 1.60F;

    public UfoModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(),
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
                .texOffs(0, 0).addBox(-24.0F, -4.0F, -24.0F, 48.0F, 8.0F, 48.0F)
                .texOffs(0, 57).addBox(-14.0F, -8.0F, -14.0F, 28.0F, 4.0F, 28.0F),
                PartPose.offset(0.0F, 8.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(113, 57).addBox(-10.0F, -9.0F, -10.0F, 20.0F, 9.0F, 20.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition light_a = root.addOrReplaceChild("light_a", CubeListBuilder.create()
                .texOffs(194, 57).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 12.0F),
                PartPose.offset(20.0F, 8.0F, 0.0F));
        PartDefinition light_b = root.addOrReplaceChild("light_b", CubeListBuilder.create()
                .texOffs(0, 90).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 12.0F),
                PartPose.offset(-20.0F, 8.0F, 0.0F));
        PartDefinition light_c = root.addOrReplaceChild("light_c", CubeListBuilder.create()
                .texOffs(33, 90).addBox(-6.0F, -2.0F, -2.0F, 12.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 8.0F, 20.0F));
        PartDefinition light_d = root.addOrReplaceChild("light_d", CubeListBuilder.create()
                .texOffs(66, 90).addBox(-6.0F, -2.0F, -2.0F, 12.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 8.0F, -20.0F));
        return LayerDefinition.create(mesh, 256, 128);
    }

    @Override
    public void setupAnim(UfoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.head(this.head, netHeadYaw, headPitch);
        Anims.bob(this.body, ageInTicks, 0.6F);
    }
}
