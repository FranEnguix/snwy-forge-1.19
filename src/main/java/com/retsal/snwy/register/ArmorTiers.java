package com.retsal.snwy.register;

import com.retsal.snwy.base.SnwyBasicArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorTiers {
    public static final ArmorMaterial HERMES = new SnwyBasicArmorMaterial(
            "hermes",
            170,
            new int[] { 3, 3, 4, 2 }, // Boots, Leggings, Chest, Helmet
            0,
            SoundEvents.BAT_TAKEOFF,
            0f,
            0f,
            () -> Ingredient.EMPTY // Repair material
    );

    public static final ArmorMaterial WARLOCK = new SnwyBasicArmorMaterial(
            "warlock",
            300,
            new int[] { 2, 6, 7, 3 }, // Boots, Leggings, Chest, Helmet
            0,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            0f,
            0f,
            () -> Ingredient.EMPTY // Repair material
    );

}
