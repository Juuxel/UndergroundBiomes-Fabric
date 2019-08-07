package com.aang23.undergroundbiomes.blocks.gravel;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class SedimentaryGravel extends UBGravel {
    public SedimentaryVariant sedimentary_variant;

    public SedimentaryGravel(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_gravel_" + sedimentary_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.SEDIMENTARY;
    }
}
