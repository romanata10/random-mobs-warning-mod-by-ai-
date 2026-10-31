package com.randommobs.entity;

import com.randommobs.RandomMobsConfig;
import com.randommobs.registry.ModAdvancements;
import com.randommobs.registry.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
 * The woodcrawler from "Gemini Home Entertainment".
 * <p>
 * A tall, thin wooden creature that stalks players. If it lands a hit,
 * the victim gets infected with the Root Virus, which slowly damages and
 * slows them down until it runs out or is cured with milk.
 */
public class WoodcrawlerEntity extends Monster {

    public WoodcrawlerEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 12;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 45.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.6D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 24.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit && target instanceof LivingEntity living) {
            MobEffectInstance virus = new MobEffectInstance(
                    ModEffects.ROOT_VIRUS.get(),
                    RandomMobsConfig.ROOT_VIRUS_DURATION.get(),
                    0);
            if (living.addEffect(virus, this)) {
                if (living instanceof ServerPlayer player) {
                    ModAdvancements.award(player, ModAdvancements.ROOT_VIRUS);
                    player.displayClientMessage(
                            Component.translatable("message.randommobs.infected"), false);
                }
            }
        }
        return hit;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        // Quiet root particles give it away at close range.
        if (this.level() instanceof ServerLevel serverLevel && this.tickCount % 40 == 0) {
            serverLevel.sendParticles(ParticleTypes.SPORE_BLOSSOM_AIR,
                    this.getX(), this.getY() + 0.2D, this.getZ(),
                    2, this.getBbWidth() * 0.5D, 0.1D, this.getBbWidth() * 0.5D, 0.01D);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        // The woodcrawler hunts silently.
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BAMBOO_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BAMBOO_WOOD_BREAK;
    }

    @Override
    protected float getSoundVolume() {
        return 2.0F;
    }
}
