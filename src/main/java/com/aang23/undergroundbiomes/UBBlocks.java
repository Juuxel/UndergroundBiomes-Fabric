package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.blocks.brick.IgneousBrick;
import com.aang23.undergroundbiomes.blocks.brick.MetamorphicBrick;
import com.aang23.undergroundbiomes.blocks.brick.SedimentaryBrick;
import com.aang23.undergroundbiomes.blocks.brick.igneous.*;
import com.aang23.undergroundbiomes.blocks.brick.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.brick.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.cobble.IgneousCobble;
import com.aang23.undergroundbiomes.blocks.cobble.MetamorphicCobble;
import com.aang23.undergroundbiomes.blocks.cobble.SedimentaryCobble;
import com.aang23.undergroundbiomes.blocks.cobble.igneous.*;
import com.aang23.undergroundbiomes.blocks.cobble.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.cobble.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.IgneousCobbleStairs;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.MetamorphicCobbleStairs;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.SedimentaryCobbleStairs;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.igneous.*;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.cobble_stairs.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.gravel.IgneousGravel;
import com.aang23.undergroundbiomes.blocks.gravel.MetamorphicGravel;
import com.aang23.undergroundbiomes.blocks.gravel.SedimentaryGravel;
import com.aang23.undergroundbiomes.blocks.gravel.igneous.*;
import com.aang23.undergroundbiomes.blocks.gravel.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.gravel.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.infested_stone.IgneousInfestedStone;
import com.aang23.undergroundbiomes.blocks.infested_stone.MetamorphicInfestedStone;
import com.aang23.undergroundbiomes.blocks.infested_stone.SedimentaryInfestedStone;
import com.aang23.undergroundbiomes.blocks.infested_stone.igneous.*;
import com.aang23.undergroundbiomes.blocks.infested_stone.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.infested_stone.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.sand.IgneousSand;
import com.aang23.undergroundbiomes.blocks.sand.MetamorphicSand;
import com.aang23.undergroundbiomes.blocks.sand.SedimentarySand;
import com.aang23.undergroundbiomes.blocks.sand.igneous.*;
import com.aang23.undergroundbiomes.blocks.sand.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.sand.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.stone_stairs.IgneousStoneStairs;
import com.aang23.undergroundbiomes.blocks.stone_stairs.MetamorphicStoneStairs;
import com.aang23.undergroundbiomes.blocks.stone_stairs.SedimentaryStoneStairs;
import com.aang23.undergroundbiomes.blocks.stone_stairs.igneous.*;
import com.aang23.undergroundbiomes.blocks.stone_stairs.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.stone_stairs.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.stone.IgneousStone;
import com.aang23.undergroundbiomes.blocks.stone.MetamorphicStone;
import com.aang23.undergroundbiomes.blocks.stone.SedimentaryStone;
import com.aang23.undergroundbiomes.blocks.stone.igneous.*;
import com.aang23.undergroundbiomes.blocks.stone.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.stone.sedimentary.*;

public class UBBlocks {
    // Igneous Stones
    public static IgneousStone IGNEOUS_STONE_RED_GRANITE = new RedGraniteStone();
    public static IgneousStone IGNEOUS_STONE_BLACK_GRANITE = new BlackGraniteStone();
    public static IgneousStone IGNEOUS_STONE_RHYOLITE = new RhyoliteStone();
    public static IgneousStone IGNEOUS_STONE_ANDESITE = new AndesiteStone();
    public static IgneousStone IGNEOUS_STONE_GABBRO = new GabbroStone();
    public static IgneousStone IGNEOUS_STONE_BASALT = new BasaltStone();
    public static IgneousStone IGNEOUS_STONE_KOMATIITE = new KomatiiteStone();
    public static IgneousStone IGNEOUS_STONE_DACITE = new DaciteStone();

    // Metamorphic Stones
    public static MetamorphicStone METAMORPHIC_STONE_GNEISS = new GneissStone();
    public static MetamorphicStone METAMORPHIC_STONE_ECLOGITE = new EclogiteStone();
    public static MetamorphicStone METAMORPHIC_STONE_MARBLE = new MarbleStone();
    public static MetamorphicStone METAMORPHIC_STONE_QUARTZITE = new QuartziteStone();
    public static MetamorphicStone METAMORPHIC_STONE_BLUESCHIST = new BlueschistStone();
    public static MetamorphicStone METAMORPHIC_STONE_GREENSCHIST = new GreenschistStone();
    public static MetamorphicStone METAMORPHIC_STONE_SOAPSTONE = new SoapstoneStone();
    public static MetamorphicStone METAMORPHIC_STONE_MIGMATITE = new MigmatiteStone();

