package main.flameutility.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "Flame" + ChatColor.GOLD + "Craft" + ChatColor.YELLOW + "]" + ChatColor.AQUA + " До свидания, " + ChatColor.GOLD + p.getDisplayName() + ChatColor.AQUA + "! Заглядывай к нам ещё!");
    }


}
