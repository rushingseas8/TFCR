package com.pffft.tfcr.biomes;

import java.util.Random;

import com.pffft.tfcr.worldgen.WorldGenTreeClimate;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeDecoratorClimate extends BiomeDecorator {
	
	WorldGenTreeClimate worldGenTreeClimate = new WorldGenTreeClimate();
	
	@Override
	public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
		
		int temperature = 6;
		
		worldGenTreeClimate.generate(worldIn, random, pos, false, temperature, treesPerChunk);
	}
}
