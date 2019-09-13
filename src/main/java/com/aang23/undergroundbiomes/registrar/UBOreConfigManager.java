package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.impl.SyntaxError;

import net.fabricmc.loader.api.FabricLoader;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UBOreConfigManager {
    private static final Jankson JANKSON = Jankson.builder().build();

    // Folders
    public static final File MAIN_FOLDER = new File(FabricLoader.getInstance().getConfigDirectory(), "undergroundbiomes");
    public static final File JSONS_FOLDER = new File(MAIN_FOLDER, "ores");
    public static final File OVERLAY_FOLDER = new File(MAIN_FOLDER, "overlays");

    // Caches so that the PackGenerator can use those datas
    public static final Map<Identifier, String> overlayCache = new HashMap<>();
    public static final Map<Identifier, String> stoneVariantCache = new HashMap<>();
    public static final Map<Identifier, String> nameCache = new HashMap<>(); // TODO improve

    public static void setupConfigs() {
        if (!MAIN_FOLDER.exists() && MAIN_FOLDER.mkdirs()) {
            extractDefaults();
        }
        readJsons();
    }

    private static void registerOre(Block ore, String overlay, String variant) {
        UBOreRegistrar.registerOre(ore);
        overlayCache.put(Registry.BLOCK.getId(ore), overlay);
        stoneVariantCache.put(Registry.BLOCK.getId(ore), variant);
    }

    private static void readJsons() {
        for (File currentJson : JSONS_FOLDER.listFiles()) {
            try {
                JsonObject currentConfig = JANKSON.load(currentJson);

                for (Object currentOreObj : currentConfig.keySet()) {
                    String currentOre = (String) currentOreObj;
                    Identifier currentOreId = new Identifier(currentOre);
                    Block toRegister = Registry.BLOCK.get(currentOreId);
                    JsonObject oreConfig = (JsonObject) currentConfig.get(currentOre);
                    String overlay = oreConfig.get(String.class, "overlay");
                    String variant = oreConfig.get(String.class, "variant");

                    String name = oreConfig.get(String.class, "name"); // TODO improve

                    nameCache.put(currentOreId, name);

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
            zipFile.extractAll(MAIN_FOLDER.getAbsolutePath());
            defaultsZip.delete();
        } catch (IOException | ZipException e) {
            e.printStackTrace();
        }
    }
}
