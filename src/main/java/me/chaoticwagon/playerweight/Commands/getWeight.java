package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class getWeight implements CommandExecutor {

    Main plugin;
    Tools tools;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 && !(sender instanceof Player)){
            Bukkit.getLogger().log(Level.WARNING, "Console Usage: /getweight <PLAYER>");
            return true;
        }
        Player p = (Player) sender;

        if (args.length == 0){
            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "PlayerWeight" + ChatColor.WHITE + "] " + "Your weight is " +
                    ChatColor.GREEN + plugin.currentWeight + "/" + tools.getMaxPlayerWeight(p));
        }

        if (args[0] == null) {
            p.sendMessage(ChatColor.RED + "Usage: /getweight <PLAYER>");
            return true;
        }

        return true;
    }

}
