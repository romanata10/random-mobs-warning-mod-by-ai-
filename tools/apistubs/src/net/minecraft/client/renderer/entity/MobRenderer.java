package net.minecraft.client.renderer.entity;
public abstract class MobRenderer<T extends net.minecraft.world.entity.Mob, M extends net.minecraft.client.model.EntityModel<T>> extends EntityRenderer<T> {
    protected MobRenderer(EntityRendererProvider.Context context, M model, float shadowRadius) { super(context); }
}
