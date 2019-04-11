package com.aang23.undergroundbiomes.blocks;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MetamorphicStone extends Block {
    public MetamorphicStone() {
        super(Block.Properties.create(Material.ROCK));
    }

}