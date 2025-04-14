package com.arcticquests.raid;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arcticquests.raid.item.ModPotion;



public class SplashOminous implements ModInitializer {

	public static final String MOD_ID = "splash_ominous";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {

		LOGGER.info("Mod Made Byyy Me!");
		ModPotion.registerPotions();
	}
}