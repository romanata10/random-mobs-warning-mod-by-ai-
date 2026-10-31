package com.arena.randommobs.block;

import com.arena.randommobs.storm.StormHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Storm siren. While a storm is raging it wails on its own, warning everyone nearby.
 */
public class StormSirenBlock extends Block {
    public StormSirenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (StormHandler.isRaging(level) && random.nextInt(3) == 0) {
            level.playSound(null, pos, SoundEvents.WARDEN_ROAR, SoundSource.BLOCKS, 3.0F, 0.7F);
        }
    }
}
