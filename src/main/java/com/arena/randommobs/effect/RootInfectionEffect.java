package com.arena.randommobs.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * The root virus. It slowly eats the host from the inside, and can only be cured with Root Serum
 * (or by dying, which turns you into a Nature's Mockery).
 */
public class RootInfectionEffect extends MobEffect {
    public RootInfectionEffect() {
        super(MobEffectCategory.HARMFUL, 0x6B3A1B);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int interval = 40 >> Math.min(amplifier, 4);
        return interval <= 0 || duration % interval == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) {
            return;
        }
        if (entity instanceof Player player && player.getAbilities().instabuild) {
            return;
        }
        entity.hurt(entity.damageSources().magic(), 1.0F + amplifier * 0.5F);
    }
}
