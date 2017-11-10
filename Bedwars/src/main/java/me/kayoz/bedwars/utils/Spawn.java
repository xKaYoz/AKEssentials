package me.kayoz.bedwars.utils;

import me.kayoz.bedwars.Bedwars;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.NumberConversions;

import java.util.HashMap;

/**
 * Created by KaYoz on 11/3/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Spawn implements ConfigurationSerializable{

    private String name;
    private Map map;
    private Color color;
    private int colorRGB;
    private World world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    public Spawn(String name, Color color, Map map, Location location){
        this.name = name;
        this.map = map;
        this.world = location.getWorld();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
        this.color = color;
        this.colorRGB = color.asRGB();
    }

    public Spawn(String name, Color color, Map map, World world, double x, double y, double z, float pitch, float yaw){

        this.name = name;
        this.map = map;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.color = color;
        this.colorRGB = color.asRGB();

    }

    public static Spawn deserialize(String name, java.util.Map<String, Object> args){

        World world = Bukkit.getWorld((String) args.get("world"));
        if(world == null){
            Bedwars.getInstance().getLogger().severe("Error while deserializing world " + args.get("world"));
            return null;
        }

        return new Spawn(name, Color.fromRGB((Integer) args.get("color")), MapManager.getMap((String) args.get("map")), world, NumberConversions.toDouble(args.get("x")),
                NumberConversions.toDouble(args.get("y")), NumberConversions.toDouble(args.get("z")), NumberConversions.toFloat("pitch"), NumberConversions.toFloat("yaw"));

    }

    @Override
    public java.util.Map<String, Object> serialize() {
        java.util.Map<String, Object> data = new HashMap<>();

        data.put("world", this.world.getName());
        data.put("x", this.x);
        data.put("y", this.y);
        data.put("z", this.z);
        data.put("pitch", this.pitch);
        data.put("yaw", this.yaw);
        data.put("map", this.map.getName());
        data.put("color", this.colorRGB);

        return data;
    }
}
