package me.kayoz.akessentials.commands;

import me.kayoz.akessentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by KaYoz on 3/29/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class MessageCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(p.hasPermission("akessentials.msg")){

                if(args.length <= 1){
                    p.sendMessage(ChatUtils.format("&cIncorrect Usage! /msg <player> <message>"));
                    return false;
                }

                StringBuilder str = new StringBuilder();

                for(int i = 1; i < args.length; i ++){
                    str.append(" ");
                    str.append(args[i]);
                }
                Player t = Bukkit.getPlayer(args[0]);
                if(t == null){
                    p.sendMessage(ChatUtils.format("&c" + t.getName() + " is not online!"));
                    return false;
                }

                if(t == p){
                    p.sendMessage(ChatUtils.format("&cYou cannot send messages to yourself!"));
                    return false;
                }

                p.sendMessage(ChatUtils.format("&6[&7" + p.getDisplayName() + " &6>&7 " + t.getDisplayName() + "&6] » &7") + str);
                t.sendMessage(ChatUtils.format("&6[&7" + p.getDisplayName() + " &6>&7 " + t.getDisplayName() + "&6] » &7") + str);


            } else {
                p.sendMessage(ChatUtils.format("&cNo Permission!"));
                return false;
            }

        } else {
            sender.sendMessage("You must be a player to use this command!");
            return false;
        }
        return false;
    }
}
