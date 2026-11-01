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
    public static final float SCALE = 1.10F;
    public static final float SHADOW = 0.30F;

    public WoodcockModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -3.0F, -7.0F, 10.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(69, 0).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(183, 0).addBox(-3.0F, 0.0F, 1.0F, 6.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(220, 0).addBox(-4.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 0).addBox(-2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 0).addBox(0.0F, -3.0F, 2.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(279, 0).addBox(2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 18.40F, 1.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(296, 0).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 3.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(349, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(382, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(431, 0).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 1.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(476, 0).addBox(-4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(485, 0).addBox(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.48F, -6.0F));
        PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(0, 25).addBox(-4.0F, -1.0F, -6.0F, 4.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 25).addBox(-3.0F, 0.0F, -5.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 25).addBox(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(131, 25).addBox(-4.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 25).addBox(-4.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(165, 25).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, -1.28F, -1.0F));
        PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(178, 25).addBox(0.0F, -1.0F, -6.0F, 4.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(243, 25).addBox(1.0F, 0.0F, -5.0F, 3.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 25).addBox(1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(309, 25).addBox(0.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(326, 25).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 25).addBox(1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(3.0F, -1.28F, -1.0F));
        PartDefinition leg_0 = body.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(356, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 25).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(398, 25).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 25).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-2.0F, 1.60F, -1.0F));
        PartDefinition leg_1 = body.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(448, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 25).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 54).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 54).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(2.0F, 1.60F, -1.0F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(WoodcockEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart wing_l = this.root.getChild("body").getChild("wing_l"); Anims.flapOne(wing_l, ageInTicks, 0.25F, 3.14F);
        ModelPart wing_r = this.root.getChild("body").getChild("wing_r"); Anims.flapOne(wing_r, ageInTicks, 0.25F, 4.71F);
        ModelPart leg_0 = this.root.getChild("body").getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_1 = this.root.getChild("body").getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 7.85F);
    }
}
