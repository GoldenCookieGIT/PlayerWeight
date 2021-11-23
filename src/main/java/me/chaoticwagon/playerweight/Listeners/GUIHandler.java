package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
        Player p = (Player) e.getWhoClicked();
        if (!e.isLeftClick()) return;

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Bossbar")) {

            if (plugin.data.getConfig().getConfigurationSection("Players." + p.getUniqueId().toString() + ".").contains("Bossbar")) {

                if (plugin.data.getConfig().getBoolean("Players." + p.getUniqueId().toString() + ".Bossbar") == true){
                    plugin.data.getConfig().set("Players." + p.getUniqueId().toString() + ".Bossbar", false);
                    plugin.bar.removerPlayer(p);
                }

                plugin.data.getConfig().set("Players." + p.getUniqueId().toString() + ".Bossbar", true);

                e.setCancelled(true);
            }

        }

    }


}
