package com.arena.randommobs.item;

import com.arena.randommobs.RandomMobs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;


/**
 * A shard of the root network. Using it drags you through the roots into the next
 * Random Mobs dimension (and back home again).
 */
public class RootShardItem extends Item {
    private static final ResourceLocation OVERWORLD = new ResourceLocation("minecraft", "overworld");
    private static final ResourceLocation ROOTED_WORLD = RandomMobs.id("rooted_world");
    private static final ResourceLocation TRENCH_WORLD = RandomMobs.id("trench_world");
    private static final ResourceLocation SCORCHED_WORLD = RandomMobs.id("scorched_world");

    public RootShardItem(Properties properties) {
        super(properties);
    }

    private static ResourceLocation next(ResourceLocation current) {
        if (current.equals(OVERWORLD)) {
            return ROOTED_WORLD;
        }
        if (current.equals(ROOTED_WORLD)) {
            return TRENCH_WORLD;
        }
        if (current.equals(TRENCH_WORLD)) {
            return SCORCHED_WORLD;
        }
        return OVERWORLD;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!(player instanceof ServerPlayer serverPlayer)) {
            return InteractionResultHolder.success(stack);
        }
        MinecraftServer server = serverPlayer.getServer();
        if (server == null) {
            return InteractionResultHolder.fail(stack);
        }
        ResourceLocation destinationId = next(serverPlayer.level().dimension().location());
        ServerLevel destination = server.getLevel(ResourceKey.create(Registries.DIMENSION, destinationId));
        if (destination == null) {
            serverPlayer.displayClientMessage(Component.translatable("item.randommobs.root_shard.no_dimension"), true);
            return InteractionResultHolder.fail(stack);
        }
        BlockPos spawn = destination.getSharedSpawnPos();
        BlockPos surface = destination.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawn);
        serverPlayer.teleportTo(destination, surface.getX() + 0.5D, surface.getY() + 0.1D,
                surface.getZ() + 0.5D, java.util.Set.of(), serverPlayer.getYRot(), serverPlayer.getXRot());
        serverPlayer.fallDistance = 0.0F;
        serverPlayer.getCooldowns().addCooldown(this, 100);
        serverPlayer.displayClientMessage(Component.translatable("item.randommobs.root_shard.travel"), true);
        return InteractionResultHolder.consume(stack);
    }
}
