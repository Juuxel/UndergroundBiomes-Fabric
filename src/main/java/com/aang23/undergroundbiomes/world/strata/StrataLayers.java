package com.aang23.undergroundbiomes.world.strata;

import java.util.ArrayList;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.config.WorldConfig;

import net.minecraft.block.Blocks;

/**
 * @author CurtisA, LouisDB
 */
final class StrataLayers {

  StrataLayer[][] layers;
  private final WorldConfig config;

  public StrataLayers(WorldConfig config) {
    this.config = config;
    layers = new StrataLayer[30][];
    if (config.harmoniousStrata()) 
      createHarmoniousLayers();
    else
    createLayers();
    cleanup();
  }

  private void createLayers() {
    layers[0] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 30, 32), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHALK), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 65, 70)};
    layers[1] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 33, 36), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 60, 62), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 75, 80)};
    layers[2] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 30, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 26, 29), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 70, 74)};
    layers[3] = new StrataLayer[]{new StrataLayer(Blocks.SANDSTONE, 40, 43), new StrataLayer(Blocks.SAND, 44, 47), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 55, 57)};
    layers[4] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 29, 33), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 42, 44), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 90, 105)};
    layers[5] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 33, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 72, 79)};
    layers[6] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 30, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 39, 44), new StrataLayer(Blocks.SANDSTONE, 52, 54), new StrataLayer(Blocks.SAND, 55, 60)};
    layers[7] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 33, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 45, 49), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 80, 85)};
    layers[8] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 30, 32), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 70, 74), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 75, 79)};
    layers[9] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 31, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 39, 42), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 62, 65)};
    layers[10] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RHYOLITE), 12, 18), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.KOMATIITE), 24, 29), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 80, 85)};
    layers[11] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BASALT), 13, 22), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.SOAPSTONE), 29, 36), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SILTSTONE), 80, 128)};

  }

  private void createHarmoniousLayers() {
    layers[0] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 30, 32), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 65, 70)};
    layers[5] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 33, 36), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 60, 62), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 75, 80)};
    layers[2] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 30, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 26, 29), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 70, 74)};
    layers[3] = new StrataLayer[]{new StrataLayer(Blocks.SANDSTONE, 40, 43), new StrataLayer(Blocks.SAND, 44, 47), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 55, 57)};
    layers[4] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 29, 33), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 42, 44), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 90, 105)};
    layers[1] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 33, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 38, 41), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 72, 79)};
    layers[6] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 30, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 39, 44), new StrataLayer(Blocks.SANDSTONE, 52, 54), new StrataLayer(Blocks.SAND, 55, 60)};
    layers[7] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 33, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 45, 49), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIGNITE), 80, 85)};
    layers[8] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.LIMESTONE), 30, 32), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 70, 74), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.GREYWACKE), 75, 79)};
    layers[9] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SHALE), 31, 35), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.DOLOMITE), 39, 42), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.CHERT), 62, 65)};
    layers[10] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RHYOLITE), 12, 18), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.KOMATIITE), 24, 29), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MARBLE), 80, 85)};
    layers[11] = new StrataLayer[]{new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BASALT), 13, 22), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.SOAPSTONE), 29, 36), new StrataLayer(UBBlocks.getBlock(UBStoneStyle.STONE, SedimentaryVariant.SILTSTONE), 80, 128)};

  }

  private void cleanup() {
    for (int i = 0; i < 12; i++) {
      layers[i] = cleanedLayers(layers[i]);
    }
  }

  private StrataLayer[] cleanedLayers(StrataLayer[] toClean) {
    // removes disallowed layers
    ArrayList<StrataLayer> kept = new ArrayList<StrataLayer>();
    for (int i = 0; i < toClean.length; i++) {
      if (true) { // UBConfig.SPECIFIC.generationAllowed(toClean[i].filler) TODO
        kept.add(toClean[i]);
      }
    }
    StrataLayer[] result = new StrataLayer[kept.size()];
    int i = 0;
    for (StrataLayer layer : kept) {
      result[i++] = layer;
    }
    return result;
  }

}
