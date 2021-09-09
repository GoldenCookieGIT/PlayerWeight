package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setMaxWeight implements CommandExecutor {

    Main plugin;

    public setMaxWeight(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            System.out.println("Sorry, this is not a console command.");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("playerweight.setmaxweight")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }

        if (args.length != 1) {
            p.sendMessage(ChatColor.RED + "USAGE: /setmaxweight <INTEGER>");
            return true;
        }

        if (!plugin.isInt(args[0])) {
            p.sendMessage(ChatColor.RED + "The argument entered is not an Integer. USAGE: /setmaxweight <INTEGER>");
            return true;
        }

        plugin.getConfig().set("Default-player-weight", args[0]);
        p.sendMessage(ChatColor.GREEN + "The maximum player weight is now set to " + args[0] + ". Reload the config!");
        return true;
    }
}
