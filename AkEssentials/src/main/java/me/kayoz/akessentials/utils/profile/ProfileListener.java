package me.kayoz.akessentials.utils.profile;

import me.kayoz.akessentials.AkEssentials;
import me.kayoz.akessentials.utils.ChatUtils;
import me.kayoz.akessentials.utils.Files;
import me.kayoz.akessentials.utils.profile.ores.Ores;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class ProfileListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        
        Player p = e.getPlayer();

        //TODO Check if A profile file exists for player FINISHED
        //TODO If False, Create new Profile file
        //TODO
        
        Files files = new Files();
        ProfileManager pm = AkEssentials.getPm();
        
        if(files.getFile(AkEssentials.getInstance().getDataFolder() + File.separator + "data", p.getUniqueId().toString()).exists()){

            pm.loadProfile(p);
            
        } else {

            pm.createProfile(p);
            
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        Files files = new Files();

        ProfileManager pm = AkEssentials.getPm();

        Profile profile = ProfileManager.getProfile(p);

        pm.saveProfile(p);

    }
}
