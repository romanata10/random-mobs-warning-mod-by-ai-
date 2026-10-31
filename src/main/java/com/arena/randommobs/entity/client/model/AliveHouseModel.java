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
    public static final float SCALE = 0.68F;
    public static final float SHADOW = 1.80F;

    public AliveHouseModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-20.0F, -22.0F, -18.0F, 40.0F, 34.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 141).addBox(-21.0F, -2.0F, -19.0F, 42.0F, 4.0F, 38.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 226).addBox(-22.0F, 12.0F, -20.0F, 44.0F, 6.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -27.51F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 319).addBox(-24.0F, -10.0F, -20.0F, 48.0F, 14.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 428).addBox(-16.0F, -18.0F, -14.0F, 32.0F, 9.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 428).addBox(6.0F, -30.0F, 6.0F, 7.0F, 14.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -24.0F, 0.0F));
        PartDefinition eye_l = body.addOrReplaceChild("eye_l", CubeListBuilder.create()
                .texOffs(298, 428).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-9.0F, 19.60F, -18.0F));
        PartDefinition eye_r = body.addOrReplaceChild("eye_r", CubeListBuilder.create()
                .texOffs(331, 428).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(9.0F, 19.60F, -18.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(364, 428).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.02F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(413, 428).addBox(-4.0F, 3.26F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, -1.91F, -10.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_a_low = leg_a.addOrReplaceChild("leg_a_low", CubeListBuilder.create()
                .texOffs(0, 503).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 9.86F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 503).addBox(-2.0F, 7.86F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(74, 503).addBox(-3.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(91, 503).addBox(1.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 13.02F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(108, 503).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.02F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 503).addBox(-4.0F, 3.26F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, -1.91F, -10.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_b_low = leg_b.addOrReplaceChild("leg_b_low", CubeListBuilder.create()
                .texOffs(222, 503).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 9.86F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 503).addBox(-2.0F, 7.86F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(296, 503).addBox(-3.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(313, 503).addBox(1.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 13.02F, 0.0F, 0.0F, 0.0F, -0.02F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(330, 503).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.02F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(379, 503).addBox(-4.0F, 3.26F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, -1.91F, 12.0F, 0.0F, 0.0F, 0.26F));
        PartDefinition leg_c_low = leg_c.addOrReplaceChild("leg_c_low", CubeListBuilder.create()
                .texOffs(444, 503).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 9.86F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 542).addBox(-2.0F, 7.86F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 542).addBox(-3.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(50, 542).addBox(1.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 13.02F, 0.0F, 0.0F, 0.0F, 0.02F));
        PartDefinition leg_d = root.addOrReplaceChild("leg_d", CubeListBuilder.create()
                .texOffs(67, 542).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.02F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(116, 542).addBox(-4.0F, 3.26F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, -1.91F, 12.0F, 0.0F, 0.0F, -0.26F));
        PartDefinition leg_d_low = leg_d.addOrReplaceChild("leg_d_low", CubeListBuilder.create()
                .texOffs(181, 542).addBox(-2.0F, 0.0F, -2.0F, 5.0F, 9.86F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(222, 542).addBox(-2.0F, 7.86F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(255, 542).addBox(-3.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(272, 542).addBox(1.0F, 9.86F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 13.02F, 0.0F, 0.0F, 0.0F, -0.02F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(AliveHouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart eye_l = this.root.getChild("body").getChild("eye_l"); Anims.pulse(eye_l, ageInTicks, 0.06F);
        ModelPart eye_r = this.root.getChild("body").getChild("eye_r"); Anims.pulse(eye_r, ageInTicks, 0.06F);
        ModelPart leg_a = this.root.getChild("leg_a"); Anims.swing(leg_a, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_a_low = this.root.getChild("leg_a").getChild("leg_a_low"); Anims.swing(leg_a_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_b_low = this.root.getChild("leg_b").getChild("leg_b_low"); Anims.swing(leg_b_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_c = this.root.getChild("leg_c"); Anims.swing(leg_c, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_c_low = this.root.getChild("leg_c").getChild("leg_c_low"); Anims.swing(leg_c_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
        ModelPart leg_d = this.root.getChild("leg_d"); Anims.swing(leg_d, limbSwing, limbSwingAmount, 0.95F, 15.71F);
        ModelPart leg_d_low = this.root.getChild("leg_d").getChild("leg_d_low"); Anims.swing(leg_d_low, limbSwing, limbSwingAmount, 0.45F, 17.28F);
    }
}
