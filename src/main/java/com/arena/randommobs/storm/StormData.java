package com.arena.randommobs.storm;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

/**
 * Persistent state of the weather system. One instance per world.
 */
public class StormData extends SavedData {
    public static final int CALM = 0;
    public static final int WARNING = 1;
    public static final int RAGING = 2;
    public static final int AFTERMATH = 3;

    public int phase = CALM;
    public int timer = 9000;

    public StormData() {
    }

    public static StormData load(CompoundTag tag) {
        StormData data = new StormData();
        data.phase = tag.getInt("Phase");
        data.timer = tag.getInt("Timer");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("Phase", this.phase);
        tag.putInt("Timer", this.timer);
        return tag;
    }
}
