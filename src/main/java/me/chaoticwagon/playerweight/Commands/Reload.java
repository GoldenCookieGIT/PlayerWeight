package me.chaoticwagon.playerweight.Commands;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

            Inventory settings = Bukkit.createInventory(p,14, ChatColor.RED + "" + ChatColor.BOLD + "Settings");

            Material type;
            ItemStack bossBar = new ItemStack(Material.DRAGON_HEAD);
            ItemMeta bossBarM = bossBar.getItemMeta();
            bossBarM.setDisplayName("Show BossBar");
            bossBar.setItemMeta(bossBarM);

            ItemStack glass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta glassM = glass.getItemMeta();
            glassM.setDisplayName("ON");
            glass.setItemMeta(glassM);

            ItemStack glass2 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta glass2M = glass2.getItemMeta();
            glass2M.setDisplayName("OFF");
            glass2.setItemMeta(glass2M);

            ItemStack chatDis = new ItemStack(Material.NAME_TAG);
            ItemMeta chatDisM = chatDis.getItemMeta();
            chatDisM.setDisplayName("Chat Log");

            settings.setItem(1,chatDis);
            settings.setItem(0, bossBar);

            if (plugin.getConfig().getBoolean("Players." + p.getUniqueId().toString() + ".BossBar")) {
                settings.setItem(9, glass);
            } else {
                settings.setItem(9, glass2);
            }

            if (plugin.getConfig().getBoolean("Players." + p.getUniqueId().toString() + ".ChatLog")) {
                settings.setItem(10, glass);
            } else {
                settings.setItem(10, glass2);
            }

            p.openInventory(settings);
        }

        return true;
    }
}
