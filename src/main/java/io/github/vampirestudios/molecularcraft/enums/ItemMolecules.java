package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MoleculeAmount;
import net.minecraft.item.Item;

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
                new MoleculeStack(new MoleculeAmount(9, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_button",
                new MoleculeStack(new MoleculeAmount(2, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_door",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_slab",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_stairs",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_pressure_plate",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_button",
                new MoleculeStack(new MoleculeAmount(4, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_boat",
                new MoleculeStack(new MoleculeAmount(5, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_fence",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_fence_gate",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_leaves",
                new MoleculeStack(new MoleculeAmount(27, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_sapling",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:acacia_wood",
                new MoleculeStack(new MoleculeAmount(82, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:oak_log",
                new MoleculeStack(new MoleculeAmount(4, BLOCK), celluloseMolecule));

        new ItemMolecules("minecraft:oak_planks",
                new MoleculeStack(new MoleculeAmount(9, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_button",
                new MoleculeStack(new MoleculeAmount(2, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:oak_door",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_slab",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_stairs",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_pressure_plate",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_button",
                new MoleculeStack(new MoleculeAmount(4, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:oak_boat",
                new MoleculeStack(new MoleculeAmount(5, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_fence",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:oak_fence_gate",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:oak_leaves",
                new MoleculeStack(new MoleculeAmount(27, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_sapling",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:oak_wood",
                new MoleculeStack(new MoleculeAmount(82, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:birch_log",
                new MoleculeStack(new MoleculeAmount(4, BLOCK), celluloseMolecule));

        new ItemMolecules("minecraft:birch_planks",
                new MoleculeStack(new MoleculeAmount(9, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_button",
                new MoleculeStack(new MoleculeAmount(2, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:birch_door",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_slab",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_stairs",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_pressure_plate",
                new MoleculeStack(new MoleculeAmount(2, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_button",
                new MoleculeStack(new MoleculeAmount(4, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:birch_boat",
                new MoleculeStack(new MoleculeAmount(5, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_fence",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:birch_fence_gate",
                new MoleculeStack(new MoleculeAmount(64, NUGGET), celluloseMolecule));

        new ItemMolecules("minecraft:birch_leaves",
                new MoleculeStack(new MoleculeAmount(27, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_sapling",
                new MoleculeStack(new MoleculeAmount(6, INGOT), celluloseMolecule));

        new ItemMolecules("minecraft:birch_wood",
                new MoleculeStack(new MoleculeAmount(82, NUGGET), celluloseMolecule));
    }
}
