package com.aang23.undergroundbiomes.registrar;

import com.aang23.undergroundbiomes.blocks.ore.UBOre;
import com.aang23.undergroundbiomes.enums.UBStoneStyle;

import net.minecraft.block.Block;

public class UBOreEntry {
    private Block baseOre;
    private String stoneTextureType;
    private String overlayPath;

    public UBOreEntry(Block baseOre, String stoneTextureType, String overlayPath){
        this.baseOre = baseOre;
        this.stoneTextureType = stoneTextureType;
        this.overlayPath = overlayPath;
    }

    public Block getBaseOre(){
        return baseOre;
    }

    public String getStoneTextureTypeString(){
        return stoneTextureType;
    }

    public String getOVerlay(){
        return overlayPath;
    }
}