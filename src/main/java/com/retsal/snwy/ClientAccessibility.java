package com.retsal.snwy;


import com.retsal.snwy.common.armor.WarlockArmorItem;
import com.retsal.snwy.register.InitItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ClientAccessibility {

    public static void infernalRodItemTooltip(List<Component> components) {
        if (!Screen.hasShiftDown()) {
            components.add(Component.literal("Press\u00A75 SHIFT\u00A7f for more information."));
        } else {
            Player player = Minecraft.getInstance().player;
            int armorSetPieces = WarlockArmorItem.getNumberOfSetPiecesEquipped(player);
            int pellets = getNumberOfPellets(player);
            if (armorSetPieces < 3)
                components.add(Component.literal("You need \u00A75" + (3 - armorSetPieces) + "\u00A7f more pieces to use me... stupid human."));
            else {
                if (pellets > 0) {
                    if (armorSetPieces == 3)
                        components.add(Component.literal("Hit someone... please..."));
                    if (armorSetPieces == 4)
                        components.add(Component.literal("Use me to unleash the flame power... The world will burn."));
                } else
                    components.add(Component.literal("I am not a philosopher's stone. Give me\u00A76 Kerosene Pellets\u00A7f to unleash the flames."));
            }
        }
    }

//    private static int getNumberOfWarlockSetPiecesEquipped(Player player) {
//        int numPieces = 0;
//        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == InitItems.WARLOCK_HELMET.get())
//            numPieces++;
//        if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == InitItems.WARLOCK_CHESTPLATE.get())
//            numPieces++;
//        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == InitItems.WARLOCK_LEGGINGS.get())
//            numPieces++;
//        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == InitItems.WARLOCK_BOOTS.get())
//            numPieces++;
//        return numPieces;
//    }

    private static int getNumberOfPellets(Player player) {
        Inventory inv = player.getInventory();
        return inv.countItem(InitItems.PELLET.get());
    }
}
