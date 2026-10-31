package com.arena.randommobs.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * An abandoned tank. It does not care about you unless you start something.
 */
public class TankEntity extends RMonster {
    private int shotCooldown;

    public TankEntity(EntityType<? extends TankEntity> type, Level level) {
        super(type, level);
        this.xpReward = 80;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 160.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.18D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.ARMOR, 20.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 40.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 24.0F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    /** Neutral: only the thing that hurt it becomes a target - and then it shoots. */
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }
        if (this.shotCooldown > 0) {
            this.shotCooldown--;
        }
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive() && this.shotCooldown <= 0
                && this.distanceToSqr(target) < 40.0D * 40.0D
                && this.getSensing().hasLineOfSight(target)) {
            this.fireShell(target);
            this.shotCooldown = 100;
        }
    }

    private void fireShell(LivingEntity target) {
        Vec3 from = this.getEyePosition();
        Vec3 to = target.position().add(0.0D, target.getBbHeight() * 0.5D, 0.0D);
        Vec3 dir = to.subtract(from).normalize();
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE,
                SoundSource.HOSTILE, 2.0F, 0.6F);
        target.hurt(this.damageSources().mobAttack(this), 14.0F);
        target.setDeltaMovement(target.getDeltaMovement().add(dir.x * 1.6D, 0.6D, dir.z * 1.6D));
        // splash damage in a small area, like a real shell
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(24.0D))) {
            if (entity instanceof LivingEntity living && living != this && living != target
                    && living.distanceToSqr(target) < 9.0D) {
                living.hurt(this.damageSources().mobAttack(this), 6.0F);
            }
        }
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 0.35F;
    }
}
