package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SandWormEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class SandWormModel extends RMobModel<SandWormEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/sand_worm.png");
    public static final float SCALE = 1.15F;
    public static final float SHADOW = 1.40F;

    public SandWormModel(ModelPart root) {
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
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-12.0F, -12.0F, -7.0F, 24.0F, 24.0F, 14.0F)
                .texOffs(77, 0).addBox(-9.0F, -9.0F, -9.0F, 18.0F, 18.0F, 3.0F)
                .texOffs(120, 0).addBox(-8.0F, -10.0F, -10.0F, 3.0F, 3.0F, 4.0F)
                .texOffs(135, 0).addBox(5.0F, -10.0F, -10.0F, 3.0F, 3.0F, 4.0F)
                .texOffs(150, 0).addBox(-8.0F, 7.0F, -10.0F, 3.0F, 3.0F, 4.0F)
                .texOffs(165, 0).addBox(5.0F, 7.0F, -10.0F, 3.0F, 3.0F, 4.0F),
                PartPose.offset(0.0F, -2.0F, -26.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 39).addBox(-11.0F, -11.0F, -8.0F, 22.0F, 22.0F, 22.0F),
                PartPose.offset(0.0F, 0.0F, -6.0F));
        PartDefinition seg2 = root.addOrReplaceChild("seg2", CubeListBuilder.create()
                .texOffs(89, 39).addBox(-9.0F, -9.0F, -6.0F, 18.0F, 18.0F, 18.0F),
                PartPose.offset(0.0F, 3.0F, 12.0F));
        PartDefinition seg3 = root.addOrReplaceChild("seg3", CubeListBuilder.create()
                .texOffs(162, 39).addBox(-7.0F, -7.0F, -6.0F, 14.0F, 14.0F, 18.0F),
                PartPose.offset(0.0F, 6.0F, 26.0F));
        PartDefinition seg4 = root.addOrReplaceChild("seg4", CubeListBuilder.create()
                .texOffs(0, 84).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 10.0F, 16.0F),
                PartPose.offset(0.0F, 8.0F, 40.0F));
        return LayerDefinition.create(mesh, 256, 128);
    }

    @Override
    public void setupAnim(SandWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
