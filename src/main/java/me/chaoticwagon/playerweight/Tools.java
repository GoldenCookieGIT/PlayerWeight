package me.chaoticwagon.playerweight;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Tools {

    Main plugin;

    public Tools(Main plugin) {
        this.plugin = plugin;
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
        int maxWeight = plugin.getConfig().getInt("Default-player-weight");
        return maxWeight;
    }

    public int getItemWeight(ItemStack item, int amount){
        int weight;

        try{
            weight = plugin.getConfig().getInt("Custom-weights." + item.getType().toString());
        }catch(Exception e){
            weight = plugin.getConfig().getInt("Default-item-weight");
        }

        return weight * amount;
    }

}
