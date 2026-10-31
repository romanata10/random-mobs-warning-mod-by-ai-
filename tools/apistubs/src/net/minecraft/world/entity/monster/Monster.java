package net.minecraft.world.entity.monster;
public abstract class Monster extends net.minecraft.world.entity.PathfinderMob {
    protected Monster(net.minecraft.world.entity.EntityType<? extends Monster> type, net.minecraft.world.level.Level level) { super(type, level); }
    public static net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder createMonsterAttributes() { return null; }
    public static boolean checkMonsterSpawnRules(net.minecraft.world.entity.EntityType<? extends Monster> type,
            net.minecraft.world.level.ServerLevelAccessor level, net.minecraft.world.entity.MobSpawnType spawnType,
            net.minecraft.core.BlockPos pos, net.minecraft.util.RandomSource random) { return false; }
    public static boolean checkAnyLightMonsterSpawnRules(net.minecraft.world.entity.EntityType<? extends Monster> type,
            net.minecraft.world.level.ServerLevelAccessor level, net.minecraft.world.entity.MobSpawnType spawnType,
            net.minecraft.core.BlockPos pos, net.minecraft.util.RandomSource random) { return false; }
}
