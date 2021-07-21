package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;

public class EggThrow implements Listener {

    Main plugin;
    Tools tools;

    public EggThrow(Main plugin) {
        this.plugin = plugin;
    }

    public EggThrow(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onThrow(PlayerEggThrowEvent e) {

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getEgg().getItem();

        plugin.currentWeight = plugin.currentWeight - tools.getItemWeight(item,1);

    }
}
