package com.aang23.undergroundbiomes.blocks.sand;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class SedimentarySand extends UBSand {
    public SedimentaryVariant sedimentary_variant;

    public SedimentarySand(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_sand_" + sedimentary_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.SEDIMENTARY;
    }
}
