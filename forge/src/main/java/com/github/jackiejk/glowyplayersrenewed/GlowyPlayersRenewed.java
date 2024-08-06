package com.github.jackiejk.glowyplayersrenewed;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class GlowyPlayersRenewed {

  public GlowyPlayersRenewed() {
    MinecraftForge.EVENT_BUS.addListener(GlowyPlayersRenewed::onEntityLoad);
  }


  public static void onEntityLoad(EntityJoinLevelEvent event) {
    Level level = event.getLevel();
    if (!(level instanceof ServerLevel)) {
      return;
    }
    WorldJoinEvent.onSpawn((ServerLevel) level, event.getEntity());
  }


}