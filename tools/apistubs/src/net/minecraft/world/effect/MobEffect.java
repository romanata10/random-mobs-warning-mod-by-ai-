package net.minecraft.world.effect;
public abstract class MobEffect {
    public MobEffect(MobEffectCategory category, int color) {}
    protected MobEffect addAttributeModifier(net.minecraft.world.entity.ai.attributes.Attribute attribute,
            String uuid, double amount, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation operation) { return this; }
    public void applyEffectTick(net.minecraft.world.entity.LivingEntity entity, int amplifier) {}
    public boolean isDurationEffectTick(int duration, int amplifier) { return false; }
}
