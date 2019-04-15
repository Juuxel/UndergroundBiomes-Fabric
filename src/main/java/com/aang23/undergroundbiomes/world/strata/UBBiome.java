package com.aang23.undergroundbiomes.world.strata;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

/**
 * @author CurtisA, LouisDB
 */
public final class UBBiome {

  public final int ID;
  public final Block block;
  public final IBlockState filler;

  public StrataLayer[] strata;

  public UBBiome(int ID, Block block) {
    this.ID = ID;
    this.block = block;
    filler = block.getDefaultState();
    Preconditions.checkNotNull(filler);
  }

  public UBBiome addStrataLayers(StrataLayer[] strata) {
    this.strata = strata;
    return this;
  }

  public IBlockState getStrataBlockAtLayer(int y) {
    for (StrataLayer layer : strata) {
      if (layer.heightInLayer(y))
        return layer.filler;
    }
    return filler;
  }

}