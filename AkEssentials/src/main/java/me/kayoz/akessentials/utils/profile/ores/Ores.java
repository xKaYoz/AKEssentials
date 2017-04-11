package me.kayoz.akessentials.utils.profile.ores;

import lombok.Getter;
import org.bukkit.Material;

/**
 * Created by KaYoz on 4/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public enum Ores {

    COAL(Material.COAL_ORE),
    IRON(Material.IRON_ORE),
    GOLD(Material.GOLD_ORE),
    REDSTONE(Material.GLOWING_REDSTONE_ORE),
    LAPIS(Material.LAPIS_ORE),
    QUARTZ(Material.QUARTZ_ORE),
    EMERALD(Material.EMERALD_ORE),
    DIAMOND(Material.DIAMOND_ORE);

    @Getter private final Material material;

    Ores(Material material){
        this.material = material;
    }

    public static Ores getMaterial(Material material){
        for(Ores type : values()){
            if(type.getMaterial() == material){
                return type;
            }
        }
        return null;
    }



}
