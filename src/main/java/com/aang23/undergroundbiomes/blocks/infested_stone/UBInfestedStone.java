package com.aang23.undergroundbiomes.blocks.infested_stone;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;

import net.minecraft.block.Blocks;
import net.minecraft.block.SilverfishBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class UBInfestedStone extends SilverfishBlock implements UBBlock {

    public UBInfestedStone() {
        super(Blocks.STONE, Properties.create(Material.ROCK));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.INFESTED_STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return null;
    }
}