package me.chaoticwagon.playerweight;

import me.chaoticwagon.playerweight.Commands.Reload;
import me.chaoticwagon.playerweight.Commands.getWeight;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("playerweight").setExecutor(new Reload(this));
        getCommand("getWeight").setExecutor(new getWeight());

        Server server;
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleAsyncRepeatingTask()
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    public int currentWeight = 0;

}
