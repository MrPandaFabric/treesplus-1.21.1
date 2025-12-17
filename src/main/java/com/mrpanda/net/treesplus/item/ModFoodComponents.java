package com.mrpanda.net.treesplus.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent HALF_COCONUT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F)
            .snack().build();
}