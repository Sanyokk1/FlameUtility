package main.flameutility.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            if(p.hasPermission("flameutility.feed"))
            {
                if(p.getFoodLevel() == 20)
                {
                    p.sendMessage("Ты и так не голоден!");
                }
                p.setFoodLevel(20);
            }
            else{
                p.sendMessage("Комманда эксклюзивно для админов :)");
            }
        }
        else{
            sender.sendMessage("У консоли нет голода :D");
        }

        return true;
    }
}
