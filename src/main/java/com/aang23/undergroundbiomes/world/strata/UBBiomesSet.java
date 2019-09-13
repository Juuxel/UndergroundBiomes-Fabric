package com.aang23.undergroundbiomes.world.strata;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.config.WorldConfig;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

/**
 * All underground biomes
 *
 * @author CurtisA, LouisDB
 */
public final class UBBiomesSet extends UndergroundBiomeSet {

  private final WorldConfig settings;
  private final UBBiome[] biomes;
  private final List<UBBiome> biomesBuilder = new ArrayList<>();
  private int ID = 0;
  private UBBiome[] allowedBiomes;

  public UBBiomesSet(WorldConfig settings) {
    super(new StrataLayers(settings).layers);

    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.RED_GRANITE, UBStoneStyle.STONE)), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.BLACK_GRANITE, UBStoneStyle.STONE)), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.RHYOLITE, UBStoneStyle.STONE)), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.ANDESITE, UBStoneStyle.STONE)), strataLayers[3]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.GABBRO, UBStoneStyle.STONE)), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.BASALT, UBStoneStyle.STONE)), strataLayers[5]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.KOMATIITE, UBStoneStyle.STONE)), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.DACITE, UBStoneStyle.STONE)), strataLayers[7]);

    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.RED_GRANITE, UBStoneStyle.STONE)), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.BLACK_GRANITE, UBStoneStyle.STONE)), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.RHYOLITE, UBStoneStyle.STONE)), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.ANDESITE, UBStoneStyle.STONE)), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.GABBRO, UBStoneStyle.STONE)), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.BASALT, UBStoneStyle.STONE)), strataLayers[3]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.KOMATIITE, UBStoneStyle.STONE)), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.getBlock(IgneousVariant.DACITE, UBStoneStyle.STONE)), strataLayers[5]);

    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.GNEISS, UBStoneStyle.STONE)), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[7]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[1]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[2]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[3]);

    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.GNEISS, UBStoneStyle.STONE)), strataLayers[4]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.ECLOGITE, UBStoneStyle.STONE)), strataLayers[5]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.MARBLE, UBStoneStyle.STONE)), strataLayers[6]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.QUARTZITE, UBStoneStyle.STONE)), strataLayers[7]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.BLUESCHIST, UBStoneStyle.STONE)), strataLayers[8]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.GREENSCHIST, UBStoneStyle.STONE)), strataLayers[9]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.SOAPSTONE, UBStoneStyle.STONE)), strataLayers[0]);
    add(new UBBiome(ID, UBBlocks.getBlock(MetamorphicVariant.MIGMATITE, UBStoneStyle.STONE)), strataLayers[1]);

    if (settings.regularStone()) {
      add(new UBBiome(ID, Blocks.STONE), strataLayers[0]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[1]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[2]);
      add(new UBBiome(ID, Blocks.STONE), strataLayers[3]);
    }

    this.biomes = new UBBiome[biomesBuilder.size()];
    biomesBuilder.toArray(this.biomes);
    if (biomes[20].ID == 0)
      throw new RuntimeException();
    this.settings = settings;
    allowedBiomes = generatable(biomes);
  }

  private void add(UBBiome biome, StrataLayer[] layers) {
    if (true) { // UBConfig.SPECIFIC.generationAllowed(biome.filler) TODO
      biome.addStrataLayers(layers);
      biomesBuilder.add(biome);
      ID++;
    }

  }

  public UBBiome[] generatable(UBBiome[] possible) {
    ArrayList<UBBiome> accepted = new ArrayList<UBBiome>();
    for (int i = 0; i < possible.length; i++) {
      BlockState block = possible[i].filler;
      if (true)
        accepted.add(possible[i]); // settings.generationAllowed(block)
    }
    UBBiome[] result = new UBBiome[accepted.size()];
    return accepted.toArray(result);
  }

  @Override
  public UBBiome[] allowedBiomes() {
    return allowedBiomes;
  }

}
