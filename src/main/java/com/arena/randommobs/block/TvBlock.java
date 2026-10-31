package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

/**
 * A very old television with a browser on it. Right click to switch it on.
 */
public class TvBlock extends Block {
    public TvBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                    () -> com.arena.randommobs.client.ClientHooks::openTelevision);
            return InteractionResult.sidedSuccess(true);
        }
        player.displayClientMessage(Component.translatable("block.randommobs.tv.boot"), true);
        return InteractionResult.CONSUME;
    }
}
