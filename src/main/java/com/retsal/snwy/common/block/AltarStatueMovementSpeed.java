package com.retsal.snwy.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AltarStatueMovementSpeed extends AltarStatue {

    public AltarStatueMovementSpeed(Properties properties) {
        super(properties, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30 * 60 * 20, 0));
    }

    private static final VoxelShape SHAPE = makeShape();

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.0625, 0.5, 0.6875, 0.375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.5, 0.4375, 0.375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.0625, 0.0625, 0.625, 0.125, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.0625, 0.625, 0.1875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.125, 0.4375, 0.1875, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.125, 0.125, 0.625, 0.1875, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.25, 0.625, 0.1875, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.375, 0.5, 0.6875, 0.9375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.9375, 0.375, 0.6875, 1.3125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.1875, 0.3125, 0.4375, 1.25, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 1.1875, 0.3125, 0.625, 1.25, 0.375), BooleanOp.OR);
        return shape;
    }
}
