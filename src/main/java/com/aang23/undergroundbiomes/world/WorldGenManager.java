package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.event.ChunkLoadCallback;
import com.aang23.undergroundbiomes.event.WorldLoadCallback;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;
import net.minecraft.util.Identifier;
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
        WorldLoadCallback.EVENT.register(world -> {
            if (dimensionId.equals(DimensionType.getId(world.getDimension().getType()))) {
                if (!worldDone) {

                    worldConfig = new WorldConfig(world);
                    worldConfig.loadConfig();

                    biomesSet = new UBBiomesSet(worldConfig);
                    seed = (int) world.getSeed();
                    if (UBConfig.instance().advanced.differentSeedPerWorld)
                        seed += dimensionId.hashCode();

                    this.stoneReplacer = new TraditionalStoneReplacer(seed, worldConfig.biomeSize(), biomesSet, worldConfig);

                    // TODO World specific config

                    worldDone = true;
                }
            }
        });

        ChunkLoadCallback.EVENT.register((world, chunk) -> {
            if (!worldDone || world == null || chunk == null) {
                System.err.println("Returned early!");
                return;
            }

            if (dimensionId.equals(DimensionType.getId(world.getDimension().getType()))) {
                if (!WorldChunkChecker.hasAlreadyBeenUBfied(world, chunk)) {

                    this.stoneReplacer.replaceStoneInChunk(chunk);
                    // stoneReplacer.redoOres(event.getWorld());

                    chunk.setShouldSave(true);
                    WorldChunkChecker.setDone(world, chunk);
                }
            }
        });
    }
}
