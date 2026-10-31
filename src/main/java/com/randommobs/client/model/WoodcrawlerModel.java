package com.randommobs.client.model;

import com.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

/**
 * Woodcrawler model: unnaturally tall and thin, with a small head, long
 * torso and long arms that almost reach the ground. Roughly 3.3 blocks tall.
 * Texture size: 64x64.
 */
public class WoodcrawlerModel extends HierarchicalModel<WoodcrawlerEntity> {

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart legLeft;
    private final ModelPart legRight;
    private final ModelPart armLeft;
    private final ModelPart armRight;

    public WoodcrawlerModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.legLeft = root.getChild("leg_left");
        this.legRight = root.getChild("leg_right");
        this.armLeft = this.torso.getChild("arm_left");
        this.armRight = this.torso.getChild("arm_right");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offset(0.0F, -20.0F, 0.0F));

        PartDefinition torso = root.addOrReplaceChild("torso",
                CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 24.0F, 6.0F),
                PartPose.offset(0.0F, -20.0F, 0.0F));

        root.addOrReplaceChild("leg_left",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 20.0F, 4.0F),
                PartPose.offset(-4.0F, 4.0F, 0.0F));
        root.addOrReplaceChild("leg_right",
                CubeListBuilder.create().texOffs(16, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 20.0F, 4.0F),
                PartPose.offset(4.0F, 4.0F, 0.0F));

        // Arms hang from the shoulders down to knee height.
        torso.addOrReplaceChild("arm_left",
                CubeListBuilder.create().texOffs(32, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F),
                PartPose.offset(-5.5F, 2.0F, 0.0F));
        torso.addOrReplaceChild("arm_right",
                CubeListBuilder.create().texOffs(40, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F),
                PartPose.offset(5.5F, 2.0F, 0.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(WoodcrawlerEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        this.legLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
        this.legRight.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 1.2F * limbSwingAmount;

        // Arms swing opposite the legs, always slightly raised and stiff.
        this.armLeft.xRot = Mth.cos(limbSwing * 0.6662F + Mth.PI) * 0.7F * limbSwingAmount - 0.25F;
        this.armRight.xRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount - 0.25F;
        this.armLeft.zRot = 0.08F + Mth.cos(ageInTicks * 0.06F) * 0.04F;
        this.armRight.zRot = -0.08F - Mth.cos(ageInTicks * 0.06F) * 0.04F;

        // Slight unnatural torso lean.
        this.torso.xRot = 0.05F + Mth.cos(ageInTicks * 0.09F) * 0.03F;
    }
}
