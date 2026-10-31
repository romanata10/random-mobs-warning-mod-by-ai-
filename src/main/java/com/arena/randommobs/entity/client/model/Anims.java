package com.arena.randommobs.entity.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

/**
 * Tiny animation helpers shared by all generated models.
 */
public final class Anims {

    public static void swing(ModelPart part, float limbSwing, float limbSwingAmount, float amplitude, float phase) {
        if (part == null) {
            return;
        }
        part.xRot += Mth.cos(limbSwing * 0.6662F + phase) * amplitude * limbSwingAmount;
        part.zRot += Mth.cos(limbSwing * 0.6662F + phase) * amplitude * limbSwingAmount * 0.18F;
    }

    public static void swayOne(ModelPart part, float ageInTicks, float amplitude, float phase) {
        if (part == null) {
            return;
        }
        part.xRot += Mth.sin(ageInTicks * 0.11F + phase) * amplitude;
        part.zRot += Mth.cos(ageInTicks * 0.09F + phase) * amplitude * 0.8F;
    }

    public static void flapOne(ModelPart part, float ageInTicks, float amplitude, float phase) {
        if (part == null) {
            return;
        }
        part.zRot += Mth.sin(ageInTicks * 0.55F + phase) * amplitude;
    }

    public static void look(ModelPart head, float netHeadYaw, float headPitch) {
        if (head == null) {
            return;
        }
        head.yRot += netHeadYaw * ((float) Math.PI / 180.0F) * 0.7F;
        head.xRot += headPitch * ((float) Math.PI / 180.0F) * 0.7F;
    }

    public static void bob(ModelPart part, float ageInTicks, float amplitude) {
        if (part != null) {
            part.y += Mth.sin(ageInTicks * 0.1F) * amplitude;
        }
    }

    public static void jaw(ModelPart part, float ageInTicks, float amplitude) {
        if (part != null) {
            part.xRot += (0.5F + 0.5F * Mth.sin(ageInTicks * 0.2F)) * amplitude;
        }
    }

    public static void spin(ModelPart part, float ageInTicks, float speed) {
        if (part != null) {
            part.yRot += ageInTicks * speed;
        }
    }

    public static void pulse(ModelPart part, float ageInTicks, float amplitude) {
        if (part != null) {
            float scale = 1.0F + Mth.sin(ageInTicks * 0.15F) * amplitude;
            part.xScale *= scale;
            part.yScale *= scale;
            part.zScale *= scale;
        }
    }

    private Anims() {
    }
}
