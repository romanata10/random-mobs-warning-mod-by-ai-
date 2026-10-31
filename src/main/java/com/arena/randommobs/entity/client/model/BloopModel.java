package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.BloopEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BloopModel extends RMobModel<BloopEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/bloop.png");
    public static final float SCALE = 1.02F;
    public static final float SHADOW = 3.40F;

    public BloopModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-26.0F, -16.0F, -24.0F, 52.0F, 34.0F, 48.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 165).addBox(-20.0F, -26.0F, -18.0F, 40.0F, 12.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 262).addBox(-32.0F, -2.0F, -28.0F, 64.0F, 8.0F, 56.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -10.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 391).addBox(-10.0F, -6.0F, -8.0F, 20.0F, 12.0F, 10.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -26.0F, -20.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(121, 391).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-18.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.28F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(170, 391).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.14F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(219, 391).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(268, 391).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(18.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.14F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(317, 391).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 26.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(30.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.28F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(BloopEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 3.14F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 4.71F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_4 = this.root.getChild("body").getChild("tentacle_4"); Anims.swayOne(tentacle_4, ageInTicks, 0.09F, 9.42F);
    }
}
