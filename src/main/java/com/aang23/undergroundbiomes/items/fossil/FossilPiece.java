package com.aang23.undergroundbiomes.items.fossil;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.FossilVariant;
import net.minecraft.item.Item;

public class FossilPiece extends Item {
    FossilVariant fossil_variant;

    public FossilPiece(FossilVariant variant) {
        super(new Properties().group(UndergroundBiomes.CREATIVE_TAB).defaultMaxDamage(0).maxStackSize(16));
        fossil_variant = variant;
        setRegistryName(UndergroundBiomes.modid + ":" + "fossil_piece_" + fossil_variant.toString());
    }
}