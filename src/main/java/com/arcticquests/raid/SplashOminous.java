package com.arcticquests.raid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arcticquests.raid.brewpotz.Brewing;


public class SplashOminous implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "splash_ominous";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This DefaultParticleType gets called when you want to use your particle in code.
	public static final SimpleParticleType OMINOUS_PARTICLE = FabricParticleTypes.simple();

	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		
		LOGGER.info("Hello ME!");

		Brewing.registerModItems();
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "ominous_particle"), OMINOUS_PARTICLE);
		
	}
}