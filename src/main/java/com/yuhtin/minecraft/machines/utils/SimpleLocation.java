package com.yuhtin.minecraft.machines.utils;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.Serializable;

@Data
public class SimpleLocation implements Serializable {

    private final String world;

    private final double x;
    private final double y;
    private final double z;

    private final float yaw;
    private final float pitch;

    public SimpleLocation(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }

    public World getWorld() {
        return Bukkit.getWorld(this.world);
    }

    public Location toBukkit() {
        Location location = new Location(this.getWorld(), x, y, z);

        location.setYaw(this.yaw);
        location.setPitch(this.pitch);

        return location;
    }
}
