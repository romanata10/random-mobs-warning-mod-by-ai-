package net.minecraftforge.event.entity;
public class SpawnPlacementRegisterEvent extends net.minecraftforge.eventbus.api.Event {
    public <T extends net.minecraft.world.entity.Entity> void register(net.minecraft.world.entity.EntityType<T> type,
            net.minecraft.world.entity.SpawnPlacements.Type placement, net.minecraft.world.level.levelgen.Heightmap.Types heightmap,
            net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<T> predicate, Operation operation) {}
    public enum Operation { REPLACE, OR, AND }
}
