package com.aang23.undergroundbiomes.world.utils;

import net.minecraft.nbt.INBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public interface UBChunkCapability {

    String getUBMarker();

    void setUBMarker(String faction);

    class Default implements UBChunkCapability {
        private String replacingMarker;

        public Default() {
            replacingMarker = null;
        }

        @Override
        public void setUBMarker(String faction) {
            replacingMarker = faction;
        }

        @Override
        public String getUBMarker() {
            return replacingMarker;
        }
    }

    class Storage implements Capability.IStorage<UBChunkCapability> {
        @Override
        public void readNBT(Capability<UBChunkCapability> capability, UBChunkCapability instance, EnumFacing side,
                INBTBase nbt) {
            if (nbt instanceof NBTTagString && !nbt.getString().isEmpty())
                instance.setUBMarker(nbt.getString());
        }

        @Override
        public INBTBase writeNBT(Capability<UBChunkCapability> capability, UBChunkCapability instance,
                EnumFacing side) {
            return new NBTTagString(instance.getUBMarker() != null ? instance.getUBMarker() : "");
        }
    }
}