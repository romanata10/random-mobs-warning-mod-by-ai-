package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * Fast stairs: while you walk on them you are pushed along your own movement, so climbing
 * a tower staircase is quick instead of painful.
 */
public class FastStairBlock extends StairBlock {
    public FastStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        Vec3 movement = entity.getDeltaMovement();
        double horizontal = Math.hypot(movement.x, movement.z);
        if (horizontal > 0.02D && horizontal < 0.62D) {
            double boost = 0.075D;
            entity.setDeltaMovement(movement.x + movement.x / horizontal * boost,
                    movement.y,
                    movement.z + movement.z / horizontal * boost);
        }
    }
}
