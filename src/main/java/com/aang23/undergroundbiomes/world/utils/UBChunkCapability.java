package com.aang23.undergroundbiomes.world.utils;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.NBTTextComponent;
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
        public void readNBT(Capability<UBChunkCapability> capability, UBChunkCapability instance, Direction side,
                INBT nbt) {
            if (nbt instanceof NBTTextComponent && !nbt.getString().isEmpty())
                instance.setUBMarker(nbt.getString());
        }

        @Override
        public INBT writeNBT(Capability<UBChunkCapability> capability, UBChunkCapability instance,
        Direction side) {
            return new StringNBT(instance.getUBMarker() != null ? instance.getUBMarker() : "");
        }
    }
}