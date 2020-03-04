package com.aang23.undergroundbiomes.world.feature;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class UndergroundBiomeFeature extends Feature<DefaultFeatureConfig> {
    private final Map<World, UBStoneReplacer> stoneReplacers = new HashMap<>();

    public UndergroundBiomeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        UBStoneReplacer replacer = stoneReplacers.computeIfAbsent(world.getWorld(), UndergroundBiomeFeature::createStoneReplacer);
        replacer.replaceStoneInChunk(world.getChunk(pos));
        return true;
    }

    private static UBStoneReplacer createStoneReplacer(World world) {
        WorldConfig worldConfig = new WorldConfig(world);
        worldConfig.loadConfig();

        UBBiomesSet biomesSet = new UBBiomesSet(worldConfig);
        int seed = (int) world.getSeed();
        if (UBConfig.instance().advanced.differentSeedPerWorld)
            seed += DimensionType.getId(world.getDimension().getType()).hashCode();

        return new TraditionalStoneReplacer(seed, worldConfig.biomeSize(), biomesSet, worldConfig);
    }
}
