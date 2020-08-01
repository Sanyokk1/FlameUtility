package main.flameutility.events;

import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class JoinFireWorks implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        World w = p.getWorld();
        Location ploc = p.getLocation();
        e.setJoinMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "Flame" + ChatColor.GOLD + "Craft" + ChatColor.YELLOW + "]" + ChatColor.AQUA + " Рады видеть тебя на сервере, " + ChatColor.GOLD + p.getDisplayName() + ChatColor.AQUA + "!");

        int x = p.getLocation().getBlockX() + 2;
        Location loc1 = new Location(w, x, ploc.getBlockY(), ploc.getBlockZ());

        int x2 = p.getLocation().getBlockX() - 2;
        Location loc2 = new Location(w, x2, ploc.getBlockY(), ploc.getBlockZ());

        int z = p.getLocation().getBlockZ() + 2;
        Location loc3 = new Location(w, ploc.getBlockX(), ploc.getBlockY(), z);

        int z2 = p.getLocation().getBlockZ() - 2;
        Location loc4 = new Location(w, ploc.getBlockX(), ploc.getBlockY(), z2);

        Firework fw = w.spawn(loc1, Firework.class);
        FireworkMeta fwmeta = (FireworkMeta) fw.getFireworkMeta();
        fwmeta.addEffect(FireworkEffect.builder().withColor(Color.ORANGE).withColor(Color.RED).with(Type.BALL_LARGE).withFlicker().withFade(Color.YELLOW).build());
        fwmeta.setPower(2);
        fw.setFireworkMeta(fwmeta);

        Firework fw2 = w.spawn(loc2, Firework.class);
        fw.setFireworkMeta(fwmeta);
        Firework fw3 = w.spawn(loc3, Firework.class);;
        fw.setFireworkMeta(fwmeta);
        Firework fw4 = w.spawn(loc4, Firework.class);
        fw.setFireworkMeta(fwmeta);

    }


}
