package com.aang23.undergroundbiomes.world.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WorldChunkChecker {
    private static final Map<World, Path> chunkDataPaths = new HashMap<>();
    private static CompoundTag ubChunkTag = null;

    private static void loadProperties(World world, Path path) {
        try {
            if (Files.exists(path)) {
                try (InputStream in = Files.newInputStream(path)) {
                    ubChunkTag = NbtIo.readCompressed(in);
                }
            } else {
                try (OutputStream out = Files.newOutputStream(path)) {
                    ubChunkTag = new CompoundTag();
                    NbtIo.writeCompressed(ubChunkTag, out);
                } catch (IOException e) {
                    throw new RuntimeException("[UB-F] Could not load save new chunk data", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("[UB-F] Could not load chunk data", e);
        }
        chunkDataPaths.put(world, path);
    }

    private static void saveProperties(World world) {
        try (OutputStream out = Files.newOutputStream(chunkDataPaths.get(world))) {
            NbtIo.writeCompressed(ubChunkTag, out);
        } catch (IOException e) {
            System.err.println("[UB-F] Could not save existing chunk data");
            e.printStackTrace();
        }
    }

    private static CompoundTag getChunkTag(ServerWorld world) {
        if (ubChunkTag == null) {
            loadProperties(world, world.getSaveHandler().getWorldDir().toPath().resolve("underground_biomes_chunks.nbt"));
        }

        return ubChunkTag;
    }

    public static boolean hasAlreadyBeenUBfied(ServerWorld world, Chunk chunk) {
        return getChunkTag(world).getBoolean(chunk.getPos().x + "," + chunk.getPos().z);
    }

    public static void setDone(ServerWorld world, Chunk chunk) {
        synchronized (getChunkTag(world)) {
            ubChunkTag.putBoolean(chunk.getPos().x + "," + chunk.getPos().z, true);
            saveProperties(world);
        }
    }
}
