package com.aang23.undergroundbiomes.mixin.client;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import com.aang23.undergroundbiomes.registrar.pack.UBResourcePack;
import net.minecraft.client.resource.ClientBuiltinResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

// TODO: I'd say this can be virtualized.
@Mixin(ClientBuiltinResourcePackProvider.class)
public class ClientBuiltinResourcePackProviderMixin {
    @Inject(method = "register", at = @At("RETURN"))
    private <T extends ResourcePackProfile> void addVirtualPacks(Map<String, T> registry, ResourcePackProfile.Factory<T> factory, CallbackInfo info) {
        String name = "mod:undergroundbiomesores";
        T packInfo = ResourcePackProfile.of(name, true,
                () -> new UBResourcePack(UBOreRegistrar.PACK_DIRECTORY),
                factory, ResourcePackProfile.InsertionPosition.TOP);
        if (packInfo != null) {
            registry.put(name, packInfo);
        }
    }
}
