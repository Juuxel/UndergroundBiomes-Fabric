package com.aang23.undergroundbiomes.mixin;

import com.aang23.undergroundbiomes.registrar.pack.UBPackFinder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.resource.ClientResourcePackContainer;
import net.minecraft.resource.ResourcePackContainerManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * For loading generated assets.
 */
// TODO: I'd say this can be virtualized.
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow
    @Final
    private ResourcePackContainerManager<ClientResourcePackContainer> resourcePackContainerManager;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstruct(RunArgs runArgs, CallbackInfo info) {
        resourcePackContainerManager.addCreator(new UBPackFinder());
    }
}
