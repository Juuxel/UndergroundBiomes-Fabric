package com.aang23.undergroundbiomes.world.strata;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.config.UBConfig;

/**
 * All underground biomes
 *
 * @author CurtisA, LouisDB
 */
public final class UBBiomesSet extends UndergroundBiomeSet {

  //private final UBSettings settings;
  private final UBBiome[] biomes;
  private final List<UBBiome> biomesBuilder = new ArrayList<>();
  private int ID = 0;
  private UBBiome[] allowedBiomes;

  public UBBiomesSet(Object settings) {
    super(new StrataLayers(0).layers);

    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_RED_GRANITE), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_BLACK_GRANITE), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_RHYOLITE), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_ANDESITE), strataLayers[3]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_GABBRO), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_BASALT), strataLayers[5]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_KOMATIITE), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_DACITE), strataLayers[7]);

    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_RED_GRANITE), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_BLACK_GRANITE), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_RHYOLITE), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_ANDESITE), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_GABBRO), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_BASALT), strataLayers[3]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_KOMATIITE), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.IGNEOUS_STONE_DACITE), strataLayers[5]);

    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_GNEISS), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_ECLOGITE), strataLayers[7]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_MARBLE), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_QUARTZITE), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_BLUESCHIST), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_GREENSCHIST), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_SOAPSTONE), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_MIGMATITE), strataLayers[3]);

    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_GNEISS), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_ECLOGITE), strataLayers[5]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_MARBLE), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_QUARTZITE), strataLayers[7]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_BLUESCHIST), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_GREENSCHIST), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_SOAPSTONE), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.METAMORPHIC_STONE_MIGMATITE), strataLayers[1]);

    if (UBConfig.WORLDGEN.spawnVanillaStone.get() /*settings.regularStoneBiomes() && UBConfig.SPECIFIC.generationAllowed(Blocks.STONE.getDefaultState())*/) {
      add(new UBBiome(ID, Blocks.STONE), strataLayers[0]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[1]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[2]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[3]);
    }

    this.biomes = new UBBiome[biomesBuilder.size()];
    biomesBuilder.toArray(this.biomes);
    if (biomes[20].ID == 0) throw new RuntimeException();
    //this.settings = settings;
    allowedBiomes = generatable(biomes);
  }

  private void add(UBBiome biome, StrataLayer[] layers) {
    if (true) { // UBConfig.SPECIFIC.generationAllowed(biome.filler)
      biome.addStrataLayers(layers);
      biomesBuilder.add(biome);
      ID++;
    }

  }

  public UBBiome[] generatable(UBBiome[] possible) {
    ArrayList<UBBiome> accepted = new ArrayList<UBBiome>();
    for (int i = 0; i < possible.length; i++) {
      IBlockState block = possible[i].filler;
      if (true) accepted.add(possible[i]); // settings.generationAllowed(block)
    }
    UBBiome[] result = new UBBiome[accepted.size()];
    return accepted.toArray(result);
  }

  @Override
  public UBBiome[] allowedBiomes() {
    return allowedBiomes;
  }

}
