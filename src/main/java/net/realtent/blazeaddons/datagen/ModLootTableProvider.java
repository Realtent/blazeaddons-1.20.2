package net.realtent.blazeaddons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.block.ModBlocks;

import java.util.function.BiConsumer;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.BLAZE_ROD_BLOCK, blazeRodItemDrops(ModBlocks.BLAZE_ROD_BLOCK, 16.0f, 20.0f));
        addDrop(ModBlocks.BLAZE_ROD_SLAB, blazeRodItemDrops(ModBlocks.BLAZE_ROD_SLAB, 8.0f, 10.0f));
        addDrop(ModBlocks.BLAZE_ROD_STAIRS, blazeRodItemDrops(ModBlocks.BLAZE_ROD_STAIRS, 16.0f, 20.0f));
        addDrop(ModBlocks.BLAZE_ROD_FENCE, blazeRodItemDrops(ModBlocks.BLAZE_ROD_FENCE, 8.0f, 10.0f));
        addDrop(ModBlocks.BLAZE_ROD_WALL, blazeRodItemDrops(ModBlocks.BLAZE_ROD_WALL, 10.0f, 14.0f));
        addDrop(ModBlocks.BLAZE_ROD_DOOR, blazeRodItemDrops(ModBlocks.BLAZE_ROD_DOOR, 10.0f, 14.0f));
        addDrop(ModBlocks.BLAZE_ROD_TRAPDOOR, blazeRodItemDrops(ModBlocks.BLAZE_ROD_TRAPDOOR, 8.0f, 12.0f));

    }

    public LootTable.Builder blazeRodItemDrops(Block drop, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(Items.BLAZE_POWDER)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
