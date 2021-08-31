package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Main plugin;
    Tools tools;

    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
    }

    public PlayerJoin(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        tools.currentWeight.put(p.getUniqueId(), tools.getPlayerWeight(p));
        tools.currentWeight.put(p.getUniqueId(), tools.getMaxPlayerWeight(p));
    }



}
