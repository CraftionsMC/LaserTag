package net.craftions.lasertag.events;

import net.minecraft.server.v1_16_R3.PlayerInteractManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class EventEntityCollect {


    @EventHandler
    public void onInteract(PlayerPickupItemEvent e){

    e.setCancelled(true);

    }


}
