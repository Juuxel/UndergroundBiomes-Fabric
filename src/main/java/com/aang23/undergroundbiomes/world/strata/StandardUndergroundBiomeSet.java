package com.aang23.undergroundbiomes.world.strata;

import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;

import java.util.ArrayList;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.config.WorldConfig;

/**
 * @author Zeno410
 */
public class StandardUndergroundBiomeSet extends UndergroundBiomeSet {

  private final WorldConfig settings;
  private UBBiome[] allowedBiomes;

  public StandardUndergroundBiomeSet(WorldConfig settings) {
    super(new StrataLayers(settings).layers);
    this.settings = settings;
    choseBiomes();
  }


  public final UBBiome igneous1 = (new UBBiome(0, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RED_GRANITE)))
          .addStrataLayers(strataLayers[0]);
  public final UBBiome igneous2 = (new UBBiome(1, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BLACK_GRANITE)))
          .addStrataLayers(strataLayers[1]);
  public final UBBiome igneous3 = (new UBBiome(2, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RHYOLITE)))
          .addStrataLayers(strataLayers[2]);
  public final UBBiome igneous4 = (new UBBiome(3, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.ANDESITE)))
          .addStrataLayers(strataLayers[3]);
  public final UBBiome igneous5 = (new UBBiome(4, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.GABBRO)))
          .addStrataLayers(strataLayers[4]);
  public final UBBiome igneous6 = (new UBBiome(5, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BASALT)))
          .addStrataLayers(strataLayers[5]);
  public final UBBiome igneous7 = (new UBBiome(6, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.KOMATIITE)))
          .addStrataLayers(strataLayers[6]);
  public final UBBiome igneous8 = (new UBBiome(7, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.DACITE)))
          .addStrataLayers(strataLayers[7]);

  public final UBBiome igneous9 = (new UBBiome(8, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RED_GRANITE)))
          .addStrataLayers(strataLayers[8]);
  public final UBBiome igneous10 = (new UBBiome(9, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BLACK_GRANITE)))
          .addStrataLayers(strataLayers[9]);
  public final UBBiome igneous11 = (new UBBiome(10, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.RHYOLITE)))
          .addStrataLayers(strataLayers[0]);
  public final UBBiome igneous12 = (new UBBiome(11, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.ANDESITE)))
          .addStrataLayers(strataLayers[1]);
  public final UBBiome igneous13 = (new UBBiome(12, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.GABBRO)))
          .addStrataLayers(strataLayers[2]);
  public final UBBiome igneous14 = (new UBBiome(13, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BASALT)))
          .addStrataLayers(strataLayers[3]);
  public final UBBiome igneous15 = (new UBBiome(14, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.KOMATIITE)))
          .addStrataLayers(strataLayers[4]);
  public final UBBiome igneous16 = (new UBBiome(15, UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.DACITE)))
          .addStrataLayers(strataLayers[5]);



  public final UBBiome metamorphic1 = (new UBBiome(16, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.GNEISS)))
          .addStrataLayers(strataLayers[6]);
  public final UBBiome metamorphic2 = (new UBBiome(17, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.ECLOGITE)))
          .addStrataLayers(strataLayers[7]);
  public final UBBiome metamorphic3 = (new UBBiome(18, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.ECLOGITE)))//to stop marble from being a base rock
          .addStrataLayers(strataLayers[8]);
  public final UBBiome metamorphic4 = (new UBBiome(19, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.QUARTZITE)))
          .addStrataLayers(strataLayers[9]);
  public final UBBiome metamorphic5 = (new UBBiome(20, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.BLUESCHIST)))
          .addStrataLayers(strataLayers[0]);
  public final UBBiome metamorphic6 = (new UBBiome(21, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.GREENSCHIST)))
          .addStrataLayers(strataLayers[1]);
  public final UBBiome metamorphic7 = (new UBBiome(22, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.SOAPSTONE)))
          .addStrataLayers(strataLayers[2]);
  public final UBBiome metamorphic8 = (new UBBiome(23, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MIGMATITE)))
          .addStrataLayers(strataLayers[3]);

  public final UBBiome metamorphic9 = (new UBBiome(24, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.GNEISS)))
          .addStrataLayers(strataLayers[4]);
  public final UBBiome metamorphic10 = (new UBBiome(25, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.ECLOGITE)))
          .addStrataLayers(strataLayers[5]);
  public final UBBiome metamorphic11 = (new UBBiome(26, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.ECLOGITE)))//to stop marble from being a base rock
          .addStrataLayers(strataLayers[6]);
  public final UBBiome metamorphic12 = (new UBBiome(27, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.QUARTZITE)))
          .addStrataLayers(strataLayers[7]);
  public final UBBiome metamorphic13 = (new UBBiome(28, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.BLUESCHIST)))
          .addStrataLayers(strataLayers[8]);
  public final UBBiome metamorphic14 = (new UBBiome(29, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.GREENSCHIST)))
          .addStrataLayers(strataLayers[9]);
  public final UBBiome metamorphic15 = (new UBBiome(30, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.SOAPSTONE)))
          .addStrataLayers(strataLayers[0]);
  public final UBBiome metamorphic16 = (new UBBiome(31, UBBlocks.getBlock(UBStoneStyle.STONE, MetamorphicVariant.MIGMATITE)))
          .addStrataLayers(strataLayers[1]);



  public final UBBiome vanillaStone1 = (new UBBiome(32, Blocks.STONE))
    .addStrataLayers(strataLayers[0]);
  public final UBBiome vanillaStone2 = (new UBBiome(33, Blocks.STONE))
    .addStrataLayers(strataLayers[1]);
  public final UBBiome vanillaStone3 = (new UBBiome(34, Blocks.STONE))
    .addStrataLayers(strataLayers[2]);
  public final UBBiome vanillaStone4 = (new UBBiome(35, Blocks.STONE))
    .addStrataLayers(strataLayers[3]);

  private void choseBiomes() {
    if (settings.regularStone()) {
      allowedBiomes = new UBBiome[]{igneous1, igneous2,
        igneous3, igneous4,
        igneous5, igneous6, igneous7,
        igneous8, igneous9, igneous10,
        igneous11, igneous12, igneous13,
        igneous14, igneous15, igneous16,
        metamorphic1, metamorphic2, metamorphic3,
        metamorphic4, metamorphic5, metamorphic6,
        metamorphic7, metamorphic8, metamorphic9,
        metamorphic10, metamorphic11, metamorphic12,
        metamorphic13, metamorphic14, metamorphic15,
        metamorphic16};
    } else {
      allowedBiomes = new UBBiome[]{igneous1, igneous2,
        igneous3, igneous4,
        igneous5, igneous6, igneous7,
        igneous8, igneous9, igneous10,
        igneous11, igneous12, igneous13,
        igneous14, igneous15, igneous16,
        metamorphic1, metamorphic2, metamorphic3,
        metamorphic4, metamorphic5, metamorphic6,
        metamorphic7, metamorphic8, metamorphic9,
        metamorphic10, metamorphic11, metamorphic12,
        metamorphic13, metamorphic14, metamorphic15,
        metamorphic16,
        vanillaStone1, vanillaStone2,
        vanillaStone3, vanillaStone4
      };
    }
    allowedBiomes = generatable(allowedBiomes);
  }

  public UBBiome[] generatable(UBBiome[] possible) {
    ArrayList<UBBiome> accepted = new ArrayList<UBBiome>();
    for (int i = 0; i < possible.length; i++) {
      BlockState block = possible[i].filler;
      if (true/*settings.generationAllowed(block)*/) accepted.add(possible[i]); //TODO
    }
    UBBiome[] result = new UBBiome[accepted.size()];
    return accepted.toArray(result);
  }

  @Override
  public UBBiome[] allowedBiomes() {
    return allowedBiomes;
  }
}
