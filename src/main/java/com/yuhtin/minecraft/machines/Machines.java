package com.yuhtin.minecraft.machines;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class Machines extends JavaPlugin {

    private Injector injector;
    private FileConfiguration machinesConfiguration;

    public static Machines getInstance() {
        return JavaPlugin.getPlugin(Machines.class);
    }

    @Override
    public void onLoad() {

        saveDefaultConfig();
        createMachinesConfig();

    }

    @Override
    public void onEnable() {

        this.injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

                bind(Machines.class).toInstance(getInstance());
                bind(Logger.class).annotatedWith(Names.named("main")).toInstance(getLogger());

            }
        });

        this.injector.injectMembers(this);

        this.getLogger().info("Injected members");

        

    }

    private void createMachinesConfig() {

        File file = new File("machines.yml");
        if (!file.exists()) saveResource("machines.yml", false);

        this.machinesConfiguration = YamlConfiguration.loadConfiguration(file);

    }
}
