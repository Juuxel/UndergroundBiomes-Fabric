package com.aang23.undergroundbiomes.blocks.cobble_stairs;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SedimentaryCobbleStairs extends UBCobbleStairs {
    public SedimentaryVariant sedimentary_variant;

    public SedimentaryCobbleStairs(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_cobble_stairs_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(IBlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return sedimentary_variant.getHardness();
    }

    @Override
    public float getExplosionResistance() {
        return sedimentary_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.SEDIMENTARY;
    }
}