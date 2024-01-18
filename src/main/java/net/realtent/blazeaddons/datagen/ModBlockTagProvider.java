package net.realtent.blazeaddons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.realtent.blazeaddons.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    public Block[] BlazeBlocks = new Block[]{
            ModBlocks.BLAZE_ROD_BLOCK,
            ModBlocks.BLAZE_ROD_SLAB,
            ModBlocks.BLAZE_ROD_STAIRS,
            ModBlocks.BLAZE_ROD_WALL,
            ModBlocks.BLAZE_ROD_FENCE,
            ModBlocks.BLAZE_ROD_DOOR,
            ModBlocks.BLAZE_ROD_TRAPDOOR
    };

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
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
