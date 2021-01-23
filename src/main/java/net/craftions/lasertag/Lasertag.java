package net.craftions.lasertag;

import org.bukkit.plugin.java.JavaPlugin;

public final class Lasertag extends JavaPlugin {

    public static Lasertag plugin;
    public static String prefix = "[§4LaserTag§r] ";

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        System.out.println("Loaded LaserTag!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
