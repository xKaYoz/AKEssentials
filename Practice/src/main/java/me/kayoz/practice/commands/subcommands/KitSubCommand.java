package me.kayoz.practice.commands.subcommands;

import me.kayoz.practice.commands.SubCommand;
import me.kayoz.practice.kits.Kit;
import me.kayoz.practice.kits.KitManager;
import me.kayoz.practice.utils.Chat;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class KitSubCommand extends SubCommand {

    public KitSubCommand() {
        super("kit", "practice.admin.kit");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(!(sender instanceof Player)){
            Chat.sendPrefixMessage(sender, "You must be a player to execute this command.");
        }

        Player p = (Player) sender;

        if(args.length == 3 && args[1].equalsIgnoreCase("create")){

            ArrayList<ItemStack> armor = new ArrayList<>();
            ArrayList<ItemStack> inv = new ArrayList<>();
            String name = args[2];

            for(ItemStack stack : p.getInventory().getArmorContents()){
                if(stack == null) return;
                armor.add(stack);
            }

            for(ItemStack stack : p.getInventory().getContents()){
                if(stack == null) inv.add(new ItemStack(Material.AIR));
                inv.add(stack);
            }

            Kit kit = new Kit(name, armor, inv);

            Chat.sendPrefixMessage(p, "You have created a kit named " + kit.getName() + ".");

        } else if(args.length == 3 && args[1].equalsIgnoreCase("delete")){

            Kit kit = KitManager.getKit(args[2]);

            if(kit == null){
                Chat.sendPrefixMessage(p, "There is not a kit with that name.");
                return;
            }

            Chat.sendPrefixMessage(p, "You have deleted the kit " + kit.getName());

            KitManager.unregister(kit);

            //TODO Finish deleting kit

        }

    }

    public void sendHelpMessage(Player p){

    }

    @Override
    public String getName() {
        return "kit";
    }

    @Override
    public String getPermission() {
        return "practice.admin.kit";
    }
}
