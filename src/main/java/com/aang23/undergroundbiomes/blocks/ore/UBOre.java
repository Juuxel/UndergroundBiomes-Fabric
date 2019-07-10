package com.aang23.undergroundbiomes.blocks.ore;

import java.util.List;
import java.util.Random;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraftforge.common.ToolType;

public class UBOre extends Block implements UBBlock {
    public Block baseOre;
    public BlockState baseState;
    public UBStoneType stone_type;
    public String sub_stone_name;

    public UBOre(Block baseOre, BlockState baseState, UBStoneType stone_type, String sub_stone_name) {
        super(Properties.create(baseOre.getMaterial(baseState)));
        this.baseOre = baseOre;
        this.baseState = baseState;
        this.stone_type = stone_type;
        this.sub_stone_name = sub_stone_name;
        setRegistryName(UndergroundBiomes.modid + ":" + stone_type + "_ore_"
                + baseOre.getRegistryName().toString().replace(":", "_") + "_" + sub_stone_name);
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.ORES_CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return stone_type;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
            ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_220076_1_, Builder p_220076_2_) {
        return baseOre.getDrops(p_220076_1_, p_220076_2_);
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return baseOre.getBlockHardness(blockState, worldIn, pos);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return baseOre.getHarvestLevel(state);
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return baseOre.getHarvestTool(state);
    }

    @Override
    public float getExplosionResistance() {
        return baseOre.getExplosionResistance();
    }

    @Override
    public int getLightValue(BlockState state) {
        return 0; // TODO fix
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        baseOre.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return baseOre.getExpDrop(state, world, pos, fortune, silktouch);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        // baseOre.onEntityWalk(worldIn, pos, entityIn); //TODO fix
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        baseOre.onPlayerDestroy(worldIn, pos, state);
    }
}