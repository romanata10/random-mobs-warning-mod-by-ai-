package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.EvilWatermelonEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class EvilWatermelonModel extends RMobModel<EvilWatermelonEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/evil_watermelon.png");
    public static final float SCALE = 0.85F;
    public static final float SHADOW = 0.50F;

    public EvilWatermelonModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b")),
                List.of(),
                List.of(),
                List.of(),
                null,
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-9.0F, -10.0F, -9.0F, 18.0F, 18.0F, 18.0F)
                .texOffs(73, 0).addBox(-4.0F, 0.0F, -10.0F, 3.0F, 4.0F, 2.0F)
                .texOffs(84, 0).addBox(1.0F, 0.0F, -10.0F, 3.0F, 4.0F, 2.0F)
                .texOffs(95, 0).addBox(-4.0F, 6.0F, -10.0F, 8.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(116, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offset(3.0F, 18.0F, 0.0F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(133, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offset(-3.0F, 18.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 64);
    }

    @Override
    public void setupAnim(EvilWatermelonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
    }
}
