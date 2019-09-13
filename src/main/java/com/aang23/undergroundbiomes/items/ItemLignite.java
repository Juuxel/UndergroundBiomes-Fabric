package com.aang23.undergroundbiomes.items;

import com.aang23.undergroundbiomes.UndergroundBiomes;

import net.minecraft.item.Item;

public class ItemLignite extends Item {
    public ItemLignite() {
        super(new Settings().group(UndergroundBiomes.CREATIVE_TAB).maxDamageIfAbsent(0).maxCount(64));
    }
}
