package com.arcticquests.raid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SplashOminous implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "splash_ominous";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This DefaultParticleType gets called when you want to use your particle in code.
	public static final SimpleParticleType SPARKLE_PARTICLE = FabricParticleTypes.simple();

	//#particle_register_main
	//#entrypoint
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello ME!");
		
		// Register our custom particle type in the mod initializer.
		//TODO: Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "sparkle_particle"), SPARKLE_PARTICLE);
		
	}
}