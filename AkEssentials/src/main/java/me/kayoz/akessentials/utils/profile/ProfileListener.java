package me.kayoz.akessentials.utils.profile;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class ProfileListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        ProfileManager pm = new ProfileManager();

        Profile profile = new Profile(e.getPlayer().getUniqueId(), e.getPlayer().getName());
        pm.register(profile);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        ProfileManager pm = new ProfileManager();

        Profile profile = ProfileManager.getProfile(e.getPlayer());

        if(profile != null){
            pm.unregister(ProfileManager.getProfile(e.getPlayer()));
        }
    }
}
