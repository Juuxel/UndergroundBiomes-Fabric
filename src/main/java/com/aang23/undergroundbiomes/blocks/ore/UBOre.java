package com.aang23.undergroundbiomes.blocks.ore;

import java.util.Random;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.enums.UBBlock;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class UBOre extends Block implements UBBlock {
    public Block baseOre;
    public IBlockState baseState;
    public UBStoneType stone_type;
    public String sub_stone_name;

    public UBOre(Block baseOre, IBlockState baseState, UBStoneType stone_type, String sub_stone_name) {
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
    public ItemBlock getItemBlock() {
        ItemBlock itemBlock = new ItemBlock(this, new Item.Properties().group(UndergroundBiomes.ORES_CREATIVE_TAB));
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
    public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
        baseOre.getDrops(state, drops, world, pos, fortune);
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return baseOre.getItemDropped(state, worldIn, pos, fortune);
    }

    @Override
    public float getBlockHardness(IBlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return baseOre.getBlockHardness(blockState, worldIn, pos);
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return baseOre.getHarvestLevel(state);
    }

    @Override
    public ToolType getHarvestTool(IBlockState state) {
        return baseOre.getHarvestTool(state);
    }

    @Override
    public float getExplosionResistance() {
        return baseOre.getExplosionResistance();
    }

    @Override
    public int getLightValue(IBlockState state) {
        return baseOre.getLightValue(state);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        baseOre.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public void onBlockClicked(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player) {
        baseOre.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        return baseOre.onBlockActivated(state, worldIn, pos, player, hand, side, hitX, hitY, hitZ);
    }

    @Override
    public int quantityDropped(IBlockState state, Random random) {
        return baseOre.quantityDropped(state, random);
    }

    @Override
    public IBlockState getStateAtViewpoint(IBlockState state, IBlockReader world, BlockPos pos, Vec3d viewpoint) {
        return baseOre.getStateAtViewpoint(state, world, pos, viewpoint);
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return baseOre.getStateForPlacement(context);
    }

    @Override
    public IBlockState getStateForPlacement(IBlockState state, EnumFacing facing, IBlockState state2, IWorld world,
            BlockPos pos1, BlockPos pos2, EnumHand hand) {
        return baseOre.getStateForPlacement(state, facing, state2, world, pos1, pos2, hand);
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockReader world, BlockPos pos) {
        return baseOre.getExtendedState(state, world, pos);
    }

    @Override
    public StateContainer<Block, IBlockState> getStateContainer() {
        return baseOre.getStateContainer();
    }

    @Override
    public int getExpDrop(IBlockState state, IWorldReader world, BlockPos pos, int fortune) {
        return baseOre.getExpDrop(state, world, pos, fortune);
    }

    @Override
    public boolean getTickRandomly(IBlockState p_149653_1_) {
        return baseOre.getTickRandomly(p_149653_1_);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        baseOre.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, IBlockState state) {
        baseOre.onPlayerDestroy(worldIn, pos, state);
    }
}