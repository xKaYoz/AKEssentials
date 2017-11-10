package me.kayoz.bedwars.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.NumberConversions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KaYoz on 8/31/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Map implements ConfigurationSerializable{

    @Getter
    private String name;
    @Getter
    private ArrayList<Generator> generators = new ArrayList<>();
    @Getter
    private String creator;
    @Getter
    @Setter
    private Location loc;

    public Map(String creator, String name){
        this.creator = creator;
        this.name = name;
    }

    public Map(String creator, String name, ArrayList<Generator> generators, Location loc){
        this.creator = creator;
        this.name = name;
        this.generators = generators;
        this.loc = loc;
    }

    public Map(java.util.Map<String, Object> args){

        World world = Bukkit.getWorld((String) args.get("world"));

        if(world == null){
            throw new IllegalArgumentException("Unknown World!");
        }

        this.creator = args.get("creator").toString();
        this.name = args.get("name").toString();
        this.generators = (ArrayList<Generator>) args.get("generators");
        this.loc = new Location(world, NumberConversions.toDouble(args.get("x")), NumberConversions.toDouble(args.get("y")), NumberConversions.toDouble(args.get("z")));
    }

    public java.util.Map<String, Object> serialize(){
        java.util.Map<String, Object> data = new HashMap<>();

        data.put("world", loc.getWorld().getName());
        data.put("x", loc.getX());
        data.put("y", loc.getY());
        data.put("z", loc.getZ());
        data.put("creator", creator);
        data.put("name", this.name);
        ArrayList<String> gens = new ArrayList<>();

        for(Generator gen : this.generators){
            gens.add(gen.serialize().toString());
        }

        data.put("generators", gens);

        return data;
    }


}
