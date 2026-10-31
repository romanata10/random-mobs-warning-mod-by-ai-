package com.arena.randommobs.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * A proper clock: it tells you the day number and how long until sunrise or sunset.
 */
public class TimeClockItem extends Item {
    public TimeClockItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        long time = level.getDayTime();
        long day = time / 24000L + 1L;
        long dayTime = time % 24000L;
        long until;
        String key;
        if (dayTime < 13000L) {
            until = 13000L - dayTime;
            key = "item.randommobs.time_clock.night";
        } else {
            until = 24000L - dayTime + 1000L;
            key = "item.randommobs.time_clock.day";
        }
        long minutes = until / 20L / 60L;
        long seconds = until / 20L % 60L;
        if (!level.isClientSide()) {
            player.displayClientMessage(Component.translatable("item.randommobs.time_clock.report",
                    day, Component.translatable(key),
                    String.format("%02d:%02d", minutes, seconds)), false);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
