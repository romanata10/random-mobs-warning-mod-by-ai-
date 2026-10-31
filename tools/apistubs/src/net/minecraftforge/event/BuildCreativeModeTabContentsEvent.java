package net.minecraftforge.event;
public class BuildCreativeModeTabContentsEvent extends net.minecraftforge.eventbus.api.Event {
    public net.minecraft.resources.ResourceKey<net.minecraft.world.item.CreativeModeTab> getTabKey() { return null; }
    public void accept(net.minecraft.world.item.Item item) {}
    public boolean accept(net.minecraft.world.item.ItemStack stack) { return false; }
}
