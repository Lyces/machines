package com.yuhtin.minecraft.machines.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.yuhtin.minecraft.machines.api.fuel.Fuel;
import org.bukkit.configuration.ConfigurationSection;

import java.util.logging.Logger;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Singleton
public class FuelParser {

    @Inject @Named("main") private Logger logger;

    @Inject private ItemParser itemParser;

    public Fuel parseFuelSection(ConfigurationSection section) {

        try {

            return Fuel.builder()
                    .quantity(section.getDouble("quantity"))
                    .icon(this.itemParser.parseItemSection(section))
                    .build();

        } catch (Exception exception) {

            this.logger.warning("Error on try parse fuel " + section.getName());
            return null;

        }

    }

}
