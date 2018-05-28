package com.pffft.tfcr.biomes;

import java.util.Random;

import com.pffft.tfcr.TFCR;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeTFCRPlains extends Biome {
	
	public static final String name = "TFCR Plains";

	public BiomeTFCRPlains(BiomeProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
		setRegistryName(TFCR.MODID, name);
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		// TODO Auto-generated method stub
		super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		// TODO Auto-generated method stub
		return super.createBiomeDecorator();
	}

}
