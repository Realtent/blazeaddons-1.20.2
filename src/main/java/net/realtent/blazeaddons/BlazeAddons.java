package net.realtent.blazeaddons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.block.ModBlocks;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.entity.projectile.BlazeboltEntity;
import net.realtent.blazeaddons.item.ModItemGroups;
import net.realtent.blazeaddons.item.ModItems;
import net.realtent.blazeaddons.util.ModLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlazeAddons implements ModInitializer {
	public static final String MOD_ID = "blazeaddons";
    public static final Logger LOGGER = LoggerFactory.getLogger("blazeaddons");

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifier.modifyLootTables();

		FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1000);


	}
}