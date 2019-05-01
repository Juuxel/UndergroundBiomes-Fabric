package com.aang23.undergroundbiomes.blocks.stone_stairs;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MetamorphicStoneStairs extends UBStoneStairs {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicStoneStairs(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_stone_stairs_" + metamorphic_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(IBlockState blockState, IBlockReader worldIn, BlockPos pos) {
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