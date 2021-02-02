package io.github.vampirestudios.molecularcraft.recipes.tracker;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;

import java.util.HashMap;
import java.util.Map;

public class RecipeTracker {
    private String name;
    private int amount;
    private String output;
    private ItemMolecule itemMolecule;
    private Map<String, RecipeTracker> subTrackers;
    private Map<String, Integer> parents;

    public RecipeTracker(String name, String output, ItemMolecule itemMolecule, int amount) {
        this.name = name;
        this.output = output;
        this.itemMolecule = itemMolecule;
        this.amount = amount;
        this.subTrackers = new HashMap<>();
        this.parents = new HashMap<>();
    }

    public void registerParent(String id, int amount) {
        if (parents.containsKey(id)) parents.put(id, parents.get(id) + amount);
        else parents.put(id, amount);
    }

    public Map<String, Integer> getParents() {
        return parents;
    }

    public void registerSub(String id, RecipeTracker tracker) {

    }
}
