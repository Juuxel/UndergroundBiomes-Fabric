package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.UBBlocks;

import net.minecraft.block.Block;

public class StoneRegistry {
    public static Block getStoneForId(int id) {
        switch (id) {
        case 0:
            return UBBlocks.IGNEOUS_STONE_RED_GRANITE;
        case 1:
            return UBBlocks.IGNEOUS_STONE_BLACK_GRANITE;
        case 2:
            return UBBlocks.IGNEOUS_STONE_RHYOLITE;
        case 3:
            return UBBlocks.IGNEOUS_STONE_ANDESITE;
        case 4:
            return UBBlocks.IGNEOUS_STONE_GABBRO;
        case 5:
            return UBBlocks.IGNEOUS_STONE_BASALT;
        case 6:
            return UBBlocks.IGNEOUS_STONE_KOMATIITE;
        case 7:
            return UBBlocks.IGNEOUS_STONE_DACITE;
        case 8:
            return UBBlocks.METAMORPHIC_STONE_GNEISS;
        case 9:
            return UBBlocks.METAMORPHIC_STONE_ECLOGITE;
        case 10:
            return UBBlocks.METAMORPHIC_STONE_MARBLE;
        case 11:
            return UBBlocks.METAMORPHIC_STONE_QUARTZITE;
        case 12:
            return UBBlocks.METAMORPHIC_STONE_BLUESCHIST;
        case 13:
            return UBBlocks.METAMORPHIC_STONE_GREENSCHIST;
        case 14:
            return UBBlocks.METAMORPHIC_STONE_SOAPSTONE;
        case 15:
            return UBBlocks.METAMORPHIC_STONE_MIGMATITE;
        case 16:
            return UBBlocks.SEDIMENTARY_STONE_LIMESTONE;
        case 17:
            return UBBlocks.SEDIMENTARY_STONE_CHALK;
        case 18:
            return UBBlocks.SEDIMENTARY_STONE_SHALE;
        case 19:
            return UBBlocks.SEDIMENTARY_STONE_SILTSTONE;
        case 20:
            return UBBlocks.SEDIMENTARY_STONE_LIGNITE;
        case 21:
            return UBBlocks.SEDIMENTARY_STONE_DOLOMITE;
        case 22:
            return UBBlocks.SEDIMENTARY_STONE_GREYWACKE;
        case 23:
            return UBBlocks.SEDIMENTARY_STONE_CHERT;
        default:
            return null;
        }
    }
}