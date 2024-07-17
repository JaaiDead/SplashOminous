package com.arcticquests.pills;

import com.arcticquests.raid.SplashOminous;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EmotionParticle;

public class SplashOminousClient implements ClientModInitializer {
 
    @Override
    public void onInitializeClient() {
    ParticleFactoryRegistry.getInstance().register(SplashOminous.OMINOUS_PARTICLE, EmotionParticle.AngryVillagerFactory::new);

}
}