package net.minecraft.world.level;
public interface BlockGetter {
    net.minecraft.world.level.block.state.BlockState getBlockState(net.minecraft.core.BlockPos pos);
}
