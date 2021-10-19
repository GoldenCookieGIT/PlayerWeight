package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIHandler implements Listener {

    Main plugin;

    public GUIHandler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.isLeftClick()) return;

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Bossbar")) {
            
        }

    }


}
