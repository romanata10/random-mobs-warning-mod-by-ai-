package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AliveHouseEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class AliveHouseModel extends RMobModel<AliveHouseEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/alive_house.png");
    public static final float SCALE = 1.12F;
    public static final float SHADOW = 2.40F;

    public AliveHouseModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b"), root.getChild("leg_c"), root.getChild("leg_d")),
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
                .texOffs(0, 0).addBox(-24.0F, -22.0F, -20.0F, 48.0F, 40.0F, 40.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));
        PartDefinition roof = root.addOrReplaceChild("roof", CubeListBuilder.create()
                .texOffs(0, 81).addBox(-27.0F, -7.0F, -23.0F, 54.0F, 8.0F, 46.0F)
                .texOffs(0, 136).addBox(-20.0F, -12.0F, -16.0F, 40.0F, 5.0F, 32.0F),
                PartPose.offset(0.0F, -28.0F, 0.0F));
        PartDefinition door = root.addOrReplaceChild("door", CubeListBuilder.create()
                .texOffs(145, 136).addBox(-6.0F, -18.0F, -1.0F, 12.0F, 22.0F, 2.0F)
                .texOffs(174, 136).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 12.0F, -20.0F));
        PartDefinition window_r = root.addOrReplaceChild("window_r", CubeListBuilder.create()
                .texOffs(183, 136).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 2.0F),
                PartPose.offset(15.0F, -2.0F, -20.0F));
        PartDefinition window_l = root.addOrReplaceChild("window_l", CubeListBuilder.create()
                .texOffs(208, 136).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 2.0F),
                PartPose.offset(-15.0F, -2.0F, -20.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(233, 136).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(16.0F, 14.0F, 14.0F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(0, 174).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(-16.0F, 14.0F, 14.0F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(17, 174).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(16.0F, 14.0F, -14.0F));
        PartDefinition leg_d = root.addOrReplaceChild("leg_d", CubeListBuilder.create()
                .texOffs(34, 174).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(-16.0F, 14.0F, -14.0F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public void setupAnim(AliveHouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
    }
}
