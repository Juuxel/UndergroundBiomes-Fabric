package com.aang23.undergroundbiomes.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.cedarsoftware.util.io.JsonWriter;
import net.minecraft.world.IWorld;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WorldConfig {
    public int dimensionId;

    private IWorld configWorld;
    private File configPath;

    public JSONObject config;

    public WorldConfig(IWorld world) {
        dimensionId = world.getWorldInfo().getDimension();
        configWorld = world;
        configPath = new File(
                world.getSaveHandler().getWorldDirectory().getAbsolutePath().toString() + "/undergroundbiomes.json");
        config = new JSONObject();

        System.out.println(configPath.toString());
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
            config.put("harmoniousStrata", UBConfig.WORLDGEN.harmoniousStrata.get());
            config.put("biomeSize", (int) UBConfig.WORLDGEN.biomeSize.get());

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
}