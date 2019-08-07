package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.blocks.ore.UBOre;
import com.aang23.undergroundbiomes.blocks.stone.IgneousStone;
import com.aang23.undergroundbiomes.blocks.stone.MetamorphicStone;
import com.aang23.undergroundbiomes.blocks.stone.SedimentaryStone;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;

public class UBOreRegistrar {

    public static File oreFolder;

    public static File mcdir = FabricLoader.getInstance().getGameDirectory();

    public static File packDir = new File(mcdir, "ubpack");

    private static Map<String, UBOre> REGISTERED_ORES = new HashMap<String, UBOre>();

    public static void registerOre(Block toRegisterAsOre) {
        for (IgneousVariant currentVariant : IgneousVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.IGNEOUS,
                    currentVariant.asString());
            REGISTERED_ORES.put(Faborge.getRegistryName(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }

        for (MetamorphicVariant currentVariant : MetamorphicVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.METAMORPHIC,
                    currentVariant.asString());
            REGISTERED_ORES.put(Faborge.getRegistryName(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }

        for (SedimentaryVariant currentVariant : SedimentaryVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.SEDIMENTARY,
                    currentVariant.asString());
            REGISTERED_ORES.put(Faborge.getRegistryName(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }
    }

    public static void registerOres() {
        for (UBOre toRegister : REGISTERED_ORES.values()) {
            Registry.register(Registry.BLOCK, Faborge.getRegistryName(toRegister), toRegister);
            Registry.register(Registry.ITEM, Faborge.getRegistryName(toRegister), toRegister.getItemBlock());
        }
    }

    public static void registerPack() {
        generatePack();
        // TODO: Mixin to MCClient, I think? Check Cotton.
        //event.getMinecraftSupplier().get().getResourcePackList().addPackFinder(new UBPackFinder());
    }

    public static void initialSetup() {
        UBOreConfigManager.setupConfigs();
    }

    public static void generatePack() {
        UBPackGenerator generator = new UBPackGenerator();
        generator.createFolders();
        generator.createMcMeta();
        for (UBOre toRegister : REGISTERED_ORES.values()) {
            generator.createModelForOre(toRegister.getRegistryName().toString(),
                    "undergroundbiomes:block/"
                            + UBOreConfigManager.stoneVariantCache.get(Faborge.getRegistryName(toRegister.baseOre).toString())
                            + "/" + toRegister.sub_stone_name,
                    UBOreConfigManager.overlayCache.get(Faborge.getRegistryName(toRegister.baseOre).toString()));
            generator.createBlockstateForOre(toRegister.getRegistryName().toString());
            generator.createItemModelForOre(toRegister.getRegistryName().toString());
            String localizedName = Character.toUpperCase(toRegister.sub_stone_name.charAt(0))
                    + toRegister.sub_stone_name.substring(1).replace("_", " ") + " "
                    + UBOreConfigManager.nameCache.get(Faborge.getRegistryName(toRegister.baseOre).toString());
            generator.createLangEntryForItem(toRegister.getRegistryName().toString(), localizedName);
        }
        generator.createLangFile();
    }

    public static BlockState getOreForStoneIfExists(Block inStone, BlockState original) {
        if (inStone instanceof IgneousStone) {
            IgneousStone igneousStone = (IgneousStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    Faborge.getRegistryName(original.getBlock()).toString() + "/" + igneousStone.igneous_variant.asString())) {

                return REGISTERED_ORES
                        .get(Faborge.getRegistryName(original.getBlock()).toString() + "/" + igneousStone.igneous_variant.asString())
                        .getDefaultState();
            } else
                return original;
        } else if (inStone instanceof MetamorphicStone) {
            MetamorphicStone metamorphicStone = (MetamorphicStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    Faborge.getRegistryName(original.getBlock()).toString() + "/" + metamorphicStone.metamorphic_variant.asString())) {

                return REGISTERED_ORES.get(
                        Faborge.getRegistryName(original.getBlock()).toString() + "/" + metamorphicStone.metamorphic_variant.asString())
                        .getDefaultState();
            } else
                return original;
        } else if (inStone instanceof SedimentaryStone) {
            SedimentaryStone sedimentaryStone = (SedimentaryStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    Faborge.getRegistryName(original.getBlock()).toString() + "/" + sedimentaryStone.sedimentary_variant.asString())) {

                return REGISTERED_ORES.get(
                        Faborge.getRegistryName(original.getBlock()).toString() + "/" + sedimentaryStone.sedimentary_variant.asString())
                        .getDefaultState();
            } else
                return original;
        } else
            return original;

    }
}
