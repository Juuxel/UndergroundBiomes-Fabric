package com.aang23.undergroundbiomes.blocks.stone_stairs;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.blocks.stone.UBStone;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class UBStoneStairs extends StairsBlock implements UBBlock {

    public UBStoneStairs() {
        super(new UBStone().getDefaultState(), Settings.of(Material.STONE));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE_STAIRS;
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
