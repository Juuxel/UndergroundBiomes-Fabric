package com.aang23.undergroundbiomes;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class UBTags {
    public static final Tag<Block> VANILLA_STONE = TagRegistry.block(UndergroundBiomes.id("vanilla_stone"));

    static void init() {
        // no-op
    }
}
