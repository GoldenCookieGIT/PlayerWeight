package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import me.chaoticwagon.playerweight.Tools;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

public class Bucket implements Listener {

    Main plugin;
    Tools tools;

    public Bucket(Main plugin) {
        this.plugin = plugin;
    }

    public Bucket(Tools tools) {
        this.tools = tools;
    }

    @EventHandler
    public void bucketFill(PlayerBucketFillEvent e){
        ItemStack newBucket = e.getItemStack();
        ItemStack oldBucket = new ItemStack(e.getBucket());
        Player p = e.getPlayer();

        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) - tools.getItemWeight(oldBucket, 1));
        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) + tools.getItemWeight(newBucket, 1));
    }

    @EventHandler
    public void bucketEmpty(PlayerBucketEmptyEvent e){
        ItemStack newBucket = e.getItemStack();
        ItemStack oldBucket = new ItemStack(e.getBucket());
        Player p = e.getPlayer();


        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) - tools.getItemWeight(oldBucket, 1));
        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) + tools.getItemWeight(newBucket, 1));
    }

    @EventHandler
    public void bucketEntity(PlayerBucketEntityEvent e){
        ItemStack newBucket = e.getEntityBucket();
        ItemStack oldBucket = new ItemStack(e.getOriginalBucket());
        Player p = e.getPlayer();

        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) - tools.getItemWeight(oldBucket, 1));
        tools.currentWeight.put(p.getUniqueId(),tools.currentWeight.get(p.getUniqueId()) + tools.getItemWeight(newBucket, 1));
    }
}
