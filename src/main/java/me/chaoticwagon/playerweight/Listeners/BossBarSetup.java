package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarSetup {

    private int taskID = -1;
    private final Main plugin;
    private BossBar bar;

    public BossBarSetup(Main plugin) {
        this.plugin = plugin;
    }

    public void addPlayer(Player player) {
        bar.addPlayer(player);
    }

    public BossBar getBar() {
        return bar;
    }

    public void createBar() {
        bar = Bukkit.createBossBar(ChatColor.GREEN + "Weight", BarColor.WHITE, BarStyle.SOLID);
    }

    public void cast() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            int count = 1;
            double progress = 1.0;
            double time = 1.0/(30);

            @Override
            public void run() {

            }
        }, 0, 20);
    }
}
