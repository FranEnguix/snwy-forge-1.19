package com.retsal.snwy;

import com.mojang.logging.LogUtils;
import com.retsal.snwy.client.event.ClientEventHandler;
import com.retsal.snwy.common.event.EventHandler;
import com.retsal.snwy.register.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(SnwyMod.MODID)
public class SnwyMod
{
    public static final String MODID = "snwy";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SnwyMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus(),
                forgeBus = MinecraftForge.EVENT_BUS;

        InitBlocks.BLOCKS.register(modBus);
        InitItems.ITEMS.register(modBus);
        InitSounds.SOUNDS.register(modBus);
        InitConfiguredFeature.CONFIGURED_FEATURE.register(modBus);
        InitPlacedFeature.PLACED_FEATURES.register(modBus);

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        }
    }

}
