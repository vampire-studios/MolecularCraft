package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MoleculeAmount;

import java.util.*;

import static io.github.vampirestudios.molecularcraft.enums.Molecules.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.*;
import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;

public class ItemMolecules {

    public static List<ItemMolecules> registry = new ArrayList<>();
    public static List<String> items = new ArrayList<>();

    private String id;
    private List<MoleculeStack> list;

    public ItemMolecules(String id, MoleculeStack... stack) {
        this.id = id;
        this.list = Arrays.asList(stack);
        registry.add(this);
        items.add(this.id);
    }

    public String getId() {
        return id;
    }

    public List<MoleculeStack> getList() {
        return list;
    }

    public static void init() {
        new ItemMolecules("minecraft:water_bucket",
                water.setAmount(16),
                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule)
        );

        new ItemMolecules("minecraft:bucket",
                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_ingot",
                new MoleculeStack(INGOT, ironMolecule));

        new ItemMolecules("minecraft:iron_nugget",
                new MoleculeStack(NUGGET, ironMolecule));

        new ItemMolecules("minecraft:iron_block",
                new MoleculeStack(BLOCK, ironMolecule));

        new ItemMolecules("minecraft:iron_helmet",
                new MoleculeStack(new MoleculeAmount(5, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_chestplate",
                new MoleculeStack(new MoleculeAmount(8, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_leggings",
                new MoleculeStack(new MoleculeAmount(7, INGOT), ironMolecule));

        new ItemMolecules("minecraft:cauldron",
                new MoleculeStack(new MoleculeAmount(7, INGOT), ironMolecule));

        new ItemMolecules("minecraft:minecart",
                new MoleculeStack(new MoleculeAmount(5, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_boots",
                new MoleculeStack(new MoleculeAmount(4, INGOT), ironMolecule));

        new ItemMolecules("minecraft:heavy_weighted_pressure_plate",
                new MoleculeStack(new MoleculeAmount(2, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_bars",
                new MoleculeStack(new MoleculeAmount(6, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_door",
                new MoleculeStack(new MoleculeAmount(6, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_trapdoor",
                new MoleculeStack(new MoleculeAmount(4, INGOT), ironMolecule));

        new ItemMolecules("minecraft:acacia_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:acacia_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:acacia_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:acacia_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:acacia_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:oak_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:oak_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:oak_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:dark_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:dark_oak_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:dark_oak_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:dark_oak_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:dark_oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:dark_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:birch_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:birch_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:birch_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:birch_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:birch_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:birch_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:jungle_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:jungle_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:jungle_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:jungle_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:jungle_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:jungle_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:spruce_log",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:spruce_planks",
                celluloseMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:spruce_button",
                celluloseMolecule.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:spruce_door",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_slab",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_stairs",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_pressure_plate",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_boat",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_fence",
                celluloseMolecule.setAmount(new MoleculeAmount(9, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_fence_gate",
                celluloseMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET).getAmount()));

        new ItemMolecules("minecraft:spruce_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:spruce_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(5, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_acacia_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_dark_oak_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_jungle_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_spruce_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_birch_log",
                celluloseMolecule.setAmount(new MoleculeAmount(3, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_acacia_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_dark_oak_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_jungle_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_spruce_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stripped_birch_wood",
                celluloseMolecule.setAmount(new MoleculeAmount(4, BLOCK).getAmount()));

        new ItemMolecules("minecraft:stick",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:wooden_axe",
                celluloseMolecule.setAmount(new MoleculeAmount(7, INGOT).getAmount()));

        new ItemMolecules("minecraft:wooden_hoe",
                celluloseMolecule.setAmount(new MoleculeAmount(6, INGOT).getAmount()));

        new ItemMolecules("minecraft:wooden_pickaxe",
                celluloseMolecule.setAmount(new MoleculeAmount(7, INGOT).getAmount()));

        new ItemMolecules("minecraft:wooden_shovel",
                celluloseMolecule.setAmount(new MoleculeAmount(5, INGOT).getAmount()));

        new ItemMolecules("minecraft:wooden_sword",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()));

        new ItemMolecules("minecraft:iron_axe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                new MoleculeStack(new MoleculeAmount(3,INGOT),ironMolecule));

        new ItemMolecules("minecraft:iron_pickaxe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                new MoleculeStack(new MoleculeAmount(3,INGOT),ironMolecule));

        new ItemMolecules("minecraft:iron_hoe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                new MoleculeStack(new MoleculeAmount(2,INGOT),ironMolecule));

        new ItemMolecules("minecraft:iron_shovel",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                new MoleculeStack(new MoleculeAmount(2,INGOT),ironMolecule));

        new ItemMolecules("minecraft:iron_sword",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()),
                new MoleculeStack(new MoleculeAmount(2,INGOT),ironMolecule));

        new ItemMolecules("minecraft:obsidian",
                obsidianMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:paper",
                celluloseMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:leather",
                livingMolecules.setAmount(new MoleculeAmount(7, NUGGET).getAmount()));

        new ItemMolecules("minecraft:diamond",
                diamondMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_block",
                diamondMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:diamond_helmet",
                diamondMolecule.setAmount(new MoleculeAmount(5,INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_chestplate",
                diamondMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_leggings",
                diamondMolecule.setAmount(new MoleculeAmount(7, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_horse_armor",
                diamondMolecule.setAmount(new MoleculeAmount(11, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_axe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                diamondMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_pickaxe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                diamondMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_hoe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                diamondMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_shovel",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                diamondMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        new ItemMolecules("minecraft:diamond_sword",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()),
                diamondMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_ingot",
                goldMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_block",
                goldMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:gold_helmet",
                goldMolecule.setAmount(new MoleculeAmount(5,INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_chestplate",
                goldMolecule.setAmount(new MoleculeAmount(8, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_leggings",
                goldMolecule.setAmount(new MoleculeAmount(7, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_horse_armor",
                goldMolecule.setAmount(new MoleculeAmount(11, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_axe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                goldMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_pickaxe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                goldMolecule.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_hoe",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                goldMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_shovel",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT).getAmount()),
                goldMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        new ItemMolecules("minecraft:gold_sword",
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()),
                goldMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:beef",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:chicken",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:mutton",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:porkchop",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:cod",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:salmon",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:sea_pickle",
                livingMolecules.setAmount(new MoleculeAmount(4, NUGGET).getAmount()));

        new ItemMolecules("minecraft:sea_grass",
                livingMolecules.setAmount(new MoleculeAmount(3, INGOT).getAmount()));

        new ItemMolecules("minecraft:spider_eye",
                livingMolecules.setAmount(new MoleculeAmount(3, NUGGET).getAmount()));

        new ItemMolecules("minecraft:sponge",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:carrot",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:potato",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:beetroot",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:wheat",
                livingMolecules.setAmount(new MoleculeAmount(10,  NUGGET).getAmount()));

        new ItemMolecules("minecraft:wheat_seeds",
                livingMolecules.setAmount(new MoleculeAmount(1,  NUGGET).getAmount()));

        new ItemMolecules("minecraft:white_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:poppy",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:oxeye_daisy",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:orange_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:peony",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:pink_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:red_tulip",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:rose_bush",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:sunflower",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:tall_grass",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:vine",
                livingMolecules.setAmount(new MoleculeAmount(4,  INGOT).getAmount()));

        new ItemMolecules("minecraft:wither_rose",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT).getAmount()),
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT).getAmount()));

        new ItemMolecules("minecraft:tube_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:tube_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:tube_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:brain_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:brain_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:brain_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:bubble_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:bubble_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:bubble_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:fire_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:fire_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:fire_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:horn_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT).getAmount()));

        new ItemMolecules("minecraft:horn_coral_block",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:horn_coral_fan",
                livingMolecules.setAmount(new MoleculeAmount(1,  INGOT).getAmount()));

        new ItemMolecules("minecraft:cactus",
                livingMolecules.setAmount(new MoleculeAmount(1,  BLOCK).getAmount()));

        new ItemMolecules("minecraft:string",
                woolMolecule.setAmount(new MoleculeAmount(1, INGOT).getAmount()));

        new ItemMolecules("minecraft:wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:black_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:blue_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:brown_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:cyan_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:gray_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:green_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:light_blue_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:light_gray_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:lime_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:magenta_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:orange_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:pink_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:purple_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:red_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:white_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:yellow_wool",
                woolMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));

        new ItemMolecules("minecraft:cement",
                cementMolecule.setAmount(new MoleculeAmount(1, BLOCK).getAmount()));
    }
}


