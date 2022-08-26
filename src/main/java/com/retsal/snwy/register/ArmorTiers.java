package com.retsal.snwy.register;

import com.retsal.snwy.base.SnwyBasicArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorTiers {
    public static final ArmorMaterial HERMES = new SnwyBasicArmorMaterial(
            "hermes",
            100,
            new int[] { 1, 3, 2, 1 },
            0,
            SoundEvents.BAT_TAKEOFF,
            0f,
            0f,
            () -> Ingredient.EMPTY // Repair material
    );

}
