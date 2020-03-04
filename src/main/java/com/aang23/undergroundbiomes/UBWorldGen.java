package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.world.feature.UndergroundBiomeFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class UBWorldGen {
    public static final Feature<DefaultFeatureConfig> UNDERGROUND_BIOMES = new UndergroundBiomeFeature(DefaultFeatureConfig::deserialize);

    static void init() {
        Registry.register(Registry.FEATURE, UndergroundBiomes.id("underground_biomes"), UNDERGROUND_BIOMES);
    }

    public static void addUndergroundBiomes(Biome biome) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_DECORATION,
                UNDERGROUND_BIOMES.configure(FeatureConfig.DEFAULT)
                        .createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT))
        );
    }
}
