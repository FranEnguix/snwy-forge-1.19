package com.retsal.snwy.common;

import com.retsal.snwy.register.InitItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CreativeModeTabSnwy {
    public static final CreativeModeTab SNWY_TAB = new CreativeModeTab("snwycreativemodetab") {
        @Override
        public ItemStack makeIcon() {
            return InitItems.GOLD_COIN.get().getDefaultInstance();
        }
    };
}
