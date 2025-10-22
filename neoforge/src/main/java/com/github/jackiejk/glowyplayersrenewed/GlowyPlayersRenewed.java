package com.github.jackiejk.glowyplayersrenewed;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@Mod(Constants.MOD_ID)
public class GlowyPlayersRenewed {

  public GlowyPlayersRenewed() {
    NeoForge.EVENT_BUS.addListener(GlowyPlayersRenewed::onEntityLoad);
    NeoForge.EVENT_BUS.addListener(GlowyPlayersRenewed::onPlayerLogout);
  }


  public static void onEntityLoad(EntityJoinLevelEvent event) {
    Level level = event.getLevel();
    if (!(level instanceof ServerLevel)) {
      return;
    }
    GlowyEvent.onSpawn((ServerLevel) level, event.getEntity());
  }


  @SubscribeEvent
  public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
    Player player = event.getEntity();
    if (player instanceof ServerPlayer serverPlayer) {
      GlowyEvent.onDisconnect(serverPlayer);
    }
  }

}