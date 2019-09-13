package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.*;
import com.aang23.undergroundbiomes.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class UBBlocks {
    private static final Map<Variant<?>, Map<UBStoneStyle, Block>> BLOCKS = new HashMap<>();

    public static void init() {
        register(IgneousVariant.values());
        register(MetamorphicVariant.values());
        register(SedimentaryVariant.values());
    }

    public static Block getBlock(Variant<?> variant, UBStoneStyle style) {
        return BLOCKS.get(variant).get(style);
    }

    public static Block getBlock(UBStoneStyle style, Variant<?> variant) {
        return BLOCKS.get(variant).get(style);
    }

    private static void register(Variant<?>[] variants) {
        for (Variant<?> variant : variants) {
            Map<UBStoneStyle, Block> blockMap = new HashMap<>();

            register(blockMap, new UBBrick(variant));
            register(blockMap, new UBGravel(variant));
            Block cobble = register(blockMap, new UBCobble(variant));
            register(blockMap, new UBCobbleStairs(cobble, variant));
            register(blockMap, new UBInfestedStone(variant));
            register(blockMap, new UBSand(variant));
            Block stone = register(blockMap, new UBStone(variant));
            register(blockMap, new UBStoneButton(variant));
            register(blockMap, new UBStoneStairs(stone, variant));

            BLOCKS.put(variant, blockMap);
        }
    }

    private static Block register(Map<UBStoneStyle, Block> blockMap, UBBlock block) {
        Identifier id = new Identifier(UndergroundBiomes.modid, block.getStoneType() + "_" + block.getStoneStyle() + "_" + block.getVariant().asString());
        Registry.register(Registry.BLOCK, id, block.asBlock());
        Registry.register(Registry.ITEM, id, new BlockItem(block.asBlock(), new Item.Settings().group(UndergroundBiomes.CREATIVE_TAB)));
        blockMap.put(block.getStoneStyle(), block.asBlock());
        return block.asBlock();
    }
}