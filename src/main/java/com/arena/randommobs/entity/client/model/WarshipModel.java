package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WarshipEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WarshipModel extends RMobModel<WarshipEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/warship.png");
    public static final float SCALE = 1.37F;
    public static final float SHADOW = 3.0F;

    public WarshipModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-18.0F, -10.0F, -46.0F, 36.0F, 18.0F, 92.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 221).addBox(-14.0F, -18.0F, -34.0F, 28.0F, 9.0F, 60.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(353, 221).addBox(-6.0F, -30.0F, -18.0F, 12.0F, 13.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(482, 221).addBox(-2.0F, -46.0F, -6.0F, 3.0F, 18.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 360).addBox(-7.0F, -6.0F, -8.0F, 14.0F, 8.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 360).addBox(-1.0F, -4.0F, -22.0F, 2.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -18.0F, -40.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(WarshipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
    }
}
