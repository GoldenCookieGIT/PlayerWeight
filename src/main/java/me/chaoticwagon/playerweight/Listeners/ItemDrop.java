package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemDrop implements Listener {

    Main plugin;

    public ItemDrop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnDropItem(EntityDropItemEvent e){

        if (!(e.getEntity() instanceof Player))return;

        Player p = (Player) e.getEntity();
        ItemStack item = e.getItemDrop().getItemStack();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(item, item.getAmount()));
        p.sendMessage("Amount: " + item.getAmount());
    }
}
