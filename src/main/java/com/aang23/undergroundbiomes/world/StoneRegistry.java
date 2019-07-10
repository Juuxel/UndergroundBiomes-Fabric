package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.blocks.stone.IgneousStone;
import com.aang23.undergroundbiomes.blocks.stone.MetamorphicStone;
import com.aang23.undergroundbiomes.blocks.stone.SedimentaryStone;
import com.aang23.undergroundbiomes.blocks.stone.UBStone;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class StoneRegistry {
    public static Block getVariantForStone(BlockState initialState, UBStoneStyle style) {
        Block initialBlock = initialState.getBlock();
        if (initialBlock instanceof UBStone) {
            UBStone stone = (UBStone) initialBlock;
            switch (style) {
            case GRAVEL:
                return getGravelForStone(stone);
            case COBBLE:
                return getCobbleForStone(stone);
            case SAND:
                return getSandForStone(stone);
            case INFESTED_STONE:
                return getInfestedStoneForStone(stone);
            default:
                return null;
            }
        } else
            return initialBlock;
    }

    public static Block getGravelForStone(UBStone stone) {
        if (stone.getStoneType() == UBStoneType.IGNEOUS) {
            IgneousStone currentStone = (IgneousStone) stone;
            switch (currentStone.igneous_variant) {
            case RED_GRANITE:
                return UBBlocks.IGNEOUS_GRAVEL_RED_GRANITE;
            case BLACK_GRANITE:
                return UBBlocks.IGNEOUS_GRAVEL_BLACK_GRANITE;
            case RHYOLITE:
                return UBBlocks.IGNEOUS_GRAVEL_RHYOLITE;
            case ANDESITE:
                return UBBlocks.IGNEOUS_GRAVEL_ANDESITE;
            case GABBRO:
                return UBBlocks.IGNEOUS_GRAVEL_GABBRO;
            case BASALT:
                return UBBlocks.IGNEOUS_GRAVEL_BASALT;
            case KOMATIITE:
                return UBBlocks.IGNEOUS_GRAVEL_KOMATIITE;
            case DACITE:
                return UBBlocks.IGNEOUS_GRAVEL_DACITE;
            default:
                return Blocks.GRAVEL;
            }
        } else if (stone.getStoneType() == UBStoneType.METAMORPHIC) {
            MetamorphicStone currentStone = (MetamorphicStone) stone;
            switch (currentStone.metamorphic_variant) {
            case GNEISS:
                return UBBlocks.METAMORPHIC_GRAVEL_GNEISS;
            case ECLOGITE:
                return UBBlocks.METAMORPHIC_GRAVEL_ECLOGITE;
            case MARBLE:
                return UBBlocks.METAMORPHIC_GRAVEL_MARBLE;
            case QUARTZITE:
                return UBBlocks.METAMORPHIC_GRAVEL_QUARTZITE;
            case BLUESCHIST:
                return UBBlocks.METAMORPHIC_GRAVEL_BLUESCHIST;
            case GREENSCHIST:
                return UBBlocks.METAMORPHIC_GRAVEL_GREENSCHIST;
            case SOAPSTONE:
                return UBBlocks.METAMORPHIC_GRAVEL_SOAPSTONE;
            case MIGMATITE:
                return UBBlocks.METAMORPHIC_GRAVEL_MIGMATITE;
            default:
                return Blocks.GRAVEL;
            }
        } else if (stone.getStoneType() == UBStoneType.SEDIMENTARY) {
            SedimentaryStone currentStone = (SedimentaryStone) stone;
            switch (currentStone.sedimentary_variant) {
            case LIMESTONE:
                return UBBlocks.SEDIMENTARY_GRAVEL_LIMESTONE;
            case CHALK:
                return UBBlocks.SEDIMENTARY_GRAVEL_CHALK;
            case SHALE:
                return UBBlocks.SEDIMENTARY_GRAVEL_SHALE;
            case SILTSTONE:
                return UBBlocks.SEDIMENTARY_GRAVEL_SILTSTONE;
            case LIGNITE:
                return UBBlocks.SEDIMENTARY_GRAVEL_LIGNITE;
            case DOLOMITE:
                return UBBlocks.SEDIMENTARY_GRAVEL_DOLOMITE;
            case GREYWACKE:
                return UBBlocks.SEDIMENTARY_GRAVEL_GREYWACKE;
            case CHERT:
                return UBBlocks.SEDIMENTARY_GRAVEL_CHERT;
            default:
                return Blocks.GRAVEL;
            }
        } else
            return Blocks.GRAVEL;
    }

    public static Block getInfestedStoneForStone(UBStone stone) {
        if (stone.getStoneType() == UBStoneType.IGNEOUS) {
            IgneousStone currentStone = (IgneousStone) stone;
            switch (currentStone.igneous_variant) {
            case RED_GRANITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_RED_GRANITE;
            case BLACK_GRANITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_BLACK_GRANITE;
            case RHYOLITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_RHYOLITE;
            case ANDESITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_ANDESITE;
            case GABBRO:
                return UBBlocks.IGNEOUS_INFESTED_STONE_GABBRO;
            case BASALT:
                return UBBlocks.IGNEOUS_INFESTED_STONE_BASALT;
            case KOMATIITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_KOMATIITE;
            case DACITE:
                return UBBlocks.IGNEOUS_INFESTED_STONE_DACITE;
            default:
                return Blocks.INFESTED_STONE;
            }
        } else if (stone.getStoneType() == UBStoneType.METAMORPHIC) {
            MetamorphicStone currentStone = (MetamorphicStone) stone;
            switch (currentStone.metamorphic_variant) {
            case GNEISS:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_GNEISS;
            case ECLOGITE:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_ECLOGITE;
            case MARBLE:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_MARBLE;
            case QUARTZITE:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_QUARTZITE;
            case BLUESCHIST:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_BLUESCHIST;
            case GREENSCHIST:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_GREENSCHIST;
            case SOAPSTONE:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_SOAPSTONE;
            case MIGMATITE:
                return UBBlocks.METAMORPHIC_INFESTED_STONE_MIGMATITE;
            default:
                return Blocks.INFESTED_STONE;
            }
        } else if (stone.getStoneType() == UBStoneType.SEDIMENTARY) {
            SedimentaryStone currentStone = (SedimentaryStone) stone;
            switch (currentStone.sedimentary_variant) {
            case LIMESTONE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_LIMESTONE;
            case CHALK:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_CHALK;
            case SHALE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_SHALE;
            case SILTSTONE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_SILTSTONE;
            case LIGNITE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_LIGNITE;
            case DOLOMITE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_DOLOMITE;
            case GREYWACKE:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_GREYWACKE;
            case CHERT:
                return UBBlocks.SEDIMENTARY_INFESTED_STONE_CHERT;
            default:
                return Blocks.INFESTED_STONE;
            }
        } else
            return Blocks.INFESTED_STONE;
    }

    public static Block getCobbleForStone(UBStone stone) {
        if (stone.getStoneType() == UBStoneType.IGNEOUS) {
            IgneousStone currentStone = (IgneousStone) stone;
            switch (currentStone.igneous_variant) {
            case RED_GRANITE:
                return UBBlocks.IGNEOUS_COBBLE_RED_GRANITE;
            case BLACK_GRANITE:
                return UBBlocks.IGNEOUS_COBBLE_BLACK_GRANITE;
            case RHYOLITE:
                return UBBlocks.IGNEOUS_COBBLE_RHYOLITE;
            case ANDESITE:
                return UBBlocks.IGNEOUS_COBBLE_ANDESITE;
            case GABBRO:
                return UBBlocks.IGNEOUS_COBBLE_GABBRO;
            case BASALT:
                return UBBlocks.IGNEOUS_COBBLE_BASALT;
            case KOMATIITE:
                return UBBlocks.IGNEOUS_COBBLE_KOMATIITE;
            case DACITE:
                return UBBlocks.IGNEOUS_COBBLE_DACITE;
            default:
                return Blocks.COBBLESTONE;
            }
        } else if (stone.getStoneType() == UBStoneType.METAMORPHIC) {
            MetamorphicStone currentStone = (MetamorphicStone) stone;
            switch (currentStone.metamorphic_variant) {
            case GNEISS:
                return UBBlocks.METAMORPHIC_COBBLE_GNEISS;
            case ECLOGITE:
                return UBBlocks.METAMORPHIC_COBBLE_ECLOGITE;
            case MARBLE:
                return UBBlocks.METAMORPHIC_COBBLE_MARBLE;
            case QUARTZITE:
                return UBBlocks.METAMORPHIC_COBBLE_QUARTZITE;
            case BLUESCHIST:
                return UBBlocks.METAMORPHIC_COBBLE_BLUESCHIST;
            case GREENSCHIST:
                return UBBlocks.METAMORPHIC_COBBLE_GREENSCHIST;
            case SOAPSTONE:
                return UBBlocks.METAMORPHIC_COBBLE_SOAPSTONE;
            case MIGMATITE:
                return UBBlocks.METAMORPHIC_COBBLE_MIGMATITE;
            default:
                return Blocks.COBBLESTONE;
            }
        } else if (stone.getStoneType() == UBStoneType.SEDIMENTARY) {
            SedimentaryStone currentStone = (SedimentaryStone) stone;
            switch (currentStone.sedimentary_variant) {
            case LIMESTONE:
                return UBBlocks.SEDIMENTARY_COBBLE_LIMESTONE;
            case CHALK:
                return UBBlocks.SEDIMENTARY_COBBLE_CHALK;
            case SHALE:
                return UBBlocks.SEDIMENTARY_COBBLE_SHALE;
            case SILTSTONE:
                return UBBlocks.SEDIMENTARY_COBBLE_SILTSTONE;
            case LIGNITE:
                return UBBlocks.SEDIMENTARY_STONE_LIGNITE; // No lignite cobble...
            case DOLOMITE:
                return UBBlocks.SEDIMENTARY_COBBLE_DOLOMITE;
            case GREYWACKE:
                return UBBlocks.SEDIMENTARY_COBBLE_GREYWACKE;
            case CHERT:
                return UBBlocks.SEDIMENTARY_COBBLE_CHERT;
            default:
                return Blocks.COBBLESTONE;
            }
        } else
            return Blocks.COBBLESTONE;
    }

    public static Block getSandForStone(UBStone stone) {
        if (stone.getStoneType() == UBStoneType.IGNEOUS) {
            IgneousStone currentStone = (IgneousStone) stone;
            switch (currentStone.igneous_variant) {
            case RED_GRANITE:
                return UBBlocks.IGNEOUS_SAND_RED_GRANITE;
            case BLACK_GRANITE:
                return UBBlocks.IGNEOUS_SAND_BLACK_GRANITE;
            case RHYOLITE:
                return UBBlocks.IGNEOUS_SAND_RHYOLITE;
            case ANDESITE:
                return UBBlocks.IGNEOUS_SAND_ANDESITE;
            case GABBRO:
                return UBBlocks.IGNEOUS_SAND_GABBRO;
            case BASALT:
                return UBBlocks.IGNEOUS_SAND_BASALT;
            case KOMATIITE:
                return UBBlocks.IGNEOUS_SAND_KOMATIITE;
            case DACITE:
                return UBBlocks.IGNEOUS_SAND_DACITE;
            default:
                return Blocks.SAND;
            }
        } else if (stone.getStoneType() == UBStoneType.METAMORPHIC) {
            MetamorphicStone currentStone = (MetamorphicStone) stone;
            switch (currentStone.metamorphic_variant) {
            case GNEISS:
                return UBBlocks.METAMORPHIC_SAND_GNEISS;
            case ECLOGITE:
                return UBBlocks.METAMORPHIC_SAND_ECLOGITE;
            case MARBLE:
                return UBBlocks.METAMORPHIC_SAND_MARBLE;
            case QUARTZITE:
                return UBBlocks.METAMORPHIC_SAND_QUARTZITE;
            case BLUESCHIST:
                return UBBlocks.METAMORPHIC_SAND_BLUESCHIST;
            case GREENSCHIST:
                return UBBlocks.METAMORPHIC_SAND_GREENSCHIST;
            case SOAPSTONE:
                return UBBlocks.METAMORPHIC_SAND_SOAPSTONE;
            case MIGMATITE:
                return UBBlocks.METAMORPHIC_SAND_MIGMATITE;
            default:
                return Blocks.SAND;
            }
        } else if (stone.getStoneType() == UBStoneType.SEDIMENTARY) {
            SedimentaryStone currentStone = (SedimentaryStone) stone;
            switch (currentStone.sedimentary_variant) {
            case LIMESTONE:
                return UBBlocks.SEDIMENTARY_SAND_LIMESTONE;
            case CHALK:
                return UBBlocks.SEDIMENTARY_SAND_CHALK;
            case SHALE:
                return UBBlocks.SEDIMENTARY_SAND_SHALE;
            case SILTSTONE:
                return UBBlocks.SEDIMENTARY_SAND_SILTSTONE;
            case LIGNITE:
                return UBBlocks.SEDIMENTARY_SAND_LIGNITE;
            case DOLOMITE:
                return UBBlocks.SEDIMENTARY_SAND_DOLOMITE;
            case GREYWACKE:
                return UBBlocks.SEDIMENTARY_SAND_GREYWACKE;
            case CHERT:
                return UBBlocks.SEDIMENTARY_SAND_CHERT;
            default:
                return Blocks.SAND;
            }
        } else
            return Blocks.SAND;
    }
}