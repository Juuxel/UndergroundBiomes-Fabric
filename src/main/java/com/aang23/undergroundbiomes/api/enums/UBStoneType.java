package com.aang23.undergroundbiomes.api.enums;

import java.util.Locale;

/**
 * @author LouisDB
 */
public enum UBStoneType {
    IGNEOUS, METAMORPHIC, SEDIMENTARY;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
