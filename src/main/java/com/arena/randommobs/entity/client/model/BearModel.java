package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BearEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class BearModel extends RMobModel<BearEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bear.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 0.90F;

    public BearModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b"), root.getChild("leg_c"), root.getChild("leg_d")),
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
                .texOffs(0, 0).addBox(-7.0F, -8.0F, -13.0F, 14.0F, 16.0F, 26.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(81, 0).addBox(-6.0F, -7.0F, -8.0F, 12.0F, 12.0F, 12.0F)
                .texOffs(130, 0).addBox(-4.0F, 1.0F, -11.0F, 8.0F, 5.0F, 4.0F)
                .texOffs(155, 0).addBox(-2.0F, 2.0F, -12.0F, 4.0F, 3.0F, 2.0F)
                .texOffs(168, 0).addBox(-5.0F, -9.0F, -3.0F, 3.0F, 3.0F, 3.0F)
                .texOffs(181, 0).addBox(2.0F, -9.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offset(0.0F, 2.0F, -13.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(194, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(5.0F, 10.0F, -9.0F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(211, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(-5.0F, 10.0F, -9.0F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(228, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(5.0F, 10.0F, 9.0F));
        PartDefinition leg_d = root.addOrReplaceChild("leg_d", CubeListBuilder.create()
                .texOffs(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(-5.0F, 10.0F, 9.0F));
        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(17, 43).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 13.0F));
        return LayerDefinition.create(mesh, 256, 64);
    }

    @Override
    public void setupAnim(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
