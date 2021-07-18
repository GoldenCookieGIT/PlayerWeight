package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class Reload implements CommandExecutor {

    Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length != 1) {
            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.RED + "Usage: /playerweight reload");
                return true;
            }
            Bukkit.getLogger().log(Level.SEVERE, "Usage: /playerweight reload");
            return true;
        }

        plugin.reloadConfig();

        return true;
    }
}
