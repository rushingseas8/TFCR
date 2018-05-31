package com.pffft.tfcr.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSnowCliffs extends WorldGenerator {

	private static final IBlockState SNOW = Blocks.SNOW.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		// TODO add rotation support, make them taper off on the edges (max height in center depth),
		// and finally add randomization to the initial shape.
		int width = rand.nextInt(6) + 2;
		int depth = rand.nextInt(4) + 3; 
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < depth; j++) {
				int height = (int)((i * i / 2.0) - (i * i * i / 20.0));
				for (int k = 0; k < height; k++) {
					worldIn.setBlockState(position.add(i, k, j), SNOW, 18);
				}
			}
		}
		
		return true;
	}

}
