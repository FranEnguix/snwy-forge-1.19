package com.retsal.snwy.common.armor;

import com.retsal.snwy.register.InitItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HermesArmorItem extends ArmorItem {

    public HermesArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide()) {
            int numSetPiecesEquipped = getNumberOfSetPiecesEquipped(player);
            if (numSetPiecesEquipped >= 3) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3 * 20));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 3 * 20));
                if (numSetPiecesEquipped >= 4 && player.getFoodData().getFoodLevel() <= 7 && getNumberOfFeathersHold(player) == 2)
                    player.getFoodData().setFoodLevel(8);
            }
            if (player.getFoodData().getFoodLevel() == 8 && getNumberOfFeathersHold(player) == 1)
                player.getFoodData().setFoodLevel(6);
        }
    }

    private int getNumberOfFeathersHold(Player player) {
        int numFeathers = 0;
        if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == Items.FEATHER)
            numFeathers++;
        if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Items.FEATHER)
            numFeathers++;
        return numFeathers;
    }

    private int getNumberOfSetPiecesEquipped(Player player) {
        int numPieces = 0;
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == InitItems.HERMES_HELMET.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == InitItems.HERMES_CHESTPLATE.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == InitItems.HERMES_LEGGINGS.get())
            numPieces++;
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == InitItems.HERMES_BOOTS.get())
            numPieces++;
        return numPieces;
    }
}
