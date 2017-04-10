package me.kayoz.akessentials.commands;

import lombok.Getter;
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

public class FlyCommand implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 0){
                if(p.hasPermission("akessentials.fly")){

                    if(p.getAllowFlight() == true){
                        p.setAllowFlight(false);
                        p.sendMessage(ChatUtils.format("&eYou have disabled your flight."));
                        return false;
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatUtils.format("&eYou have enabled your flight."));
                        return false;
                    }

                } else {
                    p.sendMessage(Errors.ErrorMessage(Errors.NO_PERMISSION));
                    return false;
                }
            } else if(args.length == 1){
                if(p.hasPermission("akessentials.fly.others")){

                    Player t = Bukkit.getPlayer(args[0]);

                    if(t == null){
                        p.sendMessage(Errors.ErrorMessage(Errors.TARGET_OFFLINE));
                        return false;
                    }

                    if(t.getAllowFlight() == true){
                        t.setAllowFlight(false);
                        p.sendMessage(ChatUtils.format("&eYou have disabled " + t.getName() + "'s flight."));
                        t.sendMessage(ChatUtils.format("&eYour flight has been disabled!"));
                        return false;
                    } else {
                        t.setAllowFlight(true);
                        p.sendMessage(ChatUtils.format("&eYou have enabled " + t.getName() + "'s flight."));
                        t.sendMessage(ChatUtils.format("&eYour flight has been enabled!"));
                        return false;
                    }

                } else {
                    p.sendMessage(Errors.ErrorMessage(Errors.NO_PERMISSION));
                    return false;
                }
            } else {
                p.sendMessage(ChatUtils.format("&cIncorrect Usage! /fly {player}"));

            }

        } else {
            sender.sendMessage(Errors.ErrorMessage(Errors.PLAYER_ONLY));
            return false;
        }
        return false;
    }

}
