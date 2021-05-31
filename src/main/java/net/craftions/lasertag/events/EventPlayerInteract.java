/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.lasertag.events;

import net.craftions.lasertag.Lasertag;
import net.minecraft.server.v1_16_R3.PacketPlayOutEntityDestroy;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventPlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        try {
            if (e.getAction().equals(Action.LEFT_CLICK_AIR)) {
                if(!e.getPlayer().hasCooldown(Material.IRON_HOE)){
                    if(e.getItem().getType().equals(Material.IRON_HOE)){
                        Arrow a = e.getPlayer().launchProjectile(Arrow.class);
                        a.setShooter(e.getPlayer());
                        a.setGravity(false);
                        a.setDamage(3.5);
                        for(Player p : Bukkit.getOnlinePlayers()){
                            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(a.getEntityId()));
                        }
                        int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lasertag.plugin, new Runnable() {
                            @Override
                            public void run() {
                                Particle.DustOptions dust = new Particle.DustOptions(
                                        Color.fromRGB((int) 255, (int) 0, (int) 0), 1);
                                a.getLocation().getWorld().spawnParticle(Particle.REDSTONE, a.getLocation(), 0, 0, 0, 0, dust);
                            }
                        }, 0L, 1L);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Lasertag.plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getScheduler().cancelTask(id);
                                a.remove();
                            }
                        }, 2*20L);
                    }
                }
            }
        }catch (NullPointerException ex){

        }
    }
}
