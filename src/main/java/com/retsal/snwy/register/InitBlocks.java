package com.retsal.snwy.register;

import com.retsal.snwy.SnwyMod;
import com.retsal.snwy.common.block.ShopBlock;
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
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = BLOCKS.register("deepslate_sapphire_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> SHOP_BLUE = BLOCKS.register("shop_blue",
            () -> new ShopBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .dynamicShape()
                    .noOcclusion()
                    .strength(10f, 30f)
            )
    );

    public static final RegistryObject<Block> SHOP_RED = BLOCKS.register("shop_red",
            () -> new ShopBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .dynamicShape()
                    .noOcclusion()
                    .strength(10f, 30f)
            )
    );
}
