package com.arcticquests.raid.item;

import com.arcticquests.raid.SplashOminous;
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

    public static Potion OMINOUS_POTION;

    public static Potion registerPotion(String name) {

        return Registry.register(Registries.POTION,  Identifier.of(SplashOminous.MOD_ID, name),
                new Potion(new StatusEffectInstance(StatusEffects.BAD_OMEN, 120000, 4)));
    }

    public static void registerPotions() {
        OMINOUS_POTION = registerPotion("ominous_potion");
        registerPotionRecipes();

        System.out.println("Registering The Potion & Recipes For + " + SplashOminous.MOD_ID);

    }

    private static void registerPotionRecipes() {

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(

					// Input potion.
					Potions.WATER,
					// Ingredient
					Items.OMINOUS_BOTTLE,
					// Output potion.
					Registries.POTION.getEntry(OMINOUS_POTION)
			);
		});
    }
}


