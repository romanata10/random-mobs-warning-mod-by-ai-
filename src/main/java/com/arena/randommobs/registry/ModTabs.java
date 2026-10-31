package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomMobs.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("main", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.TRIPOD_CORE.get()))
            .title(Component.translatable("itemGroup.randommobs.main"))
            .displayItems((params, output) -> {
                ModItems.ALL.forEach(reg -> output.accept(reg.get()));
                ModBlocks.BLOCK_ITEMS.forEach(reg -> output.accept(reg.get()));
            })
            .build());
}
