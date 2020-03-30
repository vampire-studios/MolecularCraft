package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.registries.MolecularInfoSetters;
import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Inject(
            method = "reloadDataPacks",
            at = @At("RETURN")
    )
    private void reloadData(LevelProperties levelProperties, CallbackInfo ci) {
        MolecularInfoSetters.REGISTRY.forEach(abstractMolecularInfoSetter -> abstractMolecularInfoSetter.setMolecularInfo((MinecraftServer) (Object)this));
    }
}
