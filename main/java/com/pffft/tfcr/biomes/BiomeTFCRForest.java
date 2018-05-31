package com.pffft.tfcr.biomes;

import com.pffft.tfcr.TFCR;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeTFCRForest extends BiomeTFCRBase {

	public BiomeTFCRForest() {
		super("TFCR Forest", BiomeType.WARM);
		decorator = new BiomeDecoratorClimate();
		decorator.treesPerChunk = 10;
		decorator.grassPerChunk = 20;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		// TODO Auto-generated method stub
		return Biomes.FOREST.getFoliageColorAtPos(pos);
	}
}
