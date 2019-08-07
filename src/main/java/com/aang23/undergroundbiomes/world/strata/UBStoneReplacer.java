package com.aang23.undergroundbiomes.world.strata;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import com.aang23.undergroundbiomes.blocks.stone.SedimentaryStone;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import com.aang23.undergroundbiomes.world.StoneRegistry;
import com.aang23.undergroundbiomes.world.strata.noise.NoiseGenerator;

public abstract class UBStoneReplacer implements UBStrataColumnProvider {

  final UBBiome[] biomeList;
  final NoiseGenerator noiseGenerator;

  final WorldConfig config;

  public UBStoneReplacer(UBBiome[] biomeList, NoiseGenerator noiseGenerator, WorldConfig config) {
    this.biomeList = biomeList;
    this.noiseGenerator = noiseGenerator;
    this.config = config;
    if (biomeList == null)
      throw new RuntimeException();
    if (noiseGenerator == null)
      throw new RuntimeException();
  }

  public abstract int[] getBiomeValues(Chunk chunk);

  public void replaceStoneInChunk(Chunk chunk) {
    int xPos = chunk.getPos().x * 16;
    int zPos = chunk.getPos().z * 16;
    for (ChunkSection storage : chunk.getSectionArray()) {
      if (storage != null && !storage.isEmpty()) {
        int yPos = storage.getYOffset();

        if (yPos >= config.generationHeight())
          return;

        int[] biomeValues = getBiomeValues(chunk);

        for (int x = 0; x < 16; ++x) {
          for (int z = 0; z < 16; ++z) {

            UBBiome currentBiome = biomeList[biomeValues[x * 16 + z]];
            int variation = (int) (noiseGenerator.noise((xPos + x) / 55.533, (zPos + z) / 55.533, 3, 1, 0.5) * 10 - 5);

            for (int y = 0; y < 16; ++y) {
              BlockState currentBlockState = storage.getBlockState(x, y, z);
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
              else if ((currentBlock == Blocks.STONE || currentBlock == Blocks.ANDESITE
                  || currentBlock == Blocks.DIORITE || currentBlock == Blocks.GRANITE)
                  && UBConfig.instance().worldgen.replaceStone) {
                // Replace with UBified version
                storage.setBlockState(x, y, z, currentBiome.getStrataBlockAtLayer(yPos + y + variation), true);
                continue;
              } else if (currentBlock == Blocks.GRAVEL && UBConfig.instance().worldgen.replaceGravel) {
                // Replace with UBified version
                storage.setBlockState(x, y, z, StoneRegistry
                    .getVariantForStone(currentBiome.getStrataBlockAtLayer(yPos + y + variation), UBStoneStyle.GRAVEL)
                    .getDefaultState(), true);
                continue;
              } else if (currentBlock == Blocks.INFESTED_STONE && UBConfig.instance().worldgen.replaceInfestedStone) {
                // Replace with UBified version
                storage.setBlockState(x, y, z,
                    StoneRegistry.getVariantForStone(currentBiome.getStrataBlockAtLayer(yPos + y + variation),
                        UBStoneStyle.INFESTED_STONE).getDefaultState(), true);
                continue;
              } else if (currentBlock == Blocks.SAND && UBConfig.instance().worldgen.replaceSand) {
                // Replace with UBified version
                storage.setBlockState(x, y, z,
                    StoneRegistry
                        .getVariantForStone(currentBiome.getStrataBlockAtLayer(yPos + y + variation), UBStoneStyle.SAND)
                        .getDefaultState(), true);
                continue;
              } else if (currentBlock == Blocks.COBBLESTONE && UBConfig.instance().worldgen.replaceCobble) {
                // Replace with UBified version
                BlockState strataBlock = currentBiome.getStrataBlockAtLayer(yPos + y + variation);

                if (!(strataBlock.getBlock() instanceof SedimentaryStone) || UBConfig.instance().advanced.sedimentaryCobble)
                  storage.setBlockState(x, y, z,
                      StoneRegistry.getVariantForStone(strataBlock, UBStoneStyle.COBBLE).getDefaultState(), true);
                continue;
              } else {
                // Replace with UBified version
                BlockState strataBlock = currentBiome.getStrataBlockAtLayer(yPos + y + variation);

                storage.setBlockState(x, y, z, UBOreRegistrar.getOreForStoneIfExists(strataBlock.getBlock(), currentBlockState), true);

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
  private UBStrataColumn strataColumn(final StrataLayer[] strata, final BlockState fillerBlockCodes,
      final int variation) {
    return new UBStrataColumn() {

      public BlockState stone(int y) {
        if (y >= config.generationHeight())
          return Blocks.STONE.getDefaultState();
        for (int i = 0; i < strata.length; i++) {
          if (strata[i].heightInLayer(y + variation) == true) {
            return strata[i].filler;
          }
        }
        return fillerBlockCodes;
      }

      public BlockState stone() {
        return fillerBlockCodes;
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
