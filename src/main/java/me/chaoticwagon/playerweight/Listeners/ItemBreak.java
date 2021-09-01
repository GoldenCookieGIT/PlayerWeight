package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ItemBreak implements Listener {

    Main plugin;

    public ItemBreak(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent e){

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getBrokenItem();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(item, 1));

    }
}