    // Sedimentary Stones
    public static SedimentaryStone SEDIMENTARY_STONE_LIMESTONE = new LimestoneStone();
    public static SedimentaryStone SEDIMENTARY_STONE_CHALK = new ChalkStone();
    public static SedimentaryStone SEDIMENTARY_STONE_SHALE = new ShaleStone();
    public static SedimentaryStone SEDIMENTARY_STONE_SILTSTONE = new SiltstoneStone();
    public static SedimentaryStone SEDIMENTARY_STONE_LIGNITE = new LigniteStone();
    public static SedimentaryStone SEDIMENTARY_STONE_DOLOMITE = new DolomiteStone();
    public static SedimentaryStone SEDIMENTARY_STONE_GREYWACKE = new GreywackeStone();
    public static SedimentaryStone SEDIMENTARY_STONE_CHERT = new ChertStone();

    // Igneous Gravels
    public static IgneousGravel IGNEOUS_GRAVEL_RED_GRANITE = new RedGraniteGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_BLACK_GRANITE = new BlackGraniteGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_RHYOLITE = new RhyoliteGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_ANDESITE = new AndesiteGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_GABBRO = new GabbroGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_BASALT = new BasaltGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_KOMATIITE = new KomatiiteGravel();
    public static IgneousGravel IGNEOUS_GRAVEL_DACITE = new DaciteGravel();

    // Metamorphic Gravels
    public static MetamorphicGravel METAMORPHIC_GRAVEL_GNEISS = new GneissGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_ECLOGITE = new EclogiteGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_MARBLE = new MarbleGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_QUARTZITE = new QuartziteGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_BLUESCHIST = new BlueschistGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_GREENSCHIST = new GreenschistGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_SOAPSTONE = new SoapstoneGravel();
    public static MetamorphicGravel METAMORPHIC_GRAVEL_MIGMATITE = new MigmatiteGravel();

    // Sedimentary Gravels
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_LIMESTONE = new LimestoneGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_CHALK = new ChalkGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_SHALE = new ShaleGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_SILTSTONE = new SiltstoneGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_LIGNITE = new LigniteGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_DOLOMITE = new DolomiteGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_GREYWACKE = new GreywackeGravel();
    public static SedimentaryGravel SEDIMENTARY_GRAVEL_CHERT = new ChertGravel();

    // Igneous Cobbles
    public static IgneousCobble IGNEOUS_COBBLE_RED_GRANITE = new RedGraniteCobble();
    public static IgneousCobble IGNEOUS_COBBLE_BLACK_GRANITE = new BlackGraniteCobble();
    public static IgneousCobble IGNEOUS_COBBLE_RHYOLITE = new RhyoliteCobble();
    public static IgneousCobble IGNEOUS_COBBLE_ANDESITE = new AndesiteCobble();
    public static IgneousCobble IGNEOUS_COBBLE_GABBRO = new GabbroCobble();
    public static IgneousCobble IGNEOUS_COBBLE_BASALT = new BasaltCobble();
    public static IgneousCobble IGNEOUS_COBBLE_KOMATIITE = new KomatiiteCobble();
    public static IgneousCobble IGNEOUS_COBBLE_DACITE = new DaciteCobble();

    // Metamorphic Cobbles
    public static MetamorphicCobble METAMORPHIC_COBBLE_GNEISS = new GneissCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_ECLOGITE = new EclogiteCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_MARBLE = new MarbleCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_QUARTZITE = new QuartziteCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_BLUESCHIST = new BlueschistCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_GREENSCHIST = new GreenschistCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_SOAPSTONE = new SoapstoneCobble();
    public static MetamorphicCobble METAMORPHIC_COBBLE_MIGMATITE = new MigmatiteCobble();

    // Sedimentary Cobbles
    public static SedimentaryCobble SEDIMENTARY_COBBLE_LIMESTONE = new LimestoneCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_CHALK = new ChalkCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_SHALE = new ShaleCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_SILTSTONE = new SiltstoneCobble();
    // public static SedimentaryCobble SEDIMENTARY_COBBLE_LIGNITE = new
    // LigniteCobble(); //Kept for a posible future implementation
    public static SedimentaryCobble SEDIMENTARY_COBBLE_DOLOMITE = new DolomiteCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_GREYWACKE = new GreywackeCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_CHERT = new ChertCobble();

