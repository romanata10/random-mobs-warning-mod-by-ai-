package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TripodEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TripodModel extends RMobModel<TripodEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tripod.png");
    public static final float SCALE = 1.02F;
    public static final float SHADOW = 2.20F;

    public TripodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-12.0F, -13.0F, -12.0F, 24.0F, 26.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 0).addBox(-14.0F, -4.0F, -8.0F, 28.0F, 7.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 0).addBox(-6.0F, -16.0F, -13.0F, 12.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -27.05F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 101).addBox(-9.0F, -10.0F, -9.0F, 18.0F, 12.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 101).addBox(-5.0F, -7.0F, -10.0F, 10.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -39.05F, 0.0F));
        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(194, 101).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -33.0F, -8.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(239, 101).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 22.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.0F, -17.05F, 9.0F, -0.21F, 0.0F, -0.16F));
        PartDefinition leg_a_low = leg_a.addOrReplaceChild("leg_a_low", CubeListBuilder.create()
                .texOffs(288, 101).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 20.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.24F, 0.0F, 0.07F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(321, 101).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 22.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.0F, -17.05F, 9.0F, -0.21F, 0.0F, 0.16F));
        PartDefinition leg_b_low = leg_b.addOrReplaceChild("leg_b_low", CubeListBuilder.create()
                .texOffs(370, 101).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 20.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.24F, 0.0F, -0.07F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(403, 101).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 22.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -17.05F, -13.0F, 0.24F, 0.0F, 0.0F));
        PartDefinition leg_c_low = leg_c.addOrReplaceChild("leg_c_low", CubeListBuilder.create()
                .texOffs(452, 101).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 20.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, -0.28F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(TripodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye = this.root.getChild("head").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
        ModelPart leg_a = this.root.getChild("leg_a"); Anims.swing(leg_a, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_a_low = this.root.getChild("leg_a").getChild("leg_a_low"); Anims.swing(leg_a_low, limbSwing, limbSwingAmount, 0.45F, 6.28F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 7.85F);
        ModelPart leg_b_low = this.root.getChild("leg_b").getChild("leg_b_low"); Anims.swing(leg_b_low, limbSwing, limbSwingAmount, 0.45F, 9.42F);
        ModelPart leg_c = this.root.getChild("leg_c"); Anims.swing(leg_c, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_c_low = this.root.getChild("leg_c").getChild("leg_c_low"); Anims.swing(leg_c_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
    }
}
