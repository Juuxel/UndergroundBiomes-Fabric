package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.items.ItemLignite;
import com.aang23.undergroundbiomes.items.fossil.FossilPiece;
import com.aang23.undergroundbiomes.items.fossil.type.*;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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

    private static void registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, UndergroundBiomes.id(name), item);
    }

    static void init() {
        // Fossils
        registerItem("fossil_piece_ammonite", UBItems.FOSSIL_PIECE_AMMONITE);
        registerItem("fossil_piece_shell", UBItems.FOSSIL_PIECE_SHELL);
        registerItem("fossil_piece_rib", UBItems.FOSSIL_PIECE_RIB);
        registerItem("fossil_piece_bone", UBItems.FOSSIL_PIECE_BONE);
        registerItem("fossil_piece_skull", UBItems.FOSSIL_PIECE_SKULL);
        registerItem("fossil_piece_bone2", UBItems.FOSSIL_PIECE_BONE2);
        registerItem("fossil_piece_shell2", UBItems.FOSSIL_PIECE_SHELL2);
        registerItem("fossil_piece_boneshard", UBItems.FOSSIL_PIECE_BONESHARD);

        // Others
        registerItem("lignite_coal", UBItems.LIGNITE_COAL);
        FuelRegistry.INSTANCE.add(UBItems.LIGNITE_COAL, UBConfig.instance().items.ligniteSmeltTime);
    }
}