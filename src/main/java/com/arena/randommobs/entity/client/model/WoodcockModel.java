package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WoodcockEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class WoodcockModel extends RMobModel<WoodcockEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/woodcock.png");
    public static final float SCALE = 0.48F;
    public static final float SHADOW = 0.30F;

    public WoodcockModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 8.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(81, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(130, 0).addBox(-1.0F, -3.0F, -10.0F, 2.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 9.0F, -6.0F));
        PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(167, 0).addBox(-2.0F, 0.0F, -5.0F, 2.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-4.0F, 9.0F, 0.0F));
        PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(216, 0).addBox(0.0F, 0.0F, -5.0F, 2.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(4.0F, 9.0F, 0.0F));
        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(265, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-2.0F, 16.0F, 0.0F));
        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(282, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(2.0F, 16.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 64);
    }

    @Override
    public void setupAnim(WoodcockEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart wing_l = this.root.getChild("body").getChild("wing_l"); Anims.flapOne(wing_l, ageInTicks, 0.25F, 3.14F);
        ModelPart wing_r = this.root.getChild("body").getChild("wing_r"); Anims.flapOne(wing_r, ageInTicks, 0.25F, 4.71F);
        ModelPart leg_l = this.root.getChild("body").getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_r = this.root.getChild("body").getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 7.85F);
    }
}
