package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.annotation.Target;
import java.util.logging.Level;

public class getWeight implements CommandExecutor {

    Main plugin;
    Tools tools;

    public getWeight(Main plugin) {
        this.plugin = plugin;
    }

    public getWeight(Tools tools) {
        this.tools = tools;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 && !(sender instanceof Player)){
            Bukkit.getLogger().log(Level.WARNING, "Console Usage: /getweight <PLAYER>");
            return true;
        }
        Player p = (Player) sender;

        if (args.length == 0){
            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "PlayerWeight" + ChatColor.WHITE + "] " + "Your weight is " +
                    ChatColor.GREEN + tools.currentWeight.get(p.getUniqueId()).toString() + "/" +
                    tools.maxWeight.get(p.getUniqueId()).toString());
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) return true;

        if (Bukkit.getServer().getOnlinePlayers().contains(target) && p.hasPermission("playerweight.veiwplayerweight")) {
            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "PlayerWeight" + ChatColor.WHITE + "] " + target.getDisplayName() + "'s weight is " +
                    ChatColor.GREEN + tools.currentWeight.get(target.getUniqueId()).toString() + "/" + tools.maxWeight.get(target.getUniqueId()).toString());
            return true;
        }

        return true;
    }

}
