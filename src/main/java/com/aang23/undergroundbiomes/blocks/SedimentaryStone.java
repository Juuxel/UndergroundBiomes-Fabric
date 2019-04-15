package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.UndergroundBiomesItemGroup;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SedimentaryStone extends Block implements UBBlock {
 SedimentaryVariant sedimentary_variant;

    public SedimentaryStone(SedimentaryVariant sedimentary_variant) {
        super(Properties.create(Material.ROCK));
        this.sedimentary_variant = sedimentary_variant;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_stone_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public float getBlockHardness(IBlockState blockState, IBlockReader worldIn, BlockPos pos) {
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
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public ItemBlock getItemBlock() {
        ItemBlock itemBlock = new ItemBlock(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(
                this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }
}