package com.aang23.undergroundbiomes.blocks.stone;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UBItems;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
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

        if (sedimentary_variant == SedimentaryVariant.LIGNITE) {
            drops.add(new ItemStack(UBItems.LIGNITE_COAL));
        } else {
            if (Math.random() * 10 > 8) {
                switch (sedimentary_variant) {
                case CHALK:
                    drops.add(new ItemStack(UBItems.getRandomFossil()));
                    break;
                case DOLOMITE:
                    drops.add(new ItemStack(this.asItem()));
                case LIGNITE:
                    drops.add(new ItemStack(this.asItem()));
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
                drops.add(new ItemStack(this.asItem()));
        }
        //TODO Fortune compat?
        return drops;
    }
}