package io.github.vampirestudios.molecularcraft.recipes.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeTrackerManager {

    public static final Map<String, List<RecipeTracker>> RECIPE_TRACKER_MAP = new HashMap<>();

    public static void register(String id, RecipeTracker tracker) {
        for (Map.Entry<String, Integer> parent : tracker.getParents().entrySet()) {

        }




        if (!RECIPE_TRACKER_MAP.containsKey(id)) RECIPE_TRACKER_MAP.put(id, new ArrayList<>());
        RECIPE_TRACKER_MAP.get(id).add(tracker);
    }

    private static void tryIncrement(String id) {
        
    }

    public static void registerData(String id, RecipeTracker tracker) {
        if (!RECIPE_TRACKER_MAP.containsKey(id)) RECIPE_TRACKER_MAP.put(id, new ArrayList<>());
        RECIPE_TRACKER_MAP.get(id).add(tracker);
    }
}
