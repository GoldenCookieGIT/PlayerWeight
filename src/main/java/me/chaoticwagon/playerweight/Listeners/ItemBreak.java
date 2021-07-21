package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ItemBreak implements Listener {

    Main plugin;
    Tools tools;

    public ItemBreak(Main plugin) {
        this.plugin = plugin;
    }

    public ItemBreak(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent e){

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getBrokenItem();

        plugin.currentWeight = plugin.currentWeight - tools.getItemWeight(item, 1);

    }
}
