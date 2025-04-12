package com.github.jackiejk.glowyplayersrenewed;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class GlowyPlayersRenewed {

  public GlowyPlayersRenewed() {
    MinecraftForge.EVENT_BUS.addListener(GlowyPlayersRenewed::onEntityLoad);
    MinecraftForge.EVENT_BUS.addListener(GlowyPlayersRenewed::onPlayerLogout);
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