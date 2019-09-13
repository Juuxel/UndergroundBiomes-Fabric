package com.aang23.undergroundbiomes.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.chunk.Chunk;

@FunctionalInterface
public interface ChunkLoadCallback {
    Event<ChunkLoadCallback> EVENT = EventFactory.createArrayBacked(
            ChunkLoadCallback.class,
            listeners -> (world, chunk) -> {
                for (ChunkLoadCallback listener : listeners) {
                    listener.onChunkLoad(world, chunk);
                }
            }
    );

    void onChunkLoad(ServerWorld world, Chunk chunk);
}
