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
                celluloseMolecule.setAmount(WOOD));

        register("acacia_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("acacia_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("acacia_wood",
                celluloseMolecule.setAmount(WOOD));

        register("oak_log",
                celluloseMolecule.setAmount(WOOD));

        register("oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("oak_wood",
                celluloseMolecule.setAmount(WOOD));

        register("dark_oak_log",
                celluloseMolecule.setAmount(WOOD));

        register("dark_oak_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("dark_oak_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("dark_oak_wood",
                celluloseMolecule.setAmount(WOOD));

        register("birch_log",
                celluloseMolecule.setAmount(WOOD));

        register("birch_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("birch_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("birch_wood",
                celluloseMolecule.setAmount(WOOD));

        register("jungle_log",
                celluloseMolecule.setAmount(WOOD));

        register("jungle_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("jungle_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("jungle_wood",
                celluloseMolecule.setAmount(WOOD));

        register("spruce_log",
                celluloseMolecule.setAmount(WOOD));

        register("spruce_leaves",
                celluloseMolecule.setAmount(new MoleculeAmount(12, NUGGET)));

        register("spruce_sapling",
                celluloseMolecule.setAmount(new MoleculeAmount(4, INGOT)));

        register("spruce_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_acacia_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_oak_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_dark_oak_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_jungle_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_spruce_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_birch_log",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_acacia_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_acacia_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_oak_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_dark_oak_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_jungle_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_spruce_wood",
                celluloseMolecule.setAmount(WOOD));

        register("stripped_birch_wood",
                celluloseMolecule.setAmount(WOOD));

        register("obsidian",
                obsidianMolecule.setAmount(1));

        register("paper",
                celluloseMolecule.setAmount(new MoleculeAmount(3, INGOT)));

        register("leather",
                livingMolecules.setAmount(new MoleculeAmount(7, NUGGET)));

        register("diamond",
                diamondMolecule.setAmount(INGOT));

        register("diamond_horse_armor",
                diamondMolecule.setAmount(new MoleculeAmount(11, INGOT)));

        register("gold_nugget",
                new MoleculeStack(NUGGET, goldMolecule));

        register("beef",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("chicken",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("mutton",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("porkchop",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("cod",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("salmon",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)));

        register("sea_pickle",
                livingMolecules.setAmount(new MoleculeAmount(4, NUGGET)));

        register("sea_grass",
                livingMolecules.setAmount(new MoleculeAmount(3, INGOT)));

        register("spider_eye",
                livingMolecules.setAmount(new MoleculeAmount(3, NUGGET)));

        register("sponge",
                livingMolecules.setAmount(BLOCK));

        register("carrot",
                livingMolecules.setAmount(INGOT));

        register("potato",
                livingMolecules.setAmount(INGOT));

        register("beetroot",
                livingMolecules.setAmount(INGOT));

        register("wheat",
                livingMolecules.setAmount(new MoleculeAmount(10,  NUGGET)));

        register("wheat_seeds",
                livingMolecules.setAmount(NUGGET));

        register("white_tulip",
                livingMolecules.setAmount(INGOT));

        register("poppy",
                livingMolecules.setAmount(INGOT));

        register("oxeye_daisy",
                livingMolecules.setAmount(INGOT));

        register("orange_tulip",
                livingMolecules.setAmount(INGOT));

        register("peony",
                livingMolecules.setAmount(INGOT));

        register("pink_tulip",
                livingMolecules.setAmount(INGOT));

        register("red_tulip",
                livingMolecules.setAmount(INGOT));

        register("rose_bush",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("sunflower",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("tall_grass",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("vine",
                livingMolecules.setAmount(new MoleculeAmount(4,  INGOT)));

        register("wither_rose",
                livingMolecules.setAmount(new MoleculeAmount(2, INGOT)),
                celluloseMolecule.setAmount(new MoleculeAmount(2, INGOT)));

        register("tube_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("tube_coral_block",
                livingMolecules.setAmount(BLOCK));

        register("tube_coral_fan",
                livingMolecules.setAmount(INGOT));

        register("brain_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("brain_coral_block",
                livingMolecules.setAmount(BLOCK));

        register("brain_coral_fan",
                livingMolecules.setAmount(INGOT));

        register("bubble_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("bubble_coral_block",
                livingMolecules.setAmount(BLOCK));

        register("bubble_coral_fan",
                livingMolecules.setAmount(INGOT));

        register("fire_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("fire_coral_block",
                livingMolecules.setAmount(BLOCK));

        register("fire_coral_fan",
                livingMolecules.setAmount(INGOT));

        register("horn_coral",
                livingMolecules.setAmount(new MoleculeAmount(2,  INGOT)));

        register("horn_coral_block",
                livingMolecules.setAmount(BLOCK));

        register("horn_coral_fan",
                livingMolecules.setAmount(INGOT));

        register("cactus",
                livingMolecules.setAmount(BLOCK));

        register("string",
                serine.setAmount(1), glycine.setAmount(1), alinine.setAmount(1));

        register("stone", new MoleculeStack[]{
                    new MoleculeStack(STONE,
                            new Molecule(Atoms.SILICON),
                            new Molecule(Atoms.OXYGEN)
                    )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.IRON),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.MAGNESIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.TITANIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.LEAD),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.ZINC),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.ALUMINIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                });
        register("cobblestone", new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.SILICON),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.IRON),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.MAGNESIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.TITANIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.LEAD),
                                new Molecule(Atoms.OXYGEN)
                        )
                },
                new MoleculeStack[]{
                        new MoleculeStack(STONE,
                                new Molecule(Atoms.SODIUM),
                                new Molecule(Atoms.OXYGEN)
                        )
                });
        register("bamboo", celluloseMolecule.setAmount(8));
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

    public static void register(String namespace, String path, MoleculeStack... stack) {
        register(namespace + ":" + path, stack);
    }
}


