package com.aang23.undergroundbiomes.api.enums;

import net.minecraft.util.StringIdentifiable;

import java.util.Locale;

/**
 * @author CurtisA, LouisDB
 */
public enum SedimentaryVariant implements StringIdentifiable, Variant<SedimentaryVariant> {
  LIMESTONE(0.5F, 0.29F), CHALK(0.5F, 0.29F), SHALE(0.5F, 0.29F), SILTSTONE(0.6F, 0.4F), LIGNITE(0.5F, 0.29F), DOLOMITE(0.5F, 0.29F), GREYWACKE(1.0F, 1.0F), CHERT(0.9F, 0.86F);

  public static final SedimentaryVariant[] SEDIMENTARY_VARIANTS = values();
  public static final int NB_VARIANTS = values().length;

  private final float hardness;
  private final float resistance;

  private SedimentaryVariant(float hardness, float resistance) {
    this.hardness = hardness * 1.5F;
    this.resistance = resistance * 1.66F;
  }

  public int getMetadata() {
    return ordinal();
  }

  public float getHardness() {
    return hardness;
  }

  public float getResistance() {
    return resistance;
  }

  @Override
  public UBStoneType getStoneType() {
    return UBStoneType.SEDIMENTARY;
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
