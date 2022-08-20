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

public class AltarStatueDigSpeed extends AltarStatue {

    public AltarStatueDigSpeed(Properties properties) {
        super(properties, new MobEffectInstance(MobEffects.DIG_SPEED, 15 * 60 * 20, 0));
    }

    private static final VoxelShape SHAPE = makeShape();

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.0625, 0.0625, 0.625, 0.125, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.0625, 0.625, 0.1875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.125, 0.125, 0.625, 0.1875, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.25, 0.625, 0.1875, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.125, 0.4375, 0.1875, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.4375, 0.9375, 0.6875, 0.75), BooleanOp.OR);
        return shape;
    }
}
