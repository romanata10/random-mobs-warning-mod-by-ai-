package com.randommobs.effect;

import com.randommobs.RandomMobsConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

/**
 * The Root Virus (from Gemini Home Entertainment).
 * <p>
 * Roots slowly grow inside the victim: periodic damage, slowed movement and
 * a faint heartbeat. Cured by milk (like any vanilla effect) or by waiting
 * it out. Spore particles rise from the victim while infected.
 */
public class RootVirusEffect extends MobEffect {

    private static final String SPEED_MODIFIER_UUID = "B0F2A5C3-9E17-4D84-A6F0-2C8B7E5D1A3F";

    /** Must match RandomMobsConfig default; read as a constant because effects are constructed before the config loads. */
    private static final double SPEED_PENALTY = -0.20D;

    public RootVirusEffect() {
        super(MobEffectCategory.HARMFUL, 0x6B4A2B);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, SPEED_MODIFIER_UUID,
                SPEED_PENALTY,
                AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        float damage = RandomMobsConfig.ROOT_VIRUS_DAMAGE.get().floatValue();
        if (damage > 0.0F && entity.getHealth() > 1.0F) {
            entity.hurt(entity.damageSources().magic(), damage);
        }

        if (entity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SPORE_BLOSSOM_AIR,
                    entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(),
                    6, entity.getBbWidth() * 0.4D, entity.getBbHeight() * 0.4D, entity.getBbWidth() * 0.4D, 0.01D);
            if (entity instanceof ServerPlayer) {
                serverLevel.playSound(null, entity.blockPosition(),
                        SoundEvents.WARDEN_HEARTBEAT, SoundSource.HOSTILE, 0.5F, 1.2F);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Tick the virus every 3 seconds, slightly faster at higher amplifiers.
        int interval = Math.max(20, 60 >> amplifier);
        return duration % interval == 0;
    }
}
