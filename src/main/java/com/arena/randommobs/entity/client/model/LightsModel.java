package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.LightsEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LightsModel extends RMobModel<LightsEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/lights.png");
    public static final float SCALE = 0.57F;
    public static final float SHADOW = 0.50F;

    public LightsModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -8.0F, -9.0F, 14.0F, 13.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 0).addBox(-5.0F, -10.0F, -11.0F, 10.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(194, 0).addBox(-6.0F, -6.0F, -5.0F, 12.0F, 11.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.0F, -10.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(279, 0).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, -15.0F));
        PartDefinition leg_0 = body.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(324, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, 6.0F, -6.0F));
        PartDefinition leg_1 = body.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(357, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(5.0F, 6.0F, -6.0F));
        PartDefinition leg_2 = body.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(390, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, 6.0F, 6.0F));
        PartDefinition leg_3 = body.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(423, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(5.0F, 6.0F, 6.0F));
        return LayerDefinition.create(mesh, 512, 64);
    }

    @Override
    public void setupAnim(LightsEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("body").getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
        ModelPart leg_0 = this.root.getChild("body").getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_1 = this.root.getChild("body").getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_2 = this.root.getChild("body").getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_3 = this.root.getChild("body").getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 9.42F);
    }
}
