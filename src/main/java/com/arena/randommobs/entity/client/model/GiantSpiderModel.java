package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GiantSpiderEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class GiantSpiderModel extends RMobModel<GiantSpiderEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/giant_spider.png");
    public static final float SCALE = 1.05F;
    public static final float SHADOW = 1.60F;

    public GiantSpiderModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_r0"), root.getChild("leg_r1"), root.getChild("leg_r2"), root.getChild("leg_r3"), root.getChild("leg_l0"), root.getChild("leg_l1"), root.getChild("leg_l2"), root.getChild("leg_l3")),
                List.of(),
                List.of(),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition abdomen = root.addOrReplaceChild("abdomen", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-12.0F, -10.0F, -15.0F, 24.0F, 20.0F, 30.0F),
                PartPose.offset(0.0F, 4.0F, 12.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(109, 0).addBox(-9.0F, -8.0F, -10.0F, 18.0F, 16.0F, 20.0F),
                PartPose.offset(0.0F, 4.0F, -4.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(186, 0).addBox(-7.0F, -6.0F, -8.0F, 14.0F, 12.0F, 16.0F)
                .texOffs(0, 51).addBox(-4.0F, -2.0F, -10.0F, 3.0F, 3.0F, 2.0F)
                .texOffs(11, 51).addBox(1.0F, -2.0F, -10.0F, 3.0F, 3.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, -16.0F));
        PartDefinition leg_r0 = root.addOrReplaceChild("leg_r0", CubeListBuilder.create()
                .texOffs(22, 51).addBox(0.0F, -1.0F, -1.0F, 26.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.35F, -0.56F));
        PartDefinition leg_r1 = root.addOrReplaceChild("leg_r1", CubeListBuilder.create()
                .texOffs(81, 51).addBox(0.0F, -1.0F, -1.0F, 30.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(9.0F, 0.0F, -2.0F, 0.0F, 0.14F, -0.38F));
        PartDefinition leg_r2 = root.addOrReplaceChild("leg_r2", CubeListBuilder.create()
                .texOffs(148, 51).addBox(0.0F, -1.0F, -1.0F, 30.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(9.0F, 0.0F, 4.0F, 0.0F, -0.14F, -0.38F));
        PartDefinition leg_r3 = root.addOrReplaceChild("leg_r3", CubeListBuilder.create()
                .texOffs(0, 58).addBox(0.0F, -1.0F, -1.0F, 26.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(8.0F, 0.0F, 10.0F, 0.0F, -0.35F, -0.56F));
        PartDefinition leg_l0 = root.addOrReplaceChild("leg_l0", CubeListBuilder.create()
                .texOffs(59, 58).addBox(-26.0F, -1.0F, -1.0F, 26.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-8.0F, 0.0F, -8.0F, 0.0F, -0.35F, 0.56F));
        PartDefinition leg_l1 = root.addOrReplaceChild("leg_l1", CubeListBuilder.create()
                .texOffs(118, 58).addBox(-30.0F, -1.0F, -1.0F, 30.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-9.0F, 0.0F, -2.0F, 0.0F, -0.14F, 0.38F));
        PartDefinition leg_l2 = root.addOrReplaceChild("leg_l2", CubeListBuilder.create()
                .texOffs(185, 58).addBox(-30.0F, -1.0F, -1.0F, 30.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-9.0F, 0.0F, 4.0F, 0.0F, 0.14F, 0.38F));
        PartDefinition leg_l3 = root.addOrReplaceChild("leg_l3", CubeListBuilder.create()
                .texOffs(0, 65).addBox(-26.0F, -1.0F, -1.0F, 26.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-8.0F, 0.0F, 10.0F, 0.0F, 0.35F, 0.56F));
        return LayerDefinition.create(mesh, 256, 128);
    }

    @Override
    public void setupAnim(GiantSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.45F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
