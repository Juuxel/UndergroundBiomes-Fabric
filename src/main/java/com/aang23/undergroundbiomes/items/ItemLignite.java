package com.aang23.undergroundbiomes.items;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLignite extends Item {
    public ItemLignite() {
        super(new Properties().group(UndergroundBiomes.CREATIVE_TAB).defaultMaxDamage(0).maxStackSize(64));
        setRegistryName(UndergroundBiomes.modid + ":lignite_coal");
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 200;
    }
}