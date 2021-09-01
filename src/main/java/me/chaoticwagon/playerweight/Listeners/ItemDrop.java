package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemDrop implements Listener {

    Main plugin;

    public ItemDrop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnDropItem(PlayerDropItemEvent e){

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        int itemAmount = item.getAmount();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(item, 1));

    }
}
