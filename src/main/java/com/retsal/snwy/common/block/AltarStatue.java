package com.retsal.snwy.common.block;

import com.retsal.snwy.register.InitBlocks;
import com.retsal.snwy.register.InitItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class AltarStatue extends Block {


//    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private MobEffectInstance effect;

    public AltarStatue(Properties properties, MobEffectInstance effect) {
        super(properties);
        this.effect = effect;
    }

//    public AltarStatue(BlockBehaviour.Properties properties) {
//        super(properties);
////        this.registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
//    }



    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!world.isClientSide()) {
            Inventory inventory = player.getInventory();
            if (inventory.getSelected().is(InitItems.GOLD_COIN.get())) {
                if (player.isAffectedByPotions())
                    player.removeAllEffects();
                MobEffectInstance effect = this.effect;
                player.addEffect(effect);
                inventory.getSelected().shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(!world.isClientSide());
    }

    //    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//    }

//    @Nullable
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
//        return defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
//    }
}
