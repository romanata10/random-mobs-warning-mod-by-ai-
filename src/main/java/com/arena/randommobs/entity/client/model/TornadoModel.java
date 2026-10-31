package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TornadoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TornadoModel extends RMobModel<TornadoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tornado.png");
    public static final float SCALE = 2.04F;
    public static final float SHADOW = 0.0F;

    public TornadoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-26.0F, -10.0F, -26.0F, 52.0F, 20.0F, 52.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 145).addBox(-18.0F, 10.0F, -18.0F, 36.0F, 25.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 145).addBox(-11.0F, 35.0F, -11.0F, 22.0F, 25.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 268).addBox(-6.0F, 60.0F, -6.0F, 12.0F, 24.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -60.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TornadoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.spin(body, ageInTicks, 0.35F);
    }
}
