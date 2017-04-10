package me.kayoz.akessentials.utils;

/**
 * Created by KaYoz on 4/5/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public enum Errors {
    NO_PERMISSION,
    PLAYER_ONLY,
    TARGET_OFFLINE;

    public static String ErrorMessage(Errors type){
        String message = "";
        if(type.equals(Errors.NO_PERMISSION)){
            message= ChatUtils.format("&cNo Permission!");
        } else if(type.equals(Errors.PLAYER_ONLY)){
            message= ChatUtils.format("&cYou must be a player to use this command!");
        }  else if(type.equals(Errors.TARGET_OFFLINE)){
            message= ChatUtils.format("&cThat player is not online!");
        }
        return message;
    }
}
