package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import net.fabricmc.api.ClientModInitializer;

public class UndergroundBiomesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UBOreRegistrar.registerPack();
    }
}
