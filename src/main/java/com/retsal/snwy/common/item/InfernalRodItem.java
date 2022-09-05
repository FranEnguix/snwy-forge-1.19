package com.retsal.snwy.common.item;

import com.retsal.snwy.ClientAccessibility;
import com.retsal.snwy.common.armor.WarlockArmorItem;
import com.retsal.snwy.register.InitItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfernalRodItem extends Item {

    private final float COOLDOWN_HIT_ATTACK_SECONDS = 0.5f;
    private final float COOLDOWN_THROW_ATTACK_SECONDS = 1.5f;
    private final int HIT_DAMAGE = 4;

    public InfernalRodItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, components, tooltipFlag);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientAccessibility.infernalRodItemTooltip(components));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            int armorPieces = WarlockArmorItem.getNumberOfSetPiecesEquipped(player);
            if (armorPieces >= 4 && getNumberOfPellets(player) > 0 && !player.getCooldowns().isOnCooldown(this)) {
                player.getCooldowns().addCooldown(this, (int)(COOLDOWN_THROW_ATTACK_SECONDS * 20));
                final double OFFSET = 0.05f;
                final double AMPLITUDE = 0.2f;
                Vec3 viewPosition = player.getViewVector(1);
                launchSmallFireball(viewPosition, player);
                launchSmallFireball(new Vec3(viewPosition.x + (OFFSET + (AMPLITUDE * Math.random())), viewPosition.y, viewPosition.z + (OFFSET + (AMPLITUDE * Math.random()))), player);
                launchSmallFireball(new Vec3(viewPosition.x - (OFFSET + (AMPLITUDE * Math.random())), viewPosition.y, viewPosition.z - (OFFSET + (AMPLITUDE * Math.random()))), player);
                usePellet(player);
            }
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level.isClientSide() && entity instanceof LivingEntity) {
            int armorPieces = WarlockArmorItem.getNumberOfSetPiecesEquipped(player);
            if (armorPieces >= 3 && getNumberOfPellets(player) > 0 && !player.getCooldowns().isOnCooldown(InitItems.PELLET.get())) {
                player.getCooldowns().addCooldown(InitItems.PELLET.get(), (int)(COOLDOWN_HIT_ATTACK_SECONDS * 20));
                Vec3 vec3 = player.getViewVector(1);
                double d2 = entity.getX() - (player.getX() + vec3.x * 4f);
                double d3 = entity.getY(0.5f) - (0.5f + player.getY(0.5f));
                double d4 = entity.getZ() - (player.getZ() + vec3.z * 4f);
                entity.setSecondsOnFire(5);
                LargeFireball largefireball = new LargeFireball(player.level, player, d2, d3, d4, 1);
                largefireball.setPos(player.getX() + vec3.x * 4f, player.getY(0.5f) + 0.5f, largefireball.getZ() + vec3.z * 4f);
                player.level.addFreshEntity(largefireball);
                entity.hurt(DamageSource.ON_FIRE, HIT_DAMAGE);
                usePellet(player);
                return true;
            }
        }
        return false;
    }

    private void launchSmallFireball(Vec3 direction, Player player) {
        SmallFireball smallFireball = new SmallFireball(player.getLevel(), player, direction.x, direction.y, direction.z);
        smallFireball.setPos(player.getEyePosition());
        player.level.addFreshEntity(smallFireball);
    }

    private int getNumberOfPellets(Player player) {
        Inventory inv = player.getInventory();
        return inv.countItem(InitItems.PELLET.get());
    }

    private void usePellet(Player player) {
        Inventory inv = player.getInventory();
        int pelletSlot = inv.findSlotMatchingItem(InitItems.PELLET.get().getDefaultInstance());
        inv.removeItem(pelletSlot, 1);
    }

}
