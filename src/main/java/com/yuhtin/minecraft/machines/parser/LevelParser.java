package com.yuhtin.minecraft.machines.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.yuhtin.minecraft.machines.api.level.Level;
import com.yuhtin.minecraft.machines.utils.ColorUtils;
import org.bukkit.configuration.ConfigurationSection;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Singleton
public class LevelParser {

    @Inject @Named("main") private Logger logger;

    public Level parseLevelSection(ConfigurationSection section) {

        try {
            return Level.builder()
                    .coloredName(ColorUtils.colored(""))
                    .build();
        }catch (Exception exception) {

            this.logger.warning(
                    "Error on try parse the level " + section.getName() + " of machine " + section.getParent().getName()
            );
            return null;

        }

    }

    public List<Level> parseLevelCollection(ConfigurationSection section) {

        final List<Level> levels = new LinkedList<>();

        for (String key : section.getKeys(false)) {

            levels.add(
                    parseLevelSection(section.getConfigurationSection(key))
            );

        }

        return levels;

    }


}
