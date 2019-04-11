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
        }
    }
}
