package com.aang23.undergroundbiomes.items;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLignite extends Item implements FaborgeItem {
    public ItemLignite() {
        super(new Settings().group(UndergroundBiomes.CREATIVE_TAB).maxDamageIfAbsent(0).maxCount(64));
        setRegistryName(UndergroundBiomes.modid + ":lignite_coal");
    }

    // TODO: Fuel times
    /*@Override
    public int getBurnTime(ItemStack itemStack) {
        return UBConfig.ITEMS.ligniteSmeltTime.get();
    }*/
}
