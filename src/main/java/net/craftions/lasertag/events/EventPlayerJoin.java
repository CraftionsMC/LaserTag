/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.lasertag.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spreadplayers 0 0 100 100 false " + e.getPlayer());
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().getInventory().clear();
        ItemStack shoot = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = shoot.getItemMeta();
        meta.setDisplayName("§e§lGun");
        shoot.setItemMeta(meta);
    }
}
