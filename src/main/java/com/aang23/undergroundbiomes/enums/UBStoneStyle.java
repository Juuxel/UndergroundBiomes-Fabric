package com.aang23.undergroundbiomes.enums;

/**
 * @author LouisDB
 */
public enum UBStoneStyle {
    STONE, GRAVEL, COBBLE, STONE_STAIRS, COBBLE_STAIRS, BRICK, SAND;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}