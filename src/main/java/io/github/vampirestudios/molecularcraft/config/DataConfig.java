package io.github.vampirestudios.molecularcraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public abstract class DataConfig {

    public static final File CONFIG_PATH = new File(FabricLoader.getInstance().getConfigDir().toFile(), MolecularCraft.MODID);

    private final File configFile;

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public DataConfig(String fileName) {
        configFile = new File(CONFIG_PATH, fileName + ".json");
    }

    public void load() {
        try {
            JsonObject json = GSON.fromJson(new FileReader(configFile), JsonObject.class);
            load(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected abstract void load(JsonObject jsonObject);

    public boolean fileExist() {
        return this.configFile.exists();
    }

    public void createFile() {
        try {
            new File(configFile.getParent()).mkdirs();
            FileWriter fileWriter = new FileWriter(configFile, false);
            save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generated default config: " + configFile.toString(), e);
        }
    }

    protected abstract void save(FileWriter fileWriter);
}
