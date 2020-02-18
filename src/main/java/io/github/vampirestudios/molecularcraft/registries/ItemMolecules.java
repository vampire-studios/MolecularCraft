package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MoleculeAmount;
import net.minecraft.util.Identifier;

import java.util.*;

import static io.github.vampirestudios.molecularcraft.enums.Molecules.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.*;

public class ItemMolecules {

//    public static List<ItemMolecules> registry = new ArrayList<>();
//    public static List<String> items = new ArrayList<>();
    public static Map<String, ItemMolecules> registry = new HashMap<>();

    private List<MoleculeStack> list;

    public ItemMolecules(MoleculeStack... stack) {
        this(Arrays.asList(stack));
    }

    public ItemMolecules(List<MoleculeStack> list) {
        this.list = list;
    }

    public ItemMolecules() {
        this(new ArrayList<MoleculeStack>());
    }

    public List<MoleculeStack> getList() {
        return list;
    }

    public ItemMolecules addMoleculeStack(MoleculeStack moleculeStack) {
        MoleculeStack moleculeStack1 = moleculeStack;
        List<Molecule> moleculeList = moleculeStack1.getMolecules();

        for (int k = 0;this.list.size() > k; k++) {
            List<Molecule> moleculeList1 = this.list.get(k).getMolecules();
            if (moleculeList.equals(moleculeList1)) {
                moleculeStack1 = this.list.get(k).setAmount(this.list.get(k).getAmount() + moleculeStack.getAmount());
                this.list.set(k, moleculeStack1);
                return this;
            }
        }

        this.list.add(moleculeStack1);
        return this;
    }

    public ItemMolecules addMoleculeStacks(Collection<MoleculeStack> moleculeStack) {
        moleculeStack.forEach(this::addMoleculeStack);
        return this;
    }

    public static void init() {
        register("water_bucket",
                water.setAmount(16),
                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule)
        );

        register("iron_nugget",
                new MoleculeStack(NUGGET, ironMolecule));

        register("acacia_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("acacia_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("acacia_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("dark_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("dark_oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("dark_oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("dark_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("birch_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("birch_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("birch_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("birch_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("jungle_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("jungle_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("jungle_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("jungle_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("spruce_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("spruce_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        register("spruce_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        register("spruce_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        register("stripped_acacia_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_dark_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_jungle_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_spruce_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_birch_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        register("stripped_acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_dark_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_jungle_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_spruce_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("stripped_birch_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        register("obsidian",
                obsidianMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        register("paper",
                celluloseMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        register("leather",
                livingMolecules.setAmount(new MoleculeAmount(7, NUGGET).getAmount()));

        register("diamond",
                diamondMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        register("diamond_horse_armor",
                diamondMolecule.setAmount(new MoleculeAmount(11, INGOT).getAmount()));

        register("gold_nugget",
                goldMolecule.setAmount(new MoleculeAmount(1, NUGGET).getAmount()));

        register("beef",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("chicken",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("mutton",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("porkchop",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("cod",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("salmon",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("sea_pickle",
                livingMolecules.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        register("sea_grass",
                livingMolecules.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        register("spider_eye",
                livingMolecules.setAmount(new MoleculeAmount(3, NUGGET).getAmount()));

        register("sponge",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("carrot",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("potato",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("beetroot",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("wheat",
                livingMolecules.setAmount(new MoleculeAmount(10,  NUGGET).getAmount()));

        register("wheat_seeds",
                livingMolecules.setAmount(new MoleculeAmount(1,  NUGGET).getAmount()));

        register("white_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("poppy",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("oxeye_daisy",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("orange_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("peony",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("pink_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("red_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("rose_bush",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("sunflower",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("tall_grass",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("vine",
                livingMolecules.setAmount(new MoleculeAmount(4,  INGOT).getAmount()));

        register("wither_rose",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()),
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        register("tube_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("tube_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("tube_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("brain_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("brain_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("brain_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("bubble_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("bubble_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("bubble_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("fire_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("fire_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("fire_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("horn_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        register("horn_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("horn_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        register("cactus",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        register("string",
                woolMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));
    }

    public static void register(String id, MoleculeStack... stack) {
        registry.put(new Identifier(id).toString(), new ItemMolecules(stack));
    }

    public static void register(String id, ItemMolecules itemMolecule) {
        List<MoleculeStack> list = itemMolecule.getList();


        registry.put(id, itemMolecule);
    }

    public static void register(String namespace, String path, MoleculeStack... stack) {
        register(namespace + path, stack);
    }
}


