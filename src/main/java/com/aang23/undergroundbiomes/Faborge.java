package com.aang23.undergroundbiomes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

/**
 * A Forge patch emulator.
 * @see com.aang23.undergroundbiomes.api.enums.UBBlock
 * @see com.aang23.undergroundbiomes.items.FaborgeItem
 */
@Deprecated
public class Faborge {
    public static final Map<Object, String> BLOCK_REGISTRY_NAMES = new HashMap<>();
    public static final Map<Object, String> ITEM_REGISTRY_NAMES = new HashMap<>();

    public static Identifier getRegistryName(Block block) {
        return BLOCK_REGISTRY_NAMES.containsKey(block)
                ? parseId(BLOCK_REGISTRY_NAMES.get(block))
                : Registry.BLOCK.getId(block);
    }

    public static void setRegistryName(Item item, String regName) {
        ITEM_REGISTRY_NAMES.put(item, regName);
    }

    public static Identifier getRegistryName(Item item) {
        return ITEM_REGISTRY_NAMES.containsKey(item)
                ? parseId(BLOCK_REGISTRY_NAMES.get(item))
                : Registry.ITEM.getId(item);
    }

    private static Identifier parseId(String str) {
        if (str.contains(":")) return new Identifier(str);
        return new Identifier(UndergroundBiomes.modid, str);
    }
}
