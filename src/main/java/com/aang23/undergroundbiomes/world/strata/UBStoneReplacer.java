/*
 */

package com.aang23.undergroundbiomes.world.strata;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;

import java.util.ArrayList;
import java.util.HashMap;

import com.aang23.undergroundbiomes.world.strata.noise.NoiseGenerator;

public abstract class UBStoneReplacer implements UBStrataColumnProvider {

  final UBBiome[] biomeList;
  final NoiseGenerator noiseGenerator;

  public UBStoneReplacer(UBBiome[] biomeList, NoiseGenerator noiseGenerator) {
    this.biomeList = biomeList;
    this.noiseGenerator = noiseGenerator;
    if (biomeList == null)
      throw new RuntimeException();
    if (noiseGenerator == null)
      throw new RuntimeException();
  }

  public abstract int[] getBiomeValues(IChunk chunk);

  public void replaceStoneInChunk(IChunk chunk) {
    int xPos = chunk.getPos().x * 16;
    int zPos = chunk.getPos().z * 16;
    for (ChunkSection storage : chunk.getSections()) {
      if (storage != null && !storage.isEmpty()) {
        int yPos = storage.getYLocation();
        /*
         * if (yPos >= UBConfig.SPECIFIC.generationHeight()) return;
         */
        int[] biomeValues = getBiomeValues(chunk);

        for (int x = 0; x < 16; ++x) {
          for (int z = 0; z < 16; ++z) {

            UBBiome currentBiome = biomeList[biomeValues[x * 16 + z]];
            int variation = (int) (noiseGenerator.noise((xPos + x) / 55.533, (zPos + z) / 55.533, 3, 1, 0.5) * 10 - 5);

            for (int y = 0; y < 16; ++y) {
              IBlockState currentBlockState = storage.get(x, y, z);
              Block currentBlock = currentBlockState.getBlock();
              BlockPos currentBlockPos = new BlockPos(x, y, z);
              /*
               * Skip air, water and lava
               */
              if (currentBlock == Blocks.AIR)
                continue;
              else if (currentBlock == Blocks.WATER)
                continue;
              else if (currentBlock == Blocks.LAVA)
                continue;
              else if (currentBlock == Blocks.STONE || currentBlock == Blocks.ANDESITE
                  || currentBlock == Blocks.DIORITE || currentBlock == Blocks.GRANITE) {
                // Replace with UBified version
                storage.set(x, y, z, currentBiome.getStrataBlockAtLayer(yPos + y + variation));
                continue;
              }
            }
          }
        }
      }
    }
  }

  abstract public UBBiome UBBiomeAt(int x, int z);

  @SuppressWarnings("deprecation")
  private UBStrataColumn strataColumn(final StrataLayer[] strata, final IBlockState fillerBlockCodes,
      final int variation) {
    return new UBStrataColumn() {

      public IBlockState stone(int y) {
        if (false /* y >= UBConfig.SPECIFIC.generationHeight() */)
          return Blocks.STONE.getDefaultState();
        for (int i = 0; i < strata.length; i++) {
          if (strata[i].heightInLayer(y + variation) == true) {
            return strata[i].filler;
          }
        }
        return fillerBlockCodes;
      }

      /*
       * public IBlockState cobblestone(int height) { if (false height >=
       * UBConfig.SPECIFIC.generationHeight()) return
       * Blocks.COBBLESTONE.getDefaultState(); IBlockState stone = stone(height); if
       * (stone.getBlock() == API.IGNEOUS_STONE.getBlock()) { return
       * API.IGNEOUS_COBBLE.getBlock().getStateFromMeta(stone.getBlock().
       * getMetaFromState(stone)); } if (stone.getBlock() ==
       * API.METAMORPHIC_STONE.getBlock()) { return
       * API.METAMORPHIC_COBBLE.getBlock().getStateFromMeta(stone.getBlock().
       * getMetaFromState(stone)); } return stone; }
       * 
       * public IBlockState cobblestone() { IBlockState stone = stone(); if
       * (stone.getBlock() == API.IGNEOUS_STONE.getBlock()) { return
       * API.IGNEOUS_COBBLE.getBlock().getStateFromMeta(stone.getBlock().
       * getMetaFromState(stone)); } if (stone.getBlock() ==
       * API.METAMORPHIC_STONE.getBlock()) { return
       * API.METAMORPHIC_COBBLE.getBlock().getStateFromMeta(stone.getBlock().
       * getMetaFromState(stone)); } return stone; }
       */

      public IBlockState stone() {
        return fillerBlockCodes;
      }

      @Override
      public IBlockState cobblestone(int height) {
        return null;
      }

      @Override
      public IBlockState cobblestone() {
        return null;
      }
    };
  }

  public UBStrataColumn strataColumn(int x, int z) {
    // make sure we have the right chunk
    UBBiome biome = UBBiomeAt(x, z);
    int variation = (int) (noiseGenerator.noise((x) / 55.533, (z) / 55.533, 3, 1, 0.5) * 10 - 5);
    return strataColumn(biome.strata, biome.filler, variation);
  }
}
