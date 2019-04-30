package com.aang23.undergroundbiomes.blocks.stone;

import com.aang23.undergroundbiomes.UBItems;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SedimentaryStone extends UBStone {
    public SedimentaryVariant sedimentary_variant;

    public SedimentaryStone(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_stone_" + sedimentary_variant.getName().toLowerCase());
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

    @Override
    public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
        if (world.rand.nextInt(100) <= fortune) {
            switch (sedimentary_variant) {
            case CHALK:
                drops.add(new ItemStack(UBItems.getRandomFossil()));
                break;
            case DOLOMITE:
                super.getDrops(state, drops, world, pos, fortune);
            case LIGNITE:
                super.getDrops(state, drops, world, pos, fortune);
            case LIMESTONE:
                drops.add(new ItemStack(UBItems.getRandomFossil()));
                break;
            case SILTSTONE:
                drops.add(new ItemStack(UBItems.getRandomFossil()));
                break;
            case SHALE:
                drops.add(new ItemStack(Items.CLAY_BALL));
                break;
            case CHERT:
                drops.add(new ItemStack(Items.FLINT));
                break;
            default:
                break;
            }
        } else
            super.getDrops(state, drops, world, pos, fortune);
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        if (sedimentary_variant == SedimentaryVariant.LIGNITE) {
            return UBItems.LIGNITE_COAL;
        } else {
            if (UBConfig.ADVANCED.sedimentaryCobble.get())
                return StoneRegistry.getCobbleForStone(this);
            else
                return super.getItemDropped(state, worldIn, pos, fortune);
        }
    }
}