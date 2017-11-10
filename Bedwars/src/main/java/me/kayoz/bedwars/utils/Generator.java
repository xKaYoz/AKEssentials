package me.kayoz.bedwars.utils;

import lombok.Getter;
import lombok.Setter;
import me.kayoz.bedwars.Bedwars;
import org.bukkit.*;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.NumberConversions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KaYoz on 8/31/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Generator implements ConfigurationSerializable {

    @Getter @Setter
    private World world;
    @Getter @Setter
    private double x;
    @Getter @Setter
    private double y;
    @Getter @Setter
    private double z;
    @Getter @Setter
    private Material drop;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int level = 1;
    @Getter @Setter
    private int timerID;
    @Getter @Setter
    private long time;
    @Getter @Setter
    private int base;

    public Generator(String name, World world, double x, double y, double z, Material drop){
        this.name = name;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.drop = drop;
    }

    public Generator(String name, Location loc, Material drop){
        this.name = name;
        this.world = loc.getWorld();
        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();
        this.drop = drop;
    }

    public Generator(Map<String, Object> args){
        World world = Bukkit.getWorld((String) args.get("world"));

        if(world == null){
            throw new IllegalArgumentException("Unknown World!");
        }

        this.name = args.get("name").toString();
        this.world = world;
        this.x = NumberConversions.toDouble(args.get("x"));
        this.y = NumberConversions.toDouble(args.get("y"));
        this.z = NumberConversions.toDouble(args.get("z"));
        this.drop = Material.getMaterial((String) args.get("Material"));

    }

    public void update(){


        if(getDrop() == Material.IRON_INGOT){
            base = 3;
        } else if(getDrop() == Material.GOLD_INGOT){
            base = 7;
        } else if(getDrop() == Material.DIAMOND){
            base = 30;
        } else if(getDrop() == Material.EMERALD){
            base = 60;
        }

        time = base / getLevel();

        timerID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bedwars.getInstance(), new Runnable() {
            @Override
            public void run() {

                world.dropItemNaturally(new Location(world, x, y ,z).add(.5, 0, .5), new ItemStack(drop));

            }
        },0, time * 20);

    }

    public Map<String, Object> serialize(){
        Map<String, Object> data = new HashMap<>();

        data.put("name", name);
        data.put("world", this.world.getName());
        data.put("x", this.x);
        data.put("y", this.y);
        data.put("z", this.z);
        data.put("Material", this.drop.toString());

        return data;
    }
}
