package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.block.MockeryBloomBlock;
import com.arena.randommobs.block.RootLianaBlock;
import com.arena.randommobs.block.RootPlantBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RandomMobs.MODID);

    public static final List<RegistryObject<Item>> BLOCK_ITEMS = new ArrayList<>();

    public static final RegistryObject<Block> RED_ROOTS = registerWithItem("red_roots",
            () -> new RootPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.ROOTS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ROOT_LIANA = registerWithItem("root_liana",
            () -> new RootLianaBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .randomTicks()
                    .sound(SoundType.ROOTS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> MOCKERY_BLOOM = registerWithItem("mockery_bloom",
            () -> new MockeryBloomBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission()
                    .instabreak()
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> RED_ROOT_BLOCK = registerWithItem("red_root_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(0.6F)
                    .sound(SoundType.ROOTED_DIRT)));

    public static final RegistryObject<Block> ALIEN_METAL_BLOCK = registerWithItem("alien_metal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(6.0F, 15.0F)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BLOOP_FLESH_BLOCK = registerWithItem("bloop_flesh_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .strength(1.2F)
                    .sound(SoundType.SLIME_BLOCK)));

    private static RegistryObject<Block> registerWithItem(String name, Supplier<Block> block) {
        RegistryObject<Block> reg = BLOCKS.register(name, block);
        BLOCK_ITEMS.add(ModItems.register(name, () -> new BlockItem(reg.get(), new Item.Properties())));
        return reg;
    }

    private ModBlocks() {
    }
}
