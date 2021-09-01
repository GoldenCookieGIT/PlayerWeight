package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {

    Main plugin;

    public BlockPlace(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();
        ItemStack block = new ItemStack(e.getBlockPlaced().getType());

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(block, 1));

    }
}
