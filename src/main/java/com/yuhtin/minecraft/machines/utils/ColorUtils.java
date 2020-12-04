package com.yuhtin.minecraft.machines.utils;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class ColorUtils {

    private ColorUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String colored(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> colored(String... string) {
        return Arrays.stream(string).map(ColorUtils::colored).collect(Collectors.toList());
    }

}
