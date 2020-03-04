package com.aang23.undergroundbiomes.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import blue.endless.jankson.api.SyntaxError;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.IWorld;

public class WorldConfig {
    private static final Jankson JANKSON = Jankson.builder().build();

    public String dimensionId;

    private File configPath;

    public JsonObject config;

    public WorldConfig(IWorld world) {
            dimensionId = DimensionType.getId(world.getDimension().getType()).toString();
            configPath = new File(world.getDimension().getType().getSaveDirectory(
                    ((ServerWorld) world).getSaveHandler().getWorldDir()), "undergroundbiomes.json");
            config = new JsonObject();
    }

    public void loadConfig() {
        if (configPath.exists()) {
            try {
                config = JANKSON.load(configPath);
            } catch (SyntaxError | IOException e) {
                e.printStackTrace();
            }
        } else {
            config.put("worldId", new JsonPrimitive(dimensionId));
            config.put("harmoniousStrata", new JsonPrimitive(UBConfig.instance().worldgen.harmoniousStrata));
            config.put("biomeSize", new JsonPrimitive(UBConfig.instance().worldgen.biomeSize));
            config.put("generationHeight", new JsonPrimitive(UBConfig.instance().worldgen.generationHeight));
            config.put("spawnVanillaStone", new JsonPrimitive(UBConfig.instance().worldgen.spawnVanillaStone));

            try (FileWriter writer = new FileWriter(configPath)){
                writer.write(config.toJson(true, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean harmoniousStrata() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return config.get(Boolean.class, "harmoniousStrata");
    }

    public int biomeSize() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return config.get(Integer.class, "biomeSize");
    }

    public int generationHeight() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return config.get(Integer.class, "generationHeight");
    }

    public boolean regularStone() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return config.get(Boolean.class, "spawnVanillaStone");
    }
}
