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
    public static final float SCALE = 0.99F;
    public static final float SHADOW = 0.0F;

    public TornadoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition ring_0 = root.addOrReplaceChild("ring_0", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-44.0F, 0.0F, -44.0F, 88.0F, 18.0F, 88.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 213).addBox(-46.0F, 3.0F, -46.0F, 92.0F, 3.0F, 92.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 5.80F, 6.0F));
        PartDefinition ring_1 = root.addOrReplaceChild("ring_1", CubeListBuilder.create()
                .texOffs(0, 404).addBox(-38.0F, 0.0F, -38.0F, 76.0F, 18.0F, 76.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(6.0F, -10.20F, -1.0F));
        PartDefinition ring_2 = root.addOrReplaceChild("ring_2", CubeListBuilder.create()
                .texOffs(0, 593).addBox(-34.0F, 0.0F, -34.0F, 68.0F, 18.0F, 68.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 766).addBox(-36.0F, 3.0F, -36.0F, 72.0F, 3.0F, 72.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-1.0F, -26.20F, -5.0F));
        PartDefinition ring_3 = root.addOrReplaceChild("ring_3", CubeListBuilder.create()
                .texOffs(0, 917).addBox(-31.0F, 0.0F, -31.0F, 62.0F, 18.0F, 62.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, -42.20F, 2.0F));
        PartDefinition ring_4 = root.addOrReplaceChild("ring_4", CubeListBuilder.create()
                .texOffs(497, 917).addBox(-27.0F, 0.0F, -27.0F, 54.0F, 18.0F, 54.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1078).addBox(-29.0F, 3.0F, -29.0F, 58.0F, 3.0F, 58.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(2.0F, -58.20F, 4.0F));
        PartDefinition ring_5 = root.addOrReplaceChild("ring_5", CubeListBuilder.create()
                .texOffs(465, 1078).addBox(-24.0F, 0.0F, -24.0F, 48.0F, 18.0F, 48.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(3.0F, -74.20F, -3.0F));
        PartDefinition ring_6 = root.addOrReplaceChild("ring_6", CubeListBuilder.create()
                .texOffs(0, 1211).addBox(-21.0F, 0.0F, -21.0F, 42.0F, 18.0F, 42.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(337, 1211).addBox(-23.0F, 3.0F, -23.0F, 46.0F, 3.0F, 46.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-3.0F, -90.20F, -3.0F));
        PartDefinition ring_7 = root.addOrReplaceChild("ring_7", CubeListBuilder.create()
                .texOffs(706, 1211).addBox(-18.0F, 0.0F, -18.0F, 36.0F, 18.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-2.0F, -106.20F, 3.0F));
        PartDefinition ring_8 = root.addOrReplaceChild("ring_8", CubeListBuilder.create()
                .texOffs(0, 1332).addBox(-15.0F, 0.0F, -15.0F, 30.0F, 18.0F, 30.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(241, 1332).addBox(-17.0F, 3.0F, -17.0F, 34.0F, 3.0F, 34.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(3.0F, -122.20F, 2.0F));
        PartDefinition ring_9 = root.addOrReplaceChild("ring_9", CubeListBuilder.create()
                .texOffs(514, 1332).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 18.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(1.0F, -138.20F, -3.0F));
        PartDefinition ring_10 = root.addOrReplaceChild("ring_10", CubeListBuilder.create()
                .texOffs(707, 1332).addBox(-9.0F, 0.0F, -9.0F, 18.0F, 18.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1429).addBox(-11.0F, 3.0F, -11.0F, 22.0F, 3.0F, 22.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-2.0F, -154.20F, -1.0F));
        PartDefinition ring_11 = root.addOrReplaceChild("ring_11", CubeListBuilder.create()
                .texOffs(177, 1429).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 18.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -170.20F, 2.0F));
        PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create()
                .texOffs(274, 1429).addBox(-44.0F, 0.0F, -44.0F, 88.0F, 6.0F, 88.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1618).addBox(-30.0F, -4.0F, -26.0F, 56.0F, 5.0F, 50.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(425, 1618).addBox(-16.0F, -8.0F, -12.0F, 32.0F, 5.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 18.0F, 0.0F));
        PartDefinition top = root.addOrReplaceChild("top", CubeListBuilder.create()
                .texOffs(650, 1618).addBox(-14.0F, -6.0F, -14.0F, 28.0F, 6.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 1729).addBox(-20.0F, -7.0F, -9.0F, 40.0F, 3.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -161.20F, 0.0F));
        return LayerDefinition.create(mesh, 1024, 2048);
    }

    @Override
    public void setupAnim(TornadoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart ring_0 = this.root.getChild("ring_0"); Anims.bob(ring_0, ageInTicks, 0.45F);
        ModelPart ring_4 = this.root.getChild("ring_4"); Anims.bob(ring_4, ageInTicks, 0.45F);
        ModelPart ring_8 = this.root.getChild("ring_8"); Anims.bob(ring_8, ageInTicks, 0.45F);
        ModelPart base = this.root.getChild("base"); Anims.bob(base, ageInTicks, 0.45F);
        ModelPart top = this.root.getChild("top"); Anims.bob(top, ageInTicks, 0.45F);
    }
}
