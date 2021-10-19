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
            ItemStack bossbar = new ItemStack(Material.DRAGON_HEAD);
            ItemMeta bossbarM = bossbar.getItemMeta();
            bossbarM.setDisplayName("Show BossBar");
            bossbar.setItemMeta(bossbarM);

            ItemStack bossGlass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta bossGlassM = bossGlass.getItemMeta();



            ItemStack chatDis = new ItemStack(Material.NAME_TAG);
            ItemMeta chatDisM = chatDis.getItemMeta();
            chatDisM.setDisplayName("Chat Log");

            settings.setItem(1,chatDis);
            settings.setItem(0, bossbar);
            p.openInventory(settings);
            return true;
        }

        return true;
    }
}
