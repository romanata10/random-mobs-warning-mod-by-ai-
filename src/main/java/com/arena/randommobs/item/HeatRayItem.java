package com.arena.randommobs.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

/**
 * The heat ray of a Tripod, ripped out of the machine and turned into a hand held weapon.
 */
public class HeatRayItem extends Item {
    public HeatRayItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            level.playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE,
                    SoundSource.PLAYERS, 1.0F, 0.6F, false);
            return InteractionResultHolder.success(stack);
        }

        Vec3 start = player.getEyePosition();
        Vec3 end = start.add(player.getLookAngle().scale(48.0D));
        BlockHitResult blockHit = level.clip(new ClipContext(start, end,
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        Vec3 hitPos = blockHit.getType() == HitResult.Type.MISS ? end : blockHit.getLocation();

        AABB search = new AABB(start, hitPos).inflate(1.5D);
        EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(level, player, start, hitPos, search,
                entity -> !entity.isSpectator() && entity.isAlive() && entity != player);

        Vec3 beamEnd = hitPos;
        if (entityHit != null) {
            Entity target = entityHit.getEntity();
            beamEnd = entityHit.getLocation();
            if (target instanceof LivingEntity living) {
                living.hurt(level.damageSources().playerAttack(player), 7.0F);
                living.setSecondsOnFire(5);
            }
        }

        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.FLAME, start.x, start.y, start.z, 0,
                    beamEnd.x - start.x, beamEnd.y - start.y, beamEnd.z - start.z, 1.0D);
            for (double step = 0.0D; step < start.distanceTo(beamEnd); step += 0.5D) {
                Vec3 point = start.add(beamEnd.subtract(start).normalize().scale(step));
                serverLevel.sendParticles(ParticleTypes.SMALL_FLAME, point.x, point.y, point.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            }
            serverLevel.sendParticles(ParticleTypes.LAVA, beamEnd.x, beamEnd.y, beamEnd.z, 6, 0.2D, 0.2D, 0.2D, 0.1D);
        }
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT,
                SoundSource.PLAYERS, 1.5F, 0.55F);

        player.getCooldowns().addCooldown(this, 30);
        stack.hurtAndBreak(1, player, breaker -> breaker.broadcastBreakEvent(hand));
        return InteractionResultHolder.consume(stack);
    }
}
