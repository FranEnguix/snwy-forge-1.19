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
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 120*20, 3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10*20, 2), 0.15f)
            .nutrition(4)
            .saturationMod(2)
            .alwaysEat()
            .fast()
            .build();

//    public static final FoodProperties FRESISUIS_LEMON = new FoodProperties.Builder()
//            .effect(() -> new EffectInstance(Effects.NAUSEA, 15*20, 3), 1f)
//            .effect(() -> new EffectInstance(Effects.SPEED, 40*20, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 10, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.POISON, 10*20, 2), 0.15f)
//            .hunger(4)
//            .saturation(2)
//            .meat()
//            .fastToEat()
//            .build();
//
//    public static final FoodProperties FRESISUIS_LIME = new FoodProperties.Builder()
//            .effect(() -> new EffectInstance(Effects.NAUSEA, 15*20, 3), 1f)
//            .effect(() -> new EffectInstance(Effects.SPEED, 40*20, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 10, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.POISON, 10*20, 2), 0.15f)
//            .hunger(4)
//            .saturation(2)
//            .meat()
//            .fastToEat()
//            .build();
//
//    public static final FoodProperties FRESISUIS_ORANGE = new FoodProperties.Builder()
//            .effect(() -> new EffectInstance(Effects.NAUSEA, 15*20, 3), 1f)
//            .effect(() -> new EffectInstance(Effects.SPEED, 40*20, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 10, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.POISON, 10*20, 2), 0.15f)
//            .hunger(4)
//            .saturation(2)
//            .meat()
//            .fastToEat()
//            .build();
//
//    public static final FoodProperties FRESISUIS_STRAWBERRY = new FoodProperties.Builder()
//            .effect(() -> new EffectInstance(Effects.NAUSEA, 15*20, 3), 1f)
//            .effect(() -> new EffectInstance(Effects.SPEED, 40*20, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 10, 2), 1f)
//            .effect(() -> new EffectInstance(Effects.POISON, 10*20, 2), 0.15f)
//            .hunger(4)
//            .saturation(2)
//            .meat()
//            .fastToEat()
//            .build();
}
