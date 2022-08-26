package com.retsal.snwy.base;

import com.retsal.snwy.SnwyMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public record SnwyBasicArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent equipSound,
                                     float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial)
        implements ArmorMaterial {

    // Multiplier durability for 0: boots, 1: leggins, 2: chest, 3: helmet.
    // Example: Total helmet durability = this.durability * DURABILITY_PER_SLOT[3]
    private static final int[] DURABILITY_PER_SLOT = new int[] {1, 1, 1, 1};

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return DURABILITY_PER_SLOT[equipmentSlot.getIndex()] * durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return protection[equipmentSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    public String getName() {
        return SnwyMod.MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
