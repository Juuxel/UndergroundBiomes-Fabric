package com.aang23.undergroundbiomes.world.utils;

import com.aang23.undergroundbiomes.UndergroundBiomes;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WorldChunkChecker {
    public static final String MODID = UndergroundBiomes.modid;

    public static final Identifier ubc_res = new Identifier(MODID, "ub");

    private static final Map<World, Path> chunkDataPaths = new HashMap<>();
    private static final Properties chunkProperties = new Properties();

    private static void loadProperties(World world, Path path) {
        chunkProperties.clear();

        try {
            if (Files.exists(path)) {
                try (InputStream in = Files.newInputStream(path)) {
                    chunkProperties.load(in);
                }
            } else {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("[UB-F] Could not load chunk data", e);
        }
        chunkDataPaths.put(world, path);
    }

    private static void saveProperties(World world) {
        try (OutputStream out = Files.newOutputStream(chunkDataPaths.get(world))) {
            chunkProperties.store(out, null);
        } catch (IOException e) {
            System.err.println("[UB-F] Could not save chunk properties");
            e.printStackTrace();
        }
    }

    public static boolean hasAlreadyBeenUBfied(Chunk chunk) {
        if (!(chunk instanceof WorldChunk)) return false;

        World w = ((WorldChunk) chunk).getWorld();

        if (w instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) w;

            synchronized (chunkProperties) {
                if (!chunkDataPaths.containsKey(w)) {
                    loadProperties(world, world.getSaveHandler().getWorldDir().toPath().resolve("underground_biomes_chunks.properties"));
                }

                return Boolean.parseBoolean(chunkProperties.getProperty(chunk.getPos().x + "," + chunk.getPos().z));
            }
        }

        return false;
    }

    public static void setDone(World world, Chunk chunk) {
        synchronized (chunkProperties) {
            chunkProperties.setProperty(chunk.getPos().x + "," + chunk.getPos().z, "true");
            saveProperties(world);
        }
    }
}
