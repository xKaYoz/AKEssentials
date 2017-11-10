package me.kayoz.bedwars.commands.subcommands;

import lombok.Getter;
import me.kayoz.bedwars.commands.SubCommand;
import me.kayoz.bedwars.utils.Chat;
import me.kayoz.bedwars.utils.Map;
import me.kayoz.bedwars.utils.MapManager;
import me.kayoz.bedwars.utils.guis.AddGeneratorInv;
import me.kayoz.bedwars.utils.guis.AllGeneratorInv;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by KaYoz on 10/29/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class GeneratorSubCommand extends SubCommand{

    @Getter
    private String name = "generator";
    @Getter
    private String permission = "bedwars.admin.generator";

    public GeneratorSubCommand() {
        super("generator", "bedwars.admin.generator");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 3 && args[1].equalsIgnoreCase("list")){

                Map map = MapManager.getMap(args[2]);

                if(map == null){
                    Chat.sendPrefixMessage(p, "&cThere is not a map with that name.");
                    return;
                }

                AllGeneratorInv.create(p, map);
                return;
            } else if(args.length == 3 && args[1].equalsIgnoreCase("create")){

                Map map = MapManager.getMap(args[2]);

                if(map == null){
                    Chat.sendPrefixMessage(p, "&cThere is not a map with that name.");
                    return;
                }

                AddGeneratorInv.open(p, map);
                return;
            } else if(args.length == 3 && args[1].equalsIgnoreCase("remove")){

                Map map = MapManager.getMap(args[2]);

                if(map == null){
                    Chat.sendPrefixMessage(p, "&cThere is not a map with that name.");
                    return;
                }
                //TODO Add a remove method
            }
        }
        //TODO Add a help message.
    }
}
