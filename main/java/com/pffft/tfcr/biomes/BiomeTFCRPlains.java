package com.pffft.tfcr.biomes;

import java.util.Random;

import com.pffft.tfcr.TFCR;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeTFCRPlains extends BiomeTFCRBase {

	public BiomeTFCRPlains() {
		super("TFCR Plains", BiomeType.WARM);
	}
}
