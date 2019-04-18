package com.aang23.undergroundbiomes.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class UBConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final WorldGen WORLDGEN = new WorldGen(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static class General {
        public final ForgeConfigSpec.ConfigValue<String> ubChunkKey;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("General");

            ubChunkKey = builder.comment("The sring used to mark chunks as UB-fied. Change only if you want UBC to redo everything.").define("ubChunkKey", "ub");

            builder.pop();
        }
    }

    public static class WorldGen {
        public final ForgeConfigSpec.BooleanValue replaceStone;
        public final ForgeConfigSpec.BooleanValue replaceGravel;

        WorldGen(ForgeConfigSpec.Builder builder) {
            builder.push("WorldGen");

            replaceStone = builder.comment("Do you want UBC to replace vanilla stone ?").define("replaceStone", true);
            replaceGravel = builder.comment("Do you want UBC to replace vanilla gravel ?").define("replaceGravel", true);

            builder.pop();
        }
    }
}