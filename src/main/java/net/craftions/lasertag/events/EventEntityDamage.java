/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.lasertag.events;

import net.craftions.lasertag.Lasertag;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventEntityDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            e.setDamage(0.0d);
            e.setCancelled(true);
        } else {
            Projectile p = (Projectile) e.getDamager();
            Player s = (Player) p.getShooter();
            if (e.getEntity().getType() == EntityType.PLAYER) {
                s.sendMessage(Lasertag.prefix + "Du hast " + e.getEntity().getName() + " getötet!");
            }
            if (Lasertag.kills.containsKey(s)) {
                Lasertag.kills.put(s, Lasertag.kills.get(s) + 1);
                if (Lasertag.kills.get(s) == 5) {
                    ItemStack shield = new ItemStack(Material.SHIELD);
                    ItemMeta meta = shield.getItemMeta();
                    meta.setDisplayName("§8Schutzwand");
                    shield.setItemMeta(meta);
                    shield.setDurability((short) 1);
                    s.getInventory().addItem(shield);
                }
            }
        }

    }
}
