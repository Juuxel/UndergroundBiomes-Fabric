package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;
import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;

public class WorldGenManager {

  private UBStoneReplacer stoneReplacer;

  private WorldConfig worldConfig;

  private final Identifier dimensionId;

  private UndergroundBiomeSet biomesSet = null;

  private boolean worldDone = false;
  private int seed;

  public WorldGenManager(Identifier dimensionId) {
    this.dimensionId = dimensionId;
    Faborge.WORLD_LOAD.register(event -> {
      if (!event.getWorld().isClient) {
        if (dimensionId.equals(DimensionType.getId(event.getWorld().getDimension().getType()))) {
          if (!worldDone) {

            worldConfig = new WorldConfig(event.getWorld());
            worldConfig.loadConfig();

            biomesSet = new UBBiomesSet(worldConfig);
            seed = (int) event.getWorld().getSeed();
            if (UBConfig.instance().advanced.differentSeedPerWorld)
              seed += dimensionId.hashCode();

            this.stoneReplacer = new TraditionalStoneReplacer(seed, worldConfig.biomeSize(), biomesSet, worldConfig);

            // TODO World specific config

            worldDone = true;
          }
        }
      }
    });

    Faborge.CHUNK_LOAD.register(event -> {
      if (!worldDone || event.getWorld() == null || event.getChunk() == null)
        return;

      if (!event.getWorld().isClient) {
        if (dimensionId.equals(DimensionType.getId(event.getWorld().getDimension().getType()))) {
          if (!WorldChunkChecker.hasAlreadyBeenUBfied(event.getChunk())) {
            Chunk chunk = event.getChunk();

            this.stoneReplacer.replaceStoneInChunk(chunk);
            // stoneReplacer.redoOres(event.getWorld());

            chunk.setShouldSave(true);
            WorldChunkChecker.setDone(event.getChunk());
          }
        }
      }
    });
  }
}
