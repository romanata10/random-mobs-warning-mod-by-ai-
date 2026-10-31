package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.AliveTreeEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class AliveTreeModel extends RMobModel<AliveTreeEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/alive_tree.png");
    public static final float SCALE = 1.0F;
    public static final float SHADOW = 1.80F;

    public AliveTreeModel(ModelPart root) {
        super(root);
        this.registerParts(List.of(root.getChild("leg_a"), root.getChild("leg_b"), root.getChild("leg_c"), root.getChild("leg_d")),
                List.of(),
                List.of(),
                List.of(),
                root.getChild("head"),
                root.getChild("body"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 30.0F, 10.0F)
                .texOffs(41, 0).addBox(-8.0F, 6.0F, -8.0F, 16.0F, 6.0F, 16.0F),
                PartPose.offset(0.0F, -18.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 41).addBox(-20.0F, -12.0F, -20.0F, 40.0F, 20.0F, 40.0F)
                .texOffs(0, 102).addBox(-14.0F, -18.0F, -14.0F, 28.0F, 8.0F, 28.0F)
                .texOffs(113, 102).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offset(0.0F, -38.0F, 0.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(146, 102).addBox(-1.50F, 0.0F, -1.50F, 3.0F, 12.0F, 3.0F),
                PartPose.offset(6.0F, 12.0F, 6.0F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(159, 102).addBox(-1.50F, 0.0F, -1.50F, 3.0F, 12.0F, 3.0F),
                PartPose.offset(-6.0F, 12.0F, 6.0F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(172, 102).addBox(-1.50F, 0.0F, -1.50F, 3.0F, 12.0F, 3.0F),
                PartPose.offset(6.0F, 12.0F, -6.0F));
        PartDefinition leg_d = root.addOrReplaceChild("leg_d", CubeListBuilder.create()
                .texOffs(185, 102).addBox(-1.50F, 0.0F, -1.50F, 3.0F, 12.0F, 3.0F),
                PartPose.offset(-6.0F, 12.0F, -6.0F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public void setupAnim(AliveTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        Anims.legs(this.legs, limbSwing, limbSwingAmount, 0.9F);
        Anims.head(this.head, netHeadYaw, headPitch);
    }
}
