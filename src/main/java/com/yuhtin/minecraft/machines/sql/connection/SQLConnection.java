package com.yuhtin.minecraft.machines.sql.connection;

import org.bukkit.configuration.ConfigurationSection;

import java.sql.Connection;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public interface SQLConnection {

    boolean configure(ConfigurationSection section);

    Connection findConnection();

}
