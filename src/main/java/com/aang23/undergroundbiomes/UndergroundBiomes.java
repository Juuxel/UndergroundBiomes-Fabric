package com.aang23.undergroundbiomes;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.config.ModConfig;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.utils.CobbleRecipeHandler;
import com.aang23.undergroundbiomes.config.utils.GravelRecipeHandler;
import com.aang23.undergroundbiomes.config.utils.StoneRecipeHandler;
import com.aang23.undergroundbiomes.world.WorldGenManager;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("undergroundbiomes")
public class UndergroundBiomes {
    public static String modid = "undergroundbiomes";
    public static final ItemGroup CREATIVE_TAB = new UndergroundBiomesItemGroup();
    private static final Logger LOGGER = LogManager.getLogger(modid);

    public UndergroundBiomes() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, UBConfig.SPEC);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(WorldChunkChecker::preInit);
        MinecraftForge.EVENT_BUS.register(new WorldChunkChecker());

        CraftingHelper.register(new ResourceLocation(modid, "cobble_recipe_enabled"), new CobbleRecipeHandler());
        CraftingHelper.register(new ResourceLocation(modid, "stone_recipe_enabled"), new StoneRecipeHandler());
        CraftingHelper.register(new ResourceLocation(modid, "gravel_recipe_enabled"), new GravelRecipeHandler());
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Register a WorldGenManager for each enabled dimension
        String dimsIds[] = UBConfig.GENERAL.dimensionList.get().split(",");
        for (String dimId : dimsIds) {
            MinecraftForge.EVENT_BUS.register(new WorldGenManager(Integer.parseInt(dimId)));
            LOGGER.info("Enabled UndergroundBiomes for dim " + dimId);
        }
        // MinecraftForge.EVENT_BUS.register(new WorldGenManager(0));

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> e) {
            // Stone
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_RED_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BLACK_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_RHYOLITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_ANDESITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_GABBRO);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_BASALT);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_KOMATIITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_DACITE);

            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_GNEISS);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_ECLOGITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_MARBLE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_QUARTZITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_BLUESCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_GREENSCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_SOAPSTONE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_MIGMATITE);

            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_LIMESTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_CHALK);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_SHALE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_SILTSTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_LIGNITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_DOLOMITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_GREYWACKE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_CHERT);

            // Gravel
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_RED_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_BLACK_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_RHYOLITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_ANDESITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_GABBRO);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_BASALT);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_KOMATIITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_GRAVEL_DACITE);

            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_GNEISS);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_ECLOGITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_MARBLE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_QUARTZITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_BLUESCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_GREENSCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_SOAPSTONE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_GRAVEL_MIGMATITE);

            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_LIMESTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_CHALK);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_SHALE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_SILTSTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_LIGNITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_DOLOMITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_GREYWACKE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_GRAVEL_CHERT);

            // Cobble
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_RED_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_BLACK_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_RHYOLITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_ANDESITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_GABBRO);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_BASALT);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_KOMATIITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_COBBLE_DACITE);

            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_GNEISS);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_ECLOGITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_MARBLE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_QUARTZITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_BLUESCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_GREENSCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_SOAPSTONE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_COBBLE_MIGMATITE);

            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_LIMESTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_CHALK);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_SHALE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_SILTSTONE);
            // e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_LIGNITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_DOLOMITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_GREYWACKE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_COBBLE_CHERT);

            // Stairs
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_RED_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_BLACK_GRANITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_RHYOLITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_ANDESITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_GABBRO);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_BASALT);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_KOMATIITE);
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_STAIRS_DACITE);

            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_GNEISS);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_ECLOGITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_MARBLE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_QUARTZITE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_BLUESCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_GREENSCHIST);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_SOAPSTONE);
            e.getRegistry().register(UBBlocks.METAMORPHIC_STONE_STAIRS_MIGMATITE);

            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIMESTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHALK);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_SHALE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_SILTSTONE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_LIGNITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_DOLOMITE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_GREYWACKE);
            e.getRegistry().register(UBBlocks.SEDIMENTARY_STONE_STAIRS_CHERT);
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> e) {
            // Stone
            e.getRegistry().register(UBBlocks.IGNEOUS_STONE_RED_GRANITE.getItemBlock());
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

            // Fossils
            e.getRegistry().register(UBItems.FOSSIL_PIECE_AMMONITE.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SHELL.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_RIB.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONE.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SKULL.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONE2.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SHELL2.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONESHARD.getItem());

            // Others
            e.getRegistry().register(UBItems.LIGNITE_COAL.getItem());
        }
    }
}
