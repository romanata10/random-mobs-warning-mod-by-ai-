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
    public static final float SCALE = 0.97F;
    public static final float SHADOW = 2.0F;

    public SandWormModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-11.0F, -14.0F, -11.0F, 22.0F, 7.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(177, 0).addBox(-10.0F, -14.0F, -10.0F, 20.0F, 2.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 59).addBox(-12.0F, -8.0F, -12.0F, 24.0F, 7.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 59).addBox(-13.0F, -2.0F, -13.0F, 26.0F, 7.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 126).addBox(-12.0F, 4.0F, -12.0F, 24.0F, 6.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 126).addBox(-10.0F, 11.0F, -10.0F, 20.0F, 6.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(354, 126).addBox(-10.0F, -2.0F, -8.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(371, 126).addBox(-7.0F, -2.0F, -9.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(392, 126).addBox(-3.0F, -3.0F, -9.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(413, 126).addBox(0.0F, -2.0F, -9.0F, 3.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(434, 126).addBox(4.0F, -2.0F, -8.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(451, 126).addBox(-9.0F, 5.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(472, 126).addBox(-5.0F, 4.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 187).addBox(-1.0F, 4.0F, -9.0F, 4.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 187).addBox(3.0F, 5.0F, -8.0F, 4.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(46, 187).addBox(-11.0F, 0.0F, -11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(63, 187).addBox(-6.0F, 0.0F, -11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(80, 187).addBox(-1.0F, 0.0F, -11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 187).addBox(4.0F, 0.0F, -11.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(114, 187).addBox(-9.0F, -5.0F, -9.0F, 18.0F, 5.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(259, 187).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 2.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(388, 187).addBox(-7.0F, -1.0F, -8.0F, 14.0F, 4.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 234).addBox(-5.0F, 0.0F, -10.0F, 10.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(53, 234).addBox(-8.0F, -4.0F, -10.0F, 1.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(70, 234).addBox(-6.0F, -4.0F, -10.0F, 1.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(87, 234).addBox(-4.0F, -4.0F, -10.0F, 1.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(104, 234).addBox(-1.0F, -4.0F, -10.0F, 1.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(121, 234).addBox(1.0F, -4.0F, -10.0F, 1.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(138, 234).addBox(3.0F, -4.0F, -10.0F, 1.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 234).addBox(6.0F, -4.0F, -10.0F, 1.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(172, 234).addBox(-8.0F, 1.0F, -10.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 234).addBox(-6.0F, 1.0F, -10.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(214, 234).addBox(-3.0F, 0.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 234).addBox(-1.0F, 1.0F, -10.0F, 2.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(256, 234).addBox(2.0F, 0.0F, -10.0F, 2.0F, 4.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 234).addBox(5.0F, 2.0F, -10.0F, 2.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(298, 234).addBox(-11.0F, -2.0F, -12.0F, 3.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(343, 234).addBox(8.0F, -2.0F, -12.0F, 3.0F, 4.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(388, 234).addBox(-7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(397, 234).addBox(-4.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 234).addBox(-1.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(415, 234).addBox(1.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(424, 234).addBox(4.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.40F, 0.0F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create()
                .texOffs(0, 259).addBox(-7.0F, 0.0F, -9.0F, 14.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 259).addBox(-6.0F, -2.0F, -9.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(110, 259).addBox(-4.0F, -2.0F, -9.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(123, 259).addBox(-1.0F, -3.0F, -9.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(136, 259).addBox(1.0F, -2.0F, -9.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(149, 259).addBox(4.0F, -2.0F, -9.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 13.60F, 0.0F));
        PartDefinition fin_0 = body.addOrReplaceChild("fin_0", CubeListBuilder.create()
                .texOffs(162, 259).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, -4.0F, 4.0F, 0.0F, 0.0F, -0.59F));
        PartDefinition fin_1 = body.addOrReplaceChild("fin_1", CubeListBuilder.create()
                .texOffs(195, 259).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, -4.0F, 4.0F, 0.0F, 0.0F, -0.21F));
        PartDefinition fin_2 = body.addOrReplaceChild("fin_2", CubeListBuilder.create()
                .texOffs(228, 259).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.0F, -4.0F, 4.0F, 0.0F, 0.0F, 0.17F));
        PartDefinition fin_3 = body.addOrReplaceChild("fin_3", CubeListBuilder.create()
                .texOffs(261, 259).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, -4.0F, 4.0F, 0.0F, 0.0F, 0.56F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(SandWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart jaw = this.root.getChild("body").getChild("head").getChild("jaw"); Anims.jaw(jaw, ageInTicks, 0.18F);
        ModelPart fin_0 = this.root.getChild("body").getChild("fin_0"); Anims.swayOne(fin_0, ageInTicks, 0.09F, 4.71F);
        ModelPart fin_1 = this.root.getChild("body").getChild("fin_1"); Anims.swayOne(fin_1, ageInTicks, 0.09F, 6.28F);
        ModelPart fin_2 = this.root.getChild("body").getChild("fin_2"); Anims.swayOne(fin_2, ageInTicks, 0.09F, 7.85F);
        ModelPart fin_3 = this.root.getChild("body").getChild("fin_3"); Anims.swayOne(fin_3, ageInTicks, 0.09F, 9.42F);
    }
}
