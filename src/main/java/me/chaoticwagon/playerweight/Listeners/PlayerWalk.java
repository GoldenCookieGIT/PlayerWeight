package me.chaoticwagon.playerweight.Listeners;

import me.chaoticwagon.playerweight.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerWalk implements Listener {

    Main plugin;

    public PlayerWalk(Main plugin)                                   {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerWalk(PlayerMoveEvent e) {

        Player p = e.getPlayer();

        float speed;
        int currentWeight = plugin.currentWeight.get(p.getUniqueId());
        int maxWeight = plugin.maxWeight.get(p.getUniqueId());
        int decreaseStart = plugin.getConfig().getInt("Speed-decrease-start");
        int maxDecrease = plugin.getConfig().getInt("Maximum-speed-decrease");

        //subtract the decreaseStart from the max weight and current weight, then divide the 2 values

        if (decreaseStart <= -1) return;
        if (maxDecrease <= 0) return;
        if (currentWeight <= 0) return;
        if (currentWeight - decreaseStart <= 0) return;

        //the percentage that the player is over their max weight
       float overDecreaseStart = ((float) currentWeight - (float) decreaseStart) / ((float) maxWeight - (float) decreaseStart);

       if (overDecreaseStart * 100 > maxDecrease) {
           speed = (float) maxDecrease / 100;
           p.setWalkSpeed(.2F / speed);
           return;
       }

       speed = .2F / overDecreaseStart;
       p.setWalkSpeed(speed);

    }

}
