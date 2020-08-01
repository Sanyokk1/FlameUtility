package main.flameutility;

import main.flameutility.commands.*;
import main.flameutility.events.Join;
import main.flameutility.events.JoinFireWorks;
import main.flameutility.events.Leave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FlameUtility extends JavaPlugin {

    private static Logger log = Logger.getLogger(FlameUtility.class.getName());

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String FlutPrefix = ANSI_CYAN + "[" + ANSI_RED + "Flame" + ANSI_YELLOW + "Craft" + ANSI_CYAN + "]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info(FlutPrefix + ANSI_RED + "FlameUtility Enabled" + ANSI_RESET);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if(getConfig().getBoolean("suicide.enabled")) {
            getCommand("suicide").setExecutor(new Suicide());
            log.info(FlutPrefix + ANSI_YELLOW + "Suicide Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("god.enabled")) {
            getCommand("god").setExecutor(new God());
            getCommand("ungod").setExecutor(new Ungod());
            log.info(FlutPrefix + ANSI_YELLOW + "Godmode Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("feed.enabled")) {
            getCommand("feed").setExecutor(new Feed());
            log.info(FlutPrefix + ANSI_YELLOW + "Feed Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("JoinLeave.join-enabled")){
            getServer().getPluginManager().registerEvents(new Join(), this);
            log.info(FlutPrefix + ANSI_YELLOW + "JL Join Enabled" + ANSI_RESET);
        }
        else if(getConfig().getBoolean("JoinLeave.join-with-fireworks")){
            getServer().getPluginManager().registerEvents(new JoinFireWorks(), this);
        }
        if(getConfig().getBoolean("JoinLeave.leave-enabled")){
            log.info(FlutPrefix + ANSI_YELLOW + "JL Leave Enabled" + ANSI_RESET);
            getServer().getPluginManager().registerEvents(new Leave(), this);
        }
        getCommand("fu reload");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info(FlutPrefix + "Thanks for using Flame Utility!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("fu reload")) {
            if (sender.hasPermission("flameutility.reload")) {
                reloadConfig();
            }
            else{
                sender.sendMessage("Недостаточно прав для перезагрузки конфига.");
            }
        }

        return true;
    }
}
