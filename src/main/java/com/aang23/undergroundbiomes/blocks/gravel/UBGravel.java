package com.aang23.undergroundbiomes.blocks.gravel;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.GravelBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class UBGravel extends GravelBlock implements UBBlock {

    public UBGravel() {
        super(FabricBlockSettings.copy(Blocks.GRAVEL)
                .sounds(BlockSoundGroup.GRAVEL)
                .breakByTool(FabricToolTags.SHOVELS)
                .build());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.GRAVEL;
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

    // TODO: I think this is done by FabricBlockSettings.breakByTool
    /*@Override
    public ToolType getHarvestTool(BlockState state) {
        return Blocks.GRAVEL.getHarvestTool(state);
    }*/

    // TODO: This might be useless? UBGravel extends GravelBlock
    /*@Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return Blocks.GRAVEL.getDefaultState().getHardness(worldIn, pos);
    }*/

    // TODO
    /*@Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.GRAVEL.canSustainPlant(state, world, pos, facing, plantable);
    }*/
}
