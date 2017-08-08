package me.kayoz.bedwars.utils.team;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by KaYoz on 8/7/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class TeamManager {

    @Getter
    private static ArrayList<Team> teams = new ArrayList<>();
    @Getter
    private static ArrayList<Team> alive = new ArrayList<>();

    public static Team getTeam(Color color){
        for(Team team : teams){
            if(team.getColorRGB() == color.getRGB()){
                return team;
            }
        }
        return null;
    }

    public static void register(Team t){
        if (!teams.contains(t)){
            teams.add(t);
        }
    }

    public static void unregister(Team t){
        if (teams.contains(t)){
            teams.remove(t);
        }
    }

}
