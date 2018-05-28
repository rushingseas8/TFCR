package com.pffft.tfcr.worldgen;

import com.pffft.tfcr.init.ModBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;

public class BiomeProviderTFCR extends BiomeProvider {

	public BiomeProviderTFCR(World world) {
		super(world.getWorldInfo());
		allowedBiomes.clear();
		allowedBiomes.add(ModBiomes.testPlains);
		
		getBiomesToSpawnIn().clear();
		getBiomesToSpawnIn().add(ModBiomes.testPlains);
	}
}
