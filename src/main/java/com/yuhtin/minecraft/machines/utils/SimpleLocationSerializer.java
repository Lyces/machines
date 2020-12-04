package com.yuhtin.minecraft.machines.utils;

import com.google.gson.Gson;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

public class SimpleLocationSerializer {

    private static final Gson GSON = new Gson();

    private SimpleLocationSerializer() {
        throw new IllegalStateException("Utility class");
    }

    public static String serialize(SimpleLocation value) {
        return GSON.toJson(value);
    }

    public static SimpleLocation deserialize(String data) {
        return GSON.fromJson(data, SimpleLocation.class);
    }

}
