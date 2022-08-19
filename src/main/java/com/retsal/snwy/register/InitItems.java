package com.retsal.snwy.register;

import com.retsal.snwy.SnwyMod;
import com.retsal.snwy.common.CreativeModeTabSnwy;
import com.retsal.snwy.common.IntegrationFood;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnwyMod.MODID);


    /// GENERIC ITEMS

    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)
    ));

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)
    ));


    /// BLOCKS

    public static final RegistryObject<BlockItem> SAPPHIRE_ORE = ITEMS.register("sapphire_ore",
            () -> new BlockItem(InitBlocks.SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> DEEPSLATE_SAPPHIRE_ORE = ITEMS.register("deepslate_sapphire_ore",
            () -> new BlockItem(InitBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<Item> SHOP = ITEMS.register("shop",
            () -> new BlockItem(InitBlocks.SHOP.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));


    /// FOOD

    public static final RegistryObject<Item> GLOWING_SUPPOSITORY = ITEMS.register("glowing_suppository", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.GLOWING_SUPPOSITORY)
    ));

    public static final RegistryObject<Item> FRESISUIS_BLUEBERRY = ITEMS.register("fresisuis_blueberry", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_BLUEBERRY)
    ));


}
