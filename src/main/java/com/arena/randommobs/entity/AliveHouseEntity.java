package com.arena.randommobs.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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

/**
 * A villager's house that got hungry. It climbs out of the ground with a very unpleasant
 * creaking sound and then it follows you, because you look like a snack.
 */
public class AliveHouseEntity extends RMonster implements RAnimatedMob {
    private static final EntityDataAccessor<Integer> DATA_RISE =
            SynchedEntityData.defineId(AliveHouseEntity.class, EntityDataSerializers.INT);

    public AliveHouseEntity(EntityType<? extends AliveHouseEntity> type, Level level) {
        super(type, level);
        this.xpReward = 35;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 90.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.245D)
                .add(Attributes.ATTACK_DAMAGE, 11.0D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_RISE, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.05D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 32.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    /** 0 = completely buried, 40 = fully out of the ground. */
    public int getRiseTicks() {
        return this.entityData.get(DATA_RISE);
    }

    public boolean isRising() {
        return this.getRiseTicks() < 40;
    }

    public float riseProgress(float partialTick) {
        return Math.min(1.0F, (this.getRiseTicks() + partialTick) / 40.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide() && this.isRising()) {
            this.entityData.set(DATA_RISE, this.getRiseTicks() + 1);
            this.getNavigation().stop();
            this.setDeltaMovement(0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public float renderYOffset(float partialTick) {
        // Still buried? Then draw the model underground.
        return -3.2F * (1.0F - this.riseProgress(partialTick));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return this.isRising() || super.isInvulnerableTo(source);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit) {
            this.heal(4.0F);
        }
        return hit;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOODEN_DOOR_OPEN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOODEN_DOOR_CLOSE;
    }

    @Override
    public float getVoicePitch() {
        return 0.4F;
    }

    @Override
    protected float getSoundVolume() {
        return 1.6F;
    }
}
