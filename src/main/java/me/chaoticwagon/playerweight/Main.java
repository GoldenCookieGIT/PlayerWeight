package me.chaoticwagon.playerweight;

import me.chaoticwagon.playerweight.Commands.Reload;
import me.chaoticwagon.playerweight.Commands.getWeight;
import me.chaoticwagon.playerweight.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {

    Tools tools;

    public Main(Tools tools) {
        this.tools = tools;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("playerweight").setExecutor(new Reload(this));
        getCommand("getWeight").setExecutor(new getWeight(this));

        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);
        getServer().getPluginManager().registerEvents(new Bucket(this),this);
        getServer().getPluginManager().registerEvents(new EggThrow(this),this);
        getServer().getPluginManager().registerEvents(new InventoryClose(this),this);
        getServer().getPluginManager().registerEvents(new ItemBreak(this),this);
        getServer().getPluginManager().registerEvents(new ItemConsume(this),this);
        getServer().getPluginManager().registerEvents(new ItemPickup(this),this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this),this);
        getServer().getPluginManager().registerEvents(new Respawn(this),this);

        Server server;
        BukkitScheduler scheduler = getServer().getScheduler();
//        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
//            @Override
//            public void run() {
//               for (Player p : getServer().getOnlinePlayers()){
//                   tools.currentWeight.put(p.getUniqueId(),tools.getPlayerWeight(p));
//               }
//            }
//        },0L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    public int currentWeight = 0;

}
