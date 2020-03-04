package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import com.aang23.undergroundbiomes.world.WorldGenManager;

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
        // Register a WorldGenManager for each enabled dimension
        String dimsIds[] = UBConfig.instance().general.dimensionList.split(",");
        for (String dimId : dimsIds) {
            new WorldGenManager(new Identifier(dimId));
            LOGGER.info("Enabled UndergroundBiomes for dim " + dimId);
        }
        UBOreRegistrar.initialSetup();
        UBOreRegistrar.registerOres();
        UBBlocks.init();
        UBItems.init();
        UBTags.init();
    }
}
