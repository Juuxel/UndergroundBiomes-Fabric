package com.aang23.undergroundbiomes.mixin.faborge;

import com.aang23.undergroundbiomes.Faborge;
import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientChunkManager.class)
public class ClientChunkManagerMixin {
    @Shadow @Final private WorldChunk emptyChunk;

    @Inject(method = "method_2857", at = @At("RETURN"))
    private void onMethod_2857(int int_1, int int_2, ChunkStatus chunkStatus_1, boolean boolean_1, CallbackInfoReturnable<WorldChunk> info) {
        WorldChunk chunk = info.getReturnValue();
        if (chunk != null && chunk != emptyChunk) {
            Faborge.CHUNK_LOAD.invoker().accept(new Faborge.ChunkLoadEvent(chunk.getWorld(), chunk));
        }
    }
}
