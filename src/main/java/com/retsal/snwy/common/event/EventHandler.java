package com.retsal.snwy.common.event;


import com.retsal.snwy.SnwyMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void blockPlaced(BlockEvent.EntityPlaceEvent e) {
        Entity entity = e.getEntity();
        if (entity != null && !entity.getLevel().isClientSide()) {
            if (e.getEntity() instanceof ServerPlayer) {
                Block block = e.getPlacedBlock().getBlock();
                String blockId = block.asItem().getDescriptionId().substring(6);
                String playerName = entity.getName().getString();
                String coordinates = getCoordinates(e.getPos());
                if (blockId.startsWith("securitycraft")) {
                    SnwyMod.LOGGER.info(logBlockFormat(blockId, playerName, coordinates));
                }
            }
        }
    }

    private String getCoordinates(BlockPos pos) {
        return "[" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + "]";
    }

    private String logBlockFormat(String blockId, String playerName, String coordinates) {
        return blockId + ":" + playerName + ":" + coordinates;
    }

}
