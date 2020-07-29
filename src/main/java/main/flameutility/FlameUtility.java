package main.flameutility;

import main.flameutility.commands.Feed;
import main.flameutility.commands.God;
import main.flameutility.commands.Suicide;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlameUtility extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if(getConfig().getBoolean("suicide.enabled")) {
            getCommand("suicide").setExecutor(new Suicide());
        }
        if(getConfig().getBoolean("god.enabled")) {
            getCommand("god").setExecutor(new God());
        }
        if(getConfig().getBoolean("feed.enabled")) {
            getCommand("feed").setExecutor(new Feed());
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
