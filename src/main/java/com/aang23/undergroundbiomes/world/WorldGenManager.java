package com.aang23.undergroundbiomes.world;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;

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
    this.stoneReplacer = new TraditionalStoneReplacer(seed, 10, biomesSet);

    // TODO World specific config
    // world.getSaveHandler().getWorldDirectory();

    if (true /* world.getDimension().get == dimensionID && !worldLoaded */) {
      // LOGGER.debug("Dimension " + dimensionID + " loaded");

      worldLoaded = true;

    }
  }

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public void onPopulateChunk(ChunkEvent.Load event) {
    biomesSet = new UBBiomesSet(0);

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
  }
}