package com.aang23.undergroundbiomes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.model.ModelBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import com.aang23.undergroundbiomes.blocks.IgneousStone;
import com.aang23.undergroundbiomes.blocks.MetamorphicStone;
import com.aang23.undergroundbiomes.blocks.SedimentaryStone;
import com.aang23.undergroundbiomes.enums.IgneousVariant;
import com.aang23.undergroundbiomes.world.WorldGenManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("undergroundbiomes")
public class UndergroundBiomes {
    public static final ItemGroup CREATIVE_TAB = new UndergroundBiomesItemGroup();
    private static final Logger LOGGER = LogManager.getLogger();
    public static String modid = "undergroundbiomes";

    public UndergroundBiomes() {
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
        MinecraftForge.EVENT_BUS.register(new WorldGenManager(0));
    }

    private void setup(final FMLCommonSetupEvent event) {

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
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> e) {
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
        }
    }
}
