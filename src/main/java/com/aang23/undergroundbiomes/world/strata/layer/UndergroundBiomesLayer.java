package com.aang23.undergroundbiomes.world.strata.layer;

import com.aang23.undergroundbiomes.world.strata.UBBiome;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public final class UndergroundBiomesLayer implements InitLayer {
    private final UBBiome[] allowedBiomes;

    public UndergroundBiomesLayer(UndergroundBiomeSet biomeSet) {
        this.allowedBiomes = biomeSet.allowedBiomes(); // TODO: Array?
    }

    @Override
    public int sample(LayerRandomnessSource context, int x, int z) {
        return allowedBiomes[context.nextInt(allowedBiomes.length)].id;
    }
}
