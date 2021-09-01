package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;

public class EggThrow implements Listener {

    Main plugin;


    public EggThrow(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onThrow(PlayerEggThrowEvent e) {

        Player p = (Player) e.getPlayer();
        ItemStack item = e.getEgg().getItem();

        plugin.currentWeight.put(p.getUniqueId(),plugin.currentWeight.get(p.getUniqueId()) - plugin.getItemWeight(item, 1));

    }
}
