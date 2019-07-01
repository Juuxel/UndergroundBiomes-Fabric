package com.aang23.undergroundbiomes.blocks.sand;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;

import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;

public class UBSand extends SandBlock implements UBBlock {

    public UBSand() {
        super(0, Properties.create(Material.SAND));
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.SAND;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return null;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.SHOVEL;
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        PlantType plantType = plantable.getPlantType(world, pos.offset(facing));
        if (plantType == PlantType.Desert || plantType == PlantType.Beach || plantType == PlantType.Water) {
            return true;
        } else
            return false;
    }
}