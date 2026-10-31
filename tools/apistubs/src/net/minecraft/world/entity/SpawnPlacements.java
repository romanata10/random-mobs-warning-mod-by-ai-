package net.minecraft.world.entity;
public class SpawnPlacements {
    public enum Type { ON_GROUND, IN_WATER, NO_RESTRICTIONS }
    public interface SpawnPredicate<T extends Entity> {
        boolean check(EntityType<T> type, net.minecraft.world.level.ServerLevelAccessor level,
                MobSpawnType spawnType, net.minecraft.core.BlockPos pos, net.minecraft.util.RandomSource random);
    }
}
