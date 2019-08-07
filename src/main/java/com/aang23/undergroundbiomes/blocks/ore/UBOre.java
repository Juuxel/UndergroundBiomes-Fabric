package com.aang23.undergroundbiomes.blocks.ore;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class UBOre extends Block implements UBBlock {
    public Block baseOre;
    public BlockState baseState;
    public UBStoneType stone_type;
    public String sub_stone_name;

    public UBOre(Block baseOre, BlockState baseState, UBStoneType stone_type, String sub_stone_name) {
        super(FabricBlockSettings.of(baseOre.getMaterial(baseState))
                .dropsLike(baseOre)
                .breakByTool(FabricToolTags.PICKAXES /* TODO: Mining levels */)
                .build());
        this.baseOre = baseOre;
        this.baseState = baseState;
        this.stone_type = stone_type;
        this.sub_stone_name = sub_stone_name;
        setRegistryName(UndergroundBiomes.modid + ":" + stone_type + "_ore_"
                + Faborge.getRegistryName(baseOre).toString().replace(":", "_") + "_" + sub_stone_name);
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Settings().group(UndergroundBiomes.ORES_CREATIVE_TAB));
        Faborge.setRegistryName(itemBlock, this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
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

    /*@Override
    public List<ItemStack> getDrops(BlockState p_220076_1_, Builder p_220076_2_) {
        return baseOre.getDrops(p_220076_1_, p_220076_2_);
    }*/

    @Override
    public float getHardness(BlockState blockState, BlockView worldIn, BlockPos pos) {
        return baseOre.getHardness(blockState, worldIn, pos);
    }

//    @Override
//    public int getHarvestLevel(BlockState state) {
//        return baseOre.getHarvestLevel(state);
//    }

    @Override
    public float getBlastResistance() {
        return baseOre.getBlastResistance();
    }

    @Override
    public int getLuminance(BlockState state) {
        return 0; // TODO fix
    }

    @Override
    public void onBreak(World world_1, BlockPos blockPos_1, BlockState blockState_1, PlayerEntity playerEntity_1) {
        baseOre.onBreak(world_1, blockPos_1, blockState_1, playerEntity_1);
    }

    // TODO
    /*@Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return baseOre.getExpDrop(state, world, pos, fortune, silktouch);
    }*/

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entityIn) {
        // baseOre.onSteppedOn(worldIn, pos, entityIn); //TODO fix
    }

    @Override
    public void onBroken(IWorld worldIn, BlockPos pos, BlockState state) {
        baseOre.onBroken(worldIn, pos, state);
    }
}
