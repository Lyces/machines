package com.yuhtin.minecraft.machines.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yuhtin.minecraft.machines.api.drop.Drop;
import com.yuhtin.minecraft.machines.api.level.Level;
import com.yuhtin.minecraft.machines.api.machine.Machine;
import com.yuhtin.minecraft.machines.utils.ColorUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Singleton
public class MachineParser {

    @Inject @Named("main") private Logger logger;

    @Inject private ItemParser itemParser;
    @Inject private DropParser dropParser;
    @Inject private LevelParser levelParser;

    public Machine parseMachineSection(ConfigurationSection section) {

        try {

            String name = section.getString("name");
            String displayName = ColorUtils.colored(section.getString("displayName"));
            ItemStack icon = itemParser.parseItemSection(section.getConfigurationSection("icon"));
            Drop drop = dropParser.parseDropSection(section.getConfigurationSection("drop"));

            Machine machine = Machine.builder()
                    .name(name)
                    .coloredName(displayName)
                    .icon(icon)
                    .drop(drop)
                    .build();

            List<Level> levels = levelParser.parseLevelCollection(
                    section.getConfigurationSection("levels")
            );

            machine.getLevels().addAll(levels);

            return machine;

        } catch (Exception exception) {

            this.logger.warning("Error on try parse the machine " + section.getName());
            return null;

        }

    }

    public List<Machine> parseMachineCollection(ConfigurationSection section) {

        final List<Machine> machines = new ArrayList<>();

        for (String key : section.getKeys(false)) {

            machines.add(
                    parseMachineSection(section.getConfigurationSection(key))
            );

        }

        return machines;

    }

}
