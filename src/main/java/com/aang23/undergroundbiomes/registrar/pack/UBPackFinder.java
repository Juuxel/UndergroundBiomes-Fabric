package com.aang23.undergroundbiomes.registrar.pack;

import net.minecraft.resources.IPackFinder;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackInfo.IFactory;
import java.util.Map;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;

public class UBPackFinder implements IPackFinder {
    @Override
    public <T extends ResourcePackInfo> void addPackInfosToMap(Map<String, T> nameToPackMap,
            ResourcePackInfo.IFactory<T> packInfoFactory) {
        String s = "mod:undergroundbiomesores";
        T packInfo = ResourcePackInfo.createResourcePack(s, true,
                () -> new UBResourcePack(UBOreRegistrar.packDir),
                (IFactory<T>) packInfoFactory, ResourcePackInfo.Priority.TOP);
        if (packInfo != null) {
            nameToPackMap.put(s, packInfo);
        }
    }
}