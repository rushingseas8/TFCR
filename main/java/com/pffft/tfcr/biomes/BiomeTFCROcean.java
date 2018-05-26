package com.pffft.tfcr.biomes;

import com.pffft.tfcr.TFCR;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;

public class BiomeTFCROcean extends Biome {

	public static final String name = "TFCR Ocean";
	
	public BiomeTFCROcean(BiomeProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
		setRegistryName(TFCR.MODID, name);
	}
}
