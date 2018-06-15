package com.pffft.tfcr.worldgen;

import com.pffft.tfcr.init.ModBiomes;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProviderSingle;

public class BiomeProviderTFCR extends BiomeProviderSingle {
	
	public BiomeProviderTFCR(World world) {
		//super(world.getWorldInfo());
		super(ModBiomes.BIOME_TFCR_FOREST);
		//super(ModBiomes.BIOME_TFCR_SNOW_WASTELAND);
		//allowedBiomes.clear();
		//allowedBiomes.add(ModBiomes.BIOME_TFCR_PLAINS);
		
		//getBiomesToSpawnIn().clear();
		//getBiomesToSpawnIn().add(ModBiomes.BIOME_TFCR_PLAINS);
	}
}
