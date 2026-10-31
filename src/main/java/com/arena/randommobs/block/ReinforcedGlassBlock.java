package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Reinforced glass - the only window that survives a tornado.
 */
public class ReinforcedGlassBlock extends GlassBlock {
    public ReinforcedGlassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }
}
