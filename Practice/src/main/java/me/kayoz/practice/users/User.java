package me.kayoz.practice.users;

import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class User {

    @Getter
    private Player player;

    public User(Player p){
        this.player = p;

        UserManager.register(this);
    }
}
