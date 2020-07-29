package main.flameutility.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ungod implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("flameutility.god"))
            {
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.DARK_RED + "Теперь ты снова будешь получать урон!");
            }
            else
            {
                p.sendMessage("Команда эксклюзивно для админов :)");
            }
        }

        return true;
    }
}
