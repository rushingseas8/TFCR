package com.pffft.tfcr.biomes;

import java.util.Random;

import com.pffft.tfcr.init.ModBlocks;
import com.pffft.tfcr.worldgen.WorldGenTallGrassTFCR;
import com.pffft.tfcr.worldgen.WorldGenTreeClimate;

import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeDecoratorClimate extends BiomeDecorator {
	
	WorldGenTreeClimate worldGenTreeClimate = new WorldGenTreeClimate();
	WorldGenTallGrassTFCR worldGenTallGrassTFCR = new WorldGenTallGrassTFCR(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS));
	WorldGenTallGrassTFCR worldGenHalfGrassTFCR = new WorldGenTallGrassTFCR(ModBlocks.BLOCK_HALF_GRASS.getDefaultState());
	
	@Override
	public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
		
		int temperature = 6;
		
		worldGenTreeClimate.generate(worldIn, random, pos, false, temperature, treesPerChunk);
		
		
		for (int i = 0; i < grassPerChunk / 2; i++) {
			int xOffset = random.nextInt(16) + 8;
			int zOffset = random.nextInt(16) + 8;
	        int yOffset = worldIn.getHeight(pos.add(xOffset, 0, zOffset)).getY() * 2;
	        
	        if (yOffset > 0) {
	        	int randY = random.nextInt(yOffset);
	        	worldGenTallGrassTFCR.generate(worldIn, random, pos.add(xOffset, yOffset, zOffset));
	        }
		}
		
		for (int i = 0; i < grassPerChunk / 2; i++) {
			int xOffset = random.nextInt(16) + 8;
			int zOffset = random.nextInt(16) + 8;
	        int yOffset = worldIn.getHeight(pos.add(xOffset, 0, zOffset)).getY() * 2;
	        
	        if (yOffset > 0) {
	        	int randY = random.nextInt(yOffset);
	        	worldGenHalfGrassTFCR.generate(worldIn, random, pos.add(xOffset, yOffset, zOffset));
	        }
		}
	}
}
