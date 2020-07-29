package main.flameutility.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.DARK_RED + "Я больше не хочу жить!");
                p.setHealth(0.0);
            }
            else
            {
                System.out.println("Ты головой подумай: как консоль может суициднуться?");
            }

        return true;
    }
}
