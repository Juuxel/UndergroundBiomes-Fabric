package com.aang23.undergroundbiomes.blocks.gravel;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

public class MetamorphicGravel extends UBGravel {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicGravel(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_gravel_" + metamorphic_variant.asString());
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }
}
