package com.aang23.undergroundbiomes.api.enums;

import java.util.Locale;

public enum FossilVariant {
    AMMONITE, SHELL, RIB, BONE, SKULL, BONE2, SHELL2, BONESHARD;

    public static final FossilVariant[] FOSSIL_VARIANTS = values();
    public static final int NB_VARIANTS = values().length;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
