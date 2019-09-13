package com.aang23.undergroundbiomes.items.fossil;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.FossilVariant;
import net.minecraft.item.Item;

public class FossilPiece extends Item {
    FossilVariant fossil_variant;

    public FossilPiece(FossilVariant variant) {
        super(new Settings().group(UndergroundBiomes.CREATIVE_TAB).maxDamageIfAbsent(0).maxCount(16));
        fossil_variant = variant;
    }
}
