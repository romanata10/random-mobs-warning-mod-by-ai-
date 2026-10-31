package net.minecraft.world.level;
public abstract class Level implements BlockGetter {
    public boolean isClientSide;
    public <T extends net.minecraft.world.entity.Entity> java.util.List<T> getEntitiesOfClass(Class<T> clazz,
            net.minecraft.world.phys.AABB box) { return java.util.Collections.emptyList(); }
    public void playSound(net.minecraft.world.entity.player.Player source, net.minecraft.core.BlockPos pos,
            net.minecraft.sounds.SoundEvent sound, net.minecraft.sounds.SoundSource category, float volume, float pitch) {}
    @Override
    public net.minecraft.world.level.block.state.BlockState getBlockState(net.minecraft.core.BlockPos pos) { return null; }
}
