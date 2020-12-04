package com.yuhtin.minecraft.machines.utils;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public final class NBTUtils {

    private NBTUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void updateNbtTag(ItemStack itemStack, Consumer<NBTTagCompound> compoundConsumer) {
        if (itemStack == null || itemStack.getType() == Material.AIR) return;

        final net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);

        NBTTagCompound tagCompound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();

        compoundConsumer.accept(tagCompound);
        nmsItemStack.setTag(tagCompound);

        final ItemMeta itemMeta = CraftItemStack.getItemMeta(nmsItemStack);
        itemStack.setItemMeta(itemMeta);
    }

    public static NBTTagCompound getTag(ItemStack itemStack, String tag) {
        if (itemStack == null || itemStack.getType() == Material.AIR) return null;

        final net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);

        NBTTagCompound tagCompound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        if (!tagCompound.hasKey(tag)) return null;

        return tagCompound;
    }
}
