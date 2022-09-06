package com.retsal.snwy.utility;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PlayerHead {

    public static ItemStack getPlayerHead(String playerName) {
        ItemStack head = new ItemStack(Items.PLAYER_HEAD, 1);
        CompoundTag nbtTag = head.getOrCreateTag();
        nbtTag.putString("SkullOwner", playerName);
        head.setTag(nbtTag);
        return head;
    }
}
