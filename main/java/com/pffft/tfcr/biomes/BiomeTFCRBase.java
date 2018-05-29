package com.pffft.tfcr.biomes;

import com.pffft.tfcr.TFCR;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;

public abstract class BiomeTFCRBase extends Biome {

	public String name;
	public BiomeType biomeType;
	public int weight;
	
	public BiomeTFCRBase(String name, BiomeType type) {
		this(name, type, 1);
	}
	
	public BiomeTFCRBase(String name, BiomeType type, int weight) {
		super(new BiomeProperties(name));
		this.name = name;
		this.biomeType = type;
		this.weight = weight;
		setRegistryName(TFCR.MODID, name);
	}
	
}
