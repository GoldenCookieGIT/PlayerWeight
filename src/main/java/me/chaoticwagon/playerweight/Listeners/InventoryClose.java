package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    Main plugin;

    public InventoryClose(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void invClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        plugin.currentWeight.put(p.getUniqueId(), plugin.getPlayerWeight(p));
    }
}
