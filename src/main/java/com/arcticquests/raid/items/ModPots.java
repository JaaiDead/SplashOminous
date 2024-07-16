package com.arcticquests.raid.items;

import com.arcticquests.raid.SplashOminous;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;



public class ModPots {
	public static  Potion SPLASH_OMINOUS_BOTTLE;
    public static  Potion LINGERING_OMINOUS_BOTTLE;

    public static Potion registerPotion (String name){

        return Registry.register(Registries.POTION, Identifier.of(SplashOminous.MOD_ID, name),new Potion(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1600, 5)));
    }

	@SuppressWarnings("unchecked")
	public static void registerPotionRecipes(){

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			try {
				builder.registerPotionRecipe(
					
						(RegistryEntry<Potion>) // Input potion.
						Items.OMINOUS_BOTTLE,
						// Ingredient
						Items.GUNPOWDER,

						// Output potion.
						RegistryEntry.of(SPLASH_OMINOUS_BOTTLE)
				);
			} catch (Exception e) {
				e.printStackTrace();
				throw new AssertionError("Must be implemented via interface injection");
			}
		});

        /*FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
				
					(RegistryEntry<Potion>)
					// Input potion.
					Potion.SPLASH_OMINOUS_BOTTLE,
					// Ingredient
					Items.DRAGON_BREATH,
					// Output potion.
					RegistryEntry.of(LINGERING_OMINOUS_BOTTLE)
			);
		});*/
	}

    public static void registerPotionItem(){
        System.out.println("Registering Potions For " + SplashOminous.MOD_ID);
    }

   
}


