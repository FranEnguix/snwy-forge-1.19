package com.retsal.snwy.common.block;

import com.retsal.snwy.register.InitItems;
import com.retsal.snwy.utility.CoinType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ShopBlock extends Block {
    /// Usage:
    ///  Place a sign in a block of your choice below (maximum set to 50 blocks below) the Shop block.
    ///  The first line must contain: <price> <g|c> <quantity> where g = gold coin, c = copper coin, t = token
    ///  The second, third and fourth lines are used to set the purchasable item id string.
    ///  Example:
    ///   1 g 5
    ///   minecraft:
    ///   acacia
    ///   _boat

    private static final VoxelShape SHAPE = makeShape();
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    final int MAX_SEARCH_DISTANCE = 50;

    public ShopBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!world.isClientSide()) {
            SignBlockEntity signBlockEntity = findSignBlockEntity(blockPos, world, MAX_SEARCH_DISTANCE);
            if (signBlockEntity != null) {
                if (buyItems(player, signBlockEntity, world))
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

    private boolean isContinued(SignBlockEntity sign) {
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        return spaceSeparatedText.length > 0 &&
                spaceSeparatedText[spaceSeparatedText.length - 1].equalsIgnoreCase("c"); // c = continue
    }

    private int getPrice(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin
        //          minecraft:boat
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        return Integer.parseInt(spaceSeparatedText[0]);
    }

    private CoinType getCoinType(SignBlockEntity sign) {
        // Example: 1 g 32          => g = gold coin; c = copper coin; t = token
        //          minecraft:boat
        String rawText = getSignText(sign)[0];
        String[] spaceSeparatedText = rawText.split("\\s+");
        String coinLetter = spaceSeparatedText[1];
        if (coinLetter.equalsIgnoreCase("g"))
            return CoinType.GOLD;
        else if (coinLetter.equalsIgnoreCase("c"))
            return CoinType.COPPER;
        else if (coinLetter.equalsIgnoreCase("t"))
            return CoinType.TOKEN;
        else
            return CoinType.NONE;
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

    private ItemStack getCoinType(CoinType coinType) {
        if (coinType == CoinType.GOLD)
            return InitItems.GOLD_COIN.get().getDefaultInstance();
        else if (coinType == CoinType.COPPER)
            return InitItems.COPPER_COIN.get().getDefaultInstance();
        else if (coinType == CoinType.TOKEN)
            return InitItems.TOKEN.get().getDefaultInstance();
        else
            return null;
    }

    private void doPayment(Inventory inv, ItemStack coins) {
        int price = coins.getCount();
        int sustractedQuantity = 0;
        while (sustractedQuantity < price) {
            int toSustract = price - sustractedQuantity;
            int moneySlot = inv.findSlotMatchingItem(coins);
            sustractedQuantity += inv.removeItem(moneySlot, Math.min(toSustract, 64)).getCount();
        }
    }

    private boolean buyItems(Player player, SignBlockEntity starterSign, Level world) {
        boolean continueSearching = false;
        Inventory inv = player.getInventory();
        SignBlockEntity sign = starterSign;
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        ArrayList<ItemStack> coins = new ArrayList<ItemStack>();
        do {
            if (sign == null)
                return false;
            mountObjects(coins, getCoin(sign));
            mountObjects(items, getPurchaseItem(sign));
            continueSearching = isContinued(sign);
            if (continueSearching)
                sign = findSignBlockEntity(sign.getBlockPos(), world, MAX_SEARCH_DISTANCE);
        } while (continueSearching);

        boolean hasMoney = playerHasMoney(inv, coins);
        if (hasMoney) {
            doPayments(inv, coins);
            for (ItemStack item : items)
                inv.placeItemBackInInventory(item);
        }
        return hasMoney;
    }

    private void doPayments(Inventory inv, ArrayList<ItemStack> coins) {
        for (ItemStack coin : coins)
            doPayment(inv, coin);
    }

    private boolean playerHasMoney(Inventory inv, ArrayList<ItemStack> coins) {
        boolean hasMoney = true;
        for (ItemStack coin : coins)
            hasMoney &= inv.countItem(coin.getItem()) >= coin.getCount();
        return hasMoney;
    }

    private ItemStack getPurchaseItem(SignBlockEntity sign) {
        int quantity = getQuantity(sign);
        ItemStack purchaseItem = getItem(sign);
        purchaseItem.setCount(quantity);
        return purchaseItem;
    }

    private ItemStack getCoin(SignBlockEntity sign) {
        int price = getPrice(sign);
        ItemStack coin = getCoinType(getCoinType(sign));
        coin.setCount(price);
        return coin;
    }

    private void mountObjects(ArrayList<ItemStack> bag, ItemStack obj) {
        if (bag.contains(obj)) {
            ItemStack objInBag = bag.get(bag.indexOf(obj));
            objInBag.setCount(objInBag.getCount() + obj.getCount());
        } else
            bag.add(obj);
    }

//    private boolean oldBuyItems(Player player, SignBlockEntity sign) {
//        Inventory inv = player.getInventory();
//        int price = getPrice(sign);
//        int quantity = getQuantity(sign);
//
//        ItemStack coin = getCoinType(getCoinType(sign));
//
//        ItemStack purchaseItem = getItem(sign);
//        purchaseItem.setCount(quantity);
//        coin.setCount(price);
//
//        int playerCoins = inv.countItem(coin.getItem());
//        if (!purchaseItem.isEmpty() && playerCoins >= price) {
//            doPayment(inv, coin);
//            inv.placeItemBackInInventory(purchaseItem);
//            return true;
//        }
//        return false;
//    }
}
