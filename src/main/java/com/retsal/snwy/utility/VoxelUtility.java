package com.retsal.snwy.utility;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;

public class VoxelUtility {
//    public static Shapes rotateShape(Direction from, Direction to, Shapes shape) {
//        Shapes[] buffer = new Shapes[]{ shape, Shapes.empty() };
//
//        int times = (to.getHorizontalIndex() - from.getHorizontalIndex() + 4) % 4;
//        for (int i = 0; i < times; i++) {
//            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
//            buffer[0] = buffer[1];
//            buffer[1] = Shapes.empty();
//        }
//
//        return buffer[0];
//    }

//    Original: https://forums.minecraftforge.net/topic/74979-1144-rotate-voxel-shapes/
//    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
//        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };
//
//        int times = (to.getHorizontalIndex() - from.getHorizontalIndex() + 4) % 4;
//        for (int i = 0; i < times; i++) {
//            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.create(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
//            buffer[0] = buffer[1];
//            buffer[1] = VoxelShapes.empty();
//        }
//
//        return buffer[0];
//    }
}
