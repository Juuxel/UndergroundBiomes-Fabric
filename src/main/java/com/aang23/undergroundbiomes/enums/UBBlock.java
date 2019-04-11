package com.aang23.undergroundbiomes.enums;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

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