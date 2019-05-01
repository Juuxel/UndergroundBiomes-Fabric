package com.aang23.undergroundbiomes.blocks.stone_stairs;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.blocks.stone.UBStone;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class UBStoneStairs extends BlockStairs implements UBBlock {

    public UBStoneStairs() {
        super(new UBStone().getDefaultState(), Properties.create(Material.ROCK));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STAIRS;
    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlock itemBlock = new ItemBlock(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return null;
    }
}