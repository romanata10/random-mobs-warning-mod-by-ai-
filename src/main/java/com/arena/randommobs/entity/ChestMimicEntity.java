package com.arena.randommobs.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * A chest that is a mouth. Opening it is a mistake.
 */
public class ChestMimicEntity extends RMonster {
    private int stillTicks;

    public ChestMimicEntity(EntityType<? extends ChestMimicEntity> type, Level level) {
        super(type, level);
        this.xpReward = 15;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.ATTACK_DAMAGE, 7.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 24.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25D, false));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    /** Mimics sit perfectly still until someone tries to "open" them. */
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }
        Player player = this.level().getNearestPlayer(this, 4.0D);
        if (player != null && !player.isCreative()) {
            if (this.stillTicks++ > 6) {
                this.setTarget(player);
                this.playSound(SoundEvents.CHEST_OPEN, 1.5F, 0.6F);
            }
        } else if (this.stillTicks > 0) {
            this.stillTicks = 0;
        }
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide()) {
            this.playSound(SoundEvents.CHEST_OPEN, 2.0F, 0.5F);
            this.setTarget(player);
            player.hurt(this.damageSources().mobAttack(this), 6.0F);
            if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
                com.arena.randommobs.util.Advancements.grant(serverPlayer, "mimic_bite");
            }
        }
        return InteractionResult.sidedSuccess(this.level().isClientSide());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHEST_OPEN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CHEST_CLOSE;
    }

    @Override
    public float getVoicePitch() {
        return 0.55F;
    }
}
