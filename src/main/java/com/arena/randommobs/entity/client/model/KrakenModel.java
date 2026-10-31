package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.KrakenEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class KrakenModel extends RMobModel<KrakenEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/kraken.png");
    public static final float SCALE = 0.73F;
    public static final float SHADOW = 2.60F;

    public KrakenModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-18.0F, -18.0F, -18.0F, 36.0F, 34.0F, 36.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(289, 0).addBox(-13.0F, -26.0F, -13.0F, 26.0F, 10.0F, 26.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -36.11F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 141).addBox(-9.0F, -8.0F, -8.0F, 18.0F, 13.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -24.0F, -14.0F));
        PartDefinition tentacle_0 = body.addOrReplaceChild("tentacle_0", CubeListBuilder.create()
                .texOffs(129, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 34.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-14.0F, 14.0F, -14.0F, 0.0F, 0.0F, -0.37F));
        PartDefinition tentacle_1 = body.addOrReplaceChild("tentacle_1", CubeListBuilder.create()
                .texOffs(178, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 40.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-7.0F, 14.0F, 14.0F, 0.0F, 0.0F, -0.24F));
        PartDefinition tentacle_2 = body.addOrReplaceChild("tentacle_2", CubeListBuilder.create()
                .texOffs(227, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 46.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 14.0F, -14.0F, 0.0F, 0.0F, -0.12F));
        PartDefinition tentacle_3 = body.addOrReplaceChild("tentacle_3", CubeListBuilder.create()
                .texOffs(276, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 34.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, 14.0F, 14.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition tentacle_4 = body.addOrReplaceChild("tentacle_4", CubeListBuilder.create()
                .texOffs(325, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 40.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(14.0F, 14.0F, -14.0F, 0.0F, 0.0F, 0.12F));
        PartDefinition tentacle_5 = body.addOrReplaceChild("tentacle_5", CubeListBuilder.create()
                .texOffs(374, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 46.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(21.0F, 14.0F, 14.0F, 0.0F, 0.0F, 0.24F));
        PartDefinition tentacle_6 = body.addOrReplaceChild("tentacle_6", CubeListBuilder.create()
                .texOffs(423, 141).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 34.0F, 6.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(28.0F, 14.0F, -14.0F, 0.0F, 0.0F, 0.37F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(KrakenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart tentacle_0 = this.root.getChild("body").getChild("tentacle_0"); Anims.swayOne(tentacle_0, ageInTicks, 0.09F, 3.14F);
        ModelPart tentacle_1 = this.root.getChild("body").getChild("tentacle_1"); Anims.swayOne(tentacle_1, ageInTicks, 0.09F, 4.71F);
        ModelPart tentacle_2 = this.root.getChild("body").getChild("tentacle_2"); Anims.swayOne(tentacle_2, ageInTicks, 0.09F, 6.28F);
        ModelPart tentacle_3 = this.root.getChild("body").getChild("tentacle_3"); Anims.swayOne(tentacle_3, ageInTicks, 0.09F, 7.85F);
        ModelPart tentacle_4 = this.root.getChild("body").getChild("tentacle_4"); Anims.swayOne(tentacle_4, ageInTicks, 0.09F, 9.42F);
        ModelPart tentacle_5 = this.root.getChild("body").getChild("tentacle_5"); Anims.swayOne(tentacle_5, ageInTicks, 0.09F, 11.00F);
        ModelPart tentacle_6 = this.root.getChild("body").getChild("tentacle_6"); Anims.swayOne(tentacle_6, ageInTicks, 0.09F, 12.57F);
    }
}
