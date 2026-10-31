package net.minecraft.world.entity;
public abstract class Mob extends LivingEntity {
    public final net.minecraft.world.entity.ai.goal.GoalSelector goalSelector = null;
    public final net.minecraft.world.entity.ai.goal.GoalSelector targetSelector = null;
    public int xpReward;
    protected Mob(EntityType<? extends Mob> type, net.minecraft.world.level.Level level) {}
    public boolean canBeLeashed(net.minecraft.world.entity.player.Player player) { return false; }
    public boolean doHurtTarget(Entity target) { return false; }
    protected net.minecraft.sounds.SoundEvent getAmbientSound() { return null; }
    protected net.minecraft.sounds.SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source) { return null; }
    protected net.minecraft.sounds.SoundEvent getDeathSound() { return null; }
    protected float getSoundVolume() { return 0; }
    protected void registerGoals() {}
}
