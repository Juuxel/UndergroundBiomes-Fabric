package com.aang23.undergroundbiomes.config;

import blue.endless.jankson.Comment;
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
        //public final String ubChunkKey = "ub";
        @Comment("The list of dimensions ids. Must be separated by a comma (,). Whitelist.")
        public final String dimensionList = "minecraft:overworld";
    }

    public static class WorldGen {
        @Comment("Do you want UBC to replace vanilla stone ?") public boolean replaceStone = true;
        @Comment("Do you want UBC to replace vanilla gravel ?") public boolean replaceGravel = true;
        @Comment("Do you want UBC to replace vanilla cobblestone ?") public boolean replaceCobble = true;
        @Comment("Do you want UBC to replace vanilla sand ?") public boolean replaceSand = true;
        @Comment("Do you want UBC to replace vanilla infested stone ?") public boolean replaceInfestedStone = true;

        @Comment("Enable if you want some biomes to contain vanilla stone.") public boolean spawnVanillaStone = false;
        @Comment("Smooth biome transitions.") public boolean harmoniousStrata = false;
        @Comment("Sets the biome size. Exponential !") public int biomeSize = 4;
        @Comment("How hight UBC's stones should stop generation at ?") public int generationHeight = 256;
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
