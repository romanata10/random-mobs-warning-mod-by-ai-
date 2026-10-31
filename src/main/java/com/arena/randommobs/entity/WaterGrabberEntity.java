package com.arena.randommobs.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * A giant sea star with a mouth in the middle and two enormous arms. It hooks boats and
 * swimmers and drags them to the bottom.
 */
public class WaterGrabberEntity extends RWaterMonster {
    public WaterGrabberEntity(EntityType<? extends WaterGrabberEntity> type, Level level) {
        super(type, level);
        this.xpReward = 40;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 90.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.24D)
                .add(Attributes.ATTACK_DAMAGE, 9.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
    }

    /** Grabs everything floating above it and pulls it under. */
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }
        AABB area = this.getBoundingBox().inflate(10.0D, 14.0D, 10.0D);
        for (Entity entity : this.level().getEntities(this, area)) {
            if (entity == this || !(entity instanceof LivingEntity) && !entity.isVehicle()) {
                continue;
            }
            if (entity.getY() > this.getY() + 1.0D && this.isInWater()) {
                Vec3 pull = this.position().subtract(entity.position()).normalize().scale(0.28D);
                entity.setDeltaMovement(entity.getDeltaMovement()
                        .add(pull.x, -0.16D, pull.z).scale(0.94D));
                entity.hurtMarked = true;
                if (entity instanceof LivingEntity living && this.random.nextInt(30) == 0) {
                    living.hurt(this.damageSources().mobAttack(this), 4.0F);
                }
            }
        }
        if (this.level() instanceof ServerLevel serverLevel && this.tickCount % 10 == 0) {
            serverLevel.sendParticles(ParticleTypes.BUBBLE, this.getX(), this.getY() + 0.6D, this.getZ(),
                    6, 1.2D, 0.4D, 1.2D, 0.02D);
        }
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit && target instanceof LivingEntity living) {
            living.setDeltaMovement(living.getDeltaMovement().add(0.0D, -0.9D, 0.0D));
        }
        return hit;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 0.4F;
    }
}
