package me.kayoz.practice.kits;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KaYoz on 11/10/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Kit implements ConfigurationSerializable {

    @Getter
    @Setter
    private ItemStack icon;
    @Getter
    @Setter
    private String name;
    @Getter
    private ArrayList<ItemStack> armorContents;
    @Getter
    private ArrayList<ItemStack> invContents;
    @Getter
    @Setter
    private boolean isTeam;
    @Getter
    @Setter
    private boolean isBuildable;
    @Getter
    @Setter
    private boolean isEditable;

    public Kit(String name, ArrayList<ItemStack> armorContents, ArrayList<ItemStack> invContents) {
        this.name = name;
        this.armorContents = armorContents;
        this.invContents = invContents;

        KitManager.register(this);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();

        data.put("icon", icon.getType());

        return data;
    }
}
