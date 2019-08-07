package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.impl.SyntaxError;
import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.api.event.UBRegistrarRegisterOresEvent;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UBOreConfigManager {
    private static final Jankson JANKSON = Jankson.builder().build();

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
            extractDefaults();
        }
        readJsons();
    }

    private static void registerOre(Block ore, String overlay, String variant) {
        UBOreRegistrar.registerOre(ore);
        overlayCache.put(Faborge.getRegistryName(ore).toString(), overlay);
        stoneVariantCache.put(Faborge.getRegistryName(ore).toString(), variant);
    }

    private static void readJsons() {
        for (File currentJson : jsonsFolder.listFiles()) {
            try {
                JsonObject currentConfig = JANKSON.load(currentJson);

                for (Object currentOreObj : currentConfig.keySet()) {
                    String currentOre = (String) currentOreObj;
                    Block toRegister = Registry.BLOCK.get(new Identifier(currentOre));
                    JsonObject oreConfig = (JsonObject) currentConfig.get(currentOre);
                    String overlay = oreConfig.get(String.class, "overlay");
                    String variant = oreConfig.get(String.class, "variant");

                    String name = oreConfig.get(String.class, "name"); // TODO improve

                    nameCache.put(currentOre, name);

                    registerOre(toRegister, overlay, variant);
                }
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
            }

            // Other mods can register ores in this event
            //MinecraftForge.EVENT_BUS.post(new UBRegistrarRegisterOresEvent());
        }
    }

    private static void extractDefaults() {
        try {
            File defaultsZip = new File("defaults.zip");
            InputStream link = Thread.currentThread().getContextClassLoader().getResourceAsStream(defaultsZip.getName());
            Files.copy(link, defaultsZip.getAbsoluteFile().toPath());
            ZipFile zipFile = new ZipFile(defaultsZip);
            zipFile.extractAll(mainFolder.getAbsolutePath());
            defaultsZip.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}
