package com.aang23.undergroundbiomes.blocks.gravel;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class IgneousGravel extends UBGravel {
    public IgneousVariant igneous_variant;

    public IgneousGravel(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_gravel_" + igneous_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.IGNEOUS;
    }
}
