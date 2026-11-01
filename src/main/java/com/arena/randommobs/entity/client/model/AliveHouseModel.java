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
    public static final float SCALE = 0.79F;
    public static final float SHADOW = 2.40F;

    public AliveHouseModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-15.0F, -19.0F, -11.0F, 30.0F, 30.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 0).addBox(-20.0F, -19.0F, -11.0F, 5.0F, 30.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(318, 0).addBox(15.0F, -19.0F, -11.0F, 5.0F, 30.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 105).addBox(-15.0F, -19.0F, -16.0F, 30.0F, 30.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(141, 105).addBox(-15.0F, -19.0F, 11.0F, 30.0F, 30.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(282, 105).addBox(-14.0F, -15.0F, -11.0F, 28.0F, 5.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 176).addBox(-18.0F, -15.0F, -11.0F, 4.0F, 5.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(105, 176).addBox(14.0F, -15.0F, -11.0F, 4.0F, 5.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(210, 176).addBox(-14.0F, -15.0F, -15.0F, 28.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(339, 176).addBox(-14.0F, -15.0F, 11.0F, 28.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 176).addBox(-19.0F, -20.0F, -15.0F, 2.0F, 31.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(485, 176).addBox(-19.0F, -20.0F, 15.0F, 2.0F, 31.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 243).addBox(19.0F, -20.0F, -15.0F, 2.0F, 31.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(17, 243).addBox(19.0F, -20.0F, 15.0F, 2.0F, 31.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(34, 243).addBox(-19.0F, -20.0F, 15.0F, 38.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(195, 243).addBox(-19.0F, -2.0F, 15.0F, 38.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(356, 243).addBox(-13.0F, 16.0F, -18.0F, 26.0F, 21.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(469, 243).addBox(-14.0F, 16.0F, -18.0F, 1.0F, 21.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(482, 243).addBox(13.0F, 16.0F, -18.0F, 1.0F, 21.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 310).addBox(-13.0F, 16.0F, -19.0F, 26.0F, 21.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(109, 310).addBox(-13.0F, 16.0F, -16.0F, 26.0F, 21.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(218, 310).addBox(-13.0F, -35.0F, -9.0F, 26.0F, 5.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(395, 310).addBox(-19.0F, -35.0F, -9.0F, 6.0F, 5.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 357).addBox(13.0F, -35.0F, -9.0F, 6.0F, 5.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(97, 357).addBox(-13.0F, -35.0F, -15.0F, 26.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 357).addBox(-13.0F, -35.0F, 9.0F, 26.0F, 5.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(355, 357).addBox(-11.0F, -30.0F, -7.0F, 22.0F, 5.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 404).addBox(-16.0F, -30.0F, -7.0F, 5.0F, 5.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(77, 404).addBox(11.0F, -30.0F, -7.0F, 5.0F, 5.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(154, 404).addBox(-11.0F, -30.0F, -12.0F, 22.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(263, 404).addBox(-11.0F, -30.0F, 7.0F, 22.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(372, 404).addBox(-9.0F, -25.0F, -5.0F, 18.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 443).addBox(-13.0F, -25.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(57, 443).addBox(9.0F, -25.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 443).addBox(-9.0F, -25.0F, -9.0F, 18.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(203, 443).addBox(-9.0F, -25.0F, 5.0F, 18.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(292, 443).addBox(-12.0F, -44.0F, -8.0F, 24.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 486).addBox(-17.0F, -44.0F, -8.0F, 5.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(85, 486).addBox(12.0F, -44.0F, -8.0F, 5.0F, 5.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 486).addBox(-12.0F, -44.0F, -13.0F, 24.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(287, 486).addBox(-12.0F, -44.0F, 8.0F, 24.0F, 5.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 529).addBox(-9.0F, -40.0F, -5.0F, 18.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 529).addBox(-13.0F, -40.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(170, 529).addBox(9.0F, -40.0F, -5.0F, 4.0F, 5.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(227, 529).addBox(-9.0F, -40.0F, -9.0F, 18.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(316, 529).addBox(-9.0F, -40.0F, 5.0F, 18.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(405, 529).addBox(9.0F, -45.0F, -7.0F, 4.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(438, 529).addBox(8.0F, -45.0F, -7.0F, 1.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(459, 529).addBox(13.0F, -45.0F, -7.0F, 1.0F, 26.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(480, 529).addBox(9.0F, -45.0F, -8.0F, 4.0F, 26.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 590).addBox(9.0F, -45.0F, -3.0F, 4.0F, 26.0F, 1.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -21.63F, 0.0F));
        PartDefinition face = body.addOrReplaceChild("face", CubeListBuilder.create()
                .texOffs(21, 590).addBox(-12.0F, -8.0F, -1.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(62, 590).addBox(4.0F, -8.0F, -1.0F, 8.0F, 5.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(103, 590).addBox(-6.0F, 18.0F, -1.0F, 12.0F, 12.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(160, 590).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(173, 590).addBox(-3.0F, -4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(186, 590).addBox(-1.0F, -4.0F, -2.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(199, 590).addBox(1.0F, -4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 590).addBox(3.0F, -4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(225, 590).addBox(-5.0F, 4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(238, 590).addBox(-3.0F, 4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(251, 590).addBox(-1.0F, 3.0F, -2.0F, 1.0F, 3.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(264, 590).addBox(1.0F, 4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 590).addBox(3.0F, 4.0F, -2.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -3.20F, -19.0F));
        PartDefinition leg_0 = root.addOrReplaceChild("leg_0", CubeListBuilder.create()
                .texOffs(290, 590).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 2.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 590).addBox(-4.0F, 1.11F, -4.0F, 7.0F, 4.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(420, 590).addBox(-3.0F, 5.38F, -3.0F, 5.0F, 2.78F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 645).addBox(-4.0F, 2.28F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, -7.23F, -10.0F, 0.0F, 0.0F, 0.68F));
        PartDefinition leg_0_low = leg_0.addOrReplaceChild("leg_0_low", CubeListBuilder.create()
                .texOffs(65, 645).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 7.69F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(122, 645).addBox(-3.0F, 6.84F, -3.0F, 5.0F, 6.84F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 645).addBox(-3.0F, 10.09F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.85F, 7.20F, 0.0F, 0.0F, 0.0F, -0.50F));
        PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create()
                .texOffs(204, 645).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 2.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(277, 645).addBox(-4.0F, 1.11F, -4.0F, 7.0F, 4.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(334, 645).addBox(-3.0F, 5.38F, -3.0F, 5.0F, 2.78F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 645).addBox(-4.0F, 2.28F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, -7.23F, -10.0F, 0.0F, 0.0F, -0.68F));
        PartDefinition leg_1_low = leg_1.addOrReplaceChild("leg_1_low", CubeListBuilder.create()
                .texOffs(440, 645).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 7.69F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 676).addBox(-3.0F, 6.84F, -3.0F, 5.0F, 6.84F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(41, 676).addBox(-3.0F, 10.09F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.85F, 7.20F, 0.0F, 0.0F, 0.0F, 0.50F));
        PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create()
                .texOffs(82, 676).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 2.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(155, 676).addBox(-4.0F, 1.11F, -4.0F, 7.0F, 4.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(212, 676).addBox(-3.0F, 5.38F, -3.0F, 5.0F, 2.78F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(253, 676).addBox(-4.0F, 2.28F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, -7.23F, 10.0F, 0.0F, 0.0F, 0.68F));
        PartDefinition leg_2_low = leg_2.addOrReplaceChild("leg_2_low", CubeListBuilder.create()
                .texOffs(318, 676).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 7.69F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(375, 676).addBox(-3.0F, 6.84F, -3.0F, 5.0F, 6.84F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(416, 676).addBox(-3.0F, 10.09F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-5.85F, 7.20F, 0.0F, 0.0F, 0.0F, -0.50F));
        PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create()
                .texOffs(0, 707).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 2.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(73, 707).addBox(-4.0F, 1.11F, -4.0F, 7.0F, 4.64F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(130, 707).addBox(-3.0F, 5.38F, -3.0F, 5.0F, 2.78F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(171, 707).addBox(-4.0F, 2.28F, -4.0F, 8.0F, 7.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, -7.23F, 10.0F, 0.0F, 0.0F, -0.68F));
        PartDefinition leg_3_low = leg_3.addOrReplaceChild("leg_3_low", CubeListBuilder.create()
                .texOffs(236, 707).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 7.69F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(293, 707).addBox(-3.0F, 6.84F, -3.0F, 5.0F, 6.84F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(334, 707).addBox(-3.0F, 10.09F, -3.0F, 5.0F, 7.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(5.85F, 7.20F, 0.0F, 0.0F, 0.0F, 0.50F));
        return LayerDefinition.create(mesh, 512, 1024);
    }

    @Override
    public void setupAnim(AliveHouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart face = this.root.getChild("body").getChild("face"); Anims.look(face, netHeadYaw, headPitch);
        ModelPart leg_0 = this.root.getChild("leg_0"); Anims.swing(leg_0, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_0_low = this.root.getChild("leg_0").getChild("leg_0_low"); Anims.swing(leg_0_low, limbSwing, limbSwingAmount, 0.45F, 4.71F);
        ModelPart leg_1 = this.root.getChild("leg_1"); Anims.swing(leg_1, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_1_low = this.root.getChild("leg_1").getChild("leg_1_low"); Anims.swing(leg_1_low, limbSwing, limbSwingAmount, 0.45F, 7.85F);
        ModelPart leg_2 = this.root.getChild("leg_2"); Anims.swing(leg_2, limbSwing, limbSwingAmount, 0.95F, 9.42F);
        ModelPart leg_2_low = this.root.getChild("leg_2").getChild("leg_2_low"); Anims.swing(leg_2_low, limbSwing, limbSwingAmount, 0.45F, 11.00F);
        ModelPart leg_3 = this.root.getChild("leg_3"); Anims.swing(leg_3, limbSwing, limbSwingAmount, 0.95F, 12.57F);
        ModelPart leg_3_low = this.root.getChild("leg_3").getChild("leg_3_low"); Anims.swing(leg_3_low, limbSwing, limbSwingAmount, 0.45F, 14.14F);
    }
}
