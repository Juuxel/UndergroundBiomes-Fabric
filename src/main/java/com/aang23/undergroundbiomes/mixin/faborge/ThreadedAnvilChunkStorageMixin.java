package com.aang23.undergroundbiomes.mixin.faborge;

import com.aang23.undergroundbiomes.Faborge;
import com.mojang.datafixers.util.Either;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.world.ThreadedAnvilChunkStorage;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ReadOnlyChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ThreadedAnvilChunkStorage.class)
public class ThreadedAnvilChunkStorageMixin {
    @Shadow
    @Final
    private ServerWorld world;

    // Lambda: thenApplyAsync in convertToFullChunk
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_17227(Lnet/minecraft/server/world/ChunkHolder;Lnet/minecraft/world/chunk/Chunk;)Lnet/minecraft/world/chunk/Chunk;", at = @At("RETURN"))
    private void onMethod_17227(ChunkHolder holder, Chunk chunk, CallbackInfoReturnable<Chunk> info) {
        Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(world, info.getReturnValue()));
    }

    // Lambda: supplyAsync in method_20619
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_17256(Lnet/minecraft/util/math/ChunkPos;)Lcom/mojang/datafixers/util/Either", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;setLastSaveTime(J)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onMethod_17256(ChunkPos pos, CallbackInfoReturnable<Either<?, ?>> info, CompoundTag tag, boolean b, Chunk chunk) {
        Chunk newChunk = chunk instanceof ReadOnlyChunk ? ((ReadOnlyChunk) chunk).getWrappedChunk() : chunk;
        Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(world, newChunk));
    }
}
