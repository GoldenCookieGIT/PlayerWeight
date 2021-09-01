package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemPickup implements Listener {

    Main plugin;

    public ItemPickup(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pickup(EntityPickupItemEvent e){

        if (!e.getEntity().getType().equals(EntityType.PLAYER)) return;

        ItemStack item = e.getItem().getItemStack();
        int amount = item.getAmount();
        Player p = (Player) e.getEntity();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) + plugin.getItemWeight(item, 1));


    }


}
