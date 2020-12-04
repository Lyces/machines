package com.yuhtin.minecraft.machines.sql.connection.mysql;

import com.yuhtin.minecraft.steelbosses.sql.connection.SQLConnection;
import org.bukkit.configuration.ConfigurationSection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public final class MySQLConnection implements SQLConnection {

    private Connection connection;

    @Override
    public boolean configure(ConfigurationSection section) {

        if (section.getBoolean("enabled")) {

            String url = "jdbc:mysql://" + section.getString("address") + ":3306/" + section.getString("database") + "?autoReconnect=true";
            try {

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, section.getString("username"), section.getString("password"));
                return true;

            } catch (Exception exception) {

                exception.printStackTrace();
                return false;

            }

        }

        return false;

    }

    @Override
    public Connection findConnection() {

        return connection;

    }

}
