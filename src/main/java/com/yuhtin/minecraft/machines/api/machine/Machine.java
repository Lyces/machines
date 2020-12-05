package com.yuhtin.minecraft.machines.api.machine;

import com.yuhtin.minecraft.machines.api.drop.Drop;
import com.yuhtin.minecraft.machines.api.level.Level;
import lombok.Builder;
import lombok.Data;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Data
@Builder
public class Machine {

    private final String name;
    private final String coloredName;
    private final ItemStack icon;
    private final Drop drop;
    private final List<Level> levels = new LinkedList<>();

}
