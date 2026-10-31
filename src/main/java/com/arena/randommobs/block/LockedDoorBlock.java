package com.arena.randommobs.block;

import com.arena.randommobs.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;

/**
 * A door with a lock. The key has to be somewhere in your inventory.
 */
public class LockedDoorBlock extends DoorBlock {
    public LockedDoorBlock(Properties properties, BlockSetType type) {
        super(properties, type);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (!player.isCreative() && !hasKey(player)) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.8F, 0.6F);
                player.displayClientMessage(Component.translatable("block.randommobs.locked_door.locked"), true);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    private static boolean hasKey(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.is(ModItems.LOCK_KEY.get())) {
                return true;
            }
        }
        for (ItemStack stack : player.getInventory().offhand) {
            if (stack.is(ModItems.LOCK_KEY.get())) {
                return true;
            }
        }
        return false;
    }
}
