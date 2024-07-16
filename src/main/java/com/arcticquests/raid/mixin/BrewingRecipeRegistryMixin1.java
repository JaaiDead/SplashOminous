package com.arcticquests.raid.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Mixin(BrewingRecipeRegistry.class)
@Debug(export = true)
public class BrewingRecipeRegistryMixin1 {

    @Unique
    HashMap<Pair<Item, Ingredient>, RegistryEntry<Potion>> recipes = new HashMap<>() {{
        put(new Pair<>(Items.SPLASH_POTION, Ingredient.ofItems(Items.GOLD_INGOT)), Potions.HARMING);

    }};

    @ModifyExpressionValue(method = "hasRecipe", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/BrewingRecipeRegistry;hasItemRecipe(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"))
    private boolean hasBrewingRecipe(boolean original, @Local(name = "input") ItemStack input, @Local(name = "ingredient") ItemStack ingredient) {
        return original || hasItemToPotionRecipe(input, ingredient);
    }

    @ModifyReturnValue(method = "craft", at = @At(value = "RETURN"))
    private ItemStack shimCraft(ItemStack original, @Local(argsOnly = true, ordinal = 1) ItemStack input, @Local(argsOnly = true, ordinal = 0) ItemStack ingredient) {
        Optional<Map.Entry<Pair<Item, Ingredient>, RegistryEntry<Potion>>> potion = recipes.entrySet().stream().filter(pair -> pair.getKey().getLeft().equals(input.getItem()) && pair.getKey().getRight().test(ingredient)).findFirst();
        return potion.map(pairRegistryEntryEntry -> PotionContentsComponent.createStack(Items.SPLASH_POTION, pairRegistryEntryEntry.getValue())).orElse(original);
    }

    @ModifyReturnValue(method = "isValidIngredient", at = @At(value = "RETURN"))
    private boolean shimIsValidIngredient(boolean original, @Local(argsOnly = true) ItemStack stack) {
        return original || recipes.keySet().stream().anyMatch(pair -> pair.getRight().test(stack));
    }

    @Unique
    private boolean hasItemToPotionRecipe(ItemStack input, ItemStack ingredient) {
        return recipes.keySet().stream().anyMatch(pair -> pair.getLeft().equals(input.getItem()) && pair.getRight().test(ingredient));
    }
}