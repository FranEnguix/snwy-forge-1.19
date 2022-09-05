package com.retsal.snwy.register;

import com.retsal.snwy.SnwyMod;
import com.retsal.snwy.common.CreativeModeTabSnwy;
import com.retsal.snwy.common.IntegrationFood;
import com.retsal.snwy.common.armor.HermesArmorItem;
import com.retsal.snwy.common.armor.WarlockArmorItem;
import com.retsal.snwy.common.item.InfernalRodItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
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

    public static final RegistryObject<Item> TOKEN = ITEMS.register("token", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)
    ));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)
    ));


    /// BLOCKS

    public static final RegistryObject<BlockItem> SAPPHIRE_ORE = ITEMS.register("sapphire_ore",
            () -> new BlockItem(InitBlocks.SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> DEEPSLATE_SAPPHIRE_ORE = ITEMS.register("deepslate_sapphire_ore",
            () -> new BlockItem(InitBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> SHOP_BLUE = ITEMS.register("shop_blue",
            () -> new BlockItem(InitBlocks.SHOP_BLUE.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> SHOP_RED = ITEMS.register("shop_red",
            () -> new BlockItem(InitBlocks.SHOP_RED.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> ALTAR_STATUE_DIG_SPEED = ITEMS.register("altar_statue_dig_speed",
            () -> new BlockItem(InitBlocks.ALTAR_STATUE_DIG_SPEED.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> ALTAR_STATUE_MOVEMENT_SPEED = ITEMS.register("altar_statue_movement_speed",
            () -> new BlockItem(InitBlocks.ALTAR_STATUE_MOVEMENT_SPEED.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<BlockItem> ALTAR_STATUE_REGENERATION = ITEMS.register("altar_statue_regeneration",
            () -> new BlockItem(InitBlocks.ALTAR_STATUE_REGENERATION.get(), new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));


    /// FOOD

    public static final RegistryObject<Item> GLOWING_SUPPOSITORY = ITEMS.register("glowing_suppository", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.GLOWING_SUPPOSITORY)
    ));

    public static final RegistryObject<Item> FRESISUIS_BLUEBERRY = ITEMS.register("fresisuis_blueberry", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_BLUEBERRY)
    ));

    public static final RegistryObject<Item> FRESISUIS_LEMON = ITEMS.register("fresisuis_lemon", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_LEMON)
    ));

    public static final RegistryObject<Item> FRESISUIS_LIME = ITEMS.register("fresisuis_lime", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_LIME)
    ));

    public static final RegistryObject<Item> FRESISUIS_ORANGE = ITEMS.register("fresisuis_orange", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_ORANGE)
    ));

    public static final RegistryObject<Item> FRESISUIS_STRAWBERRY = ITEMS.register("fresisuis_strawberry", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).food(IntegrationFood.FRESISUIS_STRAWBERRY)
    ));


    /// ARMOR

    public static final RegistryObject<ArmorItem> HERMES_HELMET = ITEMS.register("hermes_helmet",
            () -> new HermesArmorItem(ArmorTiers.HERMES, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> HERMES_CHESTPLATE = ITEMS.register("hermes_chestplate",
            () -> new HermesArmorItem(ArmorTiers.HERMES, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> HERMES_LEGGINGS = ITEMS.register("hermes_leggings",
            () -> new HermesArmorItem(ArmorTiers.HERMES, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> HERMES_BOOTS = ITEMS.register("hermes_boots",
            () -> new HermesArmorItem(ArmorTiers.HERMES, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));


    public static final RegistryObject<ArmorItem> WARLOCK_HELMET = ITEMS.register("warlock_helmet",
            () -> new WarlockArmorItem(ArmorTiers.WARLOCK, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> WARLOCK_CHESTPLATE = ITEMS.register("warlock_chestplate",
            () -> new WarlockArmorItem(ArmorTiers.WARLOCK, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> WARLOCK_LEGGINGS = ITEMS.register("warlock_leggings",
            () -> new WarlockArmorItem(ArmorTiers.WARLOCK, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));

    public static final RegistryObject<ArmorItem> WARLOCK_BOOTS = ITEMS.register("warlock_boots",
            () -> new WarlockArmorItem(ArmorTiers.WARLOCK, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)));



    /// WEAPONS

    public static final RegistryObject<Item> INFERNAL_ROD = ITEMS.register("infernal_rod", () -> new InfernalRodItem(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB).stacksTo(1)
    ));

    public static final RegistryObject<Item> PELLET = ITEMS.register("kerosene_pellet", () -> new Item(
            new Item.Properties().tab(CreativeModeTabSnwy.SNWY_TAB)
    ));

}
