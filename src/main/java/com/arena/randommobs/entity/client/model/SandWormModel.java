package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SandWormEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SandWormModel extends RMobModel<SandWormEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/sand_worm.png");
    public static final float SCALE = 1.15F;
    public static final float SHADOW = 2.0F;

    public SandWormModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-15.0F, 32.0F, -15.0F, 30.0F, 2.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 0).addBox(-13.0F, 30.0F, -13.0F, 26.0F, 2.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 65).addBox(-11.0F, 29.0F, -11.0F, 22.0F, 2.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 65).addBox(-9.0F, 29.44F, -10.0F, 19.0F, 4.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(330, 65).addBox(-7.0F, 28.44F, -8.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 114).addBox(-9.0F, 26.40F, -10.0F, 19.0F, 4.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 114).addBox(-7.0F, 25.40F, -8.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 114).addBox(-9.0F, 23.36F, -10.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 161).addBox(-6.0F, 22.36F, -7.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 161).addBox(-9.0F, 20.32F, -10.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 161).addBox(-6.0F, 19.32F, -7.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 161).addBox(-9.0F, 17.28F, -11.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 206).addBox(-6.0F, 16.28F, -8.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 206).addBox(-8.0F, 14.24F, -10.0F, 17.0F, 4.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 206).addBox(-6.0F, 13.24F, -8.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 206).addBox(9.0F, 16.0F, -2.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 206).addBox(7.0F, 16.0F, 4.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(373, 206).addBox(2.0F, 16.0F, 8.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(390, 206).addBox(-4.0F, 16.0F, 8.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(407, 206).addBox(-9.0F, 16.0F, 4.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 206).addBox(-11.0F, 16.0F, -2.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(441, 206).addBox(-9.0F, 16.0F, -8.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(458, 206).addBox(-4.0F, 16.0F, -12.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(475, 206).addBox(2.0F, 16.0F, -12.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(492, 206).addBox(7.0F, 16.0F, -8.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -11.20F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 249).addBox(-8.0F, -7.0F, -2.0F, 16.0F, 15.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(77, 249).addBox(-9.0F, -8.0F, -1.0F, 18.0F, 17.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(154, 249).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 9.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(215, 249).addBox(-3.0F, -2.0F, -7.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(252, 249).addBox(5.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 249).addBox(4.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(302, 249).addBox(2.0F, 4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(327, 249).addBox(-1.0F, 5.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(352, 249).addBox(-4.0F, 4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 249).addBox(-6.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 249).addBox(-7.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(427, 249).addBox(-6.0F, -4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(452, 249).addBox(-4.0F, -6.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(477, 249).addBox(-1.0F, -7.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 286).addBox(2.0F, -6.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 286).addBox(4.0F, -4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 12.48F, -6.0F));
        PartDefinition fin_0 = body.addOrReplaceChild("fin_0", CubeListBuilder.create()
                .texOffs(50, 286).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 24.0F, 3.0F, 0.0F, 0.0F, -0.52F));
        PartDefinition fin_1 = body.addOrReplaceChild("fin_1", CubeListBuilder.create()
                .texOffs(87, 286).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 24.0F, 3.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition fin_2 = body.addOrReplaceChild("fin_2", CubeListBuilder.create()
                .texOffs(124, 286).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, 24.0F, 3.0F, 0.0F, 0.0F, 0.17F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(SandWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart fin_0 = this.root.getChild("body").getChild("fin_0"); Anims.swayOne(fin_0, ageInTicks, 0.09F, 3.14F);
        ModelPart fin_1 = this.root.getChild("body").getChild("fin_1"); Anims.swayOne(fin_1, ageInTicks, 0.09F, 4.71F);
        ModelPart fin_2 = this.root.getChild("body").getChild("fin_2"); Anims.swayOne(fin_2, ageInTicks, 0.09F, 6.28F);
    }
}
