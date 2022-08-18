package com.retsal.snwy.register;

import com.google.common.base.Suppliers;
import com.retsal.snwy.SnwyMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class InitConfiguredFeature {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SnwyMod.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> SAPPHIRE_OVERWORLD_REPLACEMENT =
            Suppliers.memoize(() -> List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitBlocks.SAPPHIRE_ORE.get().defaultBlockState())
            ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPPHIRE_OVERWORLD_ORE = CONFIGURED_FEATURE.register(
            "sapphire_overworld_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPPHIRE_OVERWORLD_REPLACEMENT.get(), 8))); // p161014 = vein size


}
