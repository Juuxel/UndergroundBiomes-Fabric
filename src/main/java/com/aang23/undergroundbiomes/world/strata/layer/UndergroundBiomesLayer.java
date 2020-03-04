package com.aang23.undergroundbiomes.world.strata.layer;

import com.aang23.undergroundbiomes.world.strata.UBBiome;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public final class UndergroundBiomesLayer implements InitLayer {
    private final ImmutableList<UBBiome> allowedBiomes;

    public UndergroundBiomesLayer(UndergroundBiomeSet biomeSet) {
        this.allowedBiomes = biomeSet.allowedBiomes();
    }

    @Override
    public int sample(LayerRandomnessSource context, int x, int z) {
        return allowedBiomes.get(context.nextInt(allowedBiomes.size())).id;
    }
}
