package com.aang23.undergroundbiomes.blocks.stone;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext;

public class IgneousStone extends UBStone {
    public IgneousVariant igneous_variant;

    public IgneousStone(IgneousVariant igneous_variant) {
        super();
        this.igneous_variant = igneous_variant;
        setRegistryName(UndergroundBiomes.modid + ":igneous_stone_" + igneous_variant.asString());
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

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        List<ItemStack> toReturn = new ArrayList<ItemStack>();
        toReturn.add(new ItemStack(StoneRegistry.getCobbleForStone(this)));
        return toReturn;
    }
}
