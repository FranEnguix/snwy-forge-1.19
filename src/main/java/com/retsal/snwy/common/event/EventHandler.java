package com.retsal.snwy.common.event;


import com.retsal.snwy.SnwyMod;
import com.retsal.snwy.utility.PlayerHead;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class EventHandler {

    @SubscribeEvent()
    public void onLivingDeath(LivingDeathEvent e) {
        Entity entity = e.getEntity();
        Level world = entity.getLevel();
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            DamageSource damageSource = e.getSource();
            if (damageSource.getEntity() instanceof ServerPlayer) {
//                Vec3 killedPos = player.getPosition(1);
                ItemStack head = PlayerHead.getPlayerHead(player.getName().getString());
//                ItemEntity headEntity = new ItemEntity(world, getPosition(killedPos.x), killedPos.y + 1, getPosition(killedPos.z), head);
//                world.addFreshEntity(headEntity);
                player.drop(head, true);
            }
        }
    }

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

//    private double getPosition(double pos) {
//        double x1 = pos - 2;
//        double x2 = pos + 2;
//        double f = Math.random()/Math.nextDown(1.0);
//        return x1*(1.0 - f) + x2*f;
//    }

//    public void onAttack(AttackEntityEvent e) {
//        if (!e.getEntity().level.isClientSide()) {
//            Entity entity = e.getTarget();
//            if (entity instanceof ServerPlayer player)
//                if (player.isDeadOrDying())
//                    player.hurt(DamageSource.DRAGON_BREATH, 1);
//        }
//    }

//    public void onServerChatEvent(ServerChatEvent e) {
//        Component component = e.getComponent();
//        String[] msg = component.getString().split(" ");
//        ServerPlayer serverPlayer = e.getPlayer();
//        if (serverPlayer != null) {
//            Level world = e.getPlayer().getLevel();
//            for (String arg : msg) {
//                List<Player> players = world.players().stream().findFirst();
//                if (players.stream().anyMatch(player -> player.getName().getString().equalsIgnoreCase(arg)))
//                    serverPlayer.sendSystemMessage(Component.literal(arg));
//            }
//        }
//
////        if (component instanceof TranslatableContents translatable) {
////            if (translatable.getKey().contains("death.attack") || true) {
////                Object[] args = translatable.getArgs();
////                Level world = e.getPlayer().getLevel();
////                for (int i = 0; i < args.length; i++) {
////                    String arg = args[i].toString();
////                    e.getPlayer().sendSystemMessage(Component.literal(arg));
//////                    if (world.players().stream().anyMatch(player -> player.getName().getString().equalsIgnoreCase(arg)))
//////                        e.setCanceled(true);
////                }
//////                e.setCanceled(true);
////            }
////        }
//    }

}
