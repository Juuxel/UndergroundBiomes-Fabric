package com.aang23.undergroundbiomes.world.utils;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;

import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;
//import net.minecraftforge.common.capabilities.*;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.event.AttachCapabilitiesEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;

public class WorldChunkChecker {
    public static final String MODID = UndergroundBiomes.modid;

    //@CapabilityInject(UBChunkCapability.class)
    //public static final Capability<UBChunkCapability> UB_FIED = null;
    public static final Identifier ubc_res = new Identifier(MODID, "ub");

//    public static void preInit(FMLCommonSetupEvent event) {
//        CapabilityManager.INSTANCE.register(UBChunkCapability.class, new UBChunkCapability.Storage(),
//                UBChunkCapability.Default::new);
//    }

    public static boolean hasAlreadyBeenUBfied(Chunk chunk) {
//        UBChunkCapability cap = ((ICapabilityProvider) chunk).getCapability(UB_FIED).orElseThrow(null);
//
//        return cap != null && cap.getUBMarker() != null
//                && cap.getUBMarker().toString().equals(UBConfig.instance().general.ubChunkKey);
        return false;
    }

    public static void setDone(Chunk chunk) {
//        UBChunkCapability cap = ((ICapabilityProvider) chunk).getCapability(UB_FIED).orElseThrow(null);
//
//        if (cap != null)
//            cap.setUBMarker(UBConfig.instance().general.ubChunkKey);
    }

    /*@SubscribeEvent
    public void attachChunkCaps(AttachCapabilitiesEvent<WorldChunk> e) {
        assert UB_FIED != null;
        e.addCapability(ubc_res, new ICapabilitySerializable<INBT>() {
            UBChunkCapability inst = UB_FIED.getDefaultInstance();

            @Override
            public void deserializeNBT(INBT nbt) {
                UB_FIED.getStorage().readNBT(UB_FIED, inst, null, nbt);
            }

            @Override
            public INBT serializeNBT() {
                return UB_FIED.getStorage().writeNBT(UB_FIED, inst, null);
            }

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
                return capability == UB_FIED ? LazyOptional.of(() -> (T) inst) : LazyOptional.empty();
            }
        });
    }*/
}
