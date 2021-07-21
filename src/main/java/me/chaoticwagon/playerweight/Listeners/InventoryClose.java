package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    Main plugin;
    Tools tools;

    public InventoryClose(Main plugin) {
        this.plugin = plugin;
    }

    public InventoryClose(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void invClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        plugin.currentWeight = tools.getPlayerWeight(p);
    }
}
