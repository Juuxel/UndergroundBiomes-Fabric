package com.aang23.undergroundbiomes.blocks.sand;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class IgneousSand extends UBSand {
    public IgneousVariant igneous_variant;

    public IgneousSand(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_sand_" + igneous_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.IGNEOUS;
    }
}
