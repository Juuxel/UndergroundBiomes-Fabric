package com.aang23.undergroundbiomes.enums;

import net.minecraft.item.ItemBlock;

/**
 * Common interface for all UB blocks.
 *
 * @author LouisDB
 */
public interface UBBlock {

  ItemBlock getItemBlock();

  UBStoneType getStoneType();

  UBStoneStyle getStoneStyle();

}