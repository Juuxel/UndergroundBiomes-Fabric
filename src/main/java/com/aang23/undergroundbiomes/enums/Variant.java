package com.aang23.undergroundbiomes.enums;

/**
 * @author LouisDB
 */
public interface Variant<T> extends Comparable<T> {

    int getMetadata();

    float getHardness();

    float getResistance();

}