package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aang23.undergroundbiomes.Faborge;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.*;
import com.aang23.undergroundbiomes.blocks.UBOre;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UBOreRegistrar {
    private static final File GAME_DIRECTORY = FabricLoader.getInstance().getGameDirectory();
    public static final File PACK_DIRECTORY = new File(GAME_DIRECTORY, "ubpack");

    private static final Map<String, UBOre> REGISTERED_ORES = new HashMap<String, UBOre>();

    public static void registerOre(Block toRegisterAsOre) {
        for (IgneousVariant currentVariant : IgneousVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), currentVariant);
            REGISTERED_ORES.put(Registry.BLOCK.getId(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }

        for (MetamorphicVariant currentVariant : MetamorphicVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), currentVariant);
            REGISTERED_ORES.put(Registry.BLOCK.getId(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }

        for (SedimentaryVariant currentVariant : SedimentaryVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), currentVariant);
            REGISTERED_ORES.put(Registry.BLOCK.getId(toRegisterAsOre).toString() + "/" + currentVariant.asString(), ore);
        }
    }

    public static void registerOres() {
        for (UBOre toRegister : REGISTERED_ORES.values()) {
            Registry.register(Registry.BLOCK, Faborge.getRegistryName(toRegister), toRegister);
            Registry.register(Registry.ITEM, Faborge.getRegistryName(toRegister), new BlockItem(toRegister, new Item.Settings().group(UndergroundBiomes.ORES_CREATIVE_TAB)));
        }
    }

    public static void setOreRenderLayers() {
        for (UBOre ore : REGISTERED_ORES.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(ore, RenderLayer.getCutoutMipped());
        }
    }

    public static void registerPack() {
        generatePack();
    }

    public static void initialSetup() {
        UBOreConfigManager.setupConfigs();
    }

    public static void generatePack() {
        UBPackGenerator generator = new UBPackGenerator();
        generator.createFolders();
        generator.createMcMeta();
        for (UBOre toRegister : REGISTERED_ORES.values()) {
            String toRegisterId = Registry.BLOCK.getId(toRegister).toString();
            Identifier baseOreId = Registry.BLOCK.getId(toRegister.baseOre);
            generator.createModelForOre(toRegisterId,
                    "undergroundbiomes:block/"
                            + UBOreConfigManager.stoneVariantCache.get(baseOreId)
                            + "/" + toRegister.getVariant().asString(),
                    UBOreConfigManager.overlayCache.get(baseOreId));
            generator.createBlockstateForOre(toRegisterId);
            generator.createItemModelForOre(toRegisterId);
            String localizedName = Character.toUpperCase(toRegister.getVariant().asString().charAt(0))
                    + toRegister.getVariant().asString().substring(1).replace("_", " ") + " "
                    + UBOreConfigManager.nameCache.get(baseOreId);
            generator.createLangEntryForItem(toRegisterId, localizedName);
        }
        generator.createLangFile();
    }

    public static BlockState getOreForStoneIfExists(Block inStone, BlockState original) {
        if (inStone instanceof UBBlock) {
            UBBlock block = (UBBlock) inStone;
            String id = Registry.BLOCK.getId(original.getBlock()) + "/" + block.getVariant().asString();
            if (REGISTERED_ORES.containsKey(id)) {
                return REGISTERED_ORES
                        .get(id)
                        .getDefaultState();
            }
        }

        return original;
    }
}
