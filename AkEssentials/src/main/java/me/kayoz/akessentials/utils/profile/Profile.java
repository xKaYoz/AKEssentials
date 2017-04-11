package me.kayoz.akessentials.utils.profile;

import lombok.Getter;
import me.kayoz.akessentials.utils.profile.ores.Ores;

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

        ProfileManager pm = new ProfileManager();

        pm.register(this);
    }
}
