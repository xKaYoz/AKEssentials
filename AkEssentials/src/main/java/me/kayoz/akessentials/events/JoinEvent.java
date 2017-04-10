package me.kayoz.akessentials.events;

import me.kayoz.akessentials.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by KaYoz on 3/29/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class JoinEvent implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(!p.hasPlayedBefore()){
            e.setJoinMessage(ChatUtils.format("&8[&a+&8] &7" + p.getDisplayName() + " &6has joined the server for the first time!."));
            return;
        }

        e.setJoinMessage(ChatUtils.format("&8[&a+&8] &7" + p.getDisplayName() + " &7has joined the server."));
    }
}
