package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Main plugin;

    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        plugin.currentWeight.put(p.getUniqueId(), plugin.getPlayerWeight(p));
        plugin.maxWeight.put(p.getUniqueId(), plugin.getMaxPlayerWeight(p));

        if (!plugin.data.getConfig().getConfigurationSection("Players.").contains(p.getUniqueId().toString())) {
            plugin.data.getConfig().set("Players.", p.getUniqueId().toString());
            plugin.data.getConfig().set("Players." + p.getUniqueId().toString() + ".BossBar", true);

        }

    }



}
