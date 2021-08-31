package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener {

    Main plugin;
    Tools tools;

    public Respawn(Main plugin) {
        this.plugin = plugin;
    }

    public Respawn(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = (Player) e.getPlayer();
        tools.currentWeight.put(p.getUniqueId(), tools.getPlayerWeight(p));
    }
}
