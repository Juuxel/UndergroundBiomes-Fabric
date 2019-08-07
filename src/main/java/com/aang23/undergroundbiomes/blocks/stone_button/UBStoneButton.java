package com.aang23.undergroundbiomes.blocks.stone_button;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Material;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class UBStoneButton extends StoneButtonBlock implements UBBlock {

    public UBStoneButton() {
        super(Settings.of(Material.STONE));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.GRAVEL;
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
