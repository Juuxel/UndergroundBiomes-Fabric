package com.aang23.undergroundbiomes.blocks.brick;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class UBBrick extends Block implements UBBlock {

    public UBBrick() {
        super(Settings.of(Material.SAND));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.BRICK;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Settings().group(UndergroundBiomes.CREATIVE_TAB));
        Faborge.setRegistryName(itemBlock, this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return null;
    }
}
