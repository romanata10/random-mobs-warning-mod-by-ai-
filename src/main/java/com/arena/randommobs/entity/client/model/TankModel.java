package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TankEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TankModel extends RMobModel<TankEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tank.png");
    public static final float SCALE = 1.01F;
    public static final float SHADOW = 1.60F;

    public TankModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -8.0F, -22.0F, 32.0F, 14.0F, 44.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 117).addBox(-18.0F, 4.0F, -24.0F, 36.0F, 6.0F, 48.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 226).addBox(-14.0F, -12.0F, -20.0F, 28.0F, 5.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(273, 226).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 10.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 317).addBox(-2.0F, -5.0F, -26.0F, 4.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(89, 317).addBox(-3.0F, -6.0F, -28.0F, 6.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.0F, 4.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(TankEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
    }
}
