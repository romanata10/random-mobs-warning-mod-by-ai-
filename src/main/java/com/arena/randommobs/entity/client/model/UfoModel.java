package com.arena.randommobs.entity.client.model;

import com.arena.randommobs.entity.UfoEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class UfoModel extends RMobModel<UfoEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/ufo.png");
    public static final float SCALE = 0.76F;
    public static final float SHADOW = 1.40F;

    public UfoModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-22.0F, -6.0F, -22.0F, 44.0F, 8.0F, 44.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 105).addBox(-14.0F, -12.0F, -14.0F, 28.0F, 6.0F, 28.0F, CubeDeformation.NONE, 2.0F, 2.0F)
                .texOffs(0, 174).addBox(-26.0F, 2.0F, -26.0F, 52.0F, 4.0F, 52.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 287).addBox(-10.0F, 0.0F, -10.0F, 20.0F, 5.0F, 20.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition lamp_0 = body.addOrReplaceChild("lamp_0", CubeListBuilder.create()
                .texOffs(161, 287).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-16.0F, 4.0F, -16.0F));
        PartDefinition lamp_1 = body.addOrReplaceChild("lamp_1", CubeListBuilder.create()
                .texOffs(194, 287).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(-5.0F, 4.0F, 16.0F));
        PartDefinition lamp_2 = body.addOrReplaceChild("lamp_2", CubeListBuilder.create()
                .texOffs(227, 287).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(6.0F, 4.0F, -16.0F));
        PartDefinition lamp_3 = body.addOrReplaceChild("lamp_3", CubeListBuilder.create()
                .texOffs(260, 287).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, CubeDeformation.NONE, 2.0F, 2.0F),
                PartPose.offset(17.0F, 4.0F, 16.0F));
        return LayerDefinition.create(mesh, 512, 512);
    }

    @Override
    public void setupAnim(UfoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        this.resetPose();
        ModelPart body = this.root.getChild("body"); Anims.bob(body, ageInTicks, 0.45F);
        ModelPart head = this.root.getChild("body").getChild("head"); Anims.pulse(head, ageInTicks, 0.06F);
        ModelPart lamp_0 = this.root.getChild("body").getChild("lamp_0"); Anims.spin(lamp_0, ageInTicks, 0.35F);
        ModelPart lamp_1 = this.root.getChild("body").getChild("lamp_1"); Anims.spin(lamp_1, ageInTicks, 0.35F);
        ModelPart lamp_2 = this.root.getChild("body").getChild("lamp_2"); Anims.spin(lamp_2, ageInTicks, 0.35F);
        ModelPart lamp_3 = this.root.getChild("body").getChild("lamp_3"); Anims.spin(lamp_3, ageInTicks, 0.35F);
    }
}
