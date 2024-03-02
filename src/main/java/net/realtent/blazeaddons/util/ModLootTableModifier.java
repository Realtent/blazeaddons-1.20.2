package net.realtent.blazeaddons.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.block.ModBlocks;
import net.realtent.blazeaddons.item.ModItems;

public class ModLootTableModifier {
    private static final Identifier NETHER_FORTRESS_ID =
            new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier BLAZE_ID =
            new Identifier("minecraft", "entities/blaze");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(NETHER_FORTRESS_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_SLAB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_STAIRS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_FENCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_WALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_DOOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_TRAPDOOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.IMPACT_CASING))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.PRIMED_MINIROCKET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceLootCondition.builder(0.15f)) // Drops 15% of the time
                        .with(ItemEntry.builder(ModItems.PRIMED_MINIROCKET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());


                tableBuilder.pool(poolBuilder.build());
            }
            if(BLAZE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f)) // Drops 0.25% of the time
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_SLAB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_STAIRS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_FENCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_WALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_DOOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.005f, 2f))
                        .with(ItemEntry.builder(ModBlocks.BLAZE_ROD_TRAPDOOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
