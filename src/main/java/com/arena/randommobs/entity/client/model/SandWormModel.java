package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.SandWormEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SandWormModel extends RMobModel<SandWormEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/sand_worm.png");
    public static final float SCALE = 0.92F;
    public static final float SHADOW = 2.0F;

    public SandWormModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-10.0F, -10.0F, -10.0F, 20.0F, 22.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(161, 0).addBox(-8.0F, 10.0F, -8.0F, 16.0F, 8.0F, 16.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(290, 0).addBox(-12.0F, -2.0F, -12.0F, 24.0F, 5.0F, 24.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 85).addBox(-9.0F, -6.0F, -9.0F, 18.0F, 12.0F, 18.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(145, 85).addBox(-7.0F, 4.0F, -7.0F, 14.0F, 5.0F, 14.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -14.40F, 0.0F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create()
                .texOffs(258, 85).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 8.0F, 12.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, -2.0F));
        PartDefinition spike_0 = body.addOrReplaceChild("spike_0", CubeListBuilder.create()
                .texOffs(355, 85).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-12.0F, -3.20F, 0.0F, 0.0F, 0.0F, -0.52F));
        PartDefinition spike_1 = body.addOrReplaceChild("spike_1", CubeListBuilder.create()
                .texOffs(372, 85).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, -3.20F, 0.0F, 0.0F, 0.0F, -0.17F));
        PartDefinition spike_2 = body.addOrReplaceChild("spike_2", CubeListBuilder.create()
                .texOffs(389, 85).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, -3.20F, 0.0F, 0.0F, 0.0F, 0.17F));
        PartDefinition spike_3 = body.addOrReplaceChild("spike_3", CubeListBuilder.create()
                .texOffs(406, 85).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offsetAndRotation(12.0F, -3.20F, 0.0F, 0.0F, 0.0F, 0.52F));
        return LayerDefinition.create(mesh, 512, 256);
    }

    @Override
    public void setupAnim(SandWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.look(head, netHeadYaw, headPitch);
        ModelPart jaw = this.root.getChild("body").getChild("head").getChild("jaw"); Anims.jaw(jaw, ageInTicks, 0.18F);
        ModelPart spike_0 = this.root.getChild("body").getChild("spike_0"); Anims.swayOne(spike_0, ageInTicks, 0.09F, 4.71F);
        ModelPart spike_1 = this.root.getChild("body").getChild("spike_1"); Anims.swayOne(spike_1, ageInTicks, 0.09F, 6.28F);
        ModelPart spike_2 = this.root.getChild("body").getChild("spike_2"); Anims.swayOne(spike_2, ageInTicks, 0.09F, 7.85F);
        ModelPart spike_3 = this.root.getChild("body").getChild("spike_3"); Anims.swayOne(spike_3, ageInTicks, 0.09F, 9.42F);
    }
}
