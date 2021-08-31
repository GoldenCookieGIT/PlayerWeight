package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileLaunch implements Listener {

    Main plugin;
    Tools tools;

    public ProjectileLaunch(Main plugin) {
        this.plugin = plugin;
    }

    public ProjectileLaunch(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void onProjectile(ProjectileLaunchEvent e){

        if (!(e.getEntity().getShooter() instanceof Player)) return;

        Player p = (Player) e.getEntity().getShooter();

        tools.currentWeight.put(p.getUniqueId(), tools.getPlayerWeight(p));

    }
}
