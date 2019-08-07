package com.aang23.undergroundbiomes.blocks.infested_stone;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SedimentaryInfestedStone extends UBInfestedStone {
    public SedimentaryVariant sedimentary_variant;

    public SedimentaryInfestedStone(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_infested_stone_" + sedimentary_variant.asString());
    }

    @Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return sedimentary_variant.getHardness();
    }

    @Override
    public float getBlastResistance() {
        return sedimentary_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.SEDIMENTARY;
    }
}
