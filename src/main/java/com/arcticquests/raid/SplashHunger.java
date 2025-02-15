package com.arcticquests.raid;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arcticquests.raid.item.Modpotion;



public class SplashHunger implements ModInitializer {

	public static final String MOD_ID = "splash_hunger";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		Modpotion.registerPotions();
	}
}