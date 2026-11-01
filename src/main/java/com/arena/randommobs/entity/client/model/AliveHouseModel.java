package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AliveHouseEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class AliveHouseModel extends RMobModel<AliveHouseEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/alive_house.png");
    public static final float SCALE = 0.94F;
    public static final float SHADOW = 2.40F;

    public AliveHouseModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-16.0F, -10.0F, -14.0F, 32.0F, 24.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 0).addBox(-17.0F, -10.0F, -15.0F, 34.0F, 2.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 105).addBox(-18.0F, -19.0F, -16.0F, 36.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 105).addBox(-18.0F, -19.0F, 2.0F, 36.0F, 6.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 146).addBox(-12.0F, -26.0F, -12.0F, 24.0F, 6.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 146).addBox(-6.0F, -31.0F, -6.0F, 12.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 146).addBox(7.0F, -34.0F, 5.0F, 5.0F, 14.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(331, 146).addBox(-18.0F, 13.0F, -6.0F, 4.0F, 6.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(396, 146).addBox(-14.0F, -2.0F, -15.0F, 6.0F, 8.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 146).addBox(3.0F, -2.0F, -15.0F, 5.0F, 8.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(450, 146).addBox(10.0F, -2.0F, -15.0F, 5.0F, 8.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 146).addBox(-3.0F, 2.0F, -16.0F, 6.0F, 14.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 207).addBox(-16.0F, 0.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 207).addBox(-10.0F, 0.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 207).addBox(-3.0F, 0.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(51, 207).addBox(3.0F, 0.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(68, 207).addBox(10.0F, 0.0F, -15.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -18.45F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(85, 207).addBox(-8.0F, -18.0F, -2.0F, 16.0F, 18.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 207).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.0F, -15.0F));
        PartDefinition eye_l = body.addOrReplaceChild("eye_l", CubeListBuilder.create()
                .texOffs(195, 207).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, -3.20F, -17.0F));
        PartDefinition eye_r = body.addOrReplaceChild("eye_r", CubeListBuilder.create()
                .texOffs(216, 207).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(5.0F, -3.20F, -17.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(237, 207).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.06F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(294, 207).addBox(-3.0F, 1.55F, -3.0F, 5.0F, 6.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(335, 207).addBox(-2.0F, 7.48F, -2.0F, 3.0F, 3.87F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(360, 207).addBox(-3.0F, 7.90F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, -7.25F, -9.0F, 0.0F, 0.0F, 0.21F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(409, 207).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 6.65F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(450, 207).addBox(-2.0F, 5.91F, -2.0F, 3.0F, 5.91F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 207).addBox(-2.0F, 9.77F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 250).addBox(-2.0F, 11.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 250).addBox(-3.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 250).addBox(1.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 12.60F, 0.0F, 0.0F, 0.0F, -0.06F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(91, 250).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.06F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(148, 250).addBox(-3.0F, 1.55F, -3.0F, 5.0F, 6.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(189, 250).addBox(-2.0F, 7.48F, -2.0F, 3.0F, 3.87F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 250).addBox(-3.0F, 7.90F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, -7.25F, -9.0F, 0.0F, 0.0F, -0.21F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(263, 250).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 6.65F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(304, 250).addBox(-2.0F, 5.91F, -2.0F, 3.0F, 5.91F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(329, 250).addBox(-2.0F, 9.77F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 250).addBox(-2.0F, 11.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 250).addBox(-3.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 250).addBox(1.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 12.60F, 0.0F, 0.0F, 0.0F, 0.06F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(445, 250).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.06F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 274).addBox(-3.0F, 1.55F, -3.0F, 5.0F, 6.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 274).addBox(-2.0F, 7.48F, -2.0F, 3.0F, 3.87F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 274).addBox(-3.0F, 7.90F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, -7.25F, 9.0F, 0.0F, 0.0F, 0.21F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(115, 274).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 6.65F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(156, 274).addBox(-2.0F, 5.91F, -2.0F, 3.0F, 5.91F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(181, 274).addBox(-2.0F, 9.77F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(206, 274).addBox(-2.0F, 11.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(247, 274).addBox(-3.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 274).addBox(1.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.75F, 12.60F, 0.0F, 0.0F, 0.0F, -0.06F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(297, 274).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.06F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 274).addBox(-3.0F, 1.55F, -3.0F, 5.0F, 6.45F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 274).addBox(-2.0F, 7.48F, -2.0F, 3.0F, 3.87F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 274).addBox(-3.0F, 7.90F, -3.0F, 6.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(10.0F, -7.25F, 9.0F, 0.0F, 0.0F, -0.21F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(469, 274).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 6.65F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 298).addBox(-2.0F, 5.91F, -2.0F, 3.0F, 5.91F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 298).addBox(-2.0F, 9.77F, -2.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 298).addBox(-2.0F, 11.77F, -3.0F, 4.0F, 3.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 298).addBox(-3.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 298).addBox(1.0F, 14.77F, -3.0F, 2.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(2.75F, 12.60F, 0.0F, 0.0F, 0.0F, 0.06F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(AliveHouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye_l = this.root.getChild("body").getChild("eye_l"); Anims.pulse(eye_l, ageInTicks, 0.06F);
        ModelPart eye_r = this.root.getChild("body").getChild("eye_r"); Anims.pulse(eye_r, ageInTicks, 0.06F);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
    }
}
