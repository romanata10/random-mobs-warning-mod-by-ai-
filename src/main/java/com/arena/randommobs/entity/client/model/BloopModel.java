package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BloopEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class BloopModel extends RMobModel<BloopEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bloop.png");
    public static final float SCALE = 1.70F;
    public static final float SHADOW = 3.0F;

    public BloopModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(),
                List.of(root.getChild("tentacle_0"), root.getChild("tentacle_1"), root.getChild("tentacle_2"), root.getChild("tentacle_3")),
                List.of(),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-26.0F, -22.0F, -20.0F, 52.0F, 44.0F, 40.0F)
                .texOffs(0, 85).addBox(-18.0F, 6.0F, -14.0F, 36.0F, 16.0F, 28.0F),
                PartPose.offset(0.0F, -30.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 130).addBox(-18.0F, -8.0F, -14.0F, 36.0F, 14.0F, 28.0F),
                PartPose.offset(0.0F, -46.0F, 0.0F));
        PartDefinition eye = root.addOrReplaceChild("eye", CubeListBuilder.create()
                .texOffs(129, 130).addBox(-7.0F, -7.0F, -2.0F, 14.0F, 14.0F, 3.0F),
                PartPose.offset(0.0F, -46.0F, -15.0F));
        PartDefinition fin_r = root.addOrReplaceChild("fin_r", CubeListBuilder.create()
                .texOffs(164, 130).addBox(0.0F, -2.0F, -10.0F, 18.0F, 4.0F, 20.0F),
                PartPose.offsetAndRotation(26.0F, -20.0F, 0.0F, 0.0F, 0.0F, -0.31F));
        PartDefinition fin_l = root.addOrReplaceChild("fin_l", CubeListBuilder.create()
                .texOffs(0, 173).addBox(-18.0F, -2.0F, -10.0F, 18.0F, 4.0F, 20.0F),
                PartPose.offsetAndRotation(-26.0F, -20.0F, 0.0F, 0.0F, 0.0F, 0.31F));
        PartDefinition tentacle_0 = root.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(77, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F),
                PartPose.offset(10.0F, -6.0F, 8.0F));
        PartDefinition tentacle_1 = root.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(102, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 30.0F, 6.0F),
                PartPose.offset(-10.0F, -6.0F, 8.0F));
        PartDefinition tentacle_2 = root.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(127, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 30.0F, 6.0F),
                PartPose.offset(10.0F, -6.0F, -8.0F));
        PartDefinition tentacle_3 = root.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(152, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F),
                PartPose.offset(-10.0F, -6.0F, -8.0F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public void setupAnim(BloopEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.sway(this.tentacles, ageInTicks, 0.09F, 0.7F);
        Anims.head(this.head, netHeadYaw, headPitch);
        Anims.bob(this.body, ageInTicks, 0.6F);
    }
}
