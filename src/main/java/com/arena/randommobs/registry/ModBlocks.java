package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.block.CasinoBlock;
import com.arena.randommobs.block.FastStairBlock;
import com.arena.randommobs.block.GlowOrbBlock;
import com.arena.randommobs.block.LockedDoorBlock;
import com.arena.randommobs.block.MockeryBloomBlock;
import com.arena.randommobs.block.ReinforcedGlassBlock;
import com.arena.randommobs.block.RoadBlock;
import com.arena.randommobs.block.RootLianaBlock;
import com.arena.randommobs.block.RootPlantBlock;
import com.arena.randommobs.block.StormSirenBlock;
import com.arena.randommobs.block.TornadoBunkerBlock;
import com.arena.randommobs.block.TvBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    // ---- 1.1 storm pack ---------------------------------------------------
    public static final RegistryObject<Block> REINFORCED_PLANKS = registerWithItem("reinforced_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .strength(9.0F, 40.0F)
                    .sound(SoundType.WOOD)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> REINFORCED_GLASS = registerWithItem("reinforced_glass",
            () -> new ReinforcedGlassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .strength(4.0F, 60.0F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));

    public static final RegistryObject<Block> FAST_STAIRS = registerWithItem("fast_stairs",
            () -> new FastStairBlock(Blocks.SMOOTH_STONE.defaultBlockState(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 12.0F)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ROAD_BLOCK = registerWithItem("road_block",
            () -> new RoadBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(2.0F, 8.0F)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> SIDEWALK_BLOCK = registerWithItem("sidewalk_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(1.6F, 6.0F)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> LOCKED_DOOR = registerWithItem("locked_door",
            () -> new LockedDoorBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .strength(4.0F, 12.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> CHEESE_BLOCK = registerWithItem("cheese_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(1.0F, 4.0F)
                    .sound(SoundType.WOOL)));

    public static final RegistryObject<Block> STORM_SIREN = registerWithItem("storm_siren",
            () -> new StormSirenBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.0F, 10.0F)
                    .sound(SoundType.METAL)
                    .randomTicks()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GLOW_ORB = registerWithItem("glow_orb",
            () -> new GlowOrbBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW)
                    .strength(0.4F)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> TORNADO_BUNKER = registerWithItem("tornado_bunker",
            () -> new TornadoBunkerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(22.0F, 1200.0F)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CASINO = registerWithItem("casino",
            () -> new CasinoBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(3.0F, 10.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> TELEVISION = registerWithItem("tv",
            () -> new TvBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(2.0F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()));

    private static RegistryObject<Block> registerWithItem(String name, Supplier<Block> block) {
        RegistryObject<Block> reg = BLOCKS.register(name, block);
        BLOCK_ITEMS.add(ModItems.register(name, () -> new BlockItem(reg.get(), new Item.Properties())));
        return reg;
    }

    private ModBlocks() {
    }
}
