package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.HollowNeighborEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class HollowNeighborModel extends RMobModel<HollowNeighborEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/hollow_neighbor.png");
    public static final float SCALE = 0.78F;
    public static final float SHADOW = 0.90F;

    public HollowNeighborModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -8.0F, -4.0F, 14.0F, 19.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(93, 0).addBox(-8.0F, 8.0F, -5.0F, 16.0F, 4.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(202, 0).addBox(-9.0F, 2.0F, -5.0F, 18.0F, 4.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 1.73F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(319, 0).addBox(-6.0F, -6.0F, -5.0F, 12.0F, 11.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 0).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 57).addBox(-7.0F, -7.0F, -4.0F, 14.0F, 3.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -13.60F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(93, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 15.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(118, 57).addBox(-2.0F, 13.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 57).addBox(-3.0F, 23.0F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -7.20F, 0.0F, 0.07F, 0.0F, 0.10F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(192, 57).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 15.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 57).addBox(-2.0F, 13.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 57).addBox(-2.0F, 23.0F, -3.0F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -7.20F, 0.0F, 0.07F, 0.0F, -0.10F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(291, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.15F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 57).addBox(-3.0F, 2.29F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 5.73F, 0.0F, 0.0F, 0.0F, 0.18F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(357, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.88F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(374, 57).addBox(-2.0F, 3.88F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(407, 57).addBox(-3.0F, 5.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 57).addBox(1.0F, 5.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.15F, 0.0F, 0.0F, 0.0F, 0.05F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(441, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.15F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(466, 57).addBox(-3.0F, 2.29F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 5.73F, 0.0F, 0.0F, 0.0F, -0.18F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(0, 94).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.88F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 94).addBox(-2.0F, 3.88F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 94).addBox(-3.0F, 5.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 94).addBox(1.0F, 5.88F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.15F, 0.0F, 0.0F, 0.0F, -0.05F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(HollowNeighborEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
    }
}
