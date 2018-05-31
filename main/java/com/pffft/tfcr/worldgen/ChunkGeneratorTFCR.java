package com.pffft.tfcr.worldgen;

import java.util.ArrayList;
import java.util.HashMap;

import com.pffft.tfcr.init.ModBiomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class ChunkGeneratorTFCR extends ChunkGeneratorOverworld {

	private World world;
	private static HashMap<BlockPos, BiomeStorage> biomeLookup;
	private Biome[] biomesForGeneration;
	
	public ChunkGeneratorTFCR(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions) {
		super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
		this.world = worldIn;
		biomeLookup = new HashMap<>();
	}
	
	@Override
	public Chunk generateChunk(int x, int z) {

		BlockPos pos = new BlockPos(x, 0, z);
		
		if (biomeLookup.containsKey(pos)) { // This exact chunk is known, skip.
			BiomeStorage st = biomeLookup.get(pos);
			if (st != null) {
				System.out.println("Found existing biome at chunk position " + pos + " with temperature: " + st.temperature);	
			} else {
				System.out.println(x);
			}
		} else {
			// Get the biomes in the current chunk. We only proceed if we see a TFCR forest.
			biomesForGeneration = this.world.getBiomeProvider().getBiomes(biomesForGeneration, x * 16, z * 16, 16, 16);
			boolean hasTFCRForest = false;
			for (Biome b : biomesForGeneration) {
				if (b.equals(ModBiomes.BIOME_TFCR_FOREST)) {
					hasTFCRForest = true;
				}
			}
			
			if (!hasTFCRForest) {
				biomeLookup.put(pos, null);
			} else {
				// Check neighbors to see if we can copy their data.
				BlockPos[] neighborPositions = new BlockPos[] {
					pos.north(), pos.east(), pos.south(), pos.west()
				};
				
				ArrayList<BiomeStorage> neighborBiomeStorages = new ArrayList<>();
				
				for (int i = 0; i < neighborPositions.length; i++) {
					BlockPos neighbor = neighborPositions[i];
					if (biomeLookup.containsKey(neighbor)) {
						BiomeStorage st = biomeLookup.get(neighbor);
						if (st == null) {
							continue;
						}
						
						biomesForGeneration = this.world.getBiomeProvider().getBiomes(biomesForGeneration, neighbor.getX() * 16, neighbor.getZ() * 16, 16, 16);
						for (Biome b : biomesForGeneration) {
							if (b.equals(ModBiomes.BIOME_TFCR_FOREST)) {
								neighborBiomeStorages.add(st);
							}
						}
					}
				}
				
				if (neighborBiomeStorages.size() == 0) {
					System.out.println("Found no neighbors. Creating new storage.");
					BiomeStorage newStorage = new BiomeStorage(ModBiomes.BIOME_TFCR_FOREST, (int)(Math.random() * 100));
					biomeLookup.put(pos, newStorage);
				} else if (neighborBiomeStorages.size() == 1) {
					System.out.println("Found one neighbor. Copying storage.");
					biomeLookup.put(pos, neighborBiomeStorages.get(0));
				} else {
					System.out.println("Found multiple neighbors.");
					BiomeStorage combinedStorage = new BiomeStorage(ModBiomes.BIOME_TFCR_FOREST, 0);
					biomeLookup.put(pos, combinedStorage);
				}
			}
		}
		
		return super.generateChunk(x, z);
	}

	private class BiomeStorage {
		public Biome biome;
		public int temperature;
		
		public BiomeStorage(Biome biome, int temp) {
			this.biome = biome;
			this.temperature = temp;
		}
	}

}
