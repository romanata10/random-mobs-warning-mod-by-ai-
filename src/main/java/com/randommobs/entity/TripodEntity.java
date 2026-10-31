package com.randommobs.entity;

import com.randommobs.RandomMobsConfig;
import com.randommobs.registry.ModAdvancements;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

/**
 * The tripod from "War of the Worlds".
 * <p>
 * A giant three-legged war machine with a heat ray. It is fireproof, but
 * short-circuits in water: while its head is underwater it takes damage.
 * The first time a tripod gets fully submerged, every player who helped
 * sink it receives the "Oh that just fish" advancement.
 */
public class TripodEntity extends Monster implements RangedAttackMob {

    private boolean fishAwarded = false;

    public TripodEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 30;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.ATTACK_DAMAGE, 14.0D)
                .add(Attributes.ARMOR, 12.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 64.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.9D, true));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 0.7D, 50, 40.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.55D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 48.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            return;
        }

        // The tripod short-circuits when its head goes underwater.
        if (this.isEyeInFluid(FluidTags.WATER)) {
            if (this.tickCount % 20 == 0) {
                this.hurt(this.damageSources().drown(), RandomMobsConfig.TRIPOD_WATER_DAMAGE.get().floatValue());
            }
            if (this.tickCount % 10 == 0 && this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        this.getX(), this.getEyeY(), this.getZ(),
                        8, this.getBbWidth() * 0.4D, 0.8D, this.getBbWidth() * 0.4D, 0.02D);
                this.playSound(SoundEvents.FIRE_EXTINGUISH, 2.0F, 0.7F);
            }
            if (!this.fishAwarded) {
                this.fishAwarded = true;
                awardFishAdvancement();
            }
        }
    }

    /**
     * Grants "Oh that just fish" to the player who sank the tripod
     * (last attacker) and to everyone standing nearby watching it happen.
     */
    private void awardFishAdvancement() {
        ServerPlayer credited = this.lastHurtByPlayer;
        if (credited != null) {
            ModAdvancements.award(credited, ModAdvancements.OH_THATS_JUST_FISH);
        }
        for (ServerPlayer nearby : this.level().getEntitiesOfClass(ServerPlayer.class,
                this.getBoundingBox().inflate(48.0D))) {
            ModAdvancements.award(nearby, ModAdvancements.OH_THATS_JUST_FISH);
        }
    }

    /** The famous heat ray: sets the target on fire and draws a burning beam to it. */
    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {
        if (!(this.level() instanceof ServerLevel serverLevel) || !target.isAlive()) {
            return;
        }
        target.setSecondsOnFire(6);
        float damage = RandomMobsConfig.TRIPOD_HEAT_RAY_DAMAGE.get().floatValue() + this.getRandom().nextInt(4);
        target.hurt(this.damageSources().mobAttack(this), damage);

        Vec3 start = this.getEyePosition();
        Vec3 end = target.getEyePosition();
        int steps = Mth.ceil(start.distanceTo(end));
        for (int i = 0; i <= steps; i++) {
            double delta = steps == 0 ? 0.0D : (double) i / (double) steps;
            double x = Mth.lerp(delta, start.x, end.x);
            double y = Mth.lerp(delta, start.y, end.y);
            double z = Mth.lerp(delta, start.z, end.z);
            serverLevel.sendParticles(ParticleTypes.FLAME, x, y, z, 2, 0.08D, 0.08D, 0.08D, 0.0D);
            if (i % 3 == 0) {
                serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 1, 0.05D, 0.05D, 0.05D, 0.005D);
            }
        }
        this.playSound(SoundEvents.BLAZE_SHOOT, 4.0F, 0.5F);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("FishAwarded", this.fishAwarded);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.fishAwarded = tag.getBoolean("FishAwarded");
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_ROAR;
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
    protected float getSoundVolume() {
        return 4.0F;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return false;
    }

    /**
     * Tripods can spawn in any light level, but only on solid ground —
     * they have to stand somewhere.
     */
    public static boolean checkTripodSpawnRules(EntityType<? extends Monster> type, ServerLevelAccessor level,
                                                MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Monster.checkAnyLightMonsterSpawnRules(type, level, spawnType, pos, random)
                && level.getBlockState(pos.below()).isSolidRender(level, pos.below());
    }
}
