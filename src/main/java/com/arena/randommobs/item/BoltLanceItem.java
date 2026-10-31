package com.arena.randommobs.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.server.level.ServerLevel;

/**
 * Bolt lance: a spear with a lightning rod for a tip.
 */
public class BoltLanceItem extends SwordItem {
    public BoltLanceItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean hit = super.hurtEnemy(stack, target, attacker);
        if (hit && !target.level().isClientSide() && target.level() instanceof ServerLevel serverLevel
                && attacker.getRandom().nextFloat() < 0.3F) {
            LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
            if (bolt != null) {
                bolt.moveTo(target.getX(), target.getY(), target.getZ());
                if (attacker instanceof net.minecraft.server.level.ServerPlayer player) {
                    bolt.setCause(player);
                }
                serverLevel.addFreshEntity(bolt);
            }
        }
        return hit;
    }
}
