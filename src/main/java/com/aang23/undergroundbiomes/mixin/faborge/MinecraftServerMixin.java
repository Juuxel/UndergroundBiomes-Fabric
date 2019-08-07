package com.aang23.undergroundbiomes.mixin.faborge;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.items.FaborgeItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldSaveHandler;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.LevelInfo;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow public abstract ServerWorld getWorld(DimensionType dimensionType_1);

    @Inject(method = "createWorlds", at = @At("RETURN"))
    private void onCreateWorlds(WorldSaveHandler worldSaveHandler_1, LevelProperties levelProperties_1, LevelInfo levelInfo_1, WorldGenerationProgressListener worldGenerationProgressListener_1, CallbackInfo ci) {
        Faborge.WORLD_LOAD.invoker().accept(new Faborge.WorldLoadEvent(this.getWorld(DimensionType.OVERWORLD)));
    }
}
