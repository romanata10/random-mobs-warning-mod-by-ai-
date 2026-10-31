package net.minecraft.client.model;
public abstract class HierarchicalModel<T extends net.minecraft.world.entity.Entity> extends EntityModel<T> {
    public abstract net.minecraft.client.model.geom.ModelPart root();
}
