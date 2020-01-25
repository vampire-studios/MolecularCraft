package io.github.vampirestudios.molecularcraft.recipes;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.List;
import java.util.Random;

public class DisassemblerRecipeManager {

    public static void tick(DisassemblerBlockEntity disassemblerBlockEntity) {
        if (!disassemblerBlockEntity.getWorld().isClient) {
            ItemStack firstSlotItemStack = disassemblerBlockEntity.getInvStack(0);
            if (firstSlotItemStack.isEmpty()) return;

            if (firstSlotItemStack.getItem() instanceof MoleculeStackItem) {
                stackToMolecule(disassemblerBlockEntity, firstSlotItemStack);
            } else {
                itemToStackAndMolecule(disassemblerBlockEntity, firstSlotItemStack);
            }
        }
    }

    public static void itemToStackAndMolecule(DisassemblerBlockEntity disassemblerBlockEntity, ItemStack firstSlotItemStack) {
        String id = Registry.ITEM.getId(firstSlotItemStack.getItem()).toString();
        for (ItemMolecules itemMolecule : ItemMolecules.registry) {
            if (itemMolecule.getId().equals(id)) {
                List<MoleculeStack> moleculeStackList = itemMolecule.getList();
                boolean[] booleans = new boolean[moleculeStackList.size()];
                for (int x = 0; x < booleans.length; x++)
                    booleans[x] = false;
                for (int k = 1; k < disassemblerBlockEntity.getInvSize(); k++) {
                    ItemStack itemStack = disassemblerBlockEntity.getInvStack(k);
                    for (int g = 0; g < moleculeStackList.size(); g++) {
                        if (booleans[g]) continue;
                        ItemStack moleculeStackItemStack = moleculeStackList.get(g).getMoleculeStackItemStack();
                        if (moleculeStackItemStack.isEmpty() || moleculeStackList.get(g).getMoleculeStackItem() == null || moleculeStackList.get(g).getMoleculeStackItem() == Items.AIR) {
                            moleculeStackItemStack = new ItemStack(Registry.ITEM.get(
                                    new Identifier("molecularcraft", moleculeStackList.get(g).getMolecules().get(0).getAtom().getSymbol().toLowerCase())),
                                    moleculeStackList.get(g).getAmount());
                        }
                        if (itemStack.isEmpty()) {
                            disassemblerBlockEntity.setInvStack(k, moleculeStackItemStack);
                            booleans[g] = true;
                            break;
                        } else {
                            if (itemStack.isItemEqual(moleculeStackItemStack)) {
                                int amount = itemStack.getCount();
                                int count = moleculeStackItemStack.getCount();
                                int som = count + amount;
                                moleculeStackItemStack.setCount(som);
                                disassemblerBlockEntity.setInvStack(k, moleculeStackItemStack);
                                booleans[g] = true;
                                break;
                            } else {
                                booleans[g] = false;
                            }
                        }
                    }
                    boolean molboolean = true;
                    for (boolean boo : booleans) {
                        if (!boo) {
                            molboolean = false;
                            break;
                        }
                    }
                    if (molboolean) break;
                }
                firstSlotItemStack.decrement(1);
                break;
            }
        }
    }

    private static void stackToMolecule(DisassemblerBlockEntity disassemblerBlockEntity, ItemStack firstSlotItemStack) {
        MoleculeStackItem moleculeStackItem = (MoleculeStackItem) firstSlotItemStack.getItem();
        MoleculeStack moleculeStack = moleculeStackItem.getMoleculeStack();
        List<Molecule> moleculeList = moleculeStack.getMolecules();
        boolean[] booleans = new boolean[moleculeList.size()];
        for (int x = 0; x < booleans.length; x++)
            booleans[x] = false;
        for (int k = 0; k < disassemblerBlockEntity.getInvSize(); k++) {
            ItemStack itemStack = disassemblerBlockEntity.getInvStack(k);
            for (int g = 0; g < moleculeList.size(); g++) {
                if (booleans[g]) continue;

                Molecule molecule = moleculeList.get(g);
                Atoms atom = molecule.getAtom();
                ItemStack moleculeStackItemStack = null;
                if (atom.getIsotopes() != null) {

                    Isotope[] isotopes = atom.getIsotopes();
                    float rand = new Random().nextFloat() * 100F;
                    float abundance = 0.0F;
                    for (int a = 0; a < isotopes.length; a++) {
                        if (isotopes[a].getAbundance() == 0.00F || isotopes[a].getAbundance() == -1F) continue;
                        abundance = abundance + isotopes[a].getAbundance();
                        if (rand < abundance) {
                            moleculeStackItemStack = new ItemStack(
                                    Registry.ITEM.get(new Identifier("molecularcraft", "isotope_" + atom.getSymbol().toLowerCase() + "_" + a)),
                                    molecule.getAmount()
                            );
                            break;
                        }

                    }

                } else {
                    moleculeStackItemStack = new ItemStack(Registry.ITEM.get(
                        new Identifier("molecularcraft", moleculeList.get(g).getAtom().getSymbol().toLowerCase())),
                        moleculeList.get(g).getAmount());
                }


                if (itemStack.isEmpty()) {
                    disassemblerBlockEntity.setInvStack(k, moleculeStackItemStack);
                    booleans[g] = true;
                    break;
                } else {
                    assert moleculeStackItemStack != null;
                    if (itemStack.isItemEqual(moleculeStackItemStack)) {
                        int amount = itemStack.getCount();
                        int count = moleculeStackItemStack.getCount();
                        int som = count + amount;
                        moleculeStackItemStack.setCount(som);
                        disassemblerBlockEntity.setInvStack(k, moleculeStackItemStack);
                        booleans[g] = true;
                        break;
                    } else {
                        booleans[g] = false;
                    }
                }
            }

            boolean molboolean = true;
            for (boolean boo : booleans) {
                if (!boo) {
                    molboolean = false;
                    break;
                }
            }
            if (molboolean) break;
        }
        firstSlotItemStack.decrement(1);
    }
}
