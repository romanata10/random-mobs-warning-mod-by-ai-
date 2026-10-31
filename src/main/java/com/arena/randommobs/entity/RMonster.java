package com.arena.randommobs.entity;

import com.arena.randommobs.registry.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

/**
 * Shared base class for the not-so-friendly residents of this mod.
 */
public abstract class RMonster extends Monster {
    protected RMonster(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    /** Spawn rules that respect light level (classic monster spawning). */
    public static boolean checkDarkSpawnRules(EntityType<? extends Monster> type, LevelAccessor level,
                                              MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        boolean dark = !(level instanceof ServerLevelAccessor serverLevelAccessor)
                || Monster.isDarkEnoughToSpawn(serverLevelAccessor, pos, random);
        return dark && Mob.checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    /** Spawn rules that ignore light level (giant things do not care about the sun). */
    public static boolean checkLightSpawnRules(EntityType<? extends Monster> type, LevelAccessor level,
                                               MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL
                && Mob.checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    protected void infect(LivingEntity target, int duration, int amplifier) {
        target.addEffect(new MobEffectInstance(ModEffects.ROOT_INFECTION.get(), duration, amplifier));
    }

    @Override
    public boolean canBreatheUnderwater() {
        return this.getMobType() == net.minecraft.world.entity.MobType.WATER;
    }
}
