package com.aang23.undergroundbiomes.items;

import com.aang23.undergroundbiomes.Faborge;
import net.minecraft.item.ItemConvertible;

public interface FaborgeItem extends ItemConvertible {
    default void setRegistryName(String str) {
        Faborge.setRegistryName(asItem(), str);
    }
}
