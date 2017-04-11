package me.kayoz.akessentials.utils.profile;

import me.kayoz.akessentials.AkEssentials;
import me.kayoz.akessentials.utils.ChatUtils;
import me.kayoz.akessentials.utils.Files;
import me.kayoz.akessentials.utils.profile.ores.Ores;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class ProfileManager {

    private static List<Profile> profiles = new ArrayList<>();

    public static List<Profile> getProfiles(){
        return profiles;
    }

    public static Profile getProfile(Player p){
        if(p == null){
            return null;
        }

        for(Profile profile : getProfiles()){
            if(profile.getUuid().equals(p.getUniqueId())){
                return profile;
            }
        }
        return null;
    }

    public void register(Profile profile){
        if(!profiles.contains(profile)){
            profiles.add(profile);
        }
    }

    public void saveProfile(Player p){

        Files files = new Files();
        YamlConfiguration config = files.getConfig(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString());
        ProfileManager pm = AkEssentials.getPm();

        Profile profile = getProfile(p);

        if(profile == null) return;

        config.set("Ores.COAL", profile.getOres().getOrDefault(Ores.COAL, 0));
        config.set("Ores.IRON", profile.getOres().getOrDefault(Ores.IRON, 0));
        config.set("Ores.GOLD", profile.getOres().getOrDefault(Ores.GOLD, 0));
        config.set("Ores.REDSTONE", profile.getOres().getOrDefault(Ores.REDSTONE, 0));
        config.set("Ores.LAPIS", profile.getOres().getOrDefault(Ores.LAPIS, 0));
        config.set("Ores.QUARTZ", profile.getOres().getOrDefault(Ores.QUARTZ, 0));
        config.set("Ores.EMERALD", profile.getOres().getOrDefault(Ores.EMERALD, 0));
        config.set("Ores.DIAMOND", profile.getOres().getOrDefault(Ores.DIAMOND, 0));

        pm.unregister(getProfile(p));

        try {
            config.save(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadProfile(Player p){

        Files files = new Files();
        ProfileManager pm = AkEssentials.getPm();

        if(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()).exists()) {

            p.sendMessage(ChatUtils.format("&cWe are loading your profile for you."));

            YamlConfiguration config = files.getConfig(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString());

            Profile profile = new Profile(p.getUniqueId(), p.getName());

            profile.getOres().put(Ores.COAL, config.getInt("Ores.COAL"));
            profile.getOres().put(Ores.IRON, config.getInt("Ores.IRON"));
            profile.getOres().put(Ores.GOLD, config.getInt("Ores.GOLD"));
            profile.getOres().put(Ores.REDSTONE, config.getInt("Ores.REDSTONE"));
            profile.getOres().put(Ores.LAPIS, config.getInt("Ores.LAPIS"));
            profile.getOres().put(Ores.QUARTZ, config.getInt("Ores.QUARTZ"));
            profile.getOres().put(Ores.EMERALD, config.getInt("Ores.EMERALD"));
            profile.getOres().put(Ores.DIAMOND, config.getInt("Ores.DIAMOND"));

            config.set("Username", p.getName());

            try {
                config.save(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            pm.register(profile);

            p.sendMessage(ChatUtils.format("&aYour profile has been loaded!"));
        } else {
            createProfile(p);
        }

    }

    public void createProfile(Player p){

        Files files = new Files();
        ProfileManager pm = AkEssentials.getPm();

        if(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()).exists()) return;

        files.createNewFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString());

        YamlConfiguration config = files.getConfig(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString());

        config.set("Username", p.getName());
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
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Profile profile = new Profile(p.getUniqueId(), p.getName());

        pm.register(profile);

        p.sendMessage(ChatUtils.format("&aA new profile has been created for you!"));

    }

    public void unregister(Profile profile){
        if(profiles.contains(profile)){
            profiles.remove(profile);
        }
    }
}
