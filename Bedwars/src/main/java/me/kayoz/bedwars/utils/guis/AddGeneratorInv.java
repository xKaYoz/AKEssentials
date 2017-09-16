package me.kayoz.bedwars.utils.guis;

import me.kayoz.bedwars.utils.Chat;
import me.kayoz.bedwars.utils.ItemBuilder;
import me.kayoz.bedwars.utils.Map;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * Created by KaYoz on 9/13/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class AddGeneratorInv {

    public static void open(Player p, Map map){

        Inventory inv = Bukkit.createInventory(null, 9, Chat.format("&eGenerator: " + map.getName()));

        ItemStack diamondGen = ItemBuilder.build(Material.DIAMOND_BLOCK, 1, "&b&lDiamond Generator", Arrays.asList("&7Select this to place a diamond generator"));
        ItemStack emeraldGen = ItemBuilder.build(Material.EMERALD_BLOCK, 1, "&2&lEmerald Generator", Arrays.asList("&7Select this to place an emerald generator"));
        ItemStack goldGen = ItemBuilder.build(Material.GOLD_BLOCK, 1, "&6&lGold Generator", Arrays.asList("&7Select this to place a gold generator"));
        ItemStack ironGen = ItemBuilder.build(Material.IRON_BLOCK, 1, "&f&lIron Generator", Arrays.asList("&7Select this to place an iron generator"));
        ItemStack spacer = ItemBuilder.build(Material.STAINED_GLASS_PANE, 1, 7,  "&bDiamond Generator", Arrays.asList(""));

        inv.setItem(0, spacer);
        inv.setItem(2, spacer);
        inv.setItem(4, spacer);
        inv.setItem(6, spacer);
        inv.setItem(8, spacer);

        inv.setItem(1, ironGen);
        inv.setItem(3, goldGen);
        inv.setItem(5, diamondGen);
        inv.setItem(7, emeraldGen);

        p.openInventory(inv);

    }

}
