package com.aang23.undergroundbiomes.api.enums;

import com.aang23.undergroundbiomes.Faborge;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;

/**
 * Common interface for all UB blocks.
 *
 * @author LouisDB, Aang23
 */
public interface UBBlock {

  BlockItem getItemBlock();

  UBStoneType getStoneType();

  UBStoneStyle getStoneStyle();

  default Identifier getRegistryName() {
    return Faborge.getRegistryName((Block) this);
  }

  default void setRegistryName(String str) {
    Faborge.BLOCK_REGISTRY_NAMES.put(this, str);
  }

}
