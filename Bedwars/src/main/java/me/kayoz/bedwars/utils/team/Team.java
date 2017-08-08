package me.kayoz.bedwars.utils.team;

import lombok.Getter;
import lombok.Setter;
import me.kayoz.bedwars.utils.users.User;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * Created by KaYoz on 8/7/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Team {
    @Getter @Setter
    private ArrayList<User> members = new ArrayList<>();
    @Getter @Setter
    private int kills;
    @Getter @Setter
    private boolean respawn = false;
    @Getter @Setter
    private Inventory backpack;
    @Getter @Setter
    private Color color;
    @Getter @Setter
    private int colorRGB;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private ArrayList<Location> bed = new ArrayList<>();
    @Getter @Setter
    private boolean placedBed = false;

    public Team(User member){
        this.members.add(member);
        member.setTeam(this);
    }
}
