package net.realtent.blazeaddons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.realtent.blazeaddons.block.ModBlocks;
import net.realtent.blazeaddons.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.BLAZE_ROD_BLOCKS)
                .add(ModBlocks.BLAZE_ROD_BLOCK)
                .add(ModBlocks.BLAZE_ROD_SLAB)
                .add(ModBlocks.BLAZE_ROD_STAIRS)
                .add(ModBlocks.BLAZE_ROD_WALL)
                .add(ModBlocks.BLAZE_ROD_FENCE)
                .add(ModBlocks.BLAZE_ROD_DOOR)
                .add(ModBlocks.BLAZE_ROD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLAZE_ROD_BLOCK)
                .add(ModBlocks.BLAZE_ROD_SLAB)
                .add(ModBlocks.BLAZE_ROD_STAIRS)
                .add(ModBlocks.BLAZE_ROD_WALL)
                .add(ModBlocks.BLAZE_ROD_FENCE)
                .add(ModBlocks.BLAZE_ROD_DOOR)
                .add(ModBlocks.BLAZE_ROD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLAZE_ROD_BLOCK)
                .add(ModBlocks.BLAZE_ROD_SLAB)
                .add(ModBlocks.BLAZE_ROD_STAIRS)
                .add(ModBlocks.BLAZE_ROD_WALL)
                .add(ModBlocks.BLAZE_ROD_FENCE)
                .add(ModBlocks.BLAZE_ROD_DOOR)
                .add(ModBlocks.BLAZE_ROD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BLAZE_ROD_FENCE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BLAZE_ROD_WALL);


    }
}
