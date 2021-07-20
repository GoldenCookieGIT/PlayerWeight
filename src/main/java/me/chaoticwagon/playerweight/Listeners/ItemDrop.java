package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemDrop implements Listener {

    Main plugin;
    Tools tools;

    public ItemDrop(Main plugin) {
        this.plugin = plugin;
    }

    public ItemDrop(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void OnDropItem(PlayerDropItemEvent e){

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        int itemAmount = item.getAmount();

        plugin.currentWeight = plugin.currentWeight - tools.getItemWeight(item, itemAmount);

    }
}
