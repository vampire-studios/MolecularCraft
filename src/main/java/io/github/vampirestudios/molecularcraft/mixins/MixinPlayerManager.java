package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.registries.MolecularInfoSetters;
import io.github.vampirestudios.molecularcraft.utils.PacketHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {

    @Shadow @Final private List<ServerPlayerEntity> players;
    @Shadow @Final private MinecraftServer server;

    @Inject(method = "onPlayerConnect", at = @At("RETURN"))
    public void molecularcraft_sendPacketOnConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        PacketHandler.sendMolecularInfoPacket(player);
    }

    @Inject(method = "onDataPacksReloaded", at = @At("RETURN"))
    public void molecularcraft_sendPacketOnReload(CallbackInfo ci) {
        MolecularInfoSetters.REGISTRY.forEach(abstractMolecularInfoSetter -> abstractMolecularInfoSetter.setMolecularInfo(this.server));
        Iterator<ServerPlayerEntity> iterator = this.players.iterator();

        while (iterator.hasNext()) {
            PacketHandler.sendMolecularInfoPacket(iterator.next());
        }
    }
}
