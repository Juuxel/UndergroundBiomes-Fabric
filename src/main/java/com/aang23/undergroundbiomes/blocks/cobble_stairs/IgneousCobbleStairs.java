package com.aang23.undergroundbiomes.blocks.cobble_stairs;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class IgneousCobbleStairs extends UBCobbleStairs {
    public IgneousVariant igneous_variant;

    public IgneousCobbleStairs(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_cobble_stairs_" + igneous_variant.asString());
    }

    @Override
    public float getHardness(BlockState blockState, BlockView world, BlockPos pos) {
        return igneous_variant.getHardness();
    }

    @Override
    public float getBlastResistance() {
        return igneous_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.IGNEOUS;
    }
}
