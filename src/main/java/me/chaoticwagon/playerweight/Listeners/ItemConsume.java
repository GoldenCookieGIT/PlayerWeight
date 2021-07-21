package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class ItemConsume implements Listener {

    Main plugin;
    Tools tools;

    public ItemConsume(Main plugin) {
        this.plugin = plugin;
    }

    public ItemConsume(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){

        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        plugin.currentWeight = plugin.currentWeight - tools.getItemWeight(item, 1);

    }
}
