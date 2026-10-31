package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BearEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BearModel extends RMobModel<BearEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bear.png");
    public static final float SCALE = 0.67F;
    public static final float SHADOW = 1.0F;

    public BearModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-9.0F, -10.0F, -14.0F, 18.0F, 18.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 0).addBox(-7.0F, -14.0F, -16.0F, 14.0F, 6.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 2.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(322, 0).addBox(-7.0F, -7.0F, -8.0F, 14.0F, 13.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 0).addBox(-3.0F, -2.0F, -11.0F, 6.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -12.0F, -16.0F));
        PartDefinition leg_0 = body.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(0, 97).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-6.0F, 8.0F, -8.0F));
        PartDefinition leg_1 = body.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(49, 97).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(6.0F, 8.0F, -8.0F));
        PartDefinition leg_2 = body.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(98, 97).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-6.0F, 8.0F, 10.0F));
        PartDefinition leg_3 = body.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(147, 97).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(6.0F, 8.0F, 10.0F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("body").getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_1 = this.root.getChild("body").getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_2 = this.root.getChild("body").getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_3 = this.root.getChild("body").getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 7.85F);
    }
}
