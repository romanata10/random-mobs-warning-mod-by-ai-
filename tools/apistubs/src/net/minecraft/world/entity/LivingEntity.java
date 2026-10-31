package net.minecraft.world.entity;
public abstract class LivingEntity extends Entity {
    public net.minecraft.server.level.ServerPlayer lastHurtByPlayer;
    public float getHealth() { return 0; }
    public boolean addEffect(net.minecraft.world.effect.MobEffectInstance effect, Entity source) { return false; }
    public boolean addEffect(net.minecraft.world.effect.MobEffectInstance effect) { return false; }
    public boolean hurt(net.minecraft.world.damagesource.DamageSource source, float amount) { return false; }
    public void aiStep() {}
    public float getBbWidth() { return 0; }
    public float getBbHeight() { return 0; }
}
