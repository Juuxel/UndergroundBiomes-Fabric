package com.aang23.undergroundbiomes.mixin;

import com.aang23.undergroundbiomes.event.ChunkLoadCallback;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.world.ThreadedAnvilChunkStorage;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ThreadedAnvilChunkStorage.class)
public abstract class ThreadedAnvilChunkStorageMixin {
    @Shadow
    @Final
    private ServerWorld world;

    // Lambda: thenApplyAsync in convertToFullChunk
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_17227(Lnet/minecraft/server/world/ChunkHolder;Lnet/minecraft/world/chunk/Chunk;)Lnet/minecraft/world/chunk/Chunk;", at = @At("RETURN"))
    private void onMethod_17227(ChunkHolder holder, Chunk chunk, CallbackInfoReturnable<Chunk> info) {
        ChunkLoadCallback.EVENT.invoker().onChunkLoad(world, info.getReturnValue());
    }
}
