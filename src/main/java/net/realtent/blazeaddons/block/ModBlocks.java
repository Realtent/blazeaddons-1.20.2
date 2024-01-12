package net.realtent.blazeaddons.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;

public class ModBlocks {

    public static final Block BLAZE_ROD_BLOCK = registerBlock("blaze_rod_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(4.5f, 3.0f).instrument(Instrument.PLING).sounds(BlockSoundGroup.GLASS).luminance(state -> 10).requiresTool()));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BlazeAddons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(BlazeAddons.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks(){
        BlazeAddons.LOGGER.info("Registering Mod Blocks for " + BlazeAddons.MOD_ID);
    }
}
