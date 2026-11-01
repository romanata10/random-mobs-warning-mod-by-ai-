package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.TornadoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TornadoModel extends RMobModel<TornadoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/tornado.png");
    public static final float SCALE = 0.95F;
    public static final float SHADOW = 0.0F;

    public TornadoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-8.0F, 191.20F, -8.0F, 16.0F, 6.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 0).addBox(-6.0F, 190.20F, -6.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(226, 0).addBox(-8.0F, 186.03F, -8.0F, 17.0F, 6.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(363, 0).addBox(-6.0F, 185.03F, -6.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 47).addBox(-9.0F, 180.86F, -9.0F, 18.0F, 6.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 47).addBox(-6.0F, 179.86F, -6.0F, 13.0F, 2.0F, 13.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(250, 47).addBox(-9.0F, 175.69F, -9.0F, 19.0F, 6.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 98).addBox(-7.0F, 174.69F, -7.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(113, 98).addBox(-10.0F, 170.52F, -10.0F, 20.0F, 6.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(274, 98).addBox(-7.0F, 169.52F, -7.0F, 14.0F, 2.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 151).addBox(-10.0F, 165.35F, -10.0F, 21.0F, 6.0F, 21.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(169, 151).addBox(-7.0F, 164.35F, -7.0F, 15.0F, 2.0F, 15.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 151).addBox(-10.0F, 160.18F, -11.0F, 22.0F, 6.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 208).addBox(-7.0F, 159.18F, -8.0F, 16.0F, 2.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(129, 208).addBox(-11.0F, 155.02F, -11.0F, 24.0F, 6.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(322, 208).addBox(-7.0F, 154.02F, -7.0F, 17.0F, 2.0F, 17.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 269).addBox(-11.0F, 149.85F, -11.0F, 25.0F, 6.0F, 25.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(201, 269).addBox(-8.0F, 148.85F, -8.0F, 18.0F, 2.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 332).addBox(-12.0F, 144.68F, -12.0F, 26.0F, 6.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(209, 332).addBox(-8.0F, 143.68F, -8.0F, 19.0F, 2.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 397).addBox(-11.0F, 139.51F, -12.0F, 27.0F, 6.0F, 27.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(217, 397).addBox(-7.0F, 138.51F, -8.0F, 19.0F, 2.0F, 19.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 464).addBox(-12.0F, 134.34F, -13.0F, 28.0F, 6.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(225, 464).addBox(-8.0F, 133.34F, -9.0F, 20.0F, 2.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 533).addBox(-11.0F, 129.17F, -12.0F, 29.0F, 6.0F, 29.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(233, 533).addBox(-7.0F, 128.17F, -8.0F, 21.0F, 2.0F, 21.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 604).addBox(-12.0F, 124.0F, -13.0F, 30.0F, 6.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 604).addBox(-8.0F, 123.0F, -9.0F, 22.0F, 2.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 677).addBox(-15.0F, 124.80F, -14.0F, 30.0F, 6.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 677).addBox(-11.0F, 123.80F, -10.0F, 22.0F, 2.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 750).addBox(-15.0F, 119.88F, -14.0F, 31.0F, 6.0F, 31.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(249, 750).addBox(-11.0F, 118.88F, -10.0F, 22.0F, 2.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 825).addBox(-16.0F, 114.95F, -15.0F, 32.0F, 6.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(257, 825).addBox(-11.0F, 113.95F, -10.0F, 23.0F, 2.0F, 23.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 902).addBox(-17.0F, 110.03F, -16.0F, 34.0F, 6.0F, 34.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(273, 902).addBox(-12.0F, 109.03F, -11.0F, 24.0F, 2.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 983).addBox(-17.0F, 105.11F, -16.0F, 35.0F, 6.0F, 35.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(281, 983).addBox(-12.0F, 104.11F, -11.0F, 25.0F, 2.0F, 25.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1066).addBox(-19.0F, 100.18F, -17.0F, 36.0F, 6.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 1066).addBox(-14.0F, 99.18F, -12.0F, 26.0F, 2.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1151).addBox(-19.0F, 95.26F, -18.0F, 37.0F, 6.0F, 37.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1238).addBox(-14.0F, 94.26F, -13.0F, 27.0F, 2.0F, 27.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1297).addBox(-20.0F, 90.34F, -19.0F, 39.0F, 6.0F, 39.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1388).addBox(-15.0F, 89.34F, -14.0F, 28.0F, 2.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1449).addBox(-22.0F, 85.42F, -20.0F, 40.0F, 6.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1542).addBox(-16.0F, 84.42F, -14.0F, 29.0F, 2.0F, 29.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1605).addBox(-22.0F, 80.49F, -20.0F, 41.0F, 6.0F, 41.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1700).addBox(-17.0F, 79.49F, -15.0F, 30.0F, 2.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1765).addBox(-23.0F, 75.57F, -22.0F, 42.0F, 6.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1862).addBox(-17.0F, 74.57F, -16.0F, 30.0F, 2.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1927).addBox(-25.0F, 70.65F, -23.0F, 44.0F, 6.0F, 44.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2028).addBox(-19.0F, 69.65F, -17.0F, 32.0F, 2.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2097).addBox(-25.0F, 65.72F, -24.0F, 45.0F, 6.0F, 45.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2200).addBox(-19.0F, 64.72F, -18.0F, 32.0F, 2.0F, 32.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2269).addBox(-27.0F, 60.80F, -25.0F, 46.0F, 6.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2374).addBox(-20.0F, 59.80F, -18.0F, 33.0F, 2.0F, 33.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2445).addBox(-23.0F, 60.80F, -23.0F, 46.0F, 6.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2550).addBox(-16.0F, 59.80F, -16.0F, 33.0F, 2.0F, 33.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2621).addBox(-24.0F, 55.85F, -24.0F, 48.0F, 6.0F, 48.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2730).addBox(-17.0F, 54.85F, -17.0F, 35.0F, 2.0F, 35.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2805).addBox(-24.0F, 50.91F, -24.0F, 49.0F, 6.0F, 49.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2916).addBox(-17.0F, 49.91F, -17.0F, 35.0F, 2.0F, 35.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 2991).addBox(-25.0F, 45.96F, -25.0F, 51.0F, 6.0F, 51.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3106).addBox(-18.0F, 44.96F, -18.0F, 37.0F, 2.0F, 37.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3185).addBox(-26.0F, 41.02F, -26.0F, 53.0F, 6.0F, 53.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3304).addBox(-19.0F, 40.02F, -19.0F, 38.0F, 2.0F, 38.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3385).addBox(-26.0F, 36.07F, -26.0F, 54.0F, 6.0F, 54.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3506).addBox(-18.0F, 35.07F, -18.0F, 39.0F, 2.0F, 39.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3589).addBox(-27.0F, 31.13F, -27.0F, 56.0F, 6.0F, 56.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3714).addBox(-19.0F, 30.13F, -19.0F, 40.0F, 2.0F, 40.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3799).addBox(-27.0F, 26.18F, -27.0F, 57.0F, 6.0F, 57.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 3926).addBox(-19.0F, 25.18F, -19.0F, 41.0F, 2.0F, 41.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4013).addBox(-27.0F, 21.24F, -27.0F, 59.0F, 6.0F, 59.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4144).addBox(-19.0F, 20.24F, -19.0F, 42.0F, 2.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4233).addBox(-28.0F, 16.29F, -28.0F, 61.0F, 6.0F, 61.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4368).addBox(-20.0F, 15.29F, -20.0F, 44.0F, 2.0F, 44.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4461).addBox(-29.0F, 11.35F, -29.0F, 62.0F, 6.0F, 62.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4598).addBox(-20.0F, 10.35F, -20.0F, 45.0F, 2.0F, 45.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4693).addBox(-29.0F, 6.40F, -29.0F, 64.0F, 6.0F, 64.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4834).addBox(-20.0F, 5.40F, -20.0F, 46.0F, 2.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(369, 4834).addBox(4.0F, 172.0F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(402, 4834).addBox(1.0F, 148.0F, 3.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(435, 4834).addBox(-6.0F, 122.0F, 3.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(468, 4834).addBox(-8.0F, 96.0F, -3.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4931).addBox(-4.0F, 71.0F, -8.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(33, 4931).addBox(2.0F, 45.0F, -6.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(66, 4931).addBox(4.0F, 20.0F, 0.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -179.0F, 0.0F));
        PartDefinition core = body.addOrReplaceChild("core", CubeListBuilder.create()
                .texOffs(99, 4931).addBox(-2.0F, 176.0F, -2.0F, 4.0F, 19.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(132, 4931).addBox(-1.0F, 175.0F, -1.0F, 3.0F, 2.0F, 3.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(157, 4931).addBox(-2.0F, 158.22F, -2.0F, 5.0F, 19.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(198, 4931).addBox(-2.0F, 157.22F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(231, 4931).addBox(-3.0F, 140.44F, -3.0F, 6.0F, 19.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(280, 4931).addBox(-2.0F, 139.44F, -2.0F, 4.0F, 2.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(313, 4931).addBox(-3.0F, 122.67F, -3.0F, 7.0F, 19.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(370, 4931).addBox(-2.0F, 121.67F, -2.0F, 5.0F, 2.0F, 5.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(411, 4931).addBox(-4.0F, 104.89F, -4.0F, 8.0F, 19.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 4986).addBox(-3.0F, 103.89F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(49, 4986).addBox(-4.0F, 87.11F, -4.0F, 8.0F, 19.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(114, 4986).addBox(-3.0F, 86.11F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(163, 4986).addBox(-4.0F, 69.33F, -4.0F, 9.0F, 19.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(236, 4986).addBox(-3.0F, 68.33F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(285, 4986).addBox(-4.0F, 51.56F, -5.0F, 10.0F, 19.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(366, 4986).addBox(-2.0F, 50.56F, -3.0F, 7.0F, 2.0F, 7.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(423, 4986).addBox(-4.0F, 33.78F, -5.0F, 11.0F, 19.0F, 11.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 5047).addBox(-3.0F, 32.78F, -4.0F, 8.0F, 2.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(65, 5047).addBox(-5.0F, 16.0F, -6.0F, 12.0F, 19.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(162, 5047).addBox(-3.0F, 15.0F, -4.0F, 9.0F, 2.0F, 9.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 8.0F, 0.0F));
        PartDefinition eye = body.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(235, 5047).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(268, 5047).addBox(-6.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(301, 5047).addBox(2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(334, 5047).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(367, 5047).addBox(-2.0F, -5.0F, 2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.40F, 0.0F));
        return LayerDefinition.create(mesh, 512, 8192);
    }

    @Override
    public void setupAnim(TornadoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.spin(body, ageInTicks, 0.12F);
        ModelPart core = this.root.getChild("body").getChild("core"); Anims.spin(core, ageInTicks, 0.12F);
        ModelPart eye = this.root.getChild("body").getChild("eye"); Anims.pulse(eye, ageInTicks, 0.06F);
    }
}
