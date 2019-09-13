package com.aang23.undergroundbiomes;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

/**
 * A Forge patch emulator.
 * @see com.aang23.undergroundbiomes.api.enums.UBBlock
 */
@Deprecated
public class Faborge {
    public static final Map<Object, String> BLOCK_REGISTRY_NAMES = new HashMap<>();

    public static Identifier getRegistryName(Block block) {
        return parseId(BLOCK_REGISTRY_NAMES.get(block));
    }

    private static Identifier parseId(String str) {
        if (str.contains(":")) return new Identifier(str);
        return new Identifier(UndergroundBiomes.modid, str);
    }
}
