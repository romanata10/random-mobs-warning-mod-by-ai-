package net.minecraft.client.model;
public abstract class EntityModel<T extends net.minecraft.world.entity.Entity> {
    public abstract void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);
}
