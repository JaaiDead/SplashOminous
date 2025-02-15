package com.arcticquests.raid.item;

import com.arcticquests.raid.SplashHunger;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;


public class Modpotion {

    public static Potion HUNGER_POTION;

    public static Potion registerPotion(String name) {

        return Registry.register(Registries.POTION,  Identifier.of(SplashHunger.MOD_ID, name),
                new Potion(name,
                        new StatusEffectInstance(
                                StatusEffects.SATURATION,
                                12000,
                                3)));
    }

    public static void registerPotions() {
        HUNGER_POTION = registerPotion("hunger");
        registerPotionRecipes();
        System.out.println("Registering The Potion & Recipes For + " + SplashHunger.MOD_ID);

    }

    private static void registerPotionRecipes() {

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(

					// Input potion.
					Potions.WATER,
					// Ingredient
					Items.BAKED_POTATO,
					// Output potion.
					Registries.POTION.getEntry(HUNGER_POTION)
			);
		});
    }
}


