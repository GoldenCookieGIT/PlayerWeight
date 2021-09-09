package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class setItemWeight implements CommandExecutor {

    Main plugin;

    public setItemWeight(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("This is not a console command!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("playerweight.setitemweight")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }

        if (args.length != 1) {
            p.sendMessage(ChatColor.RED + "USAGE: /setitemweight <INTEGER>");
            return true;
        }

        if (!plugin.isInt(args[0])) {
        p.sendMessage(ChatColor.RED + "The argument entered is not an integer. USAGE: /setitemweight <INTEGER>");
        return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        String itemName = item.getType().toString();

        plugin.getConfig().set("Custom-weights." + itemName, args[0]);
        p.sendMessage(ChatColor.GREEN + "" + itemName + " was set to " + args[0].toString() + " weight in the config.");

        return true;
    }

}
