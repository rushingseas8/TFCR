package com.pffft.tfcr.biomes;

import com.pffft.tfcr.blocks.BlockWeakStone;
import com.pffft.tfcr.init.ModBlocks;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeTFCRForest extends BiomeTFCRBase {

	public BiomeTFCRForest() {
		super("TFCR Forest", BiomeType.WARM);
		decorator = new BiomeDecoratorClimate();
		decorator.treesPerChunk = 15;
		decorator.grassPerChunk = 20;
		decorator.flowersPerChunk = 2;
		
		this.fillerBlock = ModBlocks.BLOCK_WEAK_STONE.getDefaultState();
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		// TODO Auto-generated method stub
		return Biomes.FOREST.getFoliageColorAtPos(pos);
	}
}
