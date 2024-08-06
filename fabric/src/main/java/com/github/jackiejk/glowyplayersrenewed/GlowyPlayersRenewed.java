package com.github.jackiejk.glowyplayersrenewed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class GlowyPlayersRenewed implements ModInitializer {

  @Override
  public void onInitialize() {

    ServerEntityEvents.ENTITY_LOAD.register(
            (Entity entity, ServerLevel level) -> WorldJoinEvent.onSpawn(level, entity));
  }

}
