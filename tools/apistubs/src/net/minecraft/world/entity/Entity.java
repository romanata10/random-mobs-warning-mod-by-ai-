package net.minecraft.world.entity;
public abstract class Entity {
    public int tickCount;
    public net.minecraft.world.level.Level level() { return null; }
    public double getX() { return 0; }
    public double getY() { return 0; }
    public double getZ() { return 0; }
    public net.minecraft.core.BlockPos blockPosition() { return null; }
    public double getEyeY() { return 0; }
    public net.minecraft.world.phys.Vec3 getEyePosition() { return null; }
    public net.minecraft.world.phys.AABB getBoundingBox() { return null; }
    public void setSecondsOnFire(int seconds) {}
    public boolean isEyeInFluid(net.minecraft.tags.TagKey<net.minecraft.world.level.material.Fluid> tag) { return false; }
    public void playSound(net.minecraft.sounds.SoundEvent sound, float volume, float pitch) {}
    public net.minecraft.util.RandomSource getRandom() { return null; }
    public net.minecraft.world.damagesource.DamageSources damageSources() { return null; }
    public boolean isAlive() { return false; }
    public boolean isRemoved() { return false; }
    public void tick() {}
    public void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}
    public void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}
}
