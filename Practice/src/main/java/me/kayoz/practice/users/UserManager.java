package me.kayoz.practice.users;

import java.util.ArrayList;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class UserManager {

    public static ArrayList<User> users = new ArrayList<>();

    public static User getUser(String name){

        for(User user : users) if (user.getPlayer().getName().equalsIgnoreCase(name)) return user;

        return null;
    }

    public static boolean register(User u){
        if(!users.contains(u)){
            users.add(u);
            return true;
        }
        return false;
    }

    public static boolean unregister(User u){
        if(users.contains(u)){
            users.remove(u);
            return true;
        }
        return false;
    }

}
