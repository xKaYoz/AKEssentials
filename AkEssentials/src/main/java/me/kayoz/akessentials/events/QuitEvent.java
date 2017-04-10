package me.kayoz.akessentials.events;

import me.kayoz.akessentials.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by KaYoz on 3/29/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage(ChatUtils.format("&8[&c-&8] &7" + p.getDisplayName() + " &7has left the server."));
    }

}
