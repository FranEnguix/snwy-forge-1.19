package com.retsal.snwy.common;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class IntegrationFood {
    public static final FoodProperties GLOWING_SUPPOSITORY = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60*20, 1), 1f)
            .nutrition(0)
            .saturationMod(0)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties FRESISUIS_BLUEBERRY = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15*20, 2), 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 120*20, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 2), 0.15f)
            .nutrition(4)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties FRESISUIS_LEMON = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15*20, 2), 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 120*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 1), 0.15f)
            .nutrition(4)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties FRESISUIS_LIME = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15*20, 2), 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 120*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 1), 0.15f)
            .nutrition(4)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties FRESISUIS_ORANGE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15*20, 2), 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 10*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 1), 0.15f)
            .nutrition(4)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties FRESISUIS_STRAWBERRY = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 10*20, 1), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 10*20, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 1), 0.25f)
            .nutrition(4)
            .alwaysEat()
            .fast()
            .build();
}
