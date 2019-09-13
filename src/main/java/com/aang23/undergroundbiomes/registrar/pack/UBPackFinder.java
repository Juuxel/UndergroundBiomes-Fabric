package com.aang23.undergroundbiomes.registrar.pack;

import net.minecraft.resource.ResourcePackContainer;
import net.minecraft.resource.ResourcePackCreator;
import java.util.Map;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;

public class UBPackFinder implements ResourcePackCreator {
    @Override
    public <T extends ResourcePackContainer> void registerContainer(Map<String, T> map, ResourcePackContainer.Factory<T> factory) {
        String s = "mod:undergroundbiomesores";
        T packInfo = ResourcePackContainer.of(s, true,
                () -> new UBResourcePack(UBOreRegistrar.PACK_DIRECTORY),
                factory, ResourcePackContainer.InsertionPosition.TOP);
        if (packInfo != null) {
            map.put(s, packInfo);
        }
    }
}
