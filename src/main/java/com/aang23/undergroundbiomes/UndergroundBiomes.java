package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;

public class UndergroundBiomes implements ModInitializer {
    public static String modid = "undergroundbiomes";
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(id("blocks"), () -> new ItemStack(UBBlocks.getBlock(IgneousVariant.BLACK_GRANITE, UBStoneStyle.STONE)));
    public static final ItemGroup ORES_CREATIVE_TAB = FabricItemGroupBuilder.build(id("ores"), Blocks.IRON_ORE.asItem()::getStackForRender);
    private static final Logger LOGGER = LogManager.getLogger(modid);

    public static Identifier id(String path) {
        return new Identifier(modid, path);
    }

    @Override
    public void onInitialize() {
        UBOreRegistrar.initialSetup();
        UBOreRegistrar.registerOres();
        UBBlocks.init();
        UBItems.init();
        UBTags.init();
    }
}
