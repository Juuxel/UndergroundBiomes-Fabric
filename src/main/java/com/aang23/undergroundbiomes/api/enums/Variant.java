package com.aang23.undergroundbiomes.api.enums;

/**
 * @author LouisDB
 */
public interface Variant<T> extends Comparable<T> {

    int getMetadata();

    float getHardness();

    float getResistance();

}