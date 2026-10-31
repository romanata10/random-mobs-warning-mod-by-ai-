package com.arena.randommobs.entity.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

import java.util.List;

/**
 * Tiny animation helpers shared by all generated models.
 */
public final class Anims {
    public static void legs(List<ModelPart> legs, float limbSwing, float limbSwingAmount, float amplitude) {
        for (int i = 0; i < legs.size(); i++) {
            ModelPart leg = legs.get(i);
            float phase = (i % 2 == 0) ? 0.0F : (float) Math.PI;
            float swing = Mth.cos(limbSwing * 0.6662F + phase) * amplitude * limbSwingAmount;
            leg.xRot += swing;
            leg.zRot += swing * 0.25F * ((i % 2 == 0) ? 1.0F : -1.0F);
        }
    }

    public static void arms(List<ModelPart> arms, float limbSwing, float limbSwingAmount, float amplitude) {
        for (int i = 0; i < arms.size(); i++) {
            ModelPart arm = arms.get(i);
            float phase = (i % 2 == 0) ? (float) Math.PI : 0.0F;
            arm.xRot += Mth.cos(limbSwing * 0.6662F + phase) * amplitude * limbSwingAmount;
        }
    }

    public static void sway(List<ModelPart> parts, float ageInTicks, float amplitude, float phaseStep) {
        for (int i = 0; i < parts.size(); i++) {
            ModelPart part = parts.get(i);
            float phase = ageInTicks * 0.12F + i * phaseStep;
            part.xRot += Mth.sin(phase) * amplitude;
            part.zRot += Mth.cos(phase * 0.8F) * amplitude;
        }
    }

    public static void flap(List<ModelPart> wings, float ageInTicks, float amplitude) {
        for (int i = 0; i < wings.size(); i++) {
            ModelPart wing = wings.get(i);
            float direction = (i % 2 == 0) ? 1.0F : -1.0F;
            wing.zRot += Mth.sin(ageInTicks * 0.6F) * amplitude * direction;
        }
    }

    public static void head(ModelPart head, float netHeadYaw, float headPitch) {
        if (head == null) {
            return;
        }
        head.yRot += netHeadYaw * ((float) Math.PI / 180.0F) * 0.6F;
        head.xRot += headPitch * ((float) Math.PI / 180.0F) * 0.6F;
    }

    public static void bob(ModelPart part, float ageInTicks, float amplitude) {
        if (part != null) {
            part.y += Mth.sin(ageInTicks * 0.1F) * amplitude;
        }
    }

    private Anims() {
    }
}
