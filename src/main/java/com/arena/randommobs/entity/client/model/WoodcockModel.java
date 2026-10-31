package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WoodcockEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class WoodcockModel extends RMobModel<WoodcockEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/woodcock.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 0.30F;

    public WoodcockModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b")),
                List.of(),
                List.of(),
                List.of(root.getChild("wing_r"), root.getChild("wing_l")),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -6.0F, -7.0F, 10.0F, 12.0F, 14.0F)
                .texOffs(49, 0).addBox(-4.0F, 4.0F, -5.0F, 8.0F, 4.0F, 10.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(86, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F)
                .texOffs(119, 0).addBox(-3.0F, -2.0F, -5.0F, 2.0F, 2.0F, 1.0F)
                .texOffs(126, 0).addBox(1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 1.0F),
                PartPose.offset(0.0F, 8.0F, -7.0F));
        PartDefinition wing_r = root.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(133, 0).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 8.0F, 12.0F),
                PartPose.offset(5.0F, 12.0F, 0.0F));
        PartDefinition wing_l = root.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(162, 0).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 8.0F, 12.0F),
                PartPose.offset(-5.0F, 12.0F, 0.0F));
        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(191, 0).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, 7.0F));
        PartDefinition beak = root.addOrReplaceChild("beak", CubeListBuilder.create()
                .texOffs(216, 0).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offset(0.0F, 10.0F, -11.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(239, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offset(2.0F, 22.0F, 0.0F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(248, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offset(-2.0F, 22.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 64);
    }

    @Override
    public void setupAnim(WoodcockEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
        Anims.flap(this.wings, ageInTicks, 0.25F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
