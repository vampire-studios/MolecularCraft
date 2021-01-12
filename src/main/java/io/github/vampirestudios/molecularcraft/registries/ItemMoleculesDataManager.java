package io.github.vampirestudios.molecularcraft.registries;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloadListener;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;
import net.minecraft.util.profiler.Profiler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private static final Logger LOGGER = LogManager.getLogger();

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
            for (Identifier resourceIdentifier : manager.findResources("molecules", (stringx) -> {
                return stringx.endsWith(".json");
            })) {
                String string = resourceIdentifier.getPath().replace("molecules/", "").replace(".json", "");
                RegistryEntryType type = RegistryEntryType.item;
                Identifier identifier = new Identifier(resourceIdentifier.getNamespace(), string);
                if (string.startsWith("tag/")) {
                    type = RegistryEntryType.tag;
                    identifier = new Identifier(resourceIdentifier.getNamespace(), string.replace("tag/", ""));
                }
                if (string.startsWith("item/")) {
                    type = RegistryEntryType.item;
                    identifier = new Identifier(resourceIdentifier.getNamespace(), string.replace("item/", ""));
                }
                try {

                    for (Resource resource : manager.getAllResources(resourceIdentifier)) {
                        if (resource.getResourcePackName().equals("Default")) continue;
                        try {
                            InputStream inputStream = resource.getInputStream();
                            try (JsonReader read = new JsonReader(new InputStreamReader(inputStream))) {
                                JsonObject jsonObject = PARSER.parse(read).getAsJsonObject();
                                List<ItemMoleculeComponment> moleculeStacks = new ArrayList<>();
                                JsonArray molecules = jsonObject.getAsJsonArray("molecules");
                                for (Iterator<JsonElement> iter = molecules.iterator(); iter.hasNext(); ) {
                                    JsonObject moleculeObject = (JsonObject) iter.next();
                                    int amount = moleculeObject.get("amount").getAsInt();
                                    String formula = moleculeObject.get("formula").getAsString();
                                    try {
                                        MoleculeStack moleculeStack = Molecules.MOLECULE_STACKS.get(new Identifier(MolecularCraft.MODID, formula));
                                        if (moleculeStack != null) moleculeStacks.add(moleculeStack.setAmount(amount));
                                        else LOGGER.info("Unable to find molecule or atom with formula \"" + formula + "\"");
                                    } catch (InvalidIdentifierException e) {
                                        Atoms fallbackAtom = Atoms.fromSymbol(formula);
                                        moleculeStacks.add(new Molecule(fallbackAtom, amount));
                                        if (fallbackAtom == null) LOGGER.warn("Unable to find molecule or atom with formula \"" + formula + "\"");
                                    }
                                }
                                ItemMolecule itemMolecule = new ItemMolecule(moleculeStacks);
                                boolean replace = false;
                                try {
                                    replace = jsonObject.get("replace").getAsBoolean();
                                } catch (NullPointerException ignored) {

                                }

                                if (replace) {
                                    if (!itemMolecule.getList().isEmpty()) map.get(type).put(identifier.toString(), itemMolecule);
                                    else map.get(type).remove(identifier.toString());
                                } else {
                                    Map<String, ItemMolecule> typeMap = map.get(type);
                                    if (typeMap.containsKey(identifier.toString())) {
                                        ItemMolecule existingItemMolecule = typeMap.get(identifier.toString());
                                        typeMap.put(identifier.toString(), existingItemMolecule.addMoleculeComponments(itemMolecule.getList()));
                                    } else {
                                        typeMap.put(identifier.toString(), itemMolecule);
                                    }
                                }
                            }
                        } catch (RuntimeException | IOException e) {
                            LOGGER.warn("An Error occured while parsing " + resourceIdentifier.toString() + "!");
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
