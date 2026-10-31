package net.minecraftforge.eventbus.api;
public interface IEventBus {
    <T extends Event> void addListener(java.util.function.Consumer<T> listener);
    void register(Object object);
}
