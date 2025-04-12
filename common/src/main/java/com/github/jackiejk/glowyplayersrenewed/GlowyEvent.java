package com.github.jackiejk.glowyplayersrenewed;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GlowyEvent {

  public static void onSpawn(ServerLevel level, Entity entity) {
    if (level.isClientSide()) return;
    if (!(entity instanceof Player player)) return;
    player.setGlowingTag(true);
  }

  public static void onDisconnect(Player player) {
    player.setGlowingTag(false);
  }

}