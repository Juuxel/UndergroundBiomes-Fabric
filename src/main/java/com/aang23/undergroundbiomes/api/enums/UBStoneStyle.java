package com.aang23.undergroundbiomes.api.enums;

import java.util.Locale;

/**
 * @author LouisDB
 */
public enum UBStoneStyle {
    STONE, GRAVEL, COBBLE, STONE_STAIRS, COBBLE_STAIRS, BRICK, SAND, INFESTED_STONE;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
