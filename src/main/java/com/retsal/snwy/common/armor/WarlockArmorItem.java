package com.retsal.snwy.common.armor;

import com.retsal.snwy.ClientAccessibility;
import com.retsal.snwy.common.item.InfernalRodItem;
import com.retsal.snwy.register.InitItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WarlockArmorItem extends ArmorItem {

    public WarlockArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide()) {
            int numSetPiecesEquipped = WarlockArmorItem.getNumberOfSetPiecesEquipped(player);
            if (numSetPiecesEquipped >= 2)
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3 * 20));
        }
    }

    public static int getNumberOfSetPiecesEquipped(Player player) {
        int numPieces = 0;
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == InitItems.WARLOCK_HELMET.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == InitItems.WARLOCK_CHESTPLATE.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == InitItems.WARLOCK_LEGGINGS.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == InitItems.WARLOCK_BOOTS.get())
            numPieces++;
        return numPieces;
    }
}
