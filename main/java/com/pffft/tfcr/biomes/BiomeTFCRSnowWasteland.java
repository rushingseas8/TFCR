package com.pffft.tfcr.biomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pffft.tfcr.worldgen.WorldGenSnowCliffs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenIceSpike;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeTFCRSnowWasteland extends BiomeTFCRBase {
	
	private WorldGenIceSpike iceSpike = new WorldGenIceSpike();
	private WorldGenSnowCliffs snowCliffs = new WorldGenSnowCliffs();
	
	public BiomeTFCRSnowWasteland() {
		super("Snow Wasteland", BiomeType.ICY);
		decorator = new BiomeDecoratorClimate();
		decorator.treesPerChunk = 0;
		decorator.grassPerChunk = 0;
		
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = Blocks.PACKED_ICE.getDefaultState();
	}
	
	@Override
	public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return new ArrayList<SpawnListEntry>();
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		
		for (int i = 0; i < 2; i++) {
			int xOffset = pos.getX() + rand.nextInt(16) + 8;
			int zOffset = pos.getZ() + rand.nextInt(16) + 8;
			int yPos = worldIn.getHeight(xOffset, zOffset);
			
			snowCliffs.generate(worldIn, rand, new BlockPos(xOffset, yPos - 1, zOffset));
		}
		
		/*
		for (int i = 0; i < 10; i++) {
			int xOffset = pos.getX() + rand.nextInt(16) + 8;
			int zOffset = pos.getZ() + rand.nextInt(16) + 8;
			int yPos = worldIn.getHeight(xOffset, zOffset);
			
			iceSpike.generate(worldIn, rand, new BlockPos(xOffset, yPos, zOffset));
		}
		*/
	}

	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		// TODO Auto-generated method stub
		return 0x005DD8C0;
	}
}
