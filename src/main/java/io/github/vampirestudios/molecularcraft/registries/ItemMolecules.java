package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.molecules.ChanceItemMolecule;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MoleculeAmount;
import net.minecraft.util.Identifier;

import java.util.*;

import static io.github.vampirestudios.molecularcraft.enums.Molecules.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.BaseMaterials.*;

public class ItemMolecules {

    public static Map<String, ItemMolecules> registry = new HashMap<>();

    public static Map<String, ItemMolecules> tags = new HashMap<>();

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
//        register("water_bucket",
//                water.setAmount(16),
//                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule)
//        );
//
//        register("iron_nugget", new MoleculeStack(NUGGET, ironMolecule));
//        register("gold_nugget", new MoleculeStack(NUGGET, goldMolecule));
//        register("diamond", diamondMolecule.setAmount(INGOT));
//        register("emerald", emerald.setAmount(INGOT));
//
//        register("diamond_horse_armor", diamondMolecule.setAmount(new MoleculeAmount(11, INGOT)));
//
//        tag("logs",
//                celluloseMolecule.setAmount(640),
//                xylan.setAmount(128),
//                glucomannan.setAmount(128),
//                lignin.setAmount(384)
//        );
//        tag("saplings",
//                celluloseMolecule.setAmount(5),
//                xylan.setAmount(1),
//                glucomannan.setAmount(1),
//                lignin.setAmount(3)
//        );
//        tag("leaves",
//                celluloseMolecule.setAmount(80)
//        );
//
//        register("bamboo",
//                celluloseMolecule.setAmount(40),
//                xylan.setAmount(8),
//                glucomannan.setAmount(8),
//                lignin.setAmount(24));
//
//        register("obsidian", siliconDioxide.setAmount(8));
//
//        register("paper", celluloseMolecule.setAmount(6));
//
//        register("leather",
//                livingMolecules.setAmount(new MoleculeAmount(7, NUGGET)));
//
//
//        register("beef",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("chicken",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("mutton",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("porkchop",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("cod",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("salmon",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("sea_pickle",
//                livingMolecules.setAmount(new MoleculeAmount(4, NUGGET)));
//
//        register("sea_grass",
//                livingMolecules.setAmount(new MoleculeAmount(3, INGOT)));
//
//        register("spider_eye",
//                livingMolecules.setAmount(new MoleculeAmount(3, NUGGET)));
//
//        register("sponge",
//                livingMolecules.setAmount(BLOCK));
//
//        register("carrot",
//                livingMolecules.setAmount(INGOT));
//
//        register("potato",
//                livingMolecules.setAmount(INGOT));
//
//        register("beetroot",
//                livingMolecules.setAmount(INGOT));
//
//        register("wheat",
//                livingMolecules.setAmount(new MoleculeAmount(10,  NUGGET)));
//
//        register("wheat_seeds",
//                livingMolecules.setAmount(NUGGET));
//
//        register("white_tulip",
//                livingMolecules.setAmount(INGOT));
//
//        register("poppy",
//                livingMolecules.setAmount(INGOT));
//
//        register("oxeye_daisy",
//                livingMolecules.setAmount(INGOT));
//
//        register("orange_tulip",
//                livingMolecules.setAmount(INGOT));
//
//        register("peony",
//                livingMolecules.setAmount(INGOT));
//
//        register("pink_tulip",
//                livingMolecules.setAmount(INGOT));
//
//        register("red_tulip",
//                livingMolecules.setAmount(INGOT));
//
//        register("rose_bush",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("sunflower",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("tall_grass",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("vine",
//                livingMolecules.setAmount(new MoleculeAmount(4,  INGOT)));
//
//        register("wither_rose",
//                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)),
//                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT)));
//
//        register("tube_coral",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("tube_coral_block",
//                livingMolecules.setAmount(BLOCK));
//
//        register("tube_coral_fan",
//                livingMolecules.setAmount(INGOT));
//
//        register("brain_coral",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("brain_coral_block",
//                livingMolecules.setAmount(BLOCK));
//
//        register("brain_coral_fan",
//                livingMolecules.setAmount(INGOT));
//
//        register("bubble_coral",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("bubble_coral_block",
//                livingMolecules.setAmount(BLOCK));
//
//        register("bubble_coral_fan",
//                livingMolecules.setAmount(INGOT));
//
//        register("fire_coral",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("fire_coral_block",
//                livingMolecules.setAmount(BLOCK));
//
//        register("fire_coral_fan",
//                livingMolecules.setAmount(INGOT));
//
//        register("horn_coral",
//                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));
//
//        register("horn_coral_block",
//                livingMolecules.setAmount(BLOCK));
//
//        register("horn_coral_fan",
//                livingMolecules.setAmount(INGOT));
//
//        register("cactus",
//                celluloseMolecule.setAmount(BLOCK));
//
//        register("string",
//                serine.setAmount(6), glycine.setAmount(6), alinine.setAmount(6));
//
//
//
//        // CottonResources : https://github.com/CottonMC/CottonResources/tree/feature/1.16.x/src/main/resources/data/c/tags/items
//        tag("c:aluminum_nuggets", new MoleculeStack(NUGGET, aluminum));
//        tag("c:amethysts", siliconDioxide.setAmount(new MoleculeAmount(INGOT)));
//        tag("c:bronze_nuggets", bronzeMolecule.setAmount(NUGGET));
//        tag("c:cobalt_nuggets", new MoleculeStack(NUGGET, cobalt));
//        tag("c:copper_nuggets", new MoleculeStack(NUGGET, copper));
//        tag("c:electrum_nuggets", electrum.setAmount(NUGGET));
//        tag("c:iridium_nuggets", new MoleculeStack(NUGGET, iridium));
//        tag("c:lead_nuggets", new MoleculeStack(NUGGET, lead));
//        tag("c:osmium_nuggets", new MoleculeStack(NUGGET, osmium));
//        tag("c:palladium_nuggets", new MoleculeStack(NUGGET, palladium));
//        tag("c:peridots", peridot.setAmount(INGOT));
//        tag("c:platinum_nuggets", new MoleculeStack(NUGGET, platinum));
//        tag("c:plutonium_nuggets", new MoleculeStack(NUGGET, plutonium));
//        tag("c:rubies", ruby.setAmount(INGOT));
//        tag("c:sapphires", sapphire.setAmount(INGOT));
//        tag("c:silver_nuggets", new MoleculeStack(NUGGET, silver));
//        tag("c:thorium_nuggets", new MoleculeStack(NUGGET, thorium));
//        tag("c:tin_nuggets", new MoleculeStack(NUGGET, tin));
//        tag("c:titanium_nuggets", new MoleculeStack(NUGGET, titanium));
//        tag("c:topazes", topaz.setAmount(INGOT));
//        tag("c:tungsten_nuggets", new MoleculeStack(NUGGET, tungsten));
//        tag("c:uranium_nuggets", new MoleculeStack(NUGGET, uranium));
//        tag("c:zinc_nuggets", new MoleculeStack(NUGGET, zinc));
    }

    public static void register(String id, MoleculeStack... stack) {
        registry.put(new Identifier(id).toString(), new ItemMolecules(stack));
    }

    public static void register(String id, MoleculeStack[]... stacks) {
        registry.put(new Identifier(id).toString(), new ChanceItemMolecule(stacks));
    }

    public static void register(String id, ItemMolecules itemMolecule) {
        registry.put(id, itemMolecule);
    }

    public static void tag(String id, MoleculeStack... stack) {
        tag(id, new ItemMolecules(stack));
    }

    public static void tag(String id, MoleculeStack[]... stacks) {
        tag(id, new ChanceItemMolecule(stacks));
    }

    public static void tag(String id, ItemMolecules itemMolecule) {
        tags.put(id, itemMolecule);
    }

    public static void register(String namespace, String path, MoleculeStack... stack) {
        register(namespace + ":" + path, stack);
    }

    public static void tag(String namespace, String path, MoleculeStack... stack) {
        tag(namespace + ":" + path, stack);
    }
}


