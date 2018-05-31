package com.pffft.tfcr.worldgen;

import java.util.ArrayList;

import com.pffft.tfcr.biomes.BiomeTFCRPlains;
import com.pffft.tfcr.init.ModBiomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

/**
 * TerraFirmaCraft Reloaded default world type.
 * 
 * TODO: Make it so that this chooses biome based on world Z coordinate.
 * Add unique TFC biomes to this.
 * @author George
 *
 */
public class WorldTypeTFCR extends WorldType {

	public WorldTypeTFCR() {
		super("TerraFirmaCraft");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) {
		// TODO Auto-generated method stub
		//return new BiomeProvider(world.getWorldInfo());
		//return new BiomeProviderSingle(ModBiomes.BIOME_TFCR_FOREST);
		return new BiomeProviderTFCR(world);
	}
	
	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		// TODO Auto-generated method stub
		//return new ChunkGeneratorTFCR(world, world.getSeed(), true, generatorOptions);
		return new ChunkGeneratorOverworld(world, world.getSeed(), true, generatorOptions);
	}
	
}
