package io.github.vampirestudios.molecularcraft.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;

public class MoleculeDataConfig extends DataConfig {
    public MoleculeDataConfig() {
        super("molecules");
    }

    @Override
    protected void load(JsonObject jsonObject) {
        JsonArray jsonArray = jsonObject.getAsJsonArray("molecules");
        for (Iterator<JsonElement> it = jsonArray.iterator(); it.hasNext(); ) {
            JsonObject molecule = (JsonObject) it.next();
            Identifier id = new Identifier(MolecularCraft.MODID, molecule.get("id").getAsString());
            JsonArray atoms = molecule.getAsJsonArray("atoms");
            List<Molecule> molecules = new ArrayList<>();
            for (Iterator<JsonElement> iter = atoms.iterator(); iter.hasNext(); ) {
                JsonObject atom = (JsonObject) iter.next();
                Atoms atom1 = Atoms.valueOf(atom.get("atom").getAsString());
                int number = atom.get("number").getAsInt();
                molecules.add(new Molecule(atom1, number));
            }
            MoleculeStack moleculeStack = new MoleculeStack(molecules.toArray(new Molecule[molecules.size()]));
            Registry.register(Registry.ITEM, id, new MoleculeStackItem(moleculeStack));
            Registry.register(Registry.ITEM, MolecularCraft.id(id.getPath() + "_64"), new StackedMoleculeStackItem(moleculeStack));
            Registry.register(Molecules.MOLECULE_STACKS, id, moleculeStack);
        }
    }

    @Override
    protected void save(FileWriter fileWriter) {
        JsonObject main = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (MoleculeStack moleculeStack : this.getDefaultList()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", moleculeStack.getRegistryName());
            JsonArray atoms = new JsonArray();
            for (Molecule molecule : moleculeStack.getMolecules()) {
                JsonObject atom = new JsonObject();
                atom.addProperty("atom", molecule.getAtom().name());
                atom.addProperty("number", molecule.getAmount());
                atoms.add(atom);
            }
            jsonObject.add("atoms", atoms);
            jsonArray.add(jsonObject);
        }
        main.add("molecules", jsonArray);
        GSON.toJson(main, fileWriter);
    }

    private List<MoleculeStack> getDefaultList() {
        List<MoleculeStack> list = new ArrayList<>();

        list.add(new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN)));
        list.add(new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 10), new Molecule(OXYGEN, 5)));
        list.add(new MoleculeStack(new Molecule(CARBON, 31), new Molecule(HYDROGEN, 34), new Molecule(OXYGEN, 11)));
        list.add(new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 22), new Molecule(OXYGEN, 31)));
        list.add(new MoleculeStack(new Molecule(CARBON, 24), new Molecule(HYDROGEN, 42), new Molecule(OXYGEN, 21)));
        list.add(new MoleculeStack(new Molecule(CARBON, 64), new Molecule(CARBON, 64), new Molecule(CARBON, 64), new Molecule(CARBON, 64)));
        list.add(new MoleculeStack(new Molecule(CARBON, 5)));
        list.add(new MoleculeStack(new Molecule(SILICON), new Molecule(OXYGEN, 2)));
        list.add(new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 13), new Molecule(OXYGEN, 7), new Molecule(NITROGEN, 6)));
        list.add(new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN, 13), new Molecule(SILICON, 2), new Molecule(SULFUR), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM)));
        list.add(new MoleculeStack(new Molecule(OXYGEN, 12), new Molecule(SILICON, 2), new Molecule(SULFUR), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM)));
        list.add(new MoleculeStack(new Molecule(CARBON), new Molecule(HYDROGEN), new Molecule(OXYGEN), new Molecule(NITROGEN), new Molecule(SULFUR), new Molecule(PHOSPHORUS)));
        list.add(new MoleculeStack(new Molecule(HYDROGEN, 4), new Molecule(OXYGEN, 7), new Molecule(SILICON, 2), new Molecule(ALUMINIUM, 2)));
        list.add(new MoleculeStack(new Molecule(CARBON, 7), new Molecule(HYDROGEN), new Molecule(OXYGEN), new Molecule(SULFUR)));
        list.add(new MoleculeStack(new Molecule(CARBON, 4), new Molecule(HYDROGEN, 7), new Molecule(OXYGEN, 2), new Molecule(CHLORINE, 1)));
        list.add(new MoleculeStack(new Molecule(SILICON, 2), new Molecule(HYDROGEN, 2), new Molecule(OXYGEN,1 )));
        list.add(new MoleculeStack(new Molecule(NITROGEN), new Molecule(OXYGEN, 3)));
        list.add(new MoleculeStack(new Molecule(CARBON, 3), new Molecule(HYDROGEN, 7), new Molecule(NITROGEN), new Molecule(OXYGEN, 3)));
        list.add(new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 5), new Molecule(NITROGEN), new Molecule(OXYGEN, 2)));
        list.add(new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 7), new Molecule(NITROGEN), new Molecule(OXYGEN, 2)));
        list.add(new MoleculeStack(new Molecule(BERYLLIUM, 3), new Molecule(ALUMINIUM, 2), new Molecule(SILICON, 6), new Molecule(OXYGEN, 18)));
        list.add(new MoleculeStack(new Molecule(COPPER, 9), new Molecule(TIN)));
        list.add(new MoleculeStack(new Molecule(GOLD), new Molecule(SILVER)));
        list.add(new MoleculeStack(new Molecule(MAGNESIUM, 2), new Molecule(SILICON), new Molecule(OXYGEN, 4)));
        list.add(new MoleculeStack(new Molecule(ALUMINIUM, 2), new Molecule(OXYGEN, 3)));
        list.add(new MoleculeStack(new Molecule(ALUMINIUM, 2), new Molecule(SILICON), new Molecule(FLUORINE, 2), new Molecule(OXYGEN, 2), new Molecule(HYDROGEN, 2)));

        return list;
    }
}
