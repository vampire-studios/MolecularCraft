package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import io.github.vampirestudios.molecularcraft.registries.MolecularInfoSetters;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Shadow public abstract RecipeManager getRecipeManager();

    @Inject(
            method = "reloadDataPacks",
            at = @At("RETURN")
    )
    private void reloadData(LevelProperties levelProperties, CallbackInfo ci) {
        MolecularInfoSetters.REGISTRY.forEach(
                abstractMolecularInfoSetter -> abstractMolecularInfoSetter.setMolecularInfo(this.getRecipeManager()));
    }
}
