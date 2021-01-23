/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.lasertag.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventPlayerRespawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spreadplayers 0 0 100 100 false " + e.getPlayer());
    }
}
