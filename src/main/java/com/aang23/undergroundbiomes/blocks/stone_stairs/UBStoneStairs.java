package com.aang23.undergroundbiomes.blocks.stone_stairs;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.blocks.stone.UBStone;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class UBStoneStairs extends StairsBlock implements UBBlock {

    public UBStoneStairs() {
        super(new UBStone().getDefaultState(), Properties.create(Material.ROCK));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE_STAIRS;
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