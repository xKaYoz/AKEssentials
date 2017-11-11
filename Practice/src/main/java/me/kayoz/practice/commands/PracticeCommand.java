package me.kayoz.practice.commands;

import me.kayoz.practice.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class PracticeCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            SubCommandManager.getInstance().find("help").execute(sender, null);
            return false;
        }

        SubCommand sc = SubCommandManager.getInstance().find(args[0]);

        if(sc == null){
            SubCommandManager.getInstance().find("help").execute(sender, null);
            return false;
        }

        if(sender.hasPermission(sc.getPermission())){
            sc.execute(sender, args);
        } else {
            Chat.sendPrefixMessage(sender, "&cYou do not have permission to execute this command.");
        }

        return false;
    }
}
