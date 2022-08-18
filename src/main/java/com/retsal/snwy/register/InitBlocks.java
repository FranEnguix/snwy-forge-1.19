package com.retsal.snwy.register;

import com.retsal.snwy.SnwyMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SnwyMod.MODID);

    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST))
    );
}
