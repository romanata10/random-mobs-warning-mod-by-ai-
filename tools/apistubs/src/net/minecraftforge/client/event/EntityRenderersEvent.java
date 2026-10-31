package net.minecraftforge.client.event;
public class EntityRenderersEvent {
    public static class RegisterLayerDefinition extends net.minecraftforge.eventbus.api.Event {
        public void registerLayerDefinition(net.minecraft.client.model.geom.ModelLayerLocation location,
                java.util.function.Supplier<net.minecraft.client.model.geom.builders.LayerDefinition> supplier) {}
    }
    public static class RegisterRenderers extends net.minecraftforge.eventbus.api.Event {
        public <T extends net.minecraft.world.entity.Entity> void registerEntityRenderer(
                net.minecraft.world.entity.EntityType<? extends T> type,
                net.minecraft.client.renderer.entity.EntityRendererProvider<T> provider) {}
    }
}
