package net.realtent.blazeaddons.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;
import net.realtent.blazeaddons.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BLAZE_ADDONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BlazeAddons.MOD_ID, "blaze_addons"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blaze_addons"))
                    .icon(() -> new ItemStack(Items.BLAZE_ROD)).entries((displayContext, entries) -> {
                        entries.add(Items.BLAZE_ROD);
                        entries.add(Items.BLAZE_POWDER);
                        entries.add(Items.MAGMA_CREAM);
                        entries.add(Items.NETHER_BRICK);

                        entries.add(ModItems.IMPACT_CASING);
                        entries.add(ModItems.PRIMED_MINIROCKET);

                        entries.add(ModBlocks.BLAZE_ROD_BLOCK);


                    }).build());


    public static void registerItemGroups(){
        BlazeAddons.LOGGER.info("Registering Item Groups for " + BlazeAddons.MOD_ID);
    }
}
