package com.aang23.undergroundbiomes.api.enums;

import net.minecraft.util.StringIdentifiable;

/**
 * @author LouisDB
 */
public interface Variant<T> extends Comparable<T>, StringIdentifiable {

    int getMetadata();

    float getHardness();

    float getResistance();

    UBStoneType getStoneType();

}