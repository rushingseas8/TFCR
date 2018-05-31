package com.pffft.tfcr.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTallGrassTFCR extends WorldGenerator {

	private IBlockState tallGrassState;
	
	public WorldGenTallGrassTFCR(IBlockState block) {
		this.tallGrassState = block;
	}
	
	@Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position)) {
            position = position.down();
        }

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && Blocks.TALLGRASS.canBlockStay(worldIn, blockpos, this.tallGrassState)) {
                worldIn.setBlockState(blockpos, this.tallGrassState, 18);
            }
        }

        return true;
    }

}
