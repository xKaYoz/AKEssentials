package me.kayoz.practice;

import lombok.Getter;
import me.kayoz.practice.users.UserEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Practice extends JavaPlugin {

    @Getter
    private static Practice instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        registerCommands();
        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){

    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new UserEvents(), this);
    }
}
