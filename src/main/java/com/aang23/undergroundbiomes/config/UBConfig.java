package com.aang23.undergroundbiomes.config;

import blue.endless.jankson.Jankson;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public class UBConfig {
    private static UBConfig instance = null;
    public General general = new General();
    public WorldGen worldgen = new WorldGen();
    public Items items = new Items();
    public Recipes recipes = new Recipes();
    public Advanced advanced = new Advanced();

    private static UBConfig load() {
        File file = new File(FabricLoader.getInstance().getConfigDirectory(), "undergroundbiomes.json5");
        Jankson jankson = Jankson.builder().build();

        if (!file.exists()) {
            UBConfig defaultConfig = new UBConfig();
            try (FileWriter writer = new FileWriter(file)) {
                String json = jankson.toJson(defaultConfig).toJson(true, true);
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            return jankson.fromJson(jankson.load(file), UBConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load UB config", e);
        }
    }

    public static UBConfig instance() {
        if (instance == null) {
            instance = load();
        }

        return instance;
    }

    public static class General {
        public final String ubChunkKey = "ub";
        public final String dimensionList = "0";

//        General(ForgeConfigSpec.Builder builder) {
//            builder.push("General");
//
//            ubChunkKey = builder.comment("The sring used to mark chunks as UB-fied. Change only if you want UBC to redo everything.").define("ubChunkKey", "ub");
//            dimensionList = builder.comment("The list of dimensions ids. Must be separated by a comma (,). Whitelist.").define("dimensionList", "0");
//
//            builder.pop();
//        }
    }

    public static class WorldGen {
        public boolean replaceStone = true;
        public boolean replaceGravel = true;
        public boolean replaceCobble = true;
        public boolean replaceSand = true;
        public boolean replaceInfestedStone = true;

        public boolean spawnVanillaStone = false;
        public boolean harmoniousStrata = false;
        public int biomeSize = 4;
        public int generationHeight = 256;

//        WorldGen(ForgeConfigSpec.Builder builder) {
//            builder.push("WorldGen");
//
//            replaceStone = builder.comment("Do you want UBC to replace vanilla stone ?").define("replaceStone", true);
//            replaceCobble = builder.comment("Do you want UBC to replace vanilla cobblestone ?").define("replaceCobble", true);
//            replaceGravel = builder.comment("Do you want UBC to replace vanilla gravel ?").define("replaceGravel", true);
//            replaceSand = builder.comment("Do you want UBC to replace vanilla sand ?").define("replaceSand", true);
//            replaceInfestedStone = builder.comment("Do you want UBC to replace vanilla infested stone ?").define("replaceInfestedStone", true);
//            spawnVanillaStone = builder.comment("Enable if you want some biomes to contain vanilla stone.").define("spawnVanillaStone", false);
//            harmoniousStrata = builder.comment("Smooth biome transitions.").define("harmoniousStrata", false);
//            biomeSize = builder.comment("Sets the biome size. Exponential !").define("biomeSize", 4);
//            generationHeight = builder.comment("How hight UBC's stones should stop generation at ?").define("generationHeight", 256);
//
//            builder.pop();
//        }
    }

    public static class Items {
        public int ligniteSmeltTime = 200;

//        Items(ForgeConfigSpec.Builder builder) {
//            builder.push("Items");
//
//            ligniteSmeltTime = builder.comment("Smelt time for the lignite item. In ticks.").define("ligniteSmeltTime", 200);
//
//            builder.pop();
//        }
    }

    public static class Recipes {
        public boolean stoneToVanillaRecipe = true;
        public boolean cobbleToVanillaRecipe = true;
        public boolean gravelToVanillaRecipe = true;

//        Recipes(ForgeConfigSpec.Builder builder) {
//            builder.push("Recipes");
//
//            stoneToVanillaRecipe = builder.comment("Should a recipe to vanilla stone be available ?").define("stoneToVanillaRecipe", true);
//            cobbleToVanillaRecipe = builder.comment("Should a recipe to vanilla cobblestone be available ?").define("cobbleToVanillaRecipe", true);
//            gravelToVanillaRecipe = builder.comment("Should a recipe to vanilla gravel be available ?").define("gravelToVanillaRecipe", true);
//
//            builder.pop();
//        }
    }

    public static class Advanced {
        public final boolean differentSeedPerWorld = false;
        public final boolean sedimentaryCobble = false;

//        Advanced(ForgeConfigSpec.Builder builder) {
//            builder.push("Advanced");
//
//            differentSeedPerWorld = builder.comment("Should UB's seed be different in each dimension ?").define("differentSeedPerWorld", false);
//            sedimentaryCobble = builder.comment("Should UB drop cobblestone variants for sedimentary stones ?").define("sedimentaryCobble", false);
//
//            builder.pop();
//        }
    }
}
