package com.aang23.undergroundbiomes.blocks.infested_stone;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class MetamorphicInfestedStone extends UBInfestedStone {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicInfestedStone(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_infested_stone_" + metamorphic_variant.asString());
    }

    @Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return metamorphic_variant.getHardness();
    }

    @Override
    public float getBlastResistance() {
        return metamorphic_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }
}
