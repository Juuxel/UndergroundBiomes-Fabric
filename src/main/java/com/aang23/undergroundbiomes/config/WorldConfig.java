package com.aang23.undergroundbiomes.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.cedarsoftware.util.io.JsonWriter;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.minecraft.world.IWorld;

public class WorldConfig {
    public String dimensionId;

    private IWorld configWorld;
    private File configPath;

    public JSONObject config;

    public WorldConfig(IWorld world) {
            dimensionId = DimensionType.getId(world.getDimension().getType()).toString();
            configWorld = world;
            configPath = new File(world.getDimension().getType().getFile(
                    ((ServerWorld) world).getSaveHandler().getWorldDir()), "undergroundbiomes.json");
            config = new JSONObject();
    }

    public void loadConfig() {
        if (configPath.exists()) {
            try {
                config = (JSONObject) new JSONParser().parse(new FileReader(configPath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            config.put("worldId", dimensionId);
            config.put("harmoniousStrata", UBConfig.instance().worldgen.harmoniousStrata);
            config.put("biomeSize", UBConfig.instance().worldgen.biomeSize);
            config.put("generationHeight", UBConfig.instance().worldgen.generationHeight);
            config.put("spawnVanillaStone", UBConfig.instance().worldgen.spawnVanillaStone);

            PrintWriter pw = null;
            try {
                pw = new PrintWriter(configPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            pw.write(JsonWriter.formatJson(config.toJSONString()));

            pw.flush();
            pw.close();
        }
    }

    public boolean harmoniousStrata() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return (boolean) config.get("harmoniousStrata");
    }

    public int biomeSize() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return ((Number) config.get("biomeSize")).intValue();
    }

    public int generationHeight() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return ((Number) config.get("generationHeight")).intValue();
    }

    public boolean regularStone() {
        // Well not that great, but if it fails, it will only be caused by the user,
        // so...
        return (boolean) config.get("spawnVanillaStone");
    }
}
