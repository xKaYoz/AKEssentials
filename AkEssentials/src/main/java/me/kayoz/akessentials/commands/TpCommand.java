package me.kayoz.akessentials.commands;

import me.kayoz.akessentials.utils.ChatUtils;
import me.kayoz.akessentials.utils.Errors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by KaYoz on 4/5/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class TpCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 1){

                Player t = Bukkit.getPlayer(args[0]);

                if(t == null){
                    p.sendMessage(Errors.ErrorMessage(Errors.TARGET_OFFLINE));
                    return false;
                }

                if(t == p){
                    p.sendMessage(ChatUtils.format("&cYou cannot teleport to yourself!"));
                    return false;
                }

                p.teleport(t.getLocation());
                p.sendMessage(ChatUtils.format("&eYou are teleporting to " + t.getName()));

            } else if(args.length == 2){

                Player t = Bukkit.getPlayer(args[0]);
                Player to = Bukkit.getPlayer(args[1]);

                if(t == null){
                    p.sendMessage(Errors.ErrorMessage(Errors.TARGET_OFFLINE));
                    return false;
                }

                if(to == null){
                    p.sendMessage(Errors.ErrorMessage(Errors.TARGET_OFFLINE));
                    return false;
                }

                if(t == p && to == p){
                    p.sendMessage(ChatUtils.format("&cYou cannot teleport to yourself!"));
                    return false;
                }

                t.teleport(to.getLocation());
                p.sendMessage(ChatUtils.format("&eYou have teleported " + t.getName() + " to " + to.getName()));

            } else {
                p.sendMessage(ChatUtils.format("&cIncorrect Usage! /tp <player> {player}"));
            }

        } else {
            sender.sendMessage(Errors.ErrorMessage(Errors.PLAYER_ONLY));
            return false;
        }

        return false;
    }
}