    // Igneous Stairs
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_RED_GRANITE = new RedGraniteStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_BLACK_GRANITE = new BlackGraniteStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_RHYOLITE = new RhyoliteStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_ANDESITE = new AndesiteStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_GABBRO = new GabbroStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_BASALT = new BasaltStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_KOMATIITE = new KomatiiteStoneStairs();
    public static IgneousStoneStairs IGNEOUS_STONE_STAIRS_DACITE = new DaciteStoneStairs();

    // Metamorphic Stairs
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_GNEISS = new GneissStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_ECLOGITE = new EclogiteStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_MARBLE = new MarbleStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_QUARTZITE = new QuartziteStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_BLUESCHIST = new BlueschistStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_GREENSCHIST = new GreenschistStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_SOAPSTONE = new SoapstoneStoneStairs();
    public static MetamorphicStoneStairs METAMORPHIC_STONE_STAIRS_MIGMATITE = new MigmatiteStoneStairs();

    // Sedimentary Stairs
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_LIMESTONE = new LimestoneStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_CHALK = new ChalkStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_SHALE = new ShaleStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_SILTSTONE = new SiltstoneStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_LIGNITE = new LigniteStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_DOLOMITE = new DolomiteStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_GREYWACKE = new GreywackeStoneStairs();
    public static SedimentaryStoneStairs SEDIMENTARY_STONE_STAIRS_CHERT = new ChertStoneStairs();

    // Igneous Cobble Stairs
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_RED_GRANITE = new RedGraniteCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_BLACK_GRANITE = new BlackGraniteCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_RHYOLITE = new RhyoliteCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_ANDESITE = new AndesiteCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_GABBRO = new GabbroCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_BASALT = new BasaltCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_KOMATIITE = new KomatiiteCobbleStairs();
    public static IgneousCobbleStairs IGNEOUS_COBBLE_STAIRS_DACITE = new DaciteCobbleStairs();

    // Metamorphic Cobble Stairs
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_GNEISS = new GneissCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_ECLOGITE = new EclogiteCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_MARBLE = new MarbleCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_QUARTZITE = new QuartziteCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_BLUESCHIST = new BlueschistCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_GREENSCHIST = new GreenschistCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_SOAPSTONE = new SoapstoneCobbleStairs();
    public static MetamorphicCobbleStairs METAMORPHIC_COBBLE_STAIRS_MIGMATITE = new MigmatiteCobbleStairs();

    // Sedimentary Cobble Stairs
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_LIMESTONE = new LimestoneCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_CHALK = new ChalkCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_SHALE = new ShaleCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_SILTSTONE = new SiltstoneCobbleStairs();
    // public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_LIGNITE = new
    // LigniteCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_DOLOMITE = new DolomiteCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_GREYWACKE = new GreywackeCobbleStairs();
    public static SedimentaryCobbleStairs SEDIMENTARY_COBBLE_STAIRS_CHERT = new ChertCobbleStairs();

    // Igneous Bricks
    public static IgneousBrick IGNEOUS_BRICK_RED_GRANITE = new RedGraniteBrick();
    public static IgneousBrick IGNEOUS_BRICK_BLACK_GRANITE = new BlackGraniteBrick();
    public static IgneousBrick IGNEOUS_BRICK_RHYOLITE = new RhyoliteBrick();
    public static IgneousBrick IGNEOUS_BRICK_ANDESITE = new AndesiteBrick();
    public static IgneousBrick IGNEOUS_BRICK_GABBRO = new GabbroBrick();
    public static IgneousBrick IGNEOUS_BRICK_BASALT = new BasaltBrick();
    public static IgneousBrick IGNEOUS_BRICK_KOMATIITE = new KomatiiteBrick();
    public static IgneousBrick IGNEOUS_BRICK_DACITE = new DaciteBrick();

    // Metamorphic Bricks
    public static MetamorphicBrick METAMORPHIC_BRICK_GNEISS = new GneissBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_ECLOGITE = new EclogiteBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_MARBLE = new MarbleBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_QUARTZITE = new QuartziteBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_BLUESCHIST = new BlueschistBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_GREENSCHIST = new GreenschistBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_SOAPSTONE = new SoapstoneBrick();
    public static MetamorphicBrick METAMORPHIC_BRICK_MIGMATITE = new MigmatiteBrick();

