package com.aang23.undergroundbiomes.registrar.pack;

import java.util.Map;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;

public class UBPackFinder implements ResourcePackProvider {
    @Override
    public <T extends ResourcePackProfile> void register(Map<String, T> registry, ResourcePackProfile.Factory<T> factory) {
        String s = "mod:undergroundbiomesores";
        T packInfo = ResourcePackProfile.of(s, true,
                () -> new UBResourcePack(UBOreRegistrar.PACK_DIRECTORY),
                factory, ResourcePackProfile.InsertionPosition.TOP);
        if (packInfo != null) {
            registry.put(s, packInfo);
        }
    }
}
