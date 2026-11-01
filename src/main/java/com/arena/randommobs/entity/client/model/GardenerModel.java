package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GardenerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class GardenerModel extends RMobModel<GardenerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/gardener.png");
    public static final float SCALE = 0.93F;
    public static final float SHADOW = 1.20F;

    public GardenerModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7.0F, -10.0F, -5.0F, 14.0F, 20.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 0).addBox(-9.0F, 5.0F, -6.0F, 18.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 0).addBox(-8.0F, 10.0F, -6.0F, 16.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 0).addBox(-6.0F, 15.0F, -5.0F, 12.0F, 6.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 0).addBox(-7.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(437, 0).addBox(-5.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(454, 0).addBox(-2.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(471, 0).addBox(1.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(488, 0).addBox(4.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 61).addBox(-6.0F, 5.0F, -5.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(21, 61).addBox(-3.0F, 5.0F, -5.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 61).addBox(0.0F, 5.0F, -5.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(63, 61).addBox(3.0F, 5.0F, -5.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 61).addBox(-8.0F, 4.0F, -6.0F, 16.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(197, 61).addBox(4.0F, 5.0F, -7.0F, 3.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -3.90F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(218, 61).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 9.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(315, 61).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 5.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(428, 61).addBox(-5.0F, 2.0F, -8.0F, 10.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(481, 61).addBox(-4.0F, -1.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(494, 61).addBox(2.0F, -1.0F, -8.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -13.60F, 0.0F));
        PartDefinition orb = head.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(0, 104).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 5.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 104).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 104).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 1.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 104).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -9.60F, 0.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(212, 104).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(237, 104).addBox(-1.0F, 9.0F, -1.0F, 2.0F, 9.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(254, 104).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(275, 104).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 104).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 3.20F, -3.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(317, 104).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(342, 104).addBox(-1.0F, 9.0F, -1.0F, 2.0F, 9.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(359, 104).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(380, 104).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(401, 104).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 3.20F, -3.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(422, 104).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(447, 104).addBox(-1.0F, 9.0F, -1.0F, 2.0F, 9.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(464, 104).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(485, 104).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 131).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.0F, 3.20F, 1.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(21, 131).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(46, 131).addBox(-1.0F, 9.0F, -1.0F, 2.0F, 9.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(63, 131).addBox(-4.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 131).addBox(-2.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 131).addBox(0.0F, 3.0F, -3.0F, 2.0F, 1.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.0F, 3.20F, 1.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(126, 131).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(167, 131).addBox(-2.0F, 0.59F, -2.0F, 3.0F, 2.44F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(192, 131).addBox(-1.0F, 2.83F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 131).addBox(-2.0F, 1.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 11.30F, 0.0F, 0.0F, 0.0F, 0.34F));
        PartDefinition leg_l_low = leg_l.addOrReplaceChild("leg_l_low", CubeListBuilder.create()
                .texOffs(234, 131).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 131).addBox(-1.0F, 1.76F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 131).addBox(-1.0F, 1.41F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 131).addBox(-2.0F, 1.41F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 131).addBox(-3.0F, 4.41F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 131).addBox(1.0F, 4.41F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-1.65F, 4.60F, 0.0F, 0.0F, 0.0F, -0.03F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(368, 131).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(409, 131).addBox(-2.0F, 0.59F, -2.0F, 3.0F, 2.44F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 131).addBox(-1.0F, 2.83F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(443, 131).addBox(-2.0F, 1.89F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 11.30F, 0.0F, 0.0F, 0.0F, -0.34F));
        PartDefinition leg_r_low = leg_r.addOrReplaceChild("leg_r_low", CubeListBuilder.create()
                .texOffs(476, 131).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(501, 131).addBox(-1.0F, 1.76F, -1.0F, 1.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 158).addBox(-1.0F, 1.41F, -1.0F, 1.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(9, 158).addBox(-2.0F, 1.41F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 158).addBox(-3.0F, 4.41F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(75, 158).addBox(1.0F, 4.41F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(1.65F, 4.60F, 0.0F, 0.0F, 0.0F, 0.03F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(GardenerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart orb = this.root.getChild("body").getChild("head").getChild("orb"); Anims.pulse(orb, ageInTicks, 0.06F);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 4.71F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 9.42F);
        ModelPart leg_l = this.root.getChild("leg_l"); Anims.swing(leg_l, limbSwing, limbSwingAmount, 0.95F, 11.00F);
        ModelPart leg_l_low = this.root.getChild("leg_l").getChild("leg_l_low"); Anims.swing(leg_l_low, limbSwing, limbSwingAmount, 0.45F, 12.57F);
        ModelPart leg_r = this.root.getChild("leg_r"); Anims.swing(leg_r, limbSwing, limbSwingAmount, 0.95F, 14.14F);
        ModelPart leg_r_low = this.root.getChild("leg_r").getChild("leg_r_low"); Anims.swing(leg_r_low, limbSwing, limbSwingAmount, 0.45F, 15.71F);
    }
}
