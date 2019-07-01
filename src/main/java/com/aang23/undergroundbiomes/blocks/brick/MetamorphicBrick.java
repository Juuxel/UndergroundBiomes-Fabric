package com.aang23.undergroundbiomes.blocks.brick;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MetamorphicBrick extends UBBrick {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicBrick(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_brick_" + metamorphic_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return metamorphic_variant.getHardness();
    }

    @Override
    public float getExplosionResistance() {
        return metamorphic_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }
}