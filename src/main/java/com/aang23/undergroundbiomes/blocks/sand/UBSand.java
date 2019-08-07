package com.aang23.undergroundbiomes.blocks.sand;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class UBSand extends SandBlock implements UBBlock {

    public UBSand() {
        super(0, FabricBlockSettings.copy(Blocks.SAND)
                .sounds(BlockSoundGroup.SAND)
                .breakByTool(FabricToolTags.SHOVELS)
                .build());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.SAND;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Settings().group(UndergroundBiomes.CREATIVE_TAB));
        Faborge.setRegistryName(itemBlock, this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return null;
    }

    // TODO: See UBGravel#getHarvestTool
//    @Override
//    public ToolType getHarvestTool(BlockState state) {
//        return Blocks.SAND.getHarvestTool(state);
//    }

    // TODO: Useless?
    /*@Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return Blocks.SAND.getBlockHardness(blockState, worldIn, pos);
    }*/

    // TODO: Mixin-to-dead-bush-and-cactus time
    /*@Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.SAND.canSustainPlant(state, world, pos, facing, plantable);
    }*/
}
