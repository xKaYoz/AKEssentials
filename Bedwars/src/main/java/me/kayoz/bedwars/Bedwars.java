package me.kayoz.bedwars;

import lombok.Getter;
import me.kayoz.bedwars.commands.BedwarsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars extends JavaPlugin {

    @Getter
    private static Bedwars instance;

    @Override
    public void onEnable() {
        this.getCommand("bw").setExecutor(new BedwarsCommand());
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
