package com.aang23.undergroundbiomes;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * A Forge patch emulator.
 * @see com.aang23.undergroundbiomes.api.enums.UBBlock
 * @see com.aang23.undergroundbiomes.items.FaborgeItem
 */
@Deprecated
public class Faborge {
    public static final Map<Object, String> BLOCK_REGISTRY_NAMES = new HashMap<>();
    public static final Map<Object, String> ITEM_REGISTRY_NAMES = new HashMap<>();
    public static final Event<WorldLoadCallback> WORLD_LOAD =
            EventFactory.createArrayBacked(
                    WorldLoadCallback.class,
                    consumers -> event -> {
                        for (WorldLoadCallback consumer : consumers) {
                            consumer.accept(event);
                        }
                    }
            );
    public static final Event<ChunkLoadCallback> CHUNK_LOAD =
            EventFactory.createArrayBacked(
                    ChunkLoadCallback.class,
                    consumers -> event -> {
                        for (ChunkLoadCallback consumer : consumers) {
                            consumer.accept(event);
                        }
                    }
            );

    public static Identifier getRegistryName(Block block) {
        return BLOCK_REGISTRY_NAMES.containsKey(block)
                ? parseId(BLOCK_REGISTRY_NAMES.get(block))
                : Registry.BLOCK.getId(block);
    }

    public static void setRegistryName(Item item, String regName) {
        ITEM_REGISTRY_NAMES.put(item, regName);
    }

    public static Identifier getRegistryName(Item item) {
        return ITEM_REGISTRY_NAMES.containsKey(item)
                ? parseId(BLOCK_REGISTRY_NAMES.get(item))
                : Registry.ITEM.getId(item);
    }

    private static Identifier parseId(String str) {
        if (str.contains(":")) return new Identifier(str);
        return new Identifier(UndergroundBiomes.modid, str);
    }

    public static class WorldLoadEvent {

        private final World world;

        public WorldLoadEvent(World world) {
            this.world = world;
        }

        public World getWorld() {
            return world;
        }
    }

    public static class ChunkLoadEvent {
        private final World world;
        private final Chunk chunk;

        public ChunkLoadEvent(World world, Chunk chunk) {
            this.world = world;
            this.chunk = chunk;
        }

        public World getWorld() {
            return world;
        }

        public Chunk getChunk() {
            return chunk;
        }
    }

    public interface WorldLoadCallback extends Consumer<WorldLoadEvent> {}
    public interface ChunkLoadCallback extends Consumer<ChunkLoadEvent> {}
}
