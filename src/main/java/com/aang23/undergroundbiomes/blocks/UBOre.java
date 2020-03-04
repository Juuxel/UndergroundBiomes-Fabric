package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.api.enums.Variant;
import com.aang23.undergroundbiomes.mixin.ToolManagerEntryImplAccessor;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.fabricmc.fabric.impl.mining.level.ToolManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class UBOre extends Block implements UBBlock {
    public Block baseOre;
    private final Variant<?> variant;

    public UBOre(Block baseOre, BlockState baseState, Variant<?> variant) {
        super(FabricBlockSettings.of(baseOre.getMaterial(baseState))
                .dropsLike(baseOre)
                .breakByTool(FabricToolTags.PICKAXES, getMiningLevel(baseOre))
                .build());
        this.baseOre = baseOre;
        this.variant = variant;
        setRegistryName(UndergroundBiomes.modid + ":" + variant.getStoneType() + "_ore_"
                + Registry.BLOCK.getId(baseOre).toString().replace(":", "_") + "_" + variant.asString());
    }

    // TODO: Cleanup
    // See PickaxeItem and Fabric's ToolManager
    private static int getMiningLevel(Block block) {
        if (block == Blocks.OBSIDIAN)
            return 3;
        else if (block == Blocks.DIAMOND_BLOCK || block == Blocks.DIAMOND_ORE || block == Blocks.EMERALD_BLOCK || block == Blocks.EMERALD_ORE || block == Blocks.GOLD_BLOCK || block == Blocks.GOLD_ORE || block == Blocks.REDSTONE_ORE)
            return 2;
        else if (block == Blocks.IRON_BLOCK || block == Blocks.IRON_ORE || block == Blocks.LAPIS_BLOCK || block == Blocks.LAPIS_ORE)
            return 1;
        else {
            ToolManagerEntryImplAccessor entry = (ToolManagerEntryImplAccessor) ToolManager.entry(block);
            for (int i = 0; i < entry.getTags().length; i++) {
                if (entry.getTags()[i] == FabricToolTags.PICKAXES) {
                    return entry.getTagLevels()[i];
                }
            }

            return 0;
        }
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public UBStoneType getStoneType() {
        return variant.getStoneType();
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
    public Variant<?> getVariant() {
        return variant;
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
