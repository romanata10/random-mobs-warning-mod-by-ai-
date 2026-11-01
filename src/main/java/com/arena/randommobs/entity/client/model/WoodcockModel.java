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
    public static final float SCALE = 1.06F;
    public static final float SHADOW = 0.30F;

    public WoodcockModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 0).addBox(-5.0F, -3.0F, -4.0F, 3.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(78, 0).addBox(2.0F, -3.0F, -4.0F, 3.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(115, 0).addBox(-2.0F, -3.0F, -7.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(144, 0).addBox(-2.0F, -3.0F, 2.0F, 4.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 0).addBox(-2.0F, 1.0F, -4.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 0).addBox(-4.0F, 1.0F, -4.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 0).addBox(2.0F, 1.0F, -4.0F, 2.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(280, 0).addBox(-2.0F, 1.0F, -6.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(305, 0).addBox(-2.0F, 1.0F, 2.0F, 4.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(330, 0).addBox(-4.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(347, 0).addBox(-2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(368, 0).addBox(0.0F, -3.0F, 2.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 0).addBox(2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 17.60F, 1.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(406, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 0).addBox(-3.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(440, 0).addBox(1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(457, 0).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(474, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 21).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 21).addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 21).addBox(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(43, 21).addBox(0.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(52, 21).addBox(-1.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(61, 21).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(102, 21).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(127, 21).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(152, 21).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.16F, -6.0F));
        PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create()
                .texOffs(177, 21).addBox(-3.0F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(230, 21).addBox(-4.0F, -2.0F, -5.0F, 1.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(275, 21).addBox(0.0F, -2.0F, -5.0F, 1.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 21).addBox(-3.0F, -2.0F, -6.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 21).addBox(-3.0F, -2.0F, 5.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 21).addBox(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 21).addBox(-4.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(384, 21).addBox(-4.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 21).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, -0.96F, -1.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create()
                .texOffs(414, 21).addBox(0.0F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(467, 21).addBox(-1.0F, -2.0F, -5.0F, 1.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 48).addBox(3.0F, -2.0F, -5.0F, 1.0F, 3.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(45, 48).addBox(0.0F, -2.0F, -6.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(62, 48).addBox(0.0F, -2.0F, 5.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(79, 48).addBox(-2.0F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(92, 48).addBox(-3.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 48).addBox(-3.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 48).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, -0.96F, -1.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition leg_0 = body.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(139, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 48).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 48).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 48).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-2.0F, 2.24F, -1.0F));
        PartDefinition leg_1 = body.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(231, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(248, 48).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 48).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 48).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(2.0F, 2.24F, -1.0F));
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
