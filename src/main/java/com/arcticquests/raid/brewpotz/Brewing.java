package com.arcticquests.raid.brewpotz;

import com.arcticquests.raid.SplashOminous;
import com.arcticquests.raid.mixin.BrewingRecipeRegistryMixin1;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry.Builder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;



public class Brewing {
    public static  RegistryEntry<Potion> SPLASH_OMINOUS_BOTTLE;
    public static  RegistryEntry<Potion> LINGERING_OMINOUS_BOTTLE;

    public static RegistryEntry<Potion> registerPotion(String name) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SplashOminous.MOD_ID, name),
        new Potion(new StatusEffectInstance(StatusEffects.BAD_OMEN, 120000, 5)));
    }
 
    public static void registerPotions() {
        SPLASH_OMINOUS_BOTTLE = registerPotion("splash_ominous_bottle");
        LINGERING_OMINOUS_BOTTLE = registerPotion("lingering_ominous_bottle");
    }

    @SuppressWarnings("unchecked")
    private static void registerPotionRecipes(){

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					(RegistryEntry<Potion>)
                     // Input potion.
					Items.LINGERING_POTION,
					// Ingredient
					Items.DRAGON_BREATH,
					// Output potion.
			        LINGERING_OMINOUS_BOTTLE
			);
		});
	
	}

    @SuppressWarnings("unchecked")
    private static void extracted(Builder builder) {
        builder.registerPotionRecipe(
        		 (RegistryEntry<Potion>) // Input potion.
        		Items.SPLASH_POTION,
        		// Ingredient
        		Items.OMINOUS_BOTTLE,
        		// Output potion.
        		SPLASH_OMINOUS_BOTTLE
        );

    }   

    public static void registerModItems() {
 
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)  
        .register((itemGroup) -> itemGroup.equals(LINGERING_OMINOUS_BOTTLE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
        .register((itemGroup) -> itemGroup.equals(SPLASH_OMINOUS_BOTTLE));
        
        registerPotionRecipes();
        registerPotions();
        System.out.println("Registering Mod Items for " + SplashOminous.MOD_ID);
    }
 
}



