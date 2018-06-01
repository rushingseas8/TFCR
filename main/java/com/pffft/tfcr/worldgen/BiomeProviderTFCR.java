package com.pffft.tfcr.worldgen;

import java.util.HashMap;
import java.util.Random;

import com.pffft.tfcr.init.ModBiomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.layer.GenLayer;

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
