package io.github.vampirestudios.molecularcraft.registries;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.molecules.ChanceItemMolecule;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloadListener;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;
import net.minecraft.util.profiler.Profiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ItemMoleculesDataManager implements ResourceReloadListener {

    private static final JsonParser PARSER = new JsonParser();

    public static Map<String, ItemMolecule> REGISTRY = new HashMap<>();

    public static Map<String, ItemMolecule> TAGS = new HashMap<>();

    private static ItemMoleculesDataManager INSTANCE;

    private ItemMoleculesDataManager() {}

    public static ItemMoleculesDataManager getInstance() {
        if (INSTANCE == null) INSTANCE = new ItemMoleculesDataManager();
        return INSTANCE;
    }

    @Override
    public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
        CompletableFuture<Map<RegistryEntryType, Map<String, ItemMolecule>>> completableFuture = CompletableFuture.supplyAsync(() -> {
            REGISTRY.clear();
            TAGS.clear();
            Map<RegistryEntryType, Map<String, ItemMolecule>> map = new HashMap<>();
            map.put(RegistryEntryType.item, new HashMap<>());
            map.put(RegistryEntryType.tag, new HashMap<>());
            for (Identifier identifier : manager.findResources("molecule_items", (stringx) -> {
                return stringx.endsWith(".json");
            })) {
//                String string = identifier.getPath();
//                Identifier identifier2 = new Identifier(identifier.getNamespace(), string.substring("molecule_items".length() + 1, string.length() - ".json".length()));

                try {

                    for (Resource resource : manager.getAllResources(identifier)) {
                        try {
                            InputStream inputStream = resource.getInputStream();
                            try (BufferedReader read = new BufferedReader(new InputStreamReader(inputStream))) {
                                JsonObject jsonObject = PARSER.parse(read).getAsJsonObject();
                                JsonArray array = jsonObject.getAsJsonArray("values");
                                for (Iterator<JsonElement> it = array.iterator(); it.hasNext(); ) {
                                    JsonObject valueObject = (JsonObject) it.next();
                                    RegistryEntryType entryType = RegistryEntryType.valueOf(valueObject.get("type").getAsString().toLowerCase(Locale.ENGLISH));
                                    List<ItemMoleculeComponment> moleculeStacks = new ArrayList<>();
                                    JsonArray molecules = valueObject.getAsJsonArray("molecules");
                                    for (Iterator<JsonElement> iter = molecules.iterator(); iter.hasNext(); ) {
                                        JsonObject moleculeObject = (JsonObject) iter.next();
                                        int amount = moleculeObject.get("amount").getAsInt();
                                        String formula = moleculeObject.get("formula").getAsString();
                                        try {
                                            MoleculeStack moleculeStack = Molecules.MOLECULE_STACKS.get(new Identifier(MolecularCraft.MODID, formula));
                                            if (moleculeStack != null)
                                                moleculeStacks.add(moleculeStack.setAmount(amount));
                                        } catch (InvalidIdentifierException e) {
                                            moleculeStacks.add(new Molecule(Atoms.fromSymbol(formula), amount));
                                        }
                                    }
                                    ItemMolecule itemMolecule = new ItemMolecule(moleculeStacks);
                                    if (entryType == RegistryEntryType.item) {
                                        JsonArray items = valueObject.getAsJsonArray("items");
                                        for (Iterator<JsonElement> iter = items.iterator(); iter.hasNext(); ) {
                                            JsonElement jsonElement = iter.next();
                                            String itemID = new Identifier(jsonElement.getAsString()).toString();
                                            map.get(entryType).put(itemID, itemMolecule);
                                        }
                                    } else {
                                        JsonArray items = valueObject.getAsJsonArray("tags");
                                        for (Iterator<JsonElement> iter = items.iterator(); iter.hasNext(); ) {
                                            JsonElement jsonElement = iter.next();
                                            String itemID = new Identifier(jsonElement.getAsString()).toString();
                                            map.get(entryType).put(itemID, itemMolecule);
                                        }
                                    }
                                }
                            }
                        } catch (RuntimeException | IOException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return map;
        });

        return completableFuture.thenCompose(synchronizer::whenPrepared).thenAcceptAsync((void_) -> {
            Map<RegistryEntryType, Map<String, ItemMolecule>> map = completableFuture.join();
            for (Map.Entry<RegistryEntryType, Map<String, ItemMolecule>> entry : map.entrySet()) {
                switch (entry.getKey()) {
                    case tag:
                        TAGS.putAll(entry.getValue());
                    case item:
                    default:
                        REGISTRY.putAll(entry.getValue());
                }
            }
            System.out.println("Reloading Finished: " + REGISTRY.size());
        });
    }

    public static void register(String id, MoleculeStack... stack) {
        register(new Identifier(id).toString(), new ItemMolecule(stack));
    }

//    public static void register(String id, MoleculeStack[]... stacks) {
////        registry.put(new Identifier(id).toString(), new ChanceItemMolecule(stacks));
//    }

    public static void register(String id, ItemMolecule itemMolecule) {
        if (!REGISTRY.containsKey(id)) REGISTRY.put(id, itemMolecule);
    }

    public static void tag(String id, MoleculeStack... stack) {
        tag(id, new ItemMolecule(stack));
    }

//    public static void tag(String id, MoleculeStack[]... stacks) {
//        tag(id, new ChanceItemMolecule(stacks));
//    }

    public static void tag(String id, ItemMolecule itemMolecule) {
        TAGS.putIfAbsent(id, itemMolecule);
    }

    public static void register(String namespace, String path, MoleculeStack... stack) {
        register(namespace + ":" + path, stack);
    }

    public static void tag(String namespace, String path, MoleculeStack... stack) {
        tag(namespace + ":" + path, stack);
    }

    public enum RegistryEntryType {
        item,
        tag;
    }
}
