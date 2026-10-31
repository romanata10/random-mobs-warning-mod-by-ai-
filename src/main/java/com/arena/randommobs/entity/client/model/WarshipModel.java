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
    public static final float SCALE = 1.07F;
    public static final float SHADOW = 3.0F;

    public WarshipModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -10.0F, -46.0F, 32.0F, 20.0F, 92.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 225).addBox(-13.0F, -16.0F, -40.0F, 26.0F, 8.0F, 80.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 402).addBox(-15.0F, 10.0F, -44.0F, 30.0F, 4.0F, 88.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.60F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 587).addBox(-10.0F, -14.0F, -12.0F, 20.0F, 15.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 587).addBox(-7.0F, -22.0F, -8.0F, 14.0F, 8.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 587).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 587).addBox(-1.0F, -32.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 587).addBox(-6.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -32.0F, 6.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(0, 666).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 10.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 666).addBox(-2.0F, -4.0F, -16.0F, 4.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-4.0F, 1.60F, -26.0F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(162, 666).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 10.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 666).addBox(-2.0F, -4.0F, -16.0F, 4.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(4.0F, 1.60F, -4.0F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(WarshipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart arm_l = this.root.getChild("body").getChild("arm_l"); Anims.swing(arm_l, limbSwing, limbSwingAmount, 0.6F, 3.14F);
        ModelPart arm_r = this.root.getChild("body").getChild("arm_r"); Anims.swing(arm_r, limbSwing, limbSwingAmount, 0.6F, 4.71F);
    }
}
