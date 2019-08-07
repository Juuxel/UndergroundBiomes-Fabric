package com.aang23.undergroundbiomes.blocks.sand;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class MetamorphicSand extends UBSand {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicSand(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_sand_" + metamorphic_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }
}
