package com.arena.randommobs.entity;

/**
 * Mobs that want to visually offset themselves (for example a living house that is still
 * climbing out of the ground).
 */
public interface RAnimatedMob {
    default float renderYOffset(float partialTick) {
        return 0.0F;
    }
}
