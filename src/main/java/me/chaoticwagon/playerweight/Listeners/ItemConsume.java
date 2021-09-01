package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class ItemConsume implements Listener {

    Main plugin;

    public ItemConsume(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){

        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(item, 1));

    }
}
