package main.flameutility;

import main.flameutility.commands.*;
import main.flameutility.events.Join;
import main.flameutility.events.Leave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

//!TODO: Приветствие феерверками

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

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info(ANSI_RED + "FlameUtility Enabled" + ANSI_RESET);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if(getConfig().getBoolean("suicide.enabled")) {
            getCommand("suicide").setExecutor(new Suicide());
            log.info(ANSI_YELLOW + "Suicide Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("god.enabled")) {
            getCommand("god").setExecutor(new God());
            getCommand("ungod").setExecutor(new Ungod());
            log.info(ANSI_YELLOW + "Godmode Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("feed.enabled")) {
            getCommand("feed").setExecutor(new Feed());
            log.info(ANSI_YELLOW + "Feed Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("ttk.enabled")){
            getCommand("ttk").setExecutor(new ThirtyTwoK());
            log.info(ANSI_YELLOW + "32K Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("JoinLeave.join-enabled")){
            getServer().getPluginManager().registerEvents(new Join(), this);
            log.info(ANSI_YELLOW + "JL Join Enabled" + ANSI_RESET);
        }
        if(getConfig().getBoolean("JoinLeave.leave-enabled")){
            log.info(ANSI_YELLOW + "JL Leave Enabled" + ANSI_RESET);
            getServer().getPluginManager().registerEvents(new Leave(), this);
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("fu reload")){
            reloadConfig();
        }

        return true;
    }
}
