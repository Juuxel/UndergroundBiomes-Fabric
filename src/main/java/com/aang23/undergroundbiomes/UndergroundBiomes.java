package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.UBBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import com.aang23.undergroundbiomes.world.WorldGenManager;

public class UndergroundBiomes implements ModInitializer {
    public static String modid = "undergroundbiomes";
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(new Identifier(modid, "blocks"), UBBlocks.IGNEOUS_STONE_BLACK_GRANITE.asItem()::getStackForRender);
    public static final ItemGroup ORES_CREATIVE_TAB = FabricItemGroupBuilder.build(new Identifier(modid, "ores"), Blocks.IRON_ORE.asItem()::getStackForRender);
    private static final Logger LOGGER = LogManager.getLogger(modid);

    @Override
    public void onInitialize() {
        UBOreRegistrar.initialSetup();

        // Register a WorldGenManager for each enabled dimension
        String dimsIds[] = UBConfig.instance().general.dimensionList.split(",");
        for (String dimId : dimsIds) {
            new WorldGenManager(new Identifier(dimId));
            LOGGER.info("Enabled UndergroundBiomes for dim " + dimId);
        }
        registerBlocks();
        registerItems();
    }

    private static void registerBlock(Block block) {
        Registry.register(Registry.BLOCK, Faborge.getRegistryName(block), block);
        if (block instanceof UBBlock) {
            Registry.register(Registry.ITEM, Faborge.getRegistryName(block), ((UBBlock) block).getItemBlock());
        }
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(modid, name), item);
    }

    public static void registerBlocks() {

        // Ores
        UBOreRegistrar.registerOres();

        // Stone
        registerBlock(UBBlocks.IGNEOUS_STONE_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_STONE_BASALT);
        registerBlock(UBBlocks.IGNEOUS_STONE_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_STONE_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_STONE_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_STONE_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_CHERT);

        // Gravel
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_BASALT);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_GRAVEL_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_GRAVEL_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_GRAVEL_CHERT);

        // Cobble
        registerBlock(UBBlocks.IGNEOUS_COBBLE_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_BASALT);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_COBBLE_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_SILTSTONE);
        // registerBlock(UBBlocks.SEDIMENTARY_COBBLE_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_CHERT);

        // Stairs
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_BASALT);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_STAIRS_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_STAIRS_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHERT);

        // Cobble Stairs
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_BASALT);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_COBBLE_STAIRS_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_COBBLE_STAIRS_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_SILTSTONE);
        // registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_CHERT);

        // Brick
        registerBlock(UBBlocks.IGNEOUS_BRICK_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_BRICK_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_BRICK_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_BRICK_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_BRICK_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_BRICK_BASALT);
        registerBlock(UBBlocks.IGNEOUS_BRICK_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_BRICK_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_BRICK_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_BRICK_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_BRICK_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_SILTSTONE);
        // registerBlock(UBBlocks.SEDIMENTARY_BRICK_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_BRICK_CHERT);

        // Sand
        registerBlock(UBBlocks.IGNEOUS_SAND_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_SAND_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_SAND_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_SAND_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_SAND_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_SAND_BASALT);
        registerBlock(UBBlocks.IGNEOUS_SAND_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_SAND_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_SAND_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_SAND_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_SAND_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_SAND_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_SAND_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_SAND_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_SAND_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_SAND_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_SAND_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_SAND_CHERT);

        // InfestedStone
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_BASALT);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_INFESTED_STONE_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_INFESTED_STONE_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_INFESTED_STONE_CHERT);

        // Stone Buttons
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_RED_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_BLACK_GRANITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_RHYOLITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_ANDESITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_GABBRO);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_BASALT);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_KOMATIITE);
        registerBlock(UBBlocks.IGNEOUS_STONE_BUTTON_DACITE);

        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_GNEISS);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_ECLOGITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_MARBLE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_QUARTZITE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_BLUESCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_GREENSCHIST);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_SOAPSTONE);
        registerBlock(UBBlocks.METAMORPHIC_STONE_BUTTON_MIGMATITE);

        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_LIMESTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_CHALK);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_SHALE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_SILTSTONE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_LIGNITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_DOLOMITE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_GREYWACKE);
        registerBlock(UBBlocks.SEDIMENTARY_STONE_BUTTON_CHERT);
    }

    public static void registerItems() {

        // Stone
        /*e.getRegistry().register(UBBlocks.IGNEOUS_STONE_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_CHERT.getItemBlock());

        // Gravel
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_CHERT.getItemBlock());

        // Cobble
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_SILTSTONE.getItemBlock());
        // e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_CHERT.getItemBlock());

        // Stairs
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHERT.getItemBlock());

        // Cobble Stairs
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_STAIRS_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_STAIRS_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_SILTSTONE.getItemBlock());
        // e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_STAIRS_CHERT.getItemBlock());

        // Brick
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_BRICK_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_BRICK_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_SILTSTONE.getItemBlock());
        // e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_BRICK_CHERT.getItemBlock());

        // Sand
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_SAND_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_SAND_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_SAND_CHERT.getItemBlock());

        // InfestedStone
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_INFESTED_STONE_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_INFESTED_STONE_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_INFESTED_STONE_CHERT.getItemBlock());

        // Stone Buttons
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_RED_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_BLACK_GRANITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_RHYOLITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_ANDESITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_GABBRO.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_BASALT.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_KOMATIITE.getItemBlock());
        e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BUTTON_DACITE.getItemBlock());

        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_GNEISS.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_ECLOGITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_MARBLE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_QUARTZITE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_BLUESCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_GREENSCHIST.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_SOAPSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BUTTON_MIGMATITE.getItemBlock());

        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_LIMESTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_CHALK.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_SHALE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_SILTSTONE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_LIGNITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_DOLOMITE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_GREYWACKE.getItemBlock());
        e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_BUTTON_CHERT.getItemBlock());*/

        // Fossils
        registerItem("fossil_piece_ammonite", UBItems.FOSSIL_PIECE_AMMONITE);
        registerItem("fossil_piece_shell", UBItems.FOSSIL_PIECE_SHELL);
        registerItem("fossil_piece_rib", UBItems.FOSSIL_PIECE_RIB);
        registerItem("fossil_piece_bone", UBItems.FOSSIL_PIECE_BONE);
        registerItem("fossil_piece_skull", UBItems.FOSSIL_PIECE_SKULL);
        registerItem("fossil_piece_bone2", UBItems.FOSSIL_PIECE_BONE2);
        registerItem("fossil_piece_shell2", UBItems.FOSSIL_PIECE_SHELL2);
        registerItem("fossil_piece_boneshard", UBItems.FOSSIL_PIECE_BONESHARD);

        // Others
        registerItem("lignite_coal", UBItems.LIGNITE_COAL);
        FuelRegistry.INSTANCE.add(UBItems.LIGNITE_COAL, UBConfig.instance().items.ligniteSmeltTime);
    }
}
