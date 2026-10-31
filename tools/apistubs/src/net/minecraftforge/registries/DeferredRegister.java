package net.minecraftforge.registries;
public class DeferredRegister<T> {
    public static <B> DeferredRegister<B> create(IForgeRegistry<B> registry, String modid) { return null; }
    public <I extends T> RegistryObject<I> register(String name, java.util.function.Supplier<? extends I> supplier) { return null; }
    public void register(net.minecraftforge.eventbus.api.IEventBus bus) {}
}
