package me.chaoticwagon.playerweight;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class tools {

    Main plugin;

    public tools(Main plugin) {
        this.plugin = plugin;
    }

    public int getPlayerWeight(Player p){
        int weight;

        for (slot)


        return weight;
    }

    public int getMaxPlayerWeight(Player p) {
        int maxWeight = plugin.getConfig().getInt("Default-player-weight");
        return maxWeight;
    }

    public int getItemWeight(ItemStack item){
        Integer weight;

        plugin.getConfig().getConfigurationSection("Custom-weights").getKeys(false).forEach(key -> {
            if (key.equalsIgnoreCase(item.getType().toString())) {
                try{
                    weight = plugin.getConfig().getInt("Custom-weights." + key);
                }catch(Exception e){
                    weight = plugin.getConfig().getInt("Default-item-weight");
                }
            }

        });

        weight = plugin.getConfig().getInt("Default-item-weight");

        return weight;
    }

}
