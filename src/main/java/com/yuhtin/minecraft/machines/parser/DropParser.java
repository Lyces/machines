package com.yuhtin.minecraft.machines.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.yuhtin.minecraft.machines.api.drop.Drop;
import org.bukkit.configuration.ConfigurationSection;

import java.util.logging.Logger;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Singleton
public class DropParser {

    @Inject @Named("main") private Logger logger;
    @Inject private ItemParser itemParser;

    public Drop parseDropSection(ConfigurationSection section) {

        try {

            return Drop.builder()
                    .price(section.getDouble("price"))
                    .icon(itemParser.parseItemSection(section))
                    .build();

        }catch (Exception exception) {

            this.logger.warning(
                    "Error on try parse the drop of machine " + section.getParent().getName()
            );
            return null;

        }

    }

}
