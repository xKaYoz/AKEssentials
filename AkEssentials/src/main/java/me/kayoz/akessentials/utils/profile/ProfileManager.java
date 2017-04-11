package me.kayoz.akessentials.utils.profile;

import org.bukkit.entity.Player;

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

    public void unregister(Profile profile){
        if(profiles.contains(profile)){
            profiles.remove(profile);
        }
    }
}
