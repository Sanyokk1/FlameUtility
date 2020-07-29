package main.flameutility.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("flameutility.god"))
            {
                p.setInvulnerable(true);
            }
            else
            {
                p.sendMessage("Комманда эксклюзивно для админов :)");
            }
        }

        return true;
    }
}
