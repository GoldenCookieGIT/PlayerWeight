package me.chaoticwagon.playerweight;

import me.chaoticwagon.playerweight.Commands.Reload;
import me.chaoticwagon.playerweight.Commands.getWeight;
import me.chaoticwagon.playerweight.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("playerweight").setExecutor(new Reload(this));
        getCommand("getweight").setExecutor(new getWeight(this));

        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);
        getServer().getPluginManager().registerEvents(new Bucket(this),this);
        getServer().getPluginManager().registerEvents(new EggThrow(this),this);
        getServer().getPluginManager().registerEvents(new InventoryClose(this),this);
        getServer().getPluginManager().registerEvents(new ItemBreak(this),this);
        getServer().getPluginManager().registerEvents(new ItemConsume(this),this);
        getServer().getPluginManager().registerEvents(new ItemPickup(this),this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this),this);
        getServer().getPluginManager().registerEvents(new Respawn(this),this);

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
            if (item != null || item.getType() != Material.AIR) {
                int amount = item.getAmount();
                weight = weight + getItemWeight(item, p.getInventory().getItem(slot).getAmount());
            }

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

        try{
            weight = this.getConfig().getInt("Custom-weights." + item.getType().toString());
        }catch(Exception e){
            weight = this.getConfig().getInt("Default-item-weight");
        }

        return weight * amount;
    }

}
