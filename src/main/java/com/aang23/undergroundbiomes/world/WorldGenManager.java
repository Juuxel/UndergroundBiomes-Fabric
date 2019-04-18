package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.nbt.INBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.SidedProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLCommonLaunchHandler;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class WorldGenManager {

  private UBStoneReplacer stoneReplacer;

  private final int dimensionID;

  private UndergroundBiomeSet biomesSet = null;

  private boolean worldLoaded = false;
  private IWorld world;
  private int seed;

  public WorldGenManager(int dimensionID) {
    this.dimensionID = dimensionID;
  }

  @SubscribeEvent
  public void onWorldLoad(WorldEvent.Load event) {
    biomesSet = new UBBiomesSet(0);

    world = event.getWorld();

    seed = (int) world.getSeed();
    /*
     * if (UBConfig.SPECIFIC.dimensionSpecificSeeds()) seed += dimensionID;
     */
    this.stoneReplacer = new TraditionalStoneReplacer(seed, 4, biomesSet);

    // TODO World specific config
    // world.getSaveHandler().getWorldDirectory();

    if (true /* world.getDimension().get == dimensionID && !worldLoaded */) {
      // LOGGER.debug("Dimension " + dimensionID + " loaded");

      worldLoaded = true;

    }
  }

  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void onPopulateChunk(ChunkEvent.Load event) {
    if (EffectiveSide.get() == LogicalSide.SERVER) {
      if (!WorldChunkChecker.hasAlreadyBeenUBfied(event.getChunk())) {

        world = event.getWorld();

        seed = (int) world.getSeed();
        /*
         * if (UBConfig.SPECIFIC.dimensionSpecificSeeds()) seed += dimensionID;
         */
        this.stoneReplacer = new TraditionalStoneReplacer(seed, 4, biomesSet);

        if (true /* event.getWorld().getDimension() == dimensionID && worldLoaded */) {
          this.stoneReplacer.replaceStoneInChunk(event.getChunk());
          // stoneReplacer.redoOres(event.getWorld());
        }

        IChunk chunk = event.getChunk();

        ((Chunk) chunk).setModified(true);
        ((Chunk) chunk).markDirty();
        WorldChunkChecker.setDone(event.getChunk());
      }
    }
  }
}