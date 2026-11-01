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
    public static final float SCALE = 1.11F;
    public static final float SHADOW = 2.0F;

    public SandWormModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-10.0F, 28.0F, -10.0F, 20.0F, 3.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(161, 0).addBox(-14.0F, 28.0F, -10.0F, 4.0F, 3.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 0).addBox(10.0F, 28.0F, -10.0F, 4.0F, 3.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 0).addBox(-10.0F, 28.0F, -14.0F, 20.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 47).addBox(-10.0F, 28.0F, 10.0F, 20.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 47).addBox(-6.0F, 30.0F, -6.0F, 12.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(194, 47).addBox(-9.0F, 30.0F, -6.0F, 3.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(255, 47).addBox(6.0F, 30.0F, -6.0F, 3.0F, 3.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 47).addBox(-6.0F, 30.0F, -9.0F, 12.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(377, 47).addBox(-6.0F, 30.0F, 6.0F, 12.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 78).addBox(-7.0F, 26.0F, -7.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 78).addBox(-10.0F, 26.0F, -7.0F, 3.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(182, 78).addBox(7.0F, 26.0F, -7.0F, 3.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 78).addBox(-7.0F, 26.0F, -10.0F, 14.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(320, 78).addBox(-7.0F, 26.0F, 7.0F, 14.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(389, 78).addBox(-5.0F, 27.0F, -5.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 111).addBox(-7.0F, 27.0F, -5.0F, 2.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 111).addBox(5.0F, 27.0F, -5.0F, 2.0F, 2.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(98, 111).addBox(-5.0F, 27.0F, -7.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(147, 111).addBox(-5.0F, 27.0F, 5.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(196, 111).addBox(-10.0F, 29.76F, -11.0F, 20.0F, 4.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(357, 111).addBox(-7.0F, 28.76F, -8.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 160).addBox(-9.0F, 26.72F, -10.0F, 19.0F, 4.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(153, 160).addBox(-7.0F, 25.72F, -8.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(266, 160).addBox(-9.0F, 23.68F, -10.0F, 19.0F, 4.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 207).addBox(-7.0F, 22.68F, -8.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 207).addBox(-9.0F, 20.64F, -10.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 207).addBox(-6.0F, 19.64F, -7.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 207).addBox(-9.0F, 17.60F, -11.0F, 18.0F, 4.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 252).addBox(-6.0F, 16.60F, -8.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 252).addBox(-8.0F, 14.56F, -10.0F, 17.0F, 4.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(242, 252).addBox(-6.0F, 13.56F, -8.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 252).addBox(9.0F, 17.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(364, 252).addBox(9.0F, 15.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(381, 252).addBox(7.0F, 17.0F, 4.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(406, 252).addBox(7.0F, 15.0F, 4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 252).addBox(2.0F, 17.0F, 8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(448, 252).addBox(2.0F, 15.0F, 8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(465, 252).addBox(-4.0F, 17.0F, 8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(490, 252).addBox(-4.0F, 15.0F, 8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 295).addBox(-9.0F, 17.0F, 4.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(25, 295).addBox(-9.0F, 15.0F, 4.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(42, 295).addBox(-11.0F, 17.0F, -2.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(67, 295).addBox(-11.0F, 15.0F, -2.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(84, 295).addBox(-9.0F, 17.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 295).addBox(-9.0F, 15.0F, -8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(126, 295).addBox(-4.0F, 17.0F, -12.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(151, 295).addBox(-4.0F, 15.0F, -12.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(168, 295).addBox(2.0F, 17.0F, -12.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(193, 295).addBox(2.0F, 15.0F, -12.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 295).addBox(7.0F, 17.0F, -8.0F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(235, 295).addBox(7.0F, 15.0F, -8.0F, 2.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -11.20F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(252, 295).addBox(-8.0F, -8.0F, -1.0F, 16.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(325, 295).addBox(-9.0F, -8.0F, -1.0F, 1.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(338, 295).addBox(8.0F, -8.0F, -1.0F, 1.0F, 10.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(351, 295).addBox(-8.0F, -8.0F, -2.0F, 16.0F, 10.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 295).addBox(-8.0F, -8.0F, 1.0F, 16.0F, 10.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 320).addBox(-10.0F, -9.0F, -1.0F, 20.0F, 19.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(85, 320).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 9.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(146, 320).addBox(-3.0F, -2.0F, -7.0F, 6.0F, 5.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(183, 320).addBox(5.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(208, 320).addBox(4.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 320).addBox(2.0F, 4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(258, 320).addBox(-1.0F, 5.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(283, 320).addBox(-4.0F, 4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(308, 320).addBox(-6.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(333, 320).addBox(-7.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(358, 320).addBox(-6.0F, -4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(383, 320).addBox(-4.0F, -6.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(408, 320).addBox(-1.0F, -7.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(433, 320).addBox(2.0F, -6.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(458, 320).addBox(4.0F, -4.0F, -4.0F, 2.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 12.48F, -6.0F));
        PartDefinition fin_0 = body.addOrReplaceChild("fin_0", CubeListBuilder.create()
                .texOffs(0, 361).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 24.0F, 3.0F, 0.0F, 0.0F, -0.52F));
        PartDefinition fin_1 = body.addOrReplaceChild("fin_1", CubeListBuilder.create()
                .texOffs(37, 361).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.0F, 24.0F, 3.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition fin_2 = body.addOrReplaceChild("fin_2", CubeListBuilder.create()
                .texOffs(74, 361).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F),
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
