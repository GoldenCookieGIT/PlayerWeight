package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {

    Main plugin;
    Tools tools;

    public BlockPlace(Main plugin) {
        this.plugin = plugin;
    }

    public BlockPlace(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();
        ItemStack block = new ItemStack(e.getBlockPlaced().getType());

        plugin.currentWeight = plugin.currentWeight - tools.getItemWeight(block, 1);

    }
}
