package com.arcticquests.raid.brewpotz;

import com.arcticquests.raid.SplashOminous;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;



public class Brewing {

	public static final Item SPLASH_OMINOUS_BOTTLE = registerItem("splash_ominous_bottle", new Item(new Item.Settings()));
	public static final Item LINGERING_OMINOUS_BOTTLE = registerItem("lingering_ominous_bottle", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {

		return  Registry.register(Registries.ITEM, Identifier.of(SplashOminous.MOD_ID,name), item);
    }

    private static void registerPotionRecipes(){

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerItemRecipe(
					// Input potion.
					Items.SPLASH_POTION,
					// Ingredient
					Items.OMINOUS_BOTTLE,
					(Item) // Output potion.
					RegistryEntry.of(SPLASH_OMINOUS_BOTTLE)
			);
		});

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerItemRecipe(
					// Input potion.
					Items.LINGERING_POTION,
					// Ingredient
					Items.DRAGON_BREATH,
					// Output potion.
					(Item)
					RegistryEntry.of(LINGERING_OMINOUS_BOTTLE)
			);
		});
	
	} 

    public static void registerModItems() {

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)  
        .register((itemGroup) -> itemGroup.add(LINGERING_OMINOUS_BOTTLE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
        .register((itemGroup) -> itemGroup.add(SPLASH_OMINOUS_BOTTLE));

		registerPotionRecipes();

        System.out.println("Registering Mod Items for " + SplashOminous.MOD_ID);
    }

}




