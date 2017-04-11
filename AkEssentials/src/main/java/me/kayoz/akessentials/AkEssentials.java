package me.kayoz.akessentials;

import me.kayoz.akessentials.commands.FlyCommand;
import me.kayoz.akessentials.commands.MessageCommand;
import me.kayoz.akessentials.commands.TpCommand;
import me.kayoz.akessentials.events.JoinEvent;
import me.kayoz.akessentials.events.QuitEvent;
import me.kayoz.akessentials.utils.profile.ProfileListener;
import me.kayoz.akessentials.utils.profile.ores.OresListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AkEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinEvent(), this);
        pm.registerEvents(new QuitEvent(), this);
        pm.registerEvents(new ProfileListener(), this);
        pm.registerEvents(new OresListener(), this);
    }

    private void registerCommands() {
        this.getCommand("message").setExecutor(new MessageCommand());
        this.getCommand("tp").setExecutor(new TpCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
    }
}
