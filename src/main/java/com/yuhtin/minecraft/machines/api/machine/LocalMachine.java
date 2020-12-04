package com.yuhtin.minecraft.machines.api.machine;

import lombok.Builder;
import lombok.Data;
import org.bukkit.Location;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Builder
@Data
public class LocalMachine {

    private final Machine machine;
    private final Location location;

}
