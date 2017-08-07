package me.kayoz.akessentials.utils.profile;

import lombok.Getter;
import me.kayoz.akessentials.AkEssentials;
import me.kayoz.akessentials.utils.Files;
import me.kayoz.akessentials.utils.profile.ores.Ores;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Profile {

    @Getter public final UUID uuid;
    @Getter public final String name;
    @Getter private final Map<Ores, Integer> ores;

    public Profile(UUID uuid, String name){
        this.uuid = uuid;
        this.name = name;
        this.ores = new HashMap<>();

        ProfileManager pm = AkEssentials.getPm();

        pm.register(this);
    }
    
    public void resetOres(){
        Player p = Bukkit.getPlayer(uuid);
        Files files = new Files();
        YamlConfiguration config = files.getConfig(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString());

        config.set("Ores.COAL", 0);
        config.set("Ores.IRON", 0);
        config.set("Ores.GOLD", 0);
        config.set("Ores.REDSTONE", 0);
        config.set("Ores.LAPIS", 0);
        config.set("Ores.QUARTZ", 0);
        config.set("Ores.EMERALD", 0);
        config.set("Ores.DIAMOND", 0);

        try {
            config.save(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        getOres().put(Ores.COAL, config.getInt("Ores.COAL"));
        getOres().put(Ores.IRON, config.getInt("Ores.IRON"));
        getOres().put(Ores.GOLD, config.getInt("Ores.GOLD"));
        getOres().put(Ores.REDSTONE, config.getInt("Ores.REDSTONE"));
        getOres().put(Ores.LAPIS, config.getInt("Ores.LAPIS"));
        getOres().put(Ores.QUARTZ, config.getInt("Ores.QUARTZ"));
        getOres().put(Ores.EMERALD, config.getInt("Ores.EMERALD"));
        getOres().put(Ores.DIAMOND, config.getInt("Ores.DIAMOND"));
    }
}
