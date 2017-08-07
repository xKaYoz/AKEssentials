package me.kayoz.akessentials;

import lombok.Getter;
import me.kayoz.akessentials.commands.*;
import me.kayoz.akessentials.events.JoinEvent;
import me.kayoz.akessentials.events.QuitEvent;
import me.kayoz.akessentials.utils.profile.ProfileListener;
import me.kayoz.akessentials.utils.profile.ProfileManager;
import me.kayoz.akessentials.utils.profile.ores.OresListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AkEssentials extends JavaPlugin {

    @Getter public static ProfileManager pm;
    @Getter public static AkEssentials instance;

    @Override
    public void onEnable() {
        pm = new ProfileManager();
        instance = this;
        registerCommands();
        registerListeners();

        for(Player p : Bukkit.getOnlinePlayers()){
            pm.loadProfile(p);
            instance.getLogger().info("Loading profile for " + p.getName());
        }

        instance.getLogger().info("Profiles for all players have been loaded");

    }

    @Override
    public void onDisable() {

        for(Player p : Bukkit.getOnlinePlayers()){
            pm.saveProfile(p);
            instance.getLogger().info("Saving profile for " + p.getName());
        }

        instance.getLogger().info("Profiles for all players have been saved");

        pm = null;
        instance = null;
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
        this.getCommand("ores").setExecutor(new OresCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
        this.getCommand("sudo").setExecutor(new SudoCommand());
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
        this.getCommand("delhome").setExecutor(new DeleteHomeCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
    }
}
