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
    private Player player;

    public BossBarSetup(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
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

    public void removerPlayer(Player player) {
        bar.removePlayer(player);
    }

    public void cast() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                double max = plugin.getConfig().getDouble("Default-player-weight");
                double current = plugin.currentWeight.get(player.getUniqueId());
                double progress = current / max;
                bar.setProgress(progress);
                bar.setTitle(ChatColor.WHITE + "Weight");
                bar.setColor(BarColor.WHITE);
                
            }
        }, 0, 20);
    }
}
