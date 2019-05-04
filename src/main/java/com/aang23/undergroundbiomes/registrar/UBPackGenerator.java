package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.cedarsoftware.util.io.JsonWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

public class UBPackGenerator {

    // Directories
    public File assetsDir = new File(UBOreRegistrar.packDir, "assets");
    public File blockstatesDir = new File(assetsDir, "undergroundbiomes/blockstates");
    public File modelsDir = new File(assetsDir, "undergroundbiomes/models/block");
    public File itemModelsDir = new File(assetsDir, "undergroundbiomes/models/item");
    public File overlaysDir = new File(assetsDir, "undergroundbiomes/textures/block/overlays");
    public File langDir = new File(assetsDir, "undergroundbiomes/lang");

    // Files
    public File packMcMetaFile = new File(UBOreRegistrar.packDir, "pack.mcmeta");
    public File langFile = new File(langDir, "en_us.json");

    public void createFolders() {

        if (UBOreRegistrar.packDir.exists()) {
            try {
                FileUtils.deleteDirectory(UBOreRegistrar.packDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        UBOreRegistrar.packDir.mkdirs();
        assetsDir.mkdirs();
        blockstatesDir.mkdirs();
        modelsDir.mkdirs();
        itemModelsDir.mkdirs();
        overlaysDir.mkdirs();
        langDir.mkdirs();

        try {
            FileUtils.copyDirectory(UBOreConfigManager.overlayFolder, overlaysDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createMcMeta() {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("templates/pack.mcmeta");
            OutputStream os = new FileOutputStream(packMcMetaFile);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            is.close();

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createModelForOre(String oreName, String stoneTexture, String oreTexture) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates/ore_model.json");
        String content = null;
        try {
            content = IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = content.replace("#stonetexture#", stoneTexture).replace("#oretexture#", oreTexture);

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    modelsDir.toString() + "/" + oreName.replace(UndergroundBiomes.modid + ":", "") + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(content);

        pw.flush();
        pw.close();
    }

    public void createItemModelForOre(String oreName) {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("templates/ore_model_item.json");
        String content = null;
        try {
            content = IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = content.replace("#oremodel#",
                UndergroundBiomes.modid + ":block/" + oreName.replace(UndergroundBiomes.modid + ":", ""));

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    itemModelsDir.toString() + "/" + oreName.replace(UndergroundBiomes.modid + ":", "") + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(content);

        pw.flush();
        pw.close();
    }

    public void createBlockstateForOre(String oreName) {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("templates/ore_blockstate.json");
        String content = null;
        try {
            content = IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = content.replace("#oremodel#",
                UndergroundBiomes.modid + ":block/" + oreName.replace(UndergroundBiomes.modid + ":", ""));

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    blockstatesDir.toString() + "/" + oreName.replace(UndergroundBiomes.modid + ":", "") + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(content);

        pw.flush();
        pw.close();
    }

    private JSONObject langfile = new JSONObject();

    public void createLangEntryForItem(String oreName, String oreTranslation) {
        langfile.put("block." + UndergroundBiomes.modid + "." + oreName.replace(UndergroundBiomes.modid + ":", ""),
                oreTranslation);
    }

    public void createLangFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(langFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(JsonWriter.formatJson(langfile.toJSONString()));

        pw.flush();
        pw.close();
    }
}