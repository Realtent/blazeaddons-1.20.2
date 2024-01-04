package net.realtent.blazeaddons;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlazeAddons implements ModInitializer {
	public static final String MOD_ID = "blazeaddons";
    public static final Logger LOGGER = LoggerFactory.getLogger("blazeaddons");

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}