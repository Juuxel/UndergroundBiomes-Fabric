package com.aang23.undergroundbiomes.blocks.cobble;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.IgneousVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class IgneousCobble extends UBCobble {
    public IgneousVariant igneous_variant;

    public IgneousCobble(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_cobble_" + igneous_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return igneous_variant.getHardness();
    }

    @Override
    public float getExplosionResistance() {
        return igneous_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.IGNEOUS;
    }
}