package com.aang23.undergroundbiomes;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UndergroundBiomesItemGroup extends ItemGroup {
    UndergroundBiomesItemGroup() {
        super("tabUndergroundBiomesBlocks");
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(UBBlocks.IGNEOUS_STONE_BLACK_GRANITE);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}