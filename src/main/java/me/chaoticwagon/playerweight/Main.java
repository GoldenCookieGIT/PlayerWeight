package me.chaoticwagon.playerweight;

import me.chaoticwagon.playerweight.Commands.Reload;
import me.chaoticwagon.playerweight.Commands.getWeight;
import me.chaoticwagon.playerweight.Commands.setItemWeight;
import me.chaoticwagon.playerweight.Commands.setMaxWeight;
import me.chaoticwagon.playerweight.Listeners.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    DataManager data;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.data = new DataManager(this);
        getCommand("playerweight").setExecutor(new Reload(this));
        getCommand("getweight").setExecutor(new getWeight(this));
        getCommand("setitemweight").setExecutor(new setItemWeight(this));
        getCommand("setmaxweight").setExecutor(new setMaxWeight(this));

        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);
        getServer().getPluginManager().registerEvents(new Bucket(this),this);
        getServer().getPluginManager().registerEvents(new EggThrow(this),this);
        getServer().getPluginManager().registerEvents(new InventoryClose(this),this);
        getServer().getPluginManager().registerEvents(new ItemBreak(this),this);
        getServer().getPluginManager().registerEvents(new ItemConsume(this),this);
        getServer().getPluginManager().registerEvents(new ItemPickup(this),this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this),this);
        getServer().getPluginManager().registerEvents(new Respawn(this),this);
        getServer().getPluginManager().registerEvents(new ItemDrop(this),this);
        getServer().getPluginManager().registerEvents(new PlayerWalk(this),this);

        BukkitScheduler scheduler = getServer().getScheduler();
//        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
//            @Override
//            public void run() {
//               for (Player p : getServer().getOnlinePlayers()){
//                   tools.currentWeight.put(p.getUniqueId(),tools.getPlayerWeight(p));
//               }
//            }
//        },0L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public Map<UUID,Integer> currentWeight = new HashMap<UUID,Integer>();
    public Map<UUID,Integer> maxWeight = new HashMap<UUID, Integer>();

    public int getPlayerWeight(Player p){
        int weight = 0;

        for (int slot = 0; slot <= 35; slot++) {
            ItemStack item = p.getInventory().getItem(slot);
            if (item == null || item.getType().isAir()) {
                continue;
            }
            int amount = item.getAmount();
            System.out.println(item.getType().toString());
            System.out.println("Amount" + amount);
            weight = weight + getItemWeight(item, p.getInventory().getItem(slot).getAmount());
        }

        weight = weight + getItemWeight(p.getInventory().getHelmet(), 1) + getItemWeight(p.getInventory().getChestplate(), 1)
                + getItemWeight(p.getInventory().getLeggings(), 1) + getItemWeight(p.getInventory().getBoots(), 1)
                + getItemWeight(p.getInventory().getItemInOffHand(), 1);

        return weight;
    }

    public int getMaxPlayerWeight(Player p) {
        int maxWeight = this.getConfig().getInt("Default-player-weight");
        return maxWeight;
    }

    public int getItemWeight(ItemStack item, int amount){
        int weight;

        if (item == null || item.getType().isAir()) return 0;

        if (this.getConfig().getInt("Custom-weights." + item.getType().toString()) <= 0) {
            weight = this.getConfig().getInt("Default-item-weight");
            weight = weight * amount;
            System.out.println(weight);
            return weight;
        }

        weight = this.getConfig().getInt("Custom-weights." + item.getType().toString());

        weight = weight * amount;
        System.out.println(weight);
        return weight;

    }
    public boolean isInt(Object object){
        if (object instanceof Integer){
            return true;
        } else {
            String string = object.toString();

            try {
                Integer.parseInt(string);
            } catch (Exception e) {
                return false;
            }
        }
        return  true;
    }

    public String getSetting(String path) {
        String setting = getConfig().getConfigurationSection(path).toString();
        return setting;
    }



}
