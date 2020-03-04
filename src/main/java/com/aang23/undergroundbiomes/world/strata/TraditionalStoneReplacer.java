/*
 */

package com.aang23.undergroundbiomes.world.strata;


import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.world.strata.layer.UndergroundBiomesLayer;
import com.aang23.undergroundbiomes.world.strata.noise.SimplexNoiseGenerator;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.SmoothenShorelineLayer;
import net.minecraft.world.biome.layer.util.*;
import net.minecraft.world.chunk.Chunk;

import java.util.function.LongFunction;

/**
 * @author curtisadams
 */

public class TraditionalStoneReplacer extends UBStoneReplacer {

  private LayerSampler undergroundBiomeIndexLayer;

  public TraditionalStoneReplacer(long seed, int size, UndergroundBiomeSet biomeSet, WorldConfig config) {
    super(biomeSet.allowedBiomes(), new SimplexNoiseGenerator(seed), config);
    if (biomeSet.allowedBiomes().get(20).id < 1) {
      throw new RuntimeException(biomeSet.toString() + Faborge.getRegistryName(biomeSet.allowedBiomes().get(20).filler.getBlock()));
    }
    undergroundBiomeIndexLayer = biomeGenerators(size, biomeSet, salt -> new CachingLayerContext(25, seed, salt)).make();
  }


  @Override
  public int[] getBiomeValues(Chunk chunk) {
    int[] result = new int[16 * 16];

    int cx = chunk.getPos().x * 16;
    int cz = chunk.getPos().z * 16;

    for (int x = 0; x < 16; x++) {
      for (int z = 0; z < 16; z++) {
        result[x * 16 + z] = undergroundBiomeIndexLayer.sample(cx + x, cz + z);
      }
    }

    return result;
  }

  public static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> biomeGenerators(int size, UndergroundBiomeSet biomeSet, LongFunction<C> contextProvider) {
    LayerFactory<T> layer = new UndergroundBiomesLayer(biomeSet).create(contextProvider.apply(200L));
    layer = SmoothenShorelineLayer.INSTANCE.create(contextProvider.apply(1000L), layer);

    for (int i = 0; i < size + 2; i++) {
      layer = ScaleLayer.NORMAL.create(contextProvider.apply(1001L + i), layer);
    }

    layer = SmoothenShorelineLayer.INSTANCE.create(contextProvider.apply(1000L), layer);
    layer = ScaleLayer.NORMAL.create(contextProvider.apply(10L), layer);
    return layer;
  }

  public UBBiome UBBiomeAt(int x, int z) {
    int value = this.undergroundBiomeIndexLayer.sample(x, z);

    // Get the underground biome for the position
    UBBiome currentBiome = biomes.get(value);
    return currentBiome;
  }
}

