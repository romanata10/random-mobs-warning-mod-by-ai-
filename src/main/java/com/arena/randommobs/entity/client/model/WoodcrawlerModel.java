package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class WoodcrawlerModel extends RMobModel<WoodcrawlerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/woodcrawler.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 0.60F;

    public WoodcrawlerModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_r"), root.getChild("leg_l")),
                List.of(),
                List.of(root.getChild("arm_r"), root.getChild("arm_l")),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 12.0F, 6.0F)
                .texOffs(33, 0).addBox(-6.0F, -2.0F, -4.0F, 12.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(74, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F)
                .texOffs(107, 0).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 4.0F, 3.0F)
                .texOffs(122, 0).addBox(-3.0F, -6.0F, -2.0F, 2.0F, 3.0F, 2.0F)
                .texOffs(131, 0).addBox(1.0F, -6.0F, -2.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition crown = root.addOrReplaceChild("crown", CubeListBuilder.create()
                .texOffs(140, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 5.0F, 10.0F),
                PartPose.offset(0.0F, -4.0F, 0.0F));
        PartDefinition arm_r = root.addOrReplaceChild("arm_r", CubeListBuilder.create()
                .texOffs(181, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offsetAndRotation(6.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.10F));
        PartDefinition arm_l = root.addOrReplaceChild("arm_l", CubeListBuilder.create()
                .texOffs(198, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offsetAndRotation(-6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.10F));
        PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create()
                .texOffs(215, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(4.0F, 12.0F, 0.0F));
        PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create()
                .texOffs(232, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(-4.0F, 12.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 64);
    }

    @Override
    public void setupAnim(WoodcrawlerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
        Anims.arms(this.arms, limbSwing, limbSwingAmount, 0.6F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
