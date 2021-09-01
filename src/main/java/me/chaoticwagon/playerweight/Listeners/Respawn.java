package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener {

    Main plugin;

    public Respawn(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = (Player) e.getPlayer();
        plugin.currentWeight.put(p.getUniqueId(), plugin.getPlayerWeight(p));
    }
}
