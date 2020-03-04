package com.aang23.undergroundbiomes.world.strata;

import com.google.common.collect.ImmutableList;

/**
 * @author Zeno410
 */
abstract public class UndergroundBiomeSet {
  public final StrataLayer[][] strataLayers;

  public UndergroundBiomeSet(StrataLayer[][] strataLayers) {
    this.strataLayers = strataLayers;
  }

  abstract public ImmutableList<UBBiome> allowedBiomes();
}