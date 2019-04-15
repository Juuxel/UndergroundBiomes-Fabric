package com.aang23.undergroundbiomes.world;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;

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

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public void onPopulateChunk(ChunkEvent.Load event) {  // TODO : Change that really bad use of that event... But at least allows me to test worldgen.
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