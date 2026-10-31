package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.CircuitEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CircuitModel extends RMobModel<CircuitEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/circuit.png");
    public static final float SCALE = 0.80F;
    public static final float SHADOW = 0.80F;

    public CircuitModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -9.0F, -4.0F, 12.0F, 20.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(81, 0).addBox(-7.0F, 8.0F, -5.0F, 14.0F, 4.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(178, 0).addBox(-2.0F, -12.0F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -0.65F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(219, 0).addBox(-7.0F, -7.0F, -6.0F, 14.0F, 12.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(324, 0).addBox(-9.0F, -2.0F, -7.0F, 3.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(393, 0).addBox(6.0F, -2.0F, -7.0F, 3.0F, 8.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 57).addBox(-4.0F, -9.0F, -3.0F, 8.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.40F, 0.0F));
        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(57, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 14.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(82, 57).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, -2.40F, 0.0F, 0.0F, 0.0F, 0.10F));
        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(115, 57).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 14.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(140, 57).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 8.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(8.0F, -2.40F, 0.0F, 0.0F, 0.0F, -0.10F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(173, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.39F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 57).addBox(-3.0F, 1.85F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 7.35F, 0.0F, 0.0F, 0.0F, 0.23F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(239, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.84F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 57).addBox(-2.0F, 3.84F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 57).addBox(-3.0F, 5.84F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(306, 57).addBox(1.0F, 5.84F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.39F, 0.0F, 0.0F, 0.0F, 0.01F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(323, 57).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.39F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(348, 57).addBox(-3.0F, 1.85F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 7.35F, 0.0F, 0.0F, 0.0F, -0.23F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(389, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.84F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 57).addBox(-2.0F, 3.84F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(439, 57).addBox(-3.0F, 5.84F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(456, 57).addBox(1.0F, 5.84F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 7.39F, 0.0F, 0.0F, 0.0F, -0.01F));
        return LayerDefinition.create(mesh, 512, 128);
    }

    @Override
    public void setupAnim(CircuitEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
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
