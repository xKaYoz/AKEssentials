package me.kayoz.bedwars.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KaYoz on 8/7/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class SubCommandManager {

    private static SubCommandManager instance = new SubCommandManager();
    private Map<String, SubCommand> subcommands = new HashMap<>();

    public SubCommandManager(){

    }

    public static SubCommandManager getInstance(){
        return instance;
    }

    public SubCommand find(String command){
        return subcommands.get(command);
    }

}
