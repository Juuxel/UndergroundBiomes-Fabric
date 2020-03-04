package com.aang23.undergroundbiomes.mixin;

import com.aang23.undergroundbiomes.UBWorldGen;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @Inject(method = "addMineables", at = @At("RETURN"))
    private static void onAddMineables(Biome biome, CallbackInfo info) {
        UBWorldGen.addUndergroundBiomes(biome);
    }
}
