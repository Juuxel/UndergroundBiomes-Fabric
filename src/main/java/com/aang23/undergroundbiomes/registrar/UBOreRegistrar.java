package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.aang23.undergroundbiomes.blocks.ore.UBOre;
import com.aang23.undergroundbiomes.blocks.stone.IgneousStone;
import com.aang23.undergroundbiomes.blocks.stone.MetamorphicStone;
import com.aang23.undergroundbiomes.blocks.stone.SedimentaryStone;
import com.aang23.undergroundbiomes.enums.IgneousVariant;
import com.aang23.undergroundbiomes.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.enums.UBStoneType;
import com.aang23.undergroundbiomes.registrar.pack.UBPackFinder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class UBOreRegistrar {

    public static File oreFolder;

    public static File mcdir = Minecraft.getInstance().gameDir;

    public static File packDir = new File(mcdir, "ubpack");

    private static Map<String, UBOre> REGISTERED_ORES = new HashMap<String, UBOre>();

    public static void registerOre(Block toRegisterAsOre) {
        for (IgneousVariant currentVariant : IgneousVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.IGNEOUS,
                    currentVariant.getName());
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.getName(), ore);
        }

        for (MetamorphicVariant currentVariant : MetamorphicVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.METAMORPHIC,
                    currentVariant.getName());
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.getName(), ore);
        }

        for (SedimentaryVariant currentVariant : SedimentaryVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.SEDIMENTARY,
                    currentVariant.getName());
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.getName(), ore);
        }
    }

    public static void registerOres(final RegistryEvent.Register<Block> e) {
        for (UBOre toRegister : REGISTERED_ORES.values())
            e.getRegistry().register(toRegister);
    }

    public static void registerOresItems(final RegistryEvent.Register<Item> e) {
        for (UBOre toRegister : REGISTERED_ORES.values())
            e.getRegistry().register(toRegister.getItemBlock());
    }

    public static void registerPack(final FMLClientSetupEvent event) {
        generatePack();
        event.getMinecraftSupplier().get().getResourcePackList().addPackFinder(new UBPackFinder());
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
                            + UBOreConfigManager.stoneVariantCache.get(toRegister.baseOre.getRegistryName().toString())
                            + "/" + toRegister.sub_stone_name,
                    UBOreConfigManager.overlayCache.get(toRegister.baseOre.getRegistryName().toString()));
            generator.createBlockstateForOre(toRegister.getRegistryName().toString());
            generator.createItemModelForOre(toRegister.getRegistryName().toString());
            String localizedName = Character.toUpperCase(toRegister.sub_stone_name.charAt(0))
                    + toRegister.sub_stone_name.substring(1).replace("_", " ") + " "
                    + UBOreConfigManager.nameCache.get(toRegister.baseOre.getRegistryName().toString());
            generator.createLangEntryForItem(toRegister.getRegistryName().toString(), localizedName);
        }
        generator.createLangFile();
    }

    public static BlockState getOreForStoneIfExists(Block inStone, BlockState original) {
        if (inStone instanceof IgneousStone) {
            IgneousStone igneousStone = (IgneousStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    original.getBlock().getRegistryName().toString() + "/" + igneousStone.igneous_variant.getName())) {

                return REGISTERED_ORES
                        .get(original.getBlock().getRegistryName().toString() + "/" + igneousStone.igneous_variant.getName())
                        .getDefaultState();
            } else
                return original;
        } else if (inStone instanceof MetamorphicStone) {
            MetamorphicStone metamorphicStone = (MetamorphicStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    original.getBlock().getRegistryName().toString() + "/" + metamorphicStone.metamorphic_variant.getName())) {

                return REGISTERED_ORES.get(
                        original.getBlock().getRegistryName().toString() + "/" + metamorphicStone.metamorphic_variant.getName())
                        .getDefaultState();
            } else
                return original;
        } else if (inStone instanceof SedimentaryStone) {
            SedimentaryStone sedimentaryStone = (SedimentaryStone) inStone;
            if (REGISTERED_ORES.containsKey(
                    original.getBlock().getRegistryName().toString() + "/" + sedimentaryStone.sedimentary_variant.getName())) {

                return REGISTERED_ORES.get(
                        original.getBlock().getRegistryName().toString() + "/" + sedimentaryStone.sedimentary_variant.getName())
                        .getDefaultState();
            } else
                return original;
        } else
            return original;

    }
}