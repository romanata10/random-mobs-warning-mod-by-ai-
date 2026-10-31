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
    public static final float SCALE = 0.84F;
    public static final float SHADOW = 1.80F;

    public AliveHouseModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-30.0F, -30.0F, -30.0F, 60.0F, 34.0F, 60.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 189).addBox(-34.0F, -34.0F, -34.0F, 68.0F, 6.0F, 68.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(545, 189).addBox(-26.0F, -44.0F, -26.0F, 52.0F, 12.0F, 52.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -4.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 338).addBox(-8.0F, -14.0F, -4.0F, 16.0F, 16.0F, 8.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -44.0F, -28.0F));
        PartDefinition leg_a = root.addOrReplaceChild("leg_a", CubeListBuilder.create()
                .texOffs(97, 338).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 20.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(18.0F, -2.0F, 18.0F, -0.14F, 0.0F, -0.10F));
        PartDefinition leg_b = root.addOrReplaceChild("leg_b", CubeListBuilder.create()
                .texOffs(146, 338).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 20.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-18.0F, -2.0F, 18.0F, -0.14F, 0.0F, 0.10F));
        PartDefinition leg_c = root.addOrReplaceChild("leg_c", CubeListBuilder.create()
                .texOffs(195, 338).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 20.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(18.0F, -2.0F, -18.0F, 0.14F, 0.0F, -0.10F));
        PartDefinition leg_d = root.addOrReplaceChild("leg_d", CubeListBuilder.create()
                .texOffs(244, 338).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 20.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-18.0F, -2.0F, -18.0F, 0.14F, 0.0F, 0.10F));
        return LayerDefinition.create(mesh, 1024, 512);
    }

    @Override
    public void setupAnim(AliveHouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart leg_a = this.root.getChild("leg_a"); Anims.swing(leg_a, limbSwing, limbSwingAmount, 0.95F, 3.14F);
        ModelPart leg_b = this.root.getChild("leg_b"); Anims.swing(leg_b, limbSwing, limbSwingAmount, 0.95F, 4.71F);
        ModelPart leg_c = this.root.getChild("leg_c"); Anims.swing(leg_c, limbSwing, limbSwingAmount, 0.95F, 6.28F);
        ModelPart leg_d = this.root.getChild("leg_d"); Anims.swing(leg_d, limbSwing, limbSwingAmount, 0.95F, 7.85F);
    }
}
