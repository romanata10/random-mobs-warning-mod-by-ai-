package com.arena.randommobs.entity;

import com.arena.randommobs.util.Advancements;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * A classic 2004 camcorder UFO. Staring at it blinds you. Staring at it is also the only way
 * to get the achievement, so, you know. Do it for the achievement.
 */
public class UfoEntity extends RMonster {
    private int lifeTicks;

    public UfoEntity(EntityType<? extends UfoEntity> type, Level level) {
        super(type, level);
        this.xpReward = 30;
        this.setNoGravity(true);
        this.lifeTicks = 2400 + this.random.nextInt(2400);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 96.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);

        LivingEntity target = this.getTarget();
        Vec3 desired = Vec3.ZERO;
        if (target != null) {
            Vec3 wanted = target.position().add(0.0D, 9.0D, 0.0D);
            Vec3 delta = wanted.subtract(this.position());
            if (delta.length() > 2.0D) {
                desired = delta.normalize().scale(0.06D);
            }
        }
        this.setDeltaMovement(this.getDeltaMovement().scale(0.9D).add(desired));

        if (this.level().isClientSide()) {
            return;
        }

        if (--this.lifeTicks <= 0) {
            this.discard();
            return;
        }

        boolean someoneLooked = false;
        for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(64.0D))) {
            Vec3 toUfo = this.position().add(0.0D, 1.0D, 0.0D).subtract(player.getEyePosition());
            if (toUfo.length() > 64.0D) {
                continue;
            }
            double dot = player.getLookAngle().dot(toUfo.normalize());
            if (dot > 0.965D) {
                someoneLooked = true;
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 70, 0, false, false), this);
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0, false, false), this);
                if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
                    Advancements.grant(serverPlayer, "omg_its_ufo_in_trash_camera_from_2004");
                }
            }
        }

        if (someoneLooked && this.tickCount % 20 == 0) {
            this.level().playSound(null, this.blockPosition(), SoundEvents.WARDEN_AMBIENT,
                    SoundSource.AMBIENT, 3.0F, 0.5F);
        }

        if (this.level() instanceof ServerLevel serverLevel && this.tickCount % 4 == 0) {
            serverLevel.sendParticles(ParticleTypes.END_ROD, this.getX(), this.getY() - 0.4D, this.getZ(),
                    2, 0.8D, 0.05D, 0.8D, 0.01D);
            serverLevel.sendParticles(ParticleTypes.PORTAL, this.getX(), this.getY() - 0.5D, this.getZ(),
                    4, 1.4D, 0.1D, 1.4D, 0.1D);
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WARDEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SHULKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SHULKER_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 0.4F;
    }
}
