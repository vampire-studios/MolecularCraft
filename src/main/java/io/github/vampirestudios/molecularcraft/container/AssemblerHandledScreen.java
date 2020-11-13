package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class AssemblerHandledScreen extends CottonInventoryScreen<AssemblerScreenHandler> {
    AssemblerBlockEntity blockEntity;
    WLabel textField;

    public AssemblerHandledScreen(AssemblerScreenHandler linkedContainer, PlayerEntity player, Text title) {
        super(linkedContainer, player, title);

        this.blockEntity = linkedContainer.blockEntity;
        this.textField = linkedContainer.textField;
    }

    @Override
    public void tick() {
        double energy = blockEntity.getStored(null);
        double maxE = blockEntity.getMaxStoredPower();
        textField.setText(new LiteralText("Energy: " + energy + "/" + maxE));
//        ItemStack recipe = blockEntity.inventory.getInvStack(18);
//        if (recipe.getItem() == ModItems.RECIPE) {
//            CompoundTag tag = recipe.getTag();
//            String id = tag.getString("outputId");
//            Item item = Registry.ITEM.get(new Identifier(id));
//            ListTag list = tag.getList("inputs", 10);
//            boolean[] booleans = new boolean[list.size()];
//            for (int i = 0; i < list.size() ; i++) {
//                booleans[i] = false;
//                CompoundTag tag1 = list.getCompound(i);
//                int amount = tag1.getInt("count");
//                String id1 = tag1.getString("id");
//                Item item1 = Registry.ITEM.get(new Identifier(id1));
//                ItemStack itemStack = new ItemStack(item1, amount);
//                if (blockEntity.inventory.getInvStack(i).getItem() == Items.AIR) {
//                    continue;
//                } else {
//                    ItemStack inventoryStack = blockEntity.inventory.getInvStack(i);
//                    if (itemStack.getItem() == inventoryStack.getItem() && inventoryStack.getCount() >= itemStack.getCount()) {
//                        booleans[i] = true;
//                    }
//                }
//            }
//            boolean canSynthetise = true;
//            for (boolean bool : booleans) {
//                if (!bool) {
//                    canSynthetise = false;
//                    break;
//                }
//            }
//            if (canSynthetise) {
//                for (int i = 0; i < list.size(); i++) {
//                    CompoundTag tag1 = list.getCompound(i);
//                    int amount = tag1.getInt("count");
//                    String id1 = tag1.getString("id");
//                    Item item1 = Registry.ITEM.get(new Identifier(id1));
//                    ItemStack itemStack = new ItemStack(item1, amount);
//                    ItemStack invStack = blockEntity.inventory.getInvStack(i);
//                    if (blockEntity.inventory.getInvStack(19).getItem() == item || blockEntity.inventory.getInvStack(19).getItem() == Items.AIR) {
//                        MolecularCraft.sendSlotUpdatePacket(getHandler().syncId, i, 1,
//                                new ItemStack(invStack.getItem(), invStack.getCount() - itemStack.getCount()));
//                    }
//                }
//
//                if (blockEntity.inventory.getInvStack(19).getItem() == item) {
//                    int amount = blockEntity.inventory.getInvStack(19).getCount() + 1;
//                    MolecularCraft.sendSlotUpdatePacket(getHandler().syncId, 19, 1,
//                            new ItemStack(item, amount));
//                } else {
//                    if (blockEntity.inventory.getInvStack(19).getItem() == Items.AIR) {
//                        MolecularCraft.sendSlotUpdatePacket(getHandler().syncId, 19, 1,
//                                new ItemStack(item, 1));
//                    }
//                }
//            }
//        }
//        super.tick();
    }
}
