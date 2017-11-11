package me.kayoz.practice.kits;

import java.util.ArrayList;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class KitManager {

    private static ArrayList<Kit> kits = new ArrayList<>();

    public static Kit getKit(String name){
        for(Kit kit : kits) if(kit.getName().equalsIgnoreCase(name)) return kit;
        return null;
    }

    public static  boolean register(Kit kit){
        if(!kits.contains(kit)){
            kits.add(kit);
            return true;
        }
        return false;
    }

    public static boolean unregister(Kit kit){
        if(kits.contains(kit)){
            kits.remove(kit);
            return true;
        }
        return false;
    }

}
