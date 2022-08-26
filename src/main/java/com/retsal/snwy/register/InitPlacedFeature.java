package com.retsal.snwy.register;

import com.retsal.snwy.SnwyMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class InitPlacedFeature {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SnwyMod.MODID);

    public static final RegistryObject<PlacedFeature> SAPPHIRE_OVERWORLD_ORE = PLACED_FEATURES.register("sapphire_overworld_ore",
            () -> new PlacedFeature(InitConfiguredFeature.SAPPHIRE_OVERWORLD_ORE.getHolder().get(),
                    commonOrePlacement(5, HeightRangePlacement.triangle(
                            VerticalAnchor.bottom(),                // Bottom anchor -> bottom of the world
                            VerticalAnchor.absolute(40)    // Upper anchor -> y=40
                    ))));

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }
}
