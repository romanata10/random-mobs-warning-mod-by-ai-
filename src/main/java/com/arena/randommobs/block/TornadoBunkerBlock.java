package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * Bunker plating. A tornado cannot reach anything standing on or under it.
 */
public class TornadoBunkerBlock extends Block {
    public TornadoBunkerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        // inside a bunker the wind simply does not reach you
        Vec3 movement = entity.getDeltaMovement();
        if (level.isRaining() && level.isThundering()) {
            entity.setDeltaMovement(movement.x * 0.55D, movement.y, movement.z * 0.55D);
        }
    }
}
