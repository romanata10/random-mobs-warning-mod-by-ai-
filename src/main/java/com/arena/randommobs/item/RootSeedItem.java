package com.arena.randommobs.item;

import com.arena.randommobs.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RootSeedItem extends Item {
    public RootSeedItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockPos target = pos.relative(context.getClickedFace());
        BlockState plant = ModBlocks.RED_ROOTS.get().defaultBlockState();
        if (level.isEmptyBlock(target) && plant.canSurvive(level, target)) {
            level.setBlock(target, plant, Block.UPDATE_ALL);
            if (context.getPlayer() != null && !context.getPlayer().getAbilities().instabuild) {
                context.getItemInHand().shrink(1);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return InteractionResult.PASS;
    }
}
