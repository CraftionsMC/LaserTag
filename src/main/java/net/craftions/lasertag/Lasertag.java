package net.craftions.lasertag;

import net.craftions.lasertag.events.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Lasertag extends JavaPlugin {
    public static HashMap<Player, Integer> kills = new HashMap<>();
    public static Lasertag plugin;
    public static String prefix = "[§4LaserTag§r] ";

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventPlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EventEntityDamage(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPickupItemEvent, this);
        System.out.println("Loaded LaserTag!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
