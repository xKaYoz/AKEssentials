package me.kayoz.akessentials.utils;

import me.kayoz.akessentials.AkEssentials;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by KaYoz on 4/11/2017.
 * Subscribe to me on Youtube:
 * http://www.youtube.com/c/KaYozMC/
 */

public class Files {

    private File file;
    private YamlConfiguration fileConfig;

    public void createNewFile(String path, String name){
        this.file = new File(path, name + ".yml");
        if(!this.file.exists()){
            try {
                this.file.createNewFile();
                AkEssentials.getInstance().getLogger().info("File " + name + " has been created in path " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.fileConfig = YamlConfiguration.loadConfiguration(file);
        } else {
            try{
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File getFile(String path, String name) {
        this.file = new File(path, name + ".yml");
        return this.file;
    }

    public YamlConfiguration getConfig(String path, String name) {
        this.file = new File(path, name + ".yml");
        this.fileConfig = YamlConfiguration.loadConfiguration(this.file);
        return this.fileConfig;
    }
}
