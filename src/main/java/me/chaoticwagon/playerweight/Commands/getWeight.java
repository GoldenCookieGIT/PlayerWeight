package me.chaoticwagon.playerweight.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class getWeight implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 && !(sender instanceof Player)){
            Bukkit.getLogger().log(Level.WARNING, "Console Usage: /getweight <PLAYER>");
            return true;
        }
        Player p = (Player) sender;

        if (args.length == 0){
            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "PlayerWeight" + ChatColor.WHITE + "] " + "Your weight");
        }

        

        return true;
    }

}
