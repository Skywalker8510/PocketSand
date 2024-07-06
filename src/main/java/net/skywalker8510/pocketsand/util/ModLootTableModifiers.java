package net.skywalker8510.pocketsand.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.skywalker8510.pocketsand.Item.ModItems;
import net.skywalker8510.pocketsand.PocketSand;

public class ModLootTableModifiers {

    private static final Identifier HUSK_LOOT_TABLE_ID =
            new Identifier("minecraft","entities/husk");

    public static void modifyLootTables() {

        PocketSand.LOGGER.info("Registering Loot Tables for " + PocketSand.MOD_ID);

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            // Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
            // We also check that the loot table ID is equal to the ID we want.
            if (source.isBuiltin() && HUSK_LOOT_TABLE_ID.equals(key.getValue())) {
                // We make the pool and add an item
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.POCKET_SAND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
