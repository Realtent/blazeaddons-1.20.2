package net.realtent.blazeaddons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;
import net.realtent.blazeaddons.item.custom.BlazeboltItem;
import net.realtent.blazeaddons.item.custom.MinirocketItem;
import net.realtent.blazeaddons.item.custom.PrimedMinirocketItem;

public class ModItems {
    public static final Item IMPACT_CASING = registerItem("impact_casing", new Item(new FabricItemSettings()));
    public static final Item PRIMED_MINIROCKET = registerItem("primed_minirocket", new PrimedMinirocketItem(new FabricItemSettings().maxCount(1)));
    public static final Item MINIROCKET = registerItem("minirocket", new MinirocketItem(new FabricItemSettings().maxCount(1)));
    public static final Item BLAZEBOLT = registerItem("blazebolt", new BlazeboltItem(new FabricItemSettings().maxCount(1)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(IMPACT_CASING);
        entries.add(PRIMED_MINIROCKET);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BlazeAddons.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BlazeAddons.LOGGER.info("Registering Mod Items for " + BlazeAddons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
