package com.aang23.undergroundbiomes;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UndergroundBiomesItemGroupOres extends ItemGroup {
    UndergroundBiomesItemGroupOres() {
        super("tabUndergroundBiomesOres");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.IRON_ORE);
    }
}