package net.realtent.blazeaddons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.realtent.blazeaddons.block.ModBlocks;
import net.realtent.blazeaddons.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        /*
        BlockStateModelGenerator.BlockTexturePool blazePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEBUG_BLAZE_ROD_BLOCK);

        blazePool.slab(ModBlocks.BLAZE_ROD_SLAB);
        blazePool.stairs(ModBlocks.BLAZE_ROD_STAIRS);
        blazePool.wall(ModBlocks.BLAZE_ROD_WALL);
        blazePool.fence(ModBlocks.BLAZE_ROD_FENCE);

        blockStateModelGenerator.registerDoor(ModBlocks.BLAZE_ROD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BLAZE_ROD_TRAPDOOR);
        */
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.IMPACT_CASING, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMED_MINIROCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINIROCKET, Models.GENERATED);
    }
}
