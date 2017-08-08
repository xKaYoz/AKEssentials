package me.kayoz.bedwars.utils.users;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by KaYoz on 8/7/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class UserManager {

    private static ArrayList<User> users = new ArrayList<>();

    public static User getUser(Player p){
        for(User u : users){
            if(u.getPlayer() == p){
                return u;
            }
        }
        return null;
    }

    public static void register(User u){
        if(!users.contains(u)){
            users.add(u);
        }
    }

    public static void unregister(User u){
        if(users.contains(u)){
            users.remove(u);
        }
    }
}
