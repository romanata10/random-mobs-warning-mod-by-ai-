package com.arena.randommobs.item;

import com.arena.randommobs.registry.ModEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Cures the root virus. Tastes like dirt, which is honestly better than becoming a plant.
 */
public class RootSerumItem extends Item {
    public RootSerumItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.hasEffect(ModEffects.ROOT_INFECTION.get())) {
            if (!level.isClientSide()) {
                player.removeEffect(ModEffects.ROOT_INFECTION.get());
                player.hurt(level.damageSources().magic(), 2.0F);
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.HONEY_DRINK, SoundSource.PLAYERS, 1.0F, 1.2F);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
                    com.arena.randommobs.util.Advancements.grant(serverPlayer, "root_cure");
                }
            }
            return InteractionResultHolder.consume(stack);
        }
        return InteractionResultHolder.fail(stack);
    }
}
