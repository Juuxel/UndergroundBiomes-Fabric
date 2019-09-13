package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.api.enums.Variant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class UBStoneStairs extends StairsBlock implements UBBlock {
    private final Variant<?> variant;

    public UBStoneStairs(Block base, Variant<?> variant) {
        super(base.getDefaultState(), Settings.of(Material.STONE));
        this.variant = variant;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE_STAIRS;
    }

    @Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return variant.getHardness();
    }

    @Override
    public float getBlastResistance() {
        return variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return variant.getStoneType();
    }

    @Override
    public Variant<?> getVariant() {
        return variant;
    }
}
