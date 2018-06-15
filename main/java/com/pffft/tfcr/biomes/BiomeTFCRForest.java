package com.pffft.tfcr.biomes;

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
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		// TODO Auto-generated method stub
		return Biomes.FOREST.getFoliageColorAtPos(pos);
	}
}
