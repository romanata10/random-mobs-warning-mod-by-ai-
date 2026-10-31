package com.arena.randommobs.client;

import net.minecraft.client.Minecraft;

/**
 * Client-only entry points reached through DistExecutor.
 */
public final class ClientHooks {

    public static void openTelevision() {
        Minecraft.getInstance().setScreen(new TvScreen());
    }

    private ClientHooks() {
    }
}
