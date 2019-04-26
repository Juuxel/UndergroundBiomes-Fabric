package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.items.ItemLignite;
import com.aang23.undergroundbiomes.items.fossil.FossilPiece;
import com.aang23.undergroundbiomes.items.fossil.type.*;

public class UBItems {
    public static FossilPiece FOSSIL_PIECE_AMMONITE = new Ammonite();
    public static FossilPiece FOSSIL_PIECE_SHELL = new Shell();
    public static FossilPiece FOSSIL_PIECE_RIB = new Rib();
    public static FossilPiece FOSSIL_PIECE_BONE = new Bone();
    public static FossilPiece FOSSIL_PIECE_SKULL = new Skull();
    public static FossilPiece FOSSIL_PIECE_BONE2 = new Bone2();
    public static FossilPiece FOSSIL_PIECE_SHELL2 = new Shell2();
    public static FossilPiece FOSSIL_PIECE_BONESHARD = new Boneshard();

    public static ItemLignite LIGNITE_COAL = new ItemLignite();

    public static FossilPiece getRandomFossil() {
        switch ((int) (Math.random() * 7)) {
        case 0:
            return FOSSIL_PIECE_AMMONITE;
        case 1:
            return FOSSIL_PIECE_SHELL;
        case 2:
            return FOSSIL_PIECE_RIB;
        case 3:
            return FOSSIL_PIECE_BONE;
        case 4:
            return FOSSIL_PIECE_SKULL;
        case 5:
            return FOSSIL_PIECE_BONE2;
        case 6:
            return FOSSIL_PIECE_SHELL2;
        case 7:
            return FOSSIL_PIECE_BONESHARD;
        default:
            return null;
        }
    }
}