package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

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
                sender.sendMessage(ChatColor.RED + "Usage: /playerweight <>");
                return true;
            }
            Bukkit.getLogger().log(Level.SEVERE, "Usage: /playerweight <>");
            return true;
        }

        if (args[0].equals("reload")){
            plugin.reloadConfig();
            return true;
        }

        if (args[0].equals("settings")) {
            if (!(sender instanceof Player)) return true;
            Player p = (Player) sender;

            Inventory settings = Bukkit.createInventory(p,54, ChatColor.RED + "" + ChatColor.BOLD + "Settings");
            

            p.openInventory(settings);
            return true;
        }

        return true;
    }
}
