package com.aang23.undergroundbiomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
        if (Registry.BLOCK.getId(block) != Registry.BLOCK.getId(Blocks.AIR)) {
            Throwable stackTrace = new Throwable("Stack trace");
            System.err.println("Attempting to get id for registered object " + block);
            stackTrace.fillInStackTrace();
            stackTrace.printStackTrace();
        }

        return parseId(BLOCK_REGISTRY_NAMES.get(block));
    }

    private static Identifier parseId(String str) {
        if (str.contains(":")) return new Identifier(str);
        return new Identifier(UndergroundBiomes.modid, str);
    }
}
