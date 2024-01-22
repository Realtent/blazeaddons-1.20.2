package net.realtent.blazeaddons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.block.ModBlocks;
import net.realtent.blazeaddons.item.ModItems;

public class ModRecipeProvider extends FabricRecipeProvider {
     public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLAZE_ROD_BLOCK, Items.BLAZE_ROD);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMPACT_CASING, 1)
                .pattern("BMB")
                .pattern("MBM")
                .pattern("BMB")
                .input('B', Items.NETHER_BRICK)
                .input('M', Items.MAGMA_CREAM)
                .criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
                .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPACT_CASING)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PRIMED_MINIROCKET, 1)
                .pattern("BI")
                .pattern("GB")
                .input('I', ModItems.IMPACT_CASING)
                .input('B', Items.BLAZE_POWDER)
                .input('G', Items.GUNPOWDER)
                .criterion(hasItem(ModItems.IMPACT_CASING), conditionsFromItem(ModItems.IMPACT_CASING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PRIMED_MINIROCKET)));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLAZE_ROD_SLAB, ModBlocks.BLAZE_ROD_BLOCK);
        RecipeProvider.createStairsRecipe(ModBlocks.BLAZE_ROD_STAIRS, Ingredient.ofItems(ModBlocks.BLAZE_ROD_BLOCK))
                .criterion(RecipeProvider.hasItem(ModBlocks.BLAZE_ROD_BLOCK), RecipeProvider.conditionsFromItem(ModBlocks.BLAZE_ROD_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BLAZE_ROD_FENCE, 8)
                .pattern("W#W")
                .pattern("W#W")
                .input('W', ModBlocks.BLAZE_ROD_BLOCK)
                .input('#', Items.BLAZE_ROD)
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BLAZE_ROD_FENCE)));

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLAZE_ROD_WALL, ModBlocks.BLAZE_ROD_BLOCK);

        RecipeProvider.createDoorRecipe(ModBlocks.BLAZE_ROD_DOOR, Ingredient.ofItems(Items.BLAZE_ROD))
                .criterion(RecipeProvider.hasItem(Items.BLAZE_ROD), RecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.BLAZE_ROD_TRAPDOOR, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', Items.BLAZE_ROD);



        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_BLOCK,null,18);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_SLAB,null,9);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_STAIRS,null,18);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_FENCE,null,9);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_WALL,null,12);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_DOOR,null,12);
        offerShapelessRecipe(exporter, Items.BLAZE_POWDER, ModBlocks.BLAZE_ROD_TRAPDOOR,null,10);
    }
}
