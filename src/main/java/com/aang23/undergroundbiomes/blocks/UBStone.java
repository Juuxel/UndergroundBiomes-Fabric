package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.api.enums.Variant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class UBStone extends Block implements UBBlock {
    private final Variant<?> variant;

    public UBStone(Variant<?> variant) {
        super(Settings.of(Material.STONE));
        this.variant = variant;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
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

    // TODO: Loot tables
//    @Override
//    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
//        List<ItemStack> toReturn = new ArrayList<ItemStack>();
//        toReturn.add(new ItemStack(StoneRegistry.getCobbleForStone(this)));
//        return toReturn;
//    }

    @Override
    public Variant<?> getVariant() {
        return variant;
    }
}
