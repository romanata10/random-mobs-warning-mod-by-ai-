package com.arena.randommobs.entity;

import com.arena.randommobs.util.Advancements;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * A Martian fighting machine. Three legs, one eye, one heat ray. It does not like water:
 * tripods that end up underwater are, canonically, just fish.
 */
public class TripodEntity extends RMonster {
    private int heatRayCooldown = 0;

    public TripodEntity(EntityType<? extends TripodEntity> type, Level level) {
        super(type, level);
        this.xpReward = 100;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 220.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.ARMOR, 12.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 64.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 64.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }
        if (this.heatRayCooldown > 0) {
            this.heatRayCooldown--;
        }
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive() && this.getSensing().hasLineOfSight(target)) {
            double distance = this.distanceTo(target);
            if (distance < 40.0D && this.heatRayCooldown <= 0) {
                this.fireHeatRay(target);
                this.heatRayCooldown = 90 + this.random.nextInt(60);
            }
        }
        // "Oh, that just fish" - a tripod that sinks is no longer a tripod.
        if (this.isUnderWater()) {
            Advancements.grantForAllNearby(this.level(), this.position(), 48.0D, "oh_that_just_fish");
        }
    }

    private void fireHeatRay(LivingEntity target) {
        Vec3 from = this.getEyePosition();
        Vec3 to = target.position().add(0.0D, target.getBbHeight() * 0.5D, 0.0D);
        Vec3 direction = to.subtract(from);
        double length = direction.length();
        if (length < 0.001D) {
            return;
        }
        Vec3 step = direction.normalize().scale(0.4D);
        if (this.level() instanceof ServerLevel serverLevel) {
            for (double travelled = 0.0D; travelled < length; travelled += 0.4D) {
                Vec3 point = from.add(step.scale(travelled / 0.4D));
                serverLevel.sendParticles(ParticleTypes.SMALL_FLAME, point.x, point.y, point.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                if (travelled % 2.0D < 0.4D) {
                    serverLevel.sendParticles(ParticleTypes.LAVA, point.x, point.y, point.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLAZE_SHOOT,
                SoundSource.HOSTILE, 3.0F, 0.4F);
        target.hurt(this.damageSources().mobAttack(this), 10.0F);
        target.setSecondsOnFire(8);
        target.setDeltaMovement(target.getDeltaMovement().add(0.0D, 0.4D, 0.0D));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.RAVAGER_STEP, 1.4F, 0.5F);
    }

    @Override
    public float getVoicePitch() {
        return 0.35F;
    }

    @Override
    public int getMaxFallDistance() {
        return 60;
    }
}
