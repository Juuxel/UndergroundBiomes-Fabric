package com.aang23.undergroundbiomes.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.world.ServerWorld;

/**
 * A callback invoked when a server-side overworld world is loaded.
 */
@FunctionalInterface
public interface WorldLoadCallback {
    Event<WorldLoadCallback> EVENT = EventFactory.createArrayBacked(
            WorldLoadCallback.class,
            listeners -> world -> {
                for (WorldLoadCallback listener : listeners) {
                    listener.onWorldLoad(world);
                }
            }
    );

    void onWorldLoad(ServerWorld world);
}
