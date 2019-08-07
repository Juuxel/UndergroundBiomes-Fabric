package com.aang23.undergroundbiomes.mixin.faborge;

import com.aang23.undergroundbiomes.Faborge;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.LevelInfo;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiFunction;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin extends World {
    protected ClientWorldMixin(LevelProperties levelProperties_1, DimensionType dimensionType_1, BiFunction<World, Dimension, ChunkManager> biFunction_1, Profiler profiler_1, boolean boolean_1) {
        super(levelProperties_1, dimensionType_1, biFunction_1, profiler_1, boolean_1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstruct(ClientPlayNetworkHandler clientPlayNetworkHandler_1, LevelInfo levelInfo_1, DimensionType dimensionType_1, int int_1, Profiler profiler_1, WorldRenderer worldRenderer_1, CallbackInfo ci) {
        Faborge.WORLD_LOAD.invoker().accept(new Faborge.WorldLoadEvent(this));
    }
}
