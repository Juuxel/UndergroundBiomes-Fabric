/*
 */

package com.aang23.undergroundbiomes.world.strata;

import net.minecraft.block.state.IBlockState;

/**
 * @author Zeno410
 */
public interface UBStrataColumn {
  public IBlockState stone(int height);

  public IBlockState stone();
}