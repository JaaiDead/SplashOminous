package com.arcticquests.raid.loottable;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class LootTableModifier {

  private static final Identifier YOUR_ENTITY_ID = Identifier.of("namespace", "entities/your_entity");
  private static final Identifier YOUR_ITEM_ID = Identifier.of("namespace", "item");

  public static void modifyLootTables() {
      LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
          if (YOUR_ENTITY_ID.equals(key.getValue())) {
             LootPool lootPool = LootPool.builder()
                .with(ItemEntry.builder(Registries.ITEM.get(YOUR_ITEM_ID)))
                .build();

            tableBuilder.pool(lootPool);
          }     
    });
  }
} 