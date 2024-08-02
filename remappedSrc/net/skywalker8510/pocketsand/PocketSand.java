package net.skywalker8510.pocketsand;

import net.fabricmc.api.ModInitializer;

import net.skywalker8510.pocketsand.Item.ModItems;
import net.skywalker8510.pocketsand.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PocketSand implements ModInitializer {
	public static final String MOD_ID = "pocketsand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();

	}
}