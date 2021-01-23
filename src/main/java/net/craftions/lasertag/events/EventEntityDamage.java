/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.lasertag.events;

import net.craftions.lasertag.Lasertag;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventEntityDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(!e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
            Projectile p = (Projectile) e.getDamager();
            Player s = (Player) p.getShooter();
            s.sendMessage(Lasertag.prefix + "Du hast " + e.getEntity().getName() + " getötet!");
            e.setCancelled(true);
        }
    }
}
