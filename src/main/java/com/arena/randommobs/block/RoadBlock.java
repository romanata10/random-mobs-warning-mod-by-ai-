package com.arena.randommobs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * Asphalt road - walking or driving on it is noticeably faster.
 */
public class RoadBlock extends Block {
    public RoadBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        Vec3 movement = entity.getDeltaMovement();
        double horizontal = Math.hypot(movement.x, movement.z);
        if (horizontal > 0.02D && horizontal < 0.5D) {
            entity.setDeltaMovement(movement.x * 1.06D, movement.y, movement.z * 1.06D);
        }
    }
}
