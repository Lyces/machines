package com.yuhtin.minecraft.machines.api.fuel;

import lombok.Builder;
import lombok.Data;
import org.bukkit.inventory.ItemStack;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Data
@Builder
public class Fuel {

    private final double quantity;
    private final ItemStack icon;

}
