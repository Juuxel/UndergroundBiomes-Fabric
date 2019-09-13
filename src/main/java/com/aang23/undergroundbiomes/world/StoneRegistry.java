package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class StoneRegistry {
    public static Block getVariantForStone(BlockState initialState, UBStoneStyle style) {
        Block initialBlock = initialState.getBlock();
        if (initialBlock instanceof UBBlock) {
            UBBlock stone = (UBBlock) initialBlock;
            return UBBlocks.getBlock(stone.getVariant(), style);
        } else
            return initialBlock;
    }
}
