package me.kayoz.akessentials.utils;

import org.bukkit.ChatColor;

/**
 * Created by KaYoz on 3/29/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class ChatUtils {

    public static String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String formatWithPrefix(String msg){
        return ChatColor.translateAlternateColorCodes('&', "&9Essentials &8» &e" + msg);
    }
}
