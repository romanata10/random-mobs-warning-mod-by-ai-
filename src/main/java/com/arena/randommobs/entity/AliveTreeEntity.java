package com.arena.randommobs.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A tree that walks around on four thin legs and plants other trees while it goes.
 * Break a tree in front of it and it will take that personally.
 */
public class AliveTreeEntity extends RMonster {
    private int rageTicks;

    public AliveTreeEntity(EntityType<? extends AliveTreeEntity> type, Level level) {
        super(type, level);
        this.xpReward = 45;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 140.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 32.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true) {
            @Override
            public boolean canUse() {
                return AliveTreeEntity.this.isEnraged() && super.canUse();
            }
        });
    }

    public boolean isEnraged() {
        return this.rageTicks > 0;
    }

    public void enrage(LivingEntity source) {
        this.rageTicks = 1400;
        this.setTarget(source);
        this.playSound(SoundEvents.GRASS_BREAK, 2.0F, 0.5F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.rageTicks > 0) {
            this.rageTicks--;
        }
        if (this.level() instanceof ServerLevel level && this.tickCount % 100 == 0) {
            this.plantTree(level);
        }
    }

    private void plantTree(ServerLevel level) {
        BlockPos origin = this.blockPosition();
        if (this.random.nextInt(3) != 0) {
            return;
        }
        for (int attempt = 0; attempt < 6; attempt++) {
            BlockPos pos = origin.offset(this.random.nextInt(9) - 4, this.random.nextInt(3) - 1, this.random.nextInt(9) - 4);
            BlockPos below = pos.below();
            if (!level.isEmptyBlock(pos) || !level.isEmptyBlock(pos.above()) || !level.isEmptyBlock(pos.above(2))) {
                continue;
            }
            BlockState soil = level.getBlockState(below);
            if (!soil.is(Blocks.GRASS_BLOCK) && !soil.is(Blocks.DIRT) && !soil.is(Blocks.PODZOL)) {
                continue;
            }
            BlockState sapling = Blocks.OAK_SAPLING.defaultBlockState();
            level.setBlockAndUpdate(pos, sapling);
            if (this.random.nextFloat() < 0.5F && sapling.getBlock() instanceof BonemealableBlock bonemeal
                    && bonemeal.isValidBonemealTarget(level, pos, sapling, false)) {
                bonemeal.performBonemeal(level, this.random, pos, sapling);
            }
            return;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.WOOD_STEP, 0.8F, 0.6F);
    }

    @Override
    public float getVoicePitch() {
        return 0.5F;
    }
}
