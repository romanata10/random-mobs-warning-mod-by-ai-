package com.arena.randommobs.block;

import com.arena.randommobs.registry.ModBlocks;
import com.arena.randommobs.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Nature's Mockery: the bloom that grows out of an infected corpse.
 * After a while a brand new Woodcrawler grows out of it.
 */
public class MockeryBloomBlock extends BushBlock {
    public MockeryBloomBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ModBlocks.RED_ROOT_BLOCK.get())
                || state.is(Blocks.DIRT)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.COARSE_DIRT)
                || state.is(Blocks.ROOTED_DIRT)
                || state.is(Blocks.PODZOL)
                || state.is(Blocks.MOSS_BLOCK)
                || state.is(Blocks.STONE)
                || state.is(Blocks.DEEPSLATE)
                || state.is(Blocks.SAND)
                || state.is(Blocks.RED_SAND)
                || state.is(Blocks.CLAY);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isEmptyBlock(pos.above())) {
            level.scheduleTick(pos, this, 100);
            return;
        }
        if (ModEntities.WOODCRAWLER.get().spawn(level, pos.above(), MobSpawnType.TRIGGERED) != null) {
            level.removeBlock(pos, false);
        } else {
            level.scheduleTick(pos, this, 100);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(14) != 0) {
            return;
        }
        if (!level.isEmptyBlock(pos.above())) {
            return;
        }
        if (ModEntities.WOODCRAWLER.get().spawn(level, pos.above(), MobSpawnType.TRIGGERED) != null) {
            level.removeBlock(pos, false);
        }
    }
}
