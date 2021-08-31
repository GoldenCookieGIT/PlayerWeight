package me.chaoticwagon.playerweight;

import me.chaoticwagon.playerweight.Commands.Reload;
import me.chaoticwagon.playerweight.Commands.getWeight;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("playerweight").setExecutor(new Reload(this));
        getCommand("getWeight").setExecutor(new getWeight());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public int currentWeight = 0;

}
