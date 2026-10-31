package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.GardenerEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class GardenerModel extends RMobModel<GardenerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/gardener.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 1.0F;

    public GardenerModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(),
                List.of(root.getChild("tentacle_0"), root.getChild("tentacle_1"), root.getChild("tentacle_2"), root.getChild("tentacle_3"), root.getChild("tentacle_4")),
                List.of(),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-10.0F, -9.0F, -10.0F, 20.0F, 19.0F, 20.0F)
                .texOffs(81, 0).addBox(-13.0F, 6.0F, -6.0F, 26.0F, 8.0F, 12.0F),
                PartPose.offset(0.0F, -26.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(158, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F),
                PartPose.offset(0.0F, -34.0F, 0.0F));
        PartDefinition orb = root.addOrReplaceChild("orb", CubeListBuilder.create()
                .texOffs(0, 40).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F),
                PartPose.offset(0.0F, -42.0F, 0.0F));
        PartDefinition tentacle_0 = root.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(41, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 32.0F, 4.0F),
                PartPose.offset(6.0F, -8.0F, 6.0F));
        PartDefinition tentacle_1 = root.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(58, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 30.0F, 4.0F),
                PartPose.offset(-6.0F, -8.0F, 6.0F));
        PartDefinition tentacle_2 = root.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(75, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 30.0F, 4.0F),
                PartPose.offset(6.0F, -8.0F, -6.0F));
        PartDefinition tentacle_3 = root.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(92, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 32.0F, 4.0F),
                PartPose.offset(-6.0F, -8.0F, -6.0F));
        PartDefinition tentacle_4 = root.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(109, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 34.0F, 4.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 128);
    }

    @Override
    public void setupAnim(GardenerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.sway(this.tentacles, ageInTicks, 0.09F, 0.7F);
        Anims.head(this.head, netHeadYaw, headPitch);
        Anims.bob(this.body, ageInTicks, 0.6F);
    }
}
