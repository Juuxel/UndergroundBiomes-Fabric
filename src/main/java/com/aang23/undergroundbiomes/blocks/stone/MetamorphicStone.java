package com.aang23.undergroundbiomes.blocks.stone;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.world.StoneRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext;

public class MetamorphicStone extends UBStone {
    public MetamorphicVariant metamorphic_variant;

    public MetamorphicStone(MetamorphicVariant metamorphic_variant) {
        super();
        this.metamorphic_variant = metamorphic_variant;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_stone_" + metamorphic_variant.asString());
    }

    @Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return metamorphic_variant.getHardness();
    }

    @Override
    public float getBlastResistance() {
        return metamorphic_variant.getResistance();
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        List<ItemStack> toReturn = new ArrayList<ItemStack>();
        toReturn.add(new ItemStack(StoneRegistry.getCobbleForStone(this)));
        return toReturn;
    }
}
