package me.kayoz.bedwars;

import lombok.Getter;
import me.kayoz.bedwars.commands.BedwarsCommand;
import me.kayoz.bedwars.utils.Generator;
import me.kayoz.bedwars.utils.Map;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars extends JavaPlugin {

    @Getter
    private static Bedwars instance;

    @Override
    public void onEnable() {
        this.getCommand("bw").setExecutor(new BedwarsCommand());
        instance = this;

        ConfigurationSerialization.registerClass(Map.class);
        ConfigurationSerialization.registerClass(Generator.class);

    }

    @Override
    public void onDisable() {

    }
}
