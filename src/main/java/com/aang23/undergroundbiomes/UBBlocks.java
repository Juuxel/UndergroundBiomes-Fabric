package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.blocks.cobble.IgneousCobble;
import com.aang23.undergroundbiomes.blocks.cobble.MetamorphicCobble;
import com.aang23.undergroundbiomes.blocks.cobble.SedimentaryCobble;
import com.aang23.undergroundbiomes.blocks.cobble.igneous.*;
import com.aang23.undergroundbiomes.blocks.cobble.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.cobble.sedimentary.*;
import com.aang23.undergroundbiomes.blocks.gravel.IgneousGravel;
import com.aang23.undergroundbiomes.blocks.gravel.MetamorphicGravel;
import com.aang23.undergroundbiomes.blocks.gravel.SedimentaryGravel;
import com.aang23.undergroundbiomes.blocks.gravel.igneous.*;
import com.aang23.undergroundbiomes.blocks.gravel.metamorphic.*;
import com.aang23.undergroundbiomes.blocks.gravel.sedimentary.*;
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
    //public static SedimentaryCobble SEDIMENTARY_COBBLE_LIGNITE = new LigniteCobble(); //Kept for a posible future implementation
    public static SedimentaryCobble SEDIMENTARY_COBBLE_DOLOMITE = new DolomiteCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_GREYWACKE = new GreywackeCobble();
    public static SedimentaryCobble SEDIMENTARY_COBBLE_CHERT = new ChertCobble();
}