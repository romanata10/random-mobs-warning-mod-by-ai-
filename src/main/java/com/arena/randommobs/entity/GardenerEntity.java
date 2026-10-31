package com.arena.randommobs.entity;

import com.arena.randommobs.registry.ModBlocks;
import com.arena.randommobs.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
 * The Gardeners. Pale, jellyfish-like things with a single burning eye. They live on land,
 * in the ocean and deep in caves, and everywhere they go they plant red roots, lianas and
 * brand new Woodcrawlers. They are, quite literally, gardening.
 */
public class GardenerEntity extends RMonster {
    public GardenerEntity(EntityType<? extends GardenerEntity> type, Level level) {
        super(type, level);
        this.xpReward = 25;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.235D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 40.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 32.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit && target instanceof LivingEntity living) {
            this.infect(living, 500, 1);
        }
        return hit;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public void travel(Vec3 input) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), input);
            this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(input);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level() instanceof ServerLevel level && this.tickCount % 40 == 0) {
            com.arena.randommobs.util.Advancements.grantForAllNearby(level, this.position(), 32.0D, "saw_gardener");
            this.garden(level);
            if (this.tickCount % 400 == 0) {
                long woodcrawlers = level.getEntitiesOfClass(WoodcrawlerEntity.class,
                        this.getBoundingBox().inflate(24.0D)).size();
                if (woodcrawlers < 3) {
                    ModEntities.WOODCRAWLER.get().spawn(level, this.blockPosition().above(), MobSpawnType.MOB_SUMMONED);
                }
            }
        }
    }

    private void garden(ServerLevel level) {
        for (int attempt = 0; attempt < 4; attempt++) {
            BlockPos pos = this.blockPosition().offset(
                    this.random.nextInt(9) - 4,
                    this.random.nextInt(5) - 2,
                    this.random.nextInt(9) - 4);
            if (!level.isEmptyBlock(pos)) {
                continue;
            }
            BlockPos below = pos.below();
            if (level.getBlockState(below).isFaceSturdy(level, below, Direction.UP)) {
                BlockState roots = ModBlocks.RED_ROOTS.get().defaultBlockState();
                if (roots.canSurvive(level, pos)) {
                    level.setBlockAndUpdate(pos, roots);
                }
            } else if (level.getBlockState(pos.above()).isFaceSturdy(level, pos.above(), Direction.DOWN)) {
                level.setBlockAndUpdate(pos, ModBlocks.ROOT_LIANA.get().defaultBlockState());
            }
        }
        level.sendParticles(ParticleTypes.SPORE_BLOSSOM_AIR, this.getX(), this.getY() + 1.5D, this.getZ(),
                3, 0.4D, 0.4D, 0.4D, 0.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SCULK_CLICKING;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SCULK_BLOCK_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SCULK_BLOCK_SPREAD;
    }

    @Override
    public float getVoicePitch() {
        return 1.5F;
    }
}
