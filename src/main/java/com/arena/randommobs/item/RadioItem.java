package com.arena.randommobs.item;

import com.arena.randommobs.storm.StormHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Storm radio: tells you what the sky is about to do.
 */
public class RadioItem extends Item {
    public RadioItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level instanceof ServerLevel serverLevel) {
            player.displayClientMessage(Component.translatable("item.randommobs.storm_radio.report",
                    StormHandler.describe(serverLevel), StormHandler.secondsLeft(serverLevel)), false);
            level.playSound(null, player.blockPosition(), SoundEvents.NOTE_BLOCK_BIT.value(),
                    SoundSource.PLAYERS, 0.6F, 1.4F);
        }
        player.getCooldowns().addCooldown(this, 40);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
