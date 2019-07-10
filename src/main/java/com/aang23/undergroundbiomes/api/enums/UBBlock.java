package com.aang23.undergroundbiomes.api.enums;

import net.minecraft.item.BlockItem;

/**
 * Common interface for all UB blocks.
 *
 * @author LouisDB, Aang23
 */
public interface UBBlock {

  BlockItem getItemBlock();

  UBStoneType getStoneType();

  UBStoneStyle getStoneStyle();

}