package com.aang23.undergroundbiomes.mixin.faborge;

import com.aang23.undergroundbiomes.Faborge;
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
        Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(world, info.getReturnValue()));
    }

    /*// Lambda: something in supplyAsync in method_20619
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_17256", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;setLastSaveTime(J)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onMethod_17256(ChunkPos pos, CallbackInfoReturnable<Either<?, ?>> info, CompoundTag tag, boolean b, Chunk chunk) {
        Chunk newChunk = chunk instanceof ReadOnlyChunk ? ((ReadOnlyChunk) chunk).getWrappedChunk() : chunk;
        Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(world, newChunk));
    }*/

    /**
     * disgusting
     * @author Juuz
     */
    /*@Overwrite
    private CompletableFuture<Either<Chunk, ChunkHolder.Unloaded>> method_20619(ChunkPos chunkPos_1) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                CompoundTag compoundTag_1 = this.getUpdatedChunkTag(chunkPos_1);
                if (compoundTag_1 != null) {
                    boolean boolean_1 = compoundTag_1.containsKey("Level", 10) && compoundTag_1.getCompound("Level").containsKey("Status", 8);
                    if (boolean_1) {
                        Chunk chunk_1 = ChunkSerializer.deserialize(this.world, this.structureManager, this.pointOfInterestStorage, chunkPos_1, compoundTag_1);
                        chunk_1.setLastSaveTime(this.world.getTime());

                        // faborge {
                        Chunk newChunk = chunk_1 instanceof ReadOnlyChunk ? ((ReadOnlyChunk) chunk_1).getWrappedChunk() : chunk_1;
                        Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(world, newChunk));
                        // }

                        return Either.left(chunk_1);
                    }

                    LOGGER.error("Chunk file at {} is missing level data, skipping", chunkPos_1);
                }
            } catch (CrashException var5) {
                Throwable throwable_1 = var5.getCause();
                if (!(throwable_1 instanceof IOException)) {
                    throw var5;
                }

                LOGGER.error("Couldn't load chunk {}", chunkPos_1, throwable_1);
            } catch (Exception var6) {
                LOGGER.error("Couldn't load chunk {}", chunkPos_1, var6);
            }

            return Either.left(new ProtoChunk(chunkPos_1, UpgradeData.NO_UPGRADE_DATA));
        }, this.mainThreadExecutor);
    }*/
}
