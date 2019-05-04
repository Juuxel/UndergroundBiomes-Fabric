package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class UBOreConfigManager {
    // Folders
    public static File mainFolder = new File(UBOreRegistrar.mcdir, "config/undergroundbiomes");
    public static File jsonsFolder = new File(mainFolder, "ores");
    public static File overlayFolder = new File(mainFolder, "overlays");

    // Caches so that the PackGenerator can use those datas
    public static Map<String, String> overlayCache = new HashMap<String, String>();
    public static Map<String, String> stoneVariantCache = new HashMap<String, String>();
    public static Map<String, String> nameCache = new HashMap<String, String>(); // TODO improve

    public static void setupConfigs() {
        if (!mainFolder.exists()) {
            mainFolder.mkdirs();
            jsonsFolder.mkdirs();
            overlayFolder.mkdirs();
            extractDefaults();
        }
        readJsons();
    }

    private static void registerOre(Block ore, String overlay, String variant) {
        UBOreRegistrar.registerOre(ore);
        overlayCache.put(ore.getRegistryName().toString(), overlay);
        stoneVariantCache.put(ore.getRegistryName().toString(), variant);
    }

    private static void readJsons() {
        for (File currentJson : jsonsFolder.listFiles()) {
            JSONObject currentConfig = null;
            Object configobj = null;
            try {
                configobj = new JSONParser().parse(new FileReader(currentJson));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            currentConfig = (JSONObject) configobj;

            for (Object currentOreObj : currentConfig.keySet()) {
                String currentOre = (String) currentOreObj;
                Block toRegister = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(currentOre));
                Map oreConfig = new HashMap<>();
                oreConfig = (Map) currentConfig.get(currentOre);
                String overlay = (String) oreConfig.get("overlay");
                String variant = (String) oreConfig.get("variant");

                String name = (String) oreConfig.get("name"); // TODO improve

                nameCache.put(currentOre, name);

                registerOre(toRegister, overlay, variant);
            }
        }
    }

    private static void extractDefaults() {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("defaults");
            if (url == null) {
                // TODO Runtime exception
            } else {
                File dir = new File(url.toURI());
                for (File nextFile : dir.listFiles()) {
                    FileUtils.copyDirectory(nextFile, new File(mainFolder, nextFile.getName()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}