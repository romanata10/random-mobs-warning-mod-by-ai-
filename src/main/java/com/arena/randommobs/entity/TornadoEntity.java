package com.arena.randommobs.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import com.arena.randommobs.registry.ModBlocks;

/**
 * A tornado: a big spinning funnel that lifts everything around it and throws it.
 * Bunkers and reinforced blocks protect whatever is standing inside them.
 */
public class TornadoEntity extends Mob {
    private int life = 1200;

    public TornadoEntity(EntityType<? extends TornadoEntity> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
        this.noPhysics = true;
        this.xpReward = 0;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.1D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            return;
        }
        if (--this.life <= 0) {
            this.discard();
            return;
        }
        if (this.tickCount % 20 == 0) {
            this.level().playSound(null, this.blockPosition(), SoundEvents.WARDEN_AMBIENT,
                    SoundSource.WEATHER, 6.0F, 0.4F);
        }
        if (this.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 8; i++) {
                double angle = this.random.nextDouble() * Math.PI * 2.0D;
                double radius = 1.0D + this.random.nextDouble() * 7.0D;
                double y = this.random.nextDouble() * 14.0D;
                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        this.getX() + Math.cos(angle) * radius, this.getY() + y, this.getZ() + Math.sin(angle) * radius,
                        1, 0.0D, 0.4D, 0.0D, 0.05D);
            }
        }
        AABB area = this.getBoundingBox().inflate(14.0D, 20.0D, 14.0D);
        for (Entity entity : this.level().getEntities(this, area)) {
            if (entity == this || entity instanceof TornadoEntity) {
                continue;
            }
            if (isSheltered(this.level(), entity.blockPosition())) {
                continue;
            }
            Vec3 toCenter = this.position().add(0.0D, 1.0D, 0.0D).subtract(entity.position());
            double dist = Math.max(1.0D, toCenter.length());
            Vec3 swirl = new Vec3(-toCenter.z, 0.0D, toCenter.x).normalize().scale(0.35D);
            double pull = (14.0D - Math.min(dist, 14.0D)) / 14.0D;
            if (entity instanceof net.minecraft.world.entity.player.Player player
                    && (player.getMainHandItem().is(com.arena.randommobs.registry.ModItems.STORM_RADIO.get())
                    || player.getOffhandItem().is(com.arena.randommobs.registry.ModItems.STORM_RADIO.get()))) {
                pull *= 0.35D;
            }
            entity.setDeltaMovement(entity.getDeltaMovement()
                    .add(toCenter.normalize().scale(0.06D * pull))
                    .add(swirl.scale(pull))
                    .add(0.0D, 0.12D * pull, 0.0D));
            entity.hurtMarked = true;
            if (this.random.nextInt(60) == 0) {
                entity.hurt(this.damageSources().flyIntoWall(), 3.0F);
            }
        }
    }

    /** Standing on or under a bunker block keeps you out of the wind. */
    public static boolean isSheltered(Level level, net.minecraft.core.BlockPos pos) {
        for (int dy = 0; dy <= 3; dy++) {
            if (level.getBlockState(pos.above(dy)).is(ModBlocks.TORNADO_BUNKER.get())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean isInvulnerableTo(net.minecraft.world.damagesource.DamageSource source) {
        return true;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Life", this.life);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.life = tag.getInt("Life");
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    @Override
    public boolean checkSpawnRules(net.minecraft.world.level.LevelAccessor level, MobSpawnType spawnType) {
        return true;
    }
}
