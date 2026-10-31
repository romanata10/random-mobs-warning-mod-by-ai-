package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * The casino block: put a gold ingot in your main hand, right click, hope for the best.
 */
public class CasinoBlock extends Block {
    public CasinoBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.sidedSuccess(true);
        }
        ItemStack held = player.getItemInHand(hand);
        boolean freeSpin = player.isCreative() || held.is(Items.GOLD_INGOT);
        if (!freeSpin) {
            player.displayClientMessage(Component.translatable("block.randommobs.casino.need_ingot"), true);
            return InteractionResult.CONSUME;
        }
        if (held.is(Items.GOLD_INGOT)) {
            held.shrink(1);
        }
        ServerLevel serverLevel = (ServerLevel) level;
        double roll = player.getRandom().nextDouble();
        ItemStack prize;
        if (roll < 0.04D) {
            prize = new ItemStack(Items.DIAMOND, 4);
            player.displayClientMessage(Component.translatable("block.randommobs.casino.jackpot"), false);
            serverLevel.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, pos.getX() + 0.5D, pos.getY() + 1.2D,
                    pos.getZ() + 0.5D, 40, 0.6D, 0.8D, 0.6D, 0.4D);
            serverLevel.playSound(null, pos, SoundEvents.PLAYER_LEVELUP, SoundSource.BLOCKS, 1.6F, 1.1F);
            if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
                com.arena.randommobs.util.Advancements.grant(serverPlayer, "casino_jackpot");
            }
        } else if (roll < 0.22D) {
            prize = new ItemStack(Items.EMERALD, 1);
            player.displayClientMessage(Component.translatable("block.randommobs.casino.win"), false);
            serverLevel.playSound(null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1.2F, 1.3F);
        } else if (roll < 0.55D) {
            prize = new ItemStack(Items.GOLD_NUGGET, 6);
            player.displayClientMessage(Component.translatable("block.randommobs.casino.small_win"), false);
        } else {
            prize = ItemStack.EMPTY;
            player.displayClientMessage(Component.translatable("block.randommobs.casino.lose"), true);
            serverLevel.playSound(null, pos, SoundEvents.VILLAGER_NO, SoundSource.BLOCKS, 1.0F, 0.8F);
        }
        if (!prize.isEmpty()) {
            if (!player.getInventory().add(prize)) {
                player.drop(prize, false);
            }
        }
        return InteractionResult.CONSUME;
    }
}
