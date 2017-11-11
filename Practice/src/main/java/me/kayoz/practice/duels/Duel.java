package me.kayoz.practice.duels;

import lombok.Getter;
import me.kayoz.practice.kits.Kit;
import me.kayoz.practice.users.User;

import java.util.ArrayList;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Duel {
    @Getter
    private ArrayList<User> fighting;
    @Getter
    private ArrayList<User> spectators;
    @Getter
    private Kit kit;
    @Getter
    private int time;
    @Getter
    private boolean started;

    public Duel(Kit kit){
        fighting = new ArrayList<>();
        spectators = new ArrayList<>();
        this.kit = kit;
        this.time = 0;
        started = false;
        startCountdown();
    }

    public void startCountdown(){
        //TODO Start the cooldown.
    }

}
