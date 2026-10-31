package com.arena.randommobs.item;

import com.arena.randommobs.storm.StormHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Weather map: a rough drawing of what is coming in over the horizon.
 */
public class WeatherMapItem extends Item {
    public WeatherMapItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level instanceof ServerLevel serverLevel) {
            player.displayClientMessage(Component.translatable("item.randommobs.weather_map.report",
                    StormHandler.describe(serverLevel), StormHandler.secondsLeft(serverLevel),
                    level.isRaining() ? Component.translatable("storm.randommobs.rain_yes")
                            : Component.translatable("storm.randommobs.rain_no")), false);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
