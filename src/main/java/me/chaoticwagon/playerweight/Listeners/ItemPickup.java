package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemPickup implements Listener {

    Main plugin;
    Tools tools;

    public ItemPickup(Main plugin) {
        this.plugin = plugin;
    }

    public ItemPickup(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void pickup(EntityPickupItemEvent e){

        if (!e.getEntity().getType().equals(EntityType.PLAYER)) return;

        ItemStack item = e.getItem().getItemStack();
        int amount = item.getAmount();
        Player p = (Player) e.getEntity();

        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) + tools.getItemWeight(item, 1));


    }


}
