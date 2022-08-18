package com.retsal.snwy.common.block;

import com.retsal.snwy.register.InitItems;
import com.retsal.snwy.utility.CoinType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

public class ShopBlock extends Block {
    /// Usage:
    ///  Place a sign in a block of your choice below (maximum set to 30 blocks below) the Shop block.
    ///  The first line must contain: <price> <g|c> <quantity> where g = gold coin and c = copper coin
    ///  The second, third and fourth lines are used to set the purchasable item id string.
    ///  Example:
    ///   1 g 5
    ///   minecraft:
    ///   acacia
    ///   _boat

    private static final VoxelShape SHAPE = makeShape();

    public ShopBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 1, 1), BooleanOp.OR);

        return shape;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!world.isClientSide()) {
            final int MAX_SEARCH_DISTANCE = 30;
            SignBlockEntity signBlockEntity = findSignBlockEntity(blockPos, world, MAX_SEARCH_DISTANCE);
            if (signBlockEntity != null) {
                if (buyItem(player, signBlockEntity))
                    world.playSound(null,
                            player.position().x, player.position().y, player.position().z,
                            SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.AMBIENT, 1, 1f
                    );
                else
                    world.playSound(null,
                            player.position().x, player.position().y, player.position().z,
                            SoundEvents.BAMBOO_PLACE, SoundSource.AMBIENT, 1, 1f
                    );
            }
        }
        return InteractionResult.sidedSuccess(!world.isClientSide());
    }

    private SignBlockEntity findSignBlockEntity(BlockPos shopPosition, Level world, final int MAX_SEARCH_DISTANCE) {
        for (int i = 1; i <= MAX_SEARCH_DISTANCE; i++) {
            BlockEntity block = world.getBlockEntity(shopPosition.below(i));
            if (block instanceof SignBlockEntity)
                return (SignBlockEntity) block;
        }
        return null;
    }


    private int getPrice(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin
        //          minecraft:boat
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        return Integer.parseInt(spaceSeparatedText[0]);
    }

    private CoinType getCoinType(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin
        //          minecraft:boat
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        String coinLetter = spaceSeparatedText[1];
        if (coinLetter.equalsIgnoreCase("g"))
            return CoinType.GOLD;
        else
            return CoinType.COPPER;
    }

    private int getQuantity(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin
        //          minecraft:boat
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        return Integer.parseInt(spaceSeparatedText[2]);
    }

    private ItemStack getItem(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin
        //          minecraft:boat
        String[] rawText = getSignText(sign);
        String itemId = rawText[1].trim() + rawText[2].trim() + rawText[3].trim();
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId)));
    }

    private String[] getSignText(SignBlockEntity sign) {
        String[] text = new String[4];
        for (int i = 0; i < 4; i++)
            text[i] = sign.getMessage(i, false).getString();
        return text;
    }

    private ItemStack getCoin(CoinType coinType) {
        if (coinType == CoinType.GOLD)
            return InitItems.GOLD_COIN.get().getDefaultInstance();
        else
            return InitItems.COPPER_COIN.get().getDefaultInstance();
    }

    private void doPayment(Inventory inv, ItemStack coins) {
        int quantity = coins.getCount();
        inv.removeItem(inv.findSlotMatchingItem(coins), quantity);
    }

    private boolean buyItem(Player player, SignBlockEntity sign) {
        Inventory inv = player.getInventory();
        int price = getPrice(sign);
        int quantity = getQuantity(sign);
        ItemStack purchaseItem = getItem(sign);
        ItemStack coin = getCoin(getCoinType(sign));
        purchaseItem.setCount(quantity);
        coin.setCount(price);

        int playerCoins = inv.countItem(coin.getItem());
        if (!purchaseItem.isEmpty() && playerCoins >= price) {
            doPayment(inv, coin);
            inv.placeItemBackInInventory(purchaseItem);
            return true;
        }
        return false;
    }
}
