package com.aang23.undergroundbiomes.api.enums;

import net.minecraft.util.StringIdentifiable;

import java.util.Locale;

/**
 * @author CurtisA, LouisDB
 */
public enum MetamorphicVariant implements StringIdentifiable, Variant<MetamorphicVariant> {
    GNEISS(1.1F, 1.11F), ECLOGITE(1.0F, 1.0F), MARBLE(1.1F, 1.11F), QUARTZITE(1.3F, 1.26F), BLUESCHIST(0.7F, 0.54F),
    GREENSCHIST(0.7F, 0.54F), SOAPSTONE(0.4F, 0.2F), MIGMATITE(0.9F, 0.86F);

    public static final MetamorphicVariant[] METAMORPHIC_VARIANTS = values();
    public static final int NB_VARIANTS = values().length;

    private final float hardness;
    private final float resistance;

    private MetamorphicVariant(float hardness, float resistance) {
        this.hardness = hardness;
        this.resistance = resistance;
    }

    @Override
    public int getMetadata() {
        return ordinal();
    }

    @Override
    public float getHardness() {
        return hardness;
    }

    @Override
    public float getResistance() {
        return resistance;
    }

    @Override
    public UBStoneType getStoneType() {
        return UBStoneType.METAMORPHIC;
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override
    public String asString() {
        return toString();
    }

}
