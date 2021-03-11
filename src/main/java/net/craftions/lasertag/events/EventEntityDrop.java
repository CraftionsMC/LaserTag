package net.craftions.lasertag.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EventEntityDrop implements Listener {

    public void onDrop(PlayerDropItemEvent t){

    t.setCancelled(true);


    }


}
