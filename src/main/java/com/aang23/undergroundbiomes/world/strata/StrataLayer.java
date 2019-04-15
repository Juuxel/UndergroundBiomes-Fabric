package com.aang23.undergroundbiomes.world.strata;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

/**
 * @author CurtisA, LouisDB
 */
public final class StrataLayer {

  public final Block block;
  public final IBlockState filler;
  public final int minHeight, maxHeight;

  public StrataLayer(Block block, int minHeight, int maxHeight) {
    this.block = block;
    filler = block.getDefaultState();
    this.minHeight = minHeight;
    this.maxHeight = maxHeight;
  }

  public boolean heightInLayer(int y) {
    return (y >= minHeight && y <= maxHeight);
  }
}