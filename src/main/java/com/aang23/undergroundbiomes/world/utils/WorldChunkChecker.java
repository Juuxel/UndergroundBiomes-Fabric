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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WorldChunkChecker {
    public static final String MODID = UndergroundBiomes.modid;

    public static final Identifier ubc_res = new Identifier(MODID, "ub");

    private static final Map<World, Path> CHUNK_DATA_PATHS = new HashMap<>();

    private static boolean loaded = false;
    private static final Properties CHUNK_PROPERTIES = new Properties();

    private static void loadProperties(World world, Path path) {
        try {
            if (Files.exists(path)) {
                try (InputStream in = Files.newInputStream(path)) {
                    CHUNK_PROPERTIES.load(in);
                }
            } else {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("[UB-F] Could not load chunk data", e);
        }
        CHUNK_DATA_PATHS.put(world, path);
    }

    private static void saveProperties(Chunk chunk) {
        if (!(chunk instanceof WorldChunk)) return;

        World w = ((WorldChunk) chunk).getWorld();
        try (OutputStream out = Files.newOutputStream(CHUNK_DATA_PATHS.get(w))) {
            CHUNK_PROPERTIES.store(out, null);
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

            if (!loaded) {
                Path saves = world.getServer().getLevelStorage().getSavesDirectory();
                Path worldPath = saves.resolve(world.getServer().getLevelName());

                loadProperties(world, worldPath.resolve("underground_biomes_chunks.properties"));
                loaded = true;
            }

            return Boolean.parseBoolean(CHUNK_PROPERTIES.getProperty(chunk.getPos().x + "," + chunk.getPos().z));
        }

        return false;
    }

    public static void setDone(Chunk chunk) {
        CHUNK_PROPERTIES.setProperty(chunk.getPos().x + "," + chunk.getPos().z, "true");
        saveProperties(chunk);
    }
}
