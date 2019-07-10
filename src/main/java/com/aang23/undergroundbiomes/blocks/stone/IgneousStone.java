package com.aang23.undergroundbiomes.blocks.stone;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext.Builder;

public class IgneousStone extends UBStone {
    public IgneousVariant igneous_variant;

    public IgneousStone(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_stone_" + igneous_variant.getName().toLowerCase());
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

    @Override
    public List<ItemStack> getDrops(BlockState p_220076_1_, Builder p_220076_2_) {
        List<ItemStack> toReturn = new ArrayList<ItemStack>();
        toReturn.add(new ItemStack(StoneRegistry.getCobbleForStone(this)));
        return toReturn;
    }
}