    // Sedimentary Bricks
    public static SedimentaryBrick SEDIMENTARY_BRICK_LIMESTONE = new LimestoneBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_CHALK = new ChalkBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_SHALE = new ShaleBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_SILTSTONE = new SiltstoneBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_LIGNITE = new LigniteBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_DOLOMITE = new DolomiteBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_GREYWACKE = new GreywackeBrick();
    public static SedimentaryBrick SEDIMENTARY_BRICK_CHERT = new ChertBrick();

    // Igneous Sands
    public static IgneousSand IGNEOUS_SAND_RED_GRANITE = new RedGraniteSand();
    public static IgneousSand IGNEOUS_SAND_BLACK_GRANITE = new BlackGraniteSand();
    public static IgneousSand IGNEOUS_SAND_RHYOLITE = new RhyoliteSand();
    public static IgneousSand IGNEOUS_SAND_ANDESITE = new AndesiteSand();
    public static IgneousSand IGNEOUS_SAND_GABBRO = new GabbroSand();
    public static IgneousSand IGNEOUS_SAND_BASALT = new BasaltSand();
    public static IgneousSand IGNEOUS_SAND_KOMATIITE = new KomatiiteSand();
    public static IgneousSand IGNEOUS_SAND_DACITE = new DaciteSand();

    // Metamorphic Sands
    public static MetamorphicSand METAMORPHIC_SAND_GNEISS = new GneissSand();
    public static MetamorphicSand METAMORPHIC_SAND_ECLOGITE = new EclogiteSand();
    public static MetamorphicSand METAMORPHIC_SAND_MARBLE = new MarbleSand();
    public static MetamorphicSand METAMORPHIC_SAND_QUARTZITE = new QuartziteSand();
    public static MetamorphicSand METAMORPHIC_SAND_BLUESCHIST = new BlueschistSand();
    public static MetamorphicSand METAMORPHIC_SAND_GREENSCHIST = new GreenschistSand();
    public static MetamorphicSand METAMORPHIC_SAND_SOAPSTONE = new SoapstoneSand();
    public static MetamorphicSand METAMORPHIC_SAND_MIGMATITE = new MigmatiteSand();

    // Sedimentary Sands
    public static SedimentarySand SEDIMENTARY_SAND_LIMESTONE = new LimestoneSand();
    public static SedimentarySand SEDIMENTARY_SAND_CHALK = new ChalkSand();
    public static SedimentarySand SEDIMENTARY_SAND_SHALE = new ShaleSand();
    public static SedimentarySand SEDIMENTARY_SAND_SILTSTONE = new SiltstoneSand();
    public static SedimentarySand SEDIMENTARY_SAND_LIGNITE = new LigniteSand();
    public static SedimentarySand SEDIMENTARY_SAND_DOLOMITE = new DolomiteSand();
    public static SedimentarySand SEDIMENTARY_SAND_GREYWACKE = new GreywackeSand();
    public static SedimentarySand SEDIMENTARY_SAND_CHERT = new ChertSand();

    // Igneous InfestedStones
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_RED_GRANITE = new RedGraniteInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_BLACK_GRANITE = new BlackGraniteInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_RHYOLITE = new RhyoliteInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_ANDESITE = new AndesiteInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_GABBRO = new GabbroInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_BASALT = new BasaltInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_KOMATIITE = new KomatiiteInfestedStone();
    public static IgneousInfestedStone IGNEOUS_INFESTED_STONE_DACITE = new DaciteInfestedStone();

    // Metamorphic InfestedStones
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_GNEISS = new GneissInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_ECLOGITE = new EclogiteInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_MARBLE = new MarbleInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_QUARTZITE = new QuartziteInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_BLUESCHIST = new BlueschistInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_GREENSCHIST = new GreenschistInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_SOAPSTONE = new SoapstoneInfestedStone();
    public static MetamorphicInfestedStone METAMORPHIC_INFESTED_STONE_MIGMATITE = new MigmatiteInfestedStone();

    // Sedimentary InfestedStones
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_LIMESTONE = new LimestoneInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_CHALK = new ChalkInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_SHALE = new ShaleInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_SILTSTONE = new SiltstoneInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_LIGNITE = new LigniteInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_DOLOMITE = new DolomiteInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_GREYWACKE = new GreywackeInfestedStone();
    public static SedimentaryInfestedStone SEDIMENTARY_INFESTED_STONE_CHERT = new ChertInfestedStone();
}