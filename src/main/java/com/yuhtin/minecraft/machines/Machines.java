package com.yuhtin.minecraft.machines;

import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class Machines extends JavaPlugin {

    private Injector injector;


    @Override
    public void onLoad() {
        
        saveDefaultConfig();

    }

    @Override
    public void onEnable() {



    }
}
