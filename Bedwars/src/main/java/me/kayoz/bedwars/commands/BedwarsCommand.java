package me.kayoz.bedwars.commands;

import me.kayoz.bedwars.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by KaYoz on 8/7/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class BedwarsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            SubCommandManager.getInstance().find("help").execute(sender, null);
            return false;
        }

        SubCommand subCommand = SubCommandManager.getInstance().find(args[0]);

        if(subCommand == null){
            subCommand = SubCommandManager.getInstance().find("help");
        }

        if(sender.hasPermission(subCommand.getPermission())){
            subCommand.execute(sender, args);
        } else {
            Chat.sendColoredMessage(sender, "&cYou do not have permission to execute this command.");
        }

        return false;
    }
}
