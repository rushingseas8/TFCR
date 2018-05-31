package com.pffft.tfcr.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

/**
 * Chunk generator for the TFCR worldgen.
 * 
 * See https://github.com/Matryoshika/Underworld/blob/master/src/main/java/se/Matryoshika/Underworld/WorldGen/ChunkGeneratorCaves.java
 * for a mod with working code for 1.12.
 * 
 * @author George
 *
 */
public class ChunkGeneratorTFCRPerlin implements IChunkGenerator {

    private static final IBlockState STONE = Blocks.STONE.getDefaultState();
    private static final IBlockState WATER = Blocks.WATER.getDefaultState();
	private final World world;
    private final Random rand;
    private Biome[] biomesForGeneration;
	private NoiseGeneratorOctaves minLimitPerlinNoise;
	private NoiseGeneratorOctaves maxLimitPerlinNoise;
	private NoiseGeneratorOctaves mainPerlinNoise;
	private NoiseGeneratorPerlin surfaceNoise;
	private NoiseGeneratorOctaves scaleNoise;
	private NoiseGeneratorOctaves depthNoise;
	private NoiseGeneratorOctaves forestNoise;
	private double[] depthBuffer = new double[256];
	
	private double[] heightMap = new double[16 * 16];
    
    public ChunkGeneratorTFCRPerlin(World worldIn, long seed) {
    	world = worldIn;
    	rand = new Random(seed);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
	}
    
	@Override
	public Chunk generateChunk(int x, int z) {
		this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        
        heightMap = mainPerlinNoise.generateNoiseOctaves(heightMap, x * 16, 0, z * 16, 16, 1, 16, 1, 1, 1); 
        
        this.setBlocksInChunk(x, z, chunkprimer);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
	}

	/**
	 * 
	 * @param x The chunk-centric x coordinate.
	 * @param z The chunk-centric z coordinate.
	 * @param chunkprimer
	 */
	private void setBlocksInChunk(int x, int z, ChunkPrimer chunkprimer) {
		/*
		int worldXBase = x * 16;
		int worldZBase = z * 16;
		
		for (int blockX = 0; blockX < 16; blockX++) {
			for (int blockZ = 0; blockZ < 16; blockZ++) {
				int worldX = worldXBase + blockX;
				int worldZ = worldZBase = blockZ;
				
				for (int blockY = 0; blockY < 64; blockY++) {
					chunkprimer.setBlockState(blockX, blockY, blockZ, STONE);
					
				}	
			}
		}
		*/	
		
		int baseHeight = 64;
		float heightScale = 1f / 16f;

		for (int blockX = 0; blockX < 16; blockX++) {
			for (int blockZ = 0; blockZ < 16; blockZ++) {
				for (int blockY = 0; blockY < baseHeight + (heightMap[(blockX * 16) + blockZ] * heightScale); blockY++) {
					chunkprimer.setBlockState(blockX, blockY, blockZ, STONE);
				}
			}
		}
		
	}
	
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
    {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) return;
        double d0 = 0.03125D;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 16; ++j)
            {
                Biome biome = biomesIn[j + i * 16];
                biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
            }
        }
    }

	@Override
	public void populate(int x, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		// TODO Auto-generated method stub
		return new ArrayList<SpawnListEntry>();
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
			boolean findUnexplored) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}

}
