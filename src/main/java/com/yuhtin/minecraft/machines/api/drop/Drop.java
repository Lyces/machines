package com.yuhtin.minecraft.machines.api.drop;

import lombok.Builder;
import lombok.Data;
import org.bukkit.inventory.ItemStack;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
@Data
@Builder
public class Drop {

    private final double price;
    private final ItemStack icon;

}
