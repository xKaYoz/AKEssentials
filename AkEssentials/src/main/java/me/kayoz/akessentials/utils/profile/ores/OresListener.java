package me.kayoz.akessentials.utils.profile.ores;

import me.kayoz.akessentials.utils.profile.Profile;
import me.kayoz.akessentials.utils.profile.ProfileManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class OresListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Profile profile = ProfileManager.getProfile(p);

        if(profile == null) return;
        if(p.getGameMode() == GameMode.CREATIVE) return;

        Ores ore = Ores.getMaterial(e.getBlock().getType());

        if (ore != null) {
            profile.getOres().put(ore, profile.getOres().getOrDefault(ore, 0) + 1);
            p.sendMessage(ore + " " + profile.getOres().get(ore));
        }

    }
}
