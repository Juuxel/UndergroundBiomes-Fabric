package com.aang23.undergroundbiomes.blocks.stone;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UBItems;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext.Builder;

public class SedimentaryStone extends UBStone {
    public SedimentaryVariant sedimentary_variant;

    public SedimentaryStone(SedimentaryVariant sedimentary_variant) {
        super();
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_stone_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
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
    public List<ItemStack> getDrops(BlockState blockstate, Builder builder) {
        List<ItemStack> drops = new ArrayList<ItemStack>();
        //if (world.rand.nextInt(100) <= builder.) {
            switch (sedimentary_variant) {
            case CHALK:
                drops.add(new ItemStack(UBItems.getRandomFossil()));
                break;
            case DOLOMITE:
                super.getDrops(blockstate, builder);
            case LIGNITE:
                super.getDrops(blockstate, builder);
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
        //} else
        //    super.getDrops(blockstate, builder);
        return drops;
        //TODO REDO
    }

    /*    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        if (sedimentary_variant == SedimentaryVariant.LIGNITE) {
            return UBItems.LIGNITE_COAL;
        } else {
            if (UBConfig.ADVANCED.sedimentaryCobble.get())
                return StoneRegistry.getCobbleForStone(this);
            else
                return super.getItemDropped(state, worldIn, pos, fortune);
        }
    }*/
